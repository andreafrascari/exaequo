package eu.anastasis.serena.inziativesolidali;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import eu.anastasis.serena.application.core.tasks.CronPersistenceHome;
import eu.anastasis.serena.application.index.util.ModuleParameterConfiguration;
import eu.anastasis.serena.application.modules.object.ObjectUtils;
import eu.anastasis.serena.beans.Consumatori;
import eu.anastasis.serena.constants.ConstantsXSerena;
import eu.anastasis.serena.exception.SerenaException;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ComodinoSync implements Runnable {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ComodinoSync.class);
	private static CronPersistenceHome cph = null;

	private static final String SYMPA_EXE = "sympa_synclist";
	private static final String SYMPA_INPUT = "list.xml";

	/**
	 * Attention!!! It's static
	 * 
	 * @return
	 */
	private CronPersistenceHome getMyCronPersistenceHome() {
		if (cph == null)
			cph = new CronPersistenceHome();
		return cph;
	}

	public void run() {
		try {
			logger.trace("Synchronising mailing lists with Comodino's ....");
			String res = null;
			List<Consumatori> consumatori = this
					.fecthNomi("exaequo-consumatori"); 
			if (consumatori != null) {
				res = this.syncList(consumatori, "notizie");
				logger.info("done: "+res);
			}
			 Thread.sleep(72000); // si' perchè lo script ci mette anche 10 min!!!!!
			List<Consumatori> soci = this.fecthNomi("exaequo-soci");
			if (soci != null) {
				res = this.syncList(soci, "soci");
				logger.info("done: "+res);
			}
			 Thread.sleep(72000);
			List<Consumatori> prestatori = this.fecthNomi("exaequo-prestatori");
			if (prestatori != null) { 
				res = this.syncList(prestatori, "libretti");
				logger.info("done: "+res);
			}
			logger.trace("DONE: goodbye.");
		} catch (Exception e) {
			logger.error("Error while Synchronising:" + e.getMessage());
		}
	}

	/**
	 * sincronizza la lista passata utilizzando lo script pyton di enzo ed il
	 * file xml di input: <?xml version="1.0" encoding="UTF-8"?> <lists> <list>
	 * <name>libretti</name> <subscribers> <subscriber> <name>Andrea
	 * Frascari</name> <email>frasca@frasca.it</email> </subscriber> [....]
	 * 
	 * @param lista
	 */
	private String syncList(List<Consumatori> listaNomi, String nomeLista) {
		try {
			logger.info("Working on list " + nomeLista);
			Element root = DocumentHelper.createElement("lists");
			Element xml = root.addElement("list");
			Element elem = xml.addElement("name");
			elem.setText(nomeLista);
			elem = xml.addElement("subscribers");
			for (Consumatori c : listaNomi) {
				String nome = c.getNome();
				if (c.getCognome() != null) {
					nome += " " + c.getCognome();
				}
				Element subscr = elem.addElement("subscriber");
				Element attr = subscr.addElement("name");
				attr.setText(nome);
				attr = subscr.addElement("email");
				attr.setText(c.getEmail());
			}

			String ex_output = "";
			String sympa_path = ModuleParameterConfiguration.getInstance()
					.getValue(new Iniziative_Module().getDefaultName(),
							"SYMPA_SYNC_PATH");
			String command = sympa_path + SYMPA_EXE; // + " "+sympa_path +
														// SYMPA_INPUT;
			// writing xml file
			this.writeTmpFile(sympa_path, root);
			this.writeTmpFile(sympa_path+nomeLista, root);

			logger.info("launching " + command);

			Process p = Runtime.getRuntime().exec(command);
			String line = null;
			BufferedReader bri = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			while ((line = bri.readLine()) != null) {
				ex_output += line + "\n";
			}
			bri.close();
			p.waitFor();
			return ex_output;

		} catch (Exception e) {
			String message = "Errore in lista " + nomeLista;
			logger.error(message, e);
			return null;
		}

	}

	private void writeTmpFile(String path, Element xml) throws SerenaException {
		try {

			String content = xml.asXML();

			File file = new File(path + SYMPA_INPUT);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		} catch (IOException e) {
			String message = "Cannot write xml on file for input to python: "+path + SYMPA_INPUT;
			logger.error(message, e);
			throw new SerenaException(message);
		}

	}

	private List<Consumatori> fecthNomi(String datasource)
			throws SerenaException {
		try {
			logger.info("Loading " + datasource);
			Element currentElement = ObjectUtils
					.getXserenaRequestStandardHeader("whatever",
							ConstantsXSerena.ACTION_GET,
							Consumatori.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION,
					ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET,
					ConstantsXSerena.TARGET_SPECIFIED);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS,
					"0");
			currentElement.addAttribute(
					ConstantsXSerena.ATTR_FORCED_DATASOURCE, datasource);
			currentElement.addElement(Consumatori.SLOT_EMAIL);
			currentElement.addElement(Consumatori.SLOT_NOME);
			currentElement.addElement(Consumatori.SLOT_COGNOME);

			String[] messages = { "", "" };
			Document resultData = getMyCronPersistenceHome().get(
					currentElement.getDocument());
			int res = ConstantsXSerena.getXserenaRequestResult(resultData,
					messages, Consumatori.INSTANCE_NAME);
			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("Errore in ricerca nomi per " + datasource);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				logger.warn("Nessun nome per " + datasource);
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				List<Element> resList = resultData.selectNodes(".//"
						+ Consumatori.INSTANCE_NAME);
				List<Consumatori> nameList = new ArrayList<Consumatori>();
				for (Element aName : resList) {
					String name = aName.elementText(Consumatori.SLOT_NOME);
					String surname = ((Element) aName)
							.elementText(Consumatori.SLOT_COGNOME);
					String email = ((Element) aName)
							.elementText(Consumatori.SLOT_EMAIL);
					Consumatori c = new Consumatori();
					c.setNome(name);
					if (surname != null) {
						c.setCognome(surname);
					}
					c.setEmail(email);
					nameList.add(c);
				}
				return nameList;
			}
			return null;
		} catch (Exception any) {
			String msg = "Could not fetch " + datasource;
			logger.error(msg, any);
			throw new SerenaException(msg, any);
		}
	}

}

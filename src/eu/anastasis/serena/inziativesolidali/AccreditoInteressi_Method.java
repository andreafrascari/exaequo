package eu.anastasis.serena.inziativesolidali;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import eu.anastasis.serena.application.core.modules.DefaultMethod;
import eu.anastasis.serena.application.core.modules.DefaultModule;
import eu.anastasis.serena.application.index.util.ApplicationLibrary;
import eu.anastasis.serena.application.modules.object.ObjectUtils;
import eu.anastasis.serena.beans.Consumatori;
import eu.anastasis.serena.beans.Cooperative;
import eu.anastasis.serena.beans.Estrattoconto;
import eu.anastasis.serena.beans.ExaequoBeanDataManager;
import eu.anastasis.serena.beans.ExaequoBinder;
import eu.anastasis.serena.beans.InteressiIndeducibili;
import eu.anastasis.serena.beans.Libretti;
import eu.anastasis.serena.beans.Movimenti_Libretti;
import eu.anastasis.serena.beans.Organizzazioni;
import eu.anastasis.serena.beans.RegolamentoPrestito;
import eu.anastasis.serena.beans.SimulazioneEstrattoconto;
import eu.anastasis.serena.beans.Soci;
import eu.anastasis.serena.beans.TassoInteresseLibretto;
import eu.anastasis.serena.beans.exaequo.MyInteressiDeducibili;
import eu.anastasis.serena.beans.exaequo.MyLibretti;
import eu.anastasis.serena.beans.exaequo.MySoci;
import eu.anastasis.serena.common.SerenaDate;
import eu.anastasis.serena.common.XSerenaLibrary;
import eu.anastasis.serena.constants.ConstantsXSerena;
import eu.anastasis.serena.exception.SerenaException;
import eu.anastasis.serena.presentation.templates.ActiveTemplate;
import eu.anastasis.serena.presentation.templates.TemplateFactory;
import eu.anastasis.serena.query.DeleteQuery;
import eu.anastasis.serena.query.InsertQuery;

/**
 * Ridefinisce DetailEdit per la creazione atomica anche delle istanze figlie
 * 
 * @author afrascari
 * 
 */
public class AccreditoInteressi_Method extends DefaultMethod {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AccreditoInteressi_Method.class);

	public AccreditoInteressi_Method(DefaultModule defaultModule, String[] defaultParameters) {
		super(defaultModule, defaultParameters);
		// TODO Auto-generated constructor stub
	}

	public static final String METHOD_NAME = "accredito_interessi";

	private static final String PAR_ID_COOPERATIVA = "cooperativa";
	private static final String PAR_ACTION = "action";
	private static final String VAL_ACTION_DO = "do";
	private static final String VAL_ACTION_UNDO = "undo";
	private static final String VAL_ACTION_SIMULA = "simula";
	private static final String PAR_FORCE_YEAR = "year";
	public static final String A_DAY_IN_THE_FUTURE = "01/01/2099";

	@Override
	protected String getName() {
		return METHOD_NAME;
	}

	@Override
	public String doMethod(HttpServletRequest request, HttpServletResponse response) throws SerenaException {
		ActiveTemplate template = new ActiveTemplate(
				TemplateFactory.getTemplate(retrieveDefaultTemplateContext(), retrieveTemplateContext(), getName()));
		try {

			// fetch cooperativa
			String id_cooperativa = request.getParameter(PAR_ID_COOPERATIVA);

			// TODO controllo permessi???????

			String action = request.getParameter(PAR_ACTION);
			String forceYear = request.getParameter(PAR_FORCE_YEAR);

			if (action == null) {
				String errorMessage = "Action del metodo non specificata";
				logger.error(errorMessage);
				throw new SerenaException(errorMessage);
			}

			String output = "";

			// fetch regolamento prestito
			RegolamentoPrestito rp = loadRegolamentoPrestito(request, id_cooperativa);

			// controllo esistenza accrediti data corrente
			SerenaDate dataAccredito = computeDataAccredito(rp, forceYear);

			if (VAL_ACTION_DO.equals(action)) {
				output = doAccredito(request, id_cooperativa, dataAccredito, rp);
			} else if (VAL_ACTION_UNDO.equals(action)) {
				output = undoAccredito(request, id_cooperativa, dataAccredito);
				//output = "Funzione non piu' disponibile";
			} else if (VAL_ACTION_SIMULA.equals(action)) {
				output = doSimula(request, id_cooperativa, dataAccredito, rp);
			} else {
				String errorMessage = "Action " + action + " non gestita";
				logger.error(errorMessage);
				throw new SerenaException(errorMessage);
			}

			template.replaceTagInBlock("MESS", "RESULT_SUCCESS", output);
			template.publishBlock("RESULT_SUCCESS");
			template.publish();
			return template.getContenuto();

		} catch (Exception e) {
			String errorMessage = e.getMessage();
			logger.error(errorMessage, e);
			template.replaceTagInBlock("ERROR_MESSAGE", "RESULT_ERROR", errorMessage);
			template.publishBlock("RESULT_ERROR");
			template.publish();
			return template.getContenuto();
		}
	}

	protected String doAccredito(HttpServletRequest request, String id_cooperativa, SerenaDate dataAccredito,
			RegolamentoPrestito rp) throws SerenaException {

		String mess = "";
		HashMap<Libretti, Double> mappaInteressi = new HashMap<Libretti, Double>();

		HashMap<Libretti, Double> mappaInteressiDeducibili = new HashMap<Libretti, Double>();

		MyInteressiDeducibili.Reset();
		
		if (dataAccredito.isAfter(new SerenaDate()))	{
			mess = "Attenzione: l'operazione di accredito interessi sara' possibile solo DOPO il " + dataAccredito.toString()
			+ ". Per effettuare proiezioni, utilizzare la funzione di <em>proiezione estrattoconto</em>";
			throw new SerenaException(mess);
		}


		/**
		 * nuovi controlli: 1) 1 mese prima data accredito 2) accredito non
		 * ancora fatto TODO ... al momento si fa il controllo
		 * "esistono movimenti di accredito nell'anno corrente?" -> il 1 gennaio
		 * già li farebbe ....
		 */
		if (movimentiDiAccreditoInteressiIl(request, id_cooperativa, dataAccredito)) {
			mess = "Il sistema ha rilevato che esitono movimenti di accredito interessi al " + dataAccredito.toString()
					+ " e, ritenendo l'operazione di accredito interessi dell'anno corrente sia gia stata effettuata, non procede.";
			throw new SerenaException(mess);
		}

		// fetch libretti cooperativa
		List<Libretti> libretti = fecthLibrettiAttivi(request, id_cooperativa);

		try {
			for (Libretti unLibretto : libretti) {
				Double interessi = calcoloInteressiLibretto(request, dataAccredito, unLibretto, rp);

				Double interessiDeducibili = calcoloInteressiDeducibiliLibretto(request, dataAccredito, unLibretto, rp);

				if (interessiDeducibili > interessi) {
					interessiDeducibili = interessi;
				}

				// place in a map for later bulk insertion
				mappaInteressi.put(unLibretto, interessi);
				mappaInteressiDeducibili.put(unLibretto, interessiDeducibili);
				String step = "<br />libretto " + unLibretto.getCodice_contratto() + " - interessi periodo = "
						+ interessi + " di cui deducibili: " + interessiDeducibili;
				mess += "<br /> " + step;
				logger.trace(step);
			}
		} catch (Exception e) {
			mess = "Errore in computo interessi: trovato almeno un libretto senza condizioni. Nessun movimento registrato.";
			logger.error(mess);
			throw new SerenaException(mess);
		}
		// semi-bulk insert (rollback based upon causale and data)

		try {
			registraMovimenti(request, mappaInteressi, dataAccredito.toString());
			registraEstrattoconti(request, mappaInteressi, mappaInteressiDeducibili, dataAccredito.toString(), rp);
		} catch (Exception e) {
			undoAccredito(request, id_cooperativa, dataAccredito);
			mess = "Errore in operazione accredito interessi: rollback tentato ... controllare il log.";
			logger.fatal(mess);
			throw new SerenaException(mess);
		}

		if (mess.isEmpty())	{
			throw new SerenaException("Nessun movimento di accredito da scrivere in data odierna.");
		}
			

		logger.info(mess);
		return "";
	}

	protected String doSimula(HttpServletRequest request, String id_cooperativa, SerenaDate dataAccredito,
			RegolamentoPrestito rp) throws SerenaException {

		if (movimentiDiAccreditoInteressiIl(request, id_cooperativa, dataAccredito)) {
			// movimenti accredito anno corrente presenti: la simulazione e' per
			// l'anno successivo
			dataAccredito.addYears(1);
		} else {
			// movimenti anno corrente NON presenti: la simulazione e' per
			// l'anno CORRENTE
		}

		String mess = "";
		HashMap<Libretti, Double> mappaInteressi = new HashMap<Libretti, Double>();

		HashMap<Libretti, Double> mappaInteressiDeducibili = new HashMap<Libretti, Double>();

		MyInteressiDeducibili.Reset();

		// fetch libretti cooperativa
		List<Libretti> libretti = fecthLibrettiAttivi(request, id_cooperativa);

		try {
			for (Libretti unLibretto : libretti) {
				Double interessi = calcoloInteressiLibretto(request, dataAccredito, unLibretto, rp);

				Double interessiDeducibili = calcoloInteressiDeducibiliLibretto(request, dataAccredito, unLibretto, rp);

				if (interessiDeducibili > interessi) {
					interessiDeducibili = interessi;
				}

				// place in a map for later bulk insertion
				mappaInteressi.put(unLibretto, interessi);
				mappaInteressiDeducibili.put(unLibretto, interessiDeducibili);
				String step = "<br />libretto " + unLibretto.getCodice_contratto() + " - interessi periodo = "
						+ interessi + " di cui deducibili: " + interessiDeducibili;
				mess += "<br /> " + step;
				logger.trace(step);
			}
		} catch (Exception e) {
			mess = "Errore in computo interessi: trovato almeno un libretto senza condizioni. Nessun movimento registrato.";
			logger.error(mess);
			throw new SerenaException(mess);
		}
		// semi-bulk insert (rollback based upon causale and data)

		try {
			registraSimulazioneEstrattoconti(request, mappaInteressi, mappaInteressiDeducibili,
					dataAccredito.toString(), rp);
		} catch (Exception e) {
			mess = "si ricorda che non e' possibile fare 2 simulazioni lo stesso giorno!";
			logger.error(mess);
			throw new SerenaException(mess);
		}

		if (mess.isEmpty())	{
			throw new SerenaException("Nessun movimento di accredito da scrivere in data odierna.");
		}
			

		logger.info(mess);
		return "";
	}

	private void registraMovimenti(HttpServletRequest request, HashMap<Libretti, Double> mappaInteressi,
			String dataAccredito) throws SerenaException {
		InsertQuery insert = new InsertQuery(Movimenti_Libretti.INSTANCE_NAME);
		Element theRoot = insert.getFirstClassElement();
		Element node = theRoot.addElement(Movimenti_Libretti.SLOT_DATA_MOVIMENTO);
		node.setText(dataAccredito);
		node = theRoot.addElement(Movimenti_Libretti.SLOT_CAUSALE_LIBRETTO);
		node.setText(Movimenti_Libretti.CAUSALE_LIBRETTO__ACCREDITO_INTERESSI);
		// node = insert.addElement(Movimenti_Libretti.SLOT_MEZZO);
		for (Libretti unIdLibretto : mappaInteressi.keySet()) {
			logger.info("Processing libretto " + unIdLibretto + " ....");
			Document theRootCopy = (Document) theRoot.getDocument().clone();
			Element theRootClass = (Element) theRootCopy.selectSingleNode(".//" + Movimenti_Libretti.INSTANCE_NAME);
			node = theRootClass.addElement(Movimenti_Libretti.SLOT_IMPORTO);
			String accreditoDi = mappaInteressi.get(unIdLibretto).toString();
			node.setText(accreditoDi);
			node = theRootClass.addElement(Movimenti_Libretti.SLOT_LIBRETTO);
			node = node.addElement(Libretti.INSTANCE_NAME);
			node = node.addElement("ID");
			node.setText(unIdLibretto.getId());
			node = theRootClass.addElement(Movimenti_Libretti.SLOT_MEZZO);
			node.setText(Movimenti_Libretti.MEZZO__GIROCONTO);

			Document response;
			try {
				response = ApplicationLibrary.setData(theRootClass.getDocument(), request);
			} catch (Exception e) {
				String message = "Accredito for libretto " + unIdLibretto.getId()
						+ " failed: stopping procedure and rolling back....";
				logger.error(message, e);
				throw new SerenaException(message);
			}
			String[] messages2 = { "", "" };
			int res = ConstantsXSerena.getXserenaRequestResult(response, messages2, Movimenti_Libretti.INSTANCE_NAME);
			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				String message = "Accredito for libretto " + unIdLibretto.getId() + " failed (" + messages2[0]
						+ "): stopping procedure and rolling back....";
				logger.error(message);
				throw new SerenaException(message);
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				String message = "Accredito in libretto " + unIdLibretto.getId() + " di euro " + accreditoDi + " OK!";
				logger.info(message);
			}
		}

	}

	private void registraEstrattoconti(HttpServletRequest request, HashMap<Libretti, Double> mappaInteressi,
			HashMap<Libretti, Double> mappaInteressiDeducibili, String dataAccredito, RegolamentoPrestito rp)
					throws SerenaException {
		InsertQuery insert = new InsertQuery(Estrattoconto.INSTANCE_NAME);
		Element theRoot = insert.getFirstClassElement();
		Element node = theRoot.addElement(Estrattoconto.SLOT_DATA);
		node.setText(dataAccredito);
		Float ritenuta = rp.getRitenuta_fiscale();
		for (Libretti unIdLibretto : mappaInteressiDeducibili.keySet()) {
			logger.info("Generating estrattoconto for " + unIdLibretto + " ....");
			Document theRootCopy = (Document) theRoot.getDocument().clone();
			Element theRootClass = (Element) theRootCopy.selectSingleNode(".//" + Estrattoconto.INSTANCE_NAME);
			node = theRootClass.addElement(Estrattoconto.SLOT_DI_LIBRETTO);
			node = node.addElement(Libretti.INSTANCE_NAME);
			node = node.addElement("ID");
			node.setText(unIdLibretto.getId());

			String interessiDeducibili = mappaInteressiDeducibili.get(unIdLibretto).toString();
			Double interessi = mappaInteressi.get(unIdLibretto);
			node = theRootClass.addElement(Estrattoconto.SLOT_INTERESSI_INDEDUCIBILI);
			node.setText(interessiDeducibili);
			node = theRootClass.addElement(Estrattoconto.SLOT_INTERESSI_NETTI);
			node.setText(interessi.toString());
			// ricalcolo il lordo!!!
			double lordo = interessi.doubleValue() / (1 - (ritenuta.floatValue() / 100));

			node = theRootClass.addElement(Estrattoconto.SLOT_INTERESSI_LORDI);
			node.setText(new Double(lordo).toString());

			MyLibretti myl = new MyLibretti();
			MySoci s = new MySoci();
			String idSocio = unIdLibretto.getDati_socio().getId();
			Double saldoAdesione = s.saldoCapitaleAdesione(request, idSocio);
			Double saldoQuotePure = s.saldoCapitaleEsclusoRisparmioEsclusaAdesione(request, idSocio);
			Double saldo_libretto_capitale = myl.saldoQuoteRisparmio(request, unIdLibretto.getId());
			Double saldo_libretto_risparmio = myl.saldoRisparmio(request, unIdLibretto.getId());
			double altreQuote = saldoAdesione.doubleValue() + saldoQuotePure.doubleValue();
			node = theRootClass.addElement(Estrattoconto.SLOT_IMPORTO_ALTRE_QUOTE);
			node.setText(new Double(altreQuote).toString());
			node = theRootClass.addElement(Estrattoconto.SLOT_IMPORTO_CAPITALE);
			node.setText(new Double(saldo_libretto_capitale).toString());
			node = theRootClass.addElement(Estrattoconto.SLOT_IMPORTO_PRESTITO);
			node.setText(new Double(saldo_libretto_risparmio).toString());

			Document response;
			try {
				response = ApplicationLibrary.setData(theRootClass.getDocument(), request);
			} catch (Exception e) {
				String message = "Estrattoconto for libretto " + unIdLibretto.getId()
						+ " failed: stopping procedure and rolling back....";
				logger.error(message, e);
				throw new SerenaException(message);
			}
			String[] messages2 = { "", "" };
			int res = ConstantsXSerena.getXserenaRequestResult(response, messages2, Movimenti_Libretti.INSTANCE_NAME);
			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				String message = "Estrattoconto for libretto " + unIdLibretto.getId() + " failed (" + messages2[0]
						+ "): stopping procedure and rolling back....";
				logger.error(message);
				throw new SerenaException(message);
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				String message = "Estrattoconto for libretto " + unIdLibretto.getId() + " OK!";
				logger.info(message);
			}
		}
	}

	private void registraSimulazioneEstrattoconti(HttpServletRequest request, HashMap<Libretti, Double> mappaInteressi,
			HashMap<Libretti, Double> mappaInteressiDeducibili, String dataAccredito, RegolamentoPrestito rp)
					throws SerenaException {
		InsertQuery insert = new InsertQuery(SimulazioneEstrattoconto.INSTANCE_NAME);
		Element theRoot = insert.getFirstClassElement();
		Element node = theRoot.addElement(SimulazioneEstrattoconto.SLOT_DATA);
		node.setText(dataAccredito);
		Float ritenuta = rp.getRitenuta_fiscale();
		for (Libretti unIdLibretto : mappaInteressiDeducibili.keySet()) {
			logger.info("Generating estrattoconto for " + unIdLibretto + " ....");
			Document theRootCopy = (Document) theRoot.getDocument().clone();
			Element theRootClass = (Element) theRootCopy
					.selectSingleNode(".//" + SimulazioneEstrattoconto.INSTANCE_NAME);
			node = theRootClass.addElement(SimulazioneEstrattoconto.SLOT_CODICE_LIBRETTO);
			String codlibretto = unIdLibretto.getCodice_contratto();
			if (unIdLibretto.getData_scadenza()!=null)	{
				codlibretto +=" scad: " +  new SerenaDate(unIdLibretto.getData_scadenza()).toString(SerenaDate.DATE_ITALIAN_PATTERN);
			}
			node.setText(codlibretto);

			node = theRootClass.addElement(SimulazioneEstrattoconto.SLOT_DI_SOCIO);
			node.setText(getDatiSocio(request, unIdLibretto));

			String interessiDeducibili = mappaInteressiDeducibili.get(unIdLibretto).toString();
			Double interessi = mappaInteressi.get(unIdLibretto);
			node = theRootClass.addElement(SimulazioneEstrattoconto.SLOT_INTERESSI_INDEDUCIBILI);
			node.setText(interessiDeducibili);
			node = theRootClass.addElement(SimulazioneEstrattoconto.SLOT_INTERESSI_NETTI);
			node.setText(interessi.toString());
			// ricalcolo il lordo!!!
			double lordo = interessi.doubleValue() / (1 - (ritenuta.floatValue() / 100));

			node = theRootClass.addElement(SimulazioneEstrattoconto.SLOT_INTERESSI_LORDI);
			node.setText(new Double(lordo).toString());

			MyLibretti myl = new MyLibretti();
			MySoci s = new MySoci();
			String idSocio = unIdLibretto.getDati_socio().getId();
			Double saldoAdesione = s.saldoCapitaleAdesione(request, idSocio);
			Double saldoQuotePure = s.saldoCapitaleEsclusoRisparmioEsclusaAdesione(request, idSocio);
			Double saldo_libretto_capitale = myl.saldoQuoteRisparmio(request, unIdLibretto.getId());
			Double saldo_libretto_risparmio = myl.saldoRisparmio(request, unIdLibretto.getId());
			double altreQuote = saldoAdesione.doubleValue() + saldoQuotePure.doubleValue();
			node = theRootClass.addElement(SimulazioneEstrattoconto.SLOT_IMPORTO_ALTRE_QUOTE);
			node.setText(new Double(altreQuote).toString());
			node = theRootClass.addElement(SimulazioneEstrattoconto.SLOT_IMPORTO_CAPITALE);
			node.setText(new Double(saldo_libretto_capitale).toString());
			node = theRootClass.addElement(SimulazioneEstrattoconto.SLOT_IMPORTO_PRESTITO);
			node.setText(new Double(saldo_libretto_risparmio).toString());

			Document response;
			try {
				response = ApplicationLibrary.setData(theRootClass.getDocument(), request);
			} catch (Exception e) {
				String message = "SimulazioneEstrattoconto for libretto " + unIdLibretto.getId()
						+ " failed: stopping procedure and rolling back....";
				logger.error(message, e);
				throw new SerenaException(message);
			}
			String[] messages2 = { "", "" };
			int res = ConstantsXSerena.getXserenaRequestResult(response, messages2, Movimenti_Libretti.INSTANCE_NAME);
			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				String message = "SimulazioneEstrattoconto for libretto " + unIdLibretto.getId() + " failed ("
						+ messages2[0] + "): stopping procedure and rolling back....";
				logger.error(message);
				throw new SerenaException(message);
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				String message = "SimulazioneEstrattoconto for libretto " + unIdLibretto.getId() + " OK!";
				logger.info(message);
			}
		}
	}

	private String getDatiSocio(HttpServletRequest request, Libretti unLibretto) {
		try {
			Soci s = new ExaequoBeanDataManager().getSoci(request, 3, unLibretto.getDati_socio().getId());

			if (s.getDati_consumatore() != null) {
				Consumatori c = s.getDati_consumatore();
				return c.getCognome() + " " + c.getNome();
			} else {
				Organizzazioni o = s.getDati_organizzazione();
				return o.getNome();
			}
		} catch (Exception e) {
			logger.error("Cannot access comsumatore or org from libretto");
			return unLibretto.getDati_socio().getNumero_socio();
		}
	}

	/**
	 * Manual Rollback based upon data accredito and causale and cooperative
	 * 
	 * @param request
	 * @param dataAccredito
	 * @throws SerenaException
	 */
	private String undoAccredito(HttpServletRequest request, String idCooperativa, SerenaDate dataAccredito)
			throws SerenaException {

		/*
		 * La vieto se ANCHE un solo estrattoconoto con questa data accredito e'
		 * gia' stato spedito
		 */
		if (esisteEstrattocontoSpeditoIl(request, dataAccredito)) {

			String mess = "Il sistema ha rilevato che esitono estratticonto  al " + dataAccredito.toString()
					+ " gia' inviati ai soci e, conseguentemente, non puo' procedere con l'operazione.";
			throw new SerenaException(mess);
		}

		String res = "";
		DeleteQuery del = new DeleteQuery(Movimenti_Libretti.INSTANCE_NAME, Movimenti_Libretti.SLOT_DATA_MOVIMENTO,
				dataAccredito.toString());
		Element theRoot = del.getFirstClassElement();
		Element condition = (Element) theRoot.selectSingleNode(".//" + ConstantsXSerena.TAG_CONDITION);
		Element node = condition.addElement(Movimenti_Libretti.SLOT_CAUSALE_LIBRETTO);
		node.setText(Movimenti_Libretti.CAUSALE_LIBRETTO__ACCREDITO_INTERESSI);

		node = condition.addElement(Movimenti_Libretti.SLOT_LIBRETTO);
		node = node.addElement(Libretti.INSTANCE_NAME);
		node = node.addElement(Libretti.SLOT_DATI_SOCIO);
		node = node.addElement(Soci.INSTANCE_NAME);
		node = node.addElement(Soci.SLOT_DI_COOPERATIVA);
		node = node.addElement(Cooperative.INSTANCE_NAME);
		node = node.addElement("ID");
		node.setText(idCooperativa);

		del.setPhysicalDelete(theRoot);

		logger.info("Rolling back on movimenti accredito...");

		Document response;
		try {
			response = ApplicationLibrary.setData(del, request);
		} catch (Exception e) {
			res = "rollback movimenti has failed..";
			logger.error(res, e);
			throw new SerenaException(res);
		}
		if (!XSerenaLibrary.isValidResult(response)) {
			res = "rollback movimenti has failed..";
			logger.error(res);
		} else {
			res = "rollback movimenti has SUCCEDED!";
			logger.info(res);
		}

		del = new DeleteQuery(Estrattoconto.INSTANCE_NAME, Estrattoconto.SLOT_DATA, dataAccredito.toString());
		theRoot = del.getFirstClassElement();
		condition = (Element) theRoot.selectSingleNode(".//" + ConstantsXSerena.TAG_CONDITION);
		node = condition.addElement(Estrattoconto.SLOT_DATA);
		node.setText(dataAccredito.toString());

		del.setPhysicalDelete(theRoot);

		logger.info("Rolling back on estrattoconto...");

		try {
			response = ApplicationLibrary.setData(del, request);
		} catch (Exception e) {
			res = "rollback estrattoconto has failed..";
			logger.error(res, e);
			throw new SerenaException(res);
		}
		if (!XSerenaLibrary.isValidResult(response)) {
			res = "rollback estrattoconto has failed..";
			logger.error(res);
		} else {
			res = "rollback estrattoconto has SUCCEDED!";
			logger.info(res);
		}

		return res;
	}

	private Double calcoloInteressiLibretto(HttpServletRequest request, SerenaDate dataAccredito, Libretti unLibretto,
			RegolamentoPrestito rp) throws SerenaException {
		List<TassoInteresseLibretto> tassi = null;
		try {
			tassi = unLibretto.getTipo_libretto().getTassi_di_interesse();
		} catch (Exception e) {
			String msg = "Attenzione! Libretto " + unLibretto.getCodice_contratto()
					+ " senza condizioni, oppure senza tasso di interesse";
			logger.error(msg);
			throw new SerenaException(msg);
		}
		double interessi = 0;
		for (TassoInteresseLibretto t : tassi) {
			double ammontarePeriodo = calcoloInteressePeriodo(request, dataAccredito, unLibretto, t);
			// process log/info for t,ammontarePeriodo
			interessi += ammontarePeriodo;
		}
		Float ritenuta = rp.getRitenuta_fiscale();
		logger.info("Libretto " + unLibretto.getCodice_contratto() + ": applico ritenuta di " + ritenuta
				+ " al lordo di " + interessi);
		return new Double(interessi * (1 - (ritenuta.floatValue() / 100)));
	}

	private Double calcoloInteressiDeducibiliLibretto(HttpServletRequest request, SerenaDate dataAccredito,
			Libretti unLibretto, RegolamentoPrestito rp) throws SerenaException {
		List<InteressiIndeducibili> tassi = null;
		try {
			tassi = MyInteressiDeducibili.GetInstance(request).getListaTassi();
		} catch (Exception e) {
			String msg = "Attenzione! Lista interessi deducibili vuota!";
			logger.error(msg);
			throw new SerenaException(msg);
		}
		double interessi = 0;
		for (InteressiIndeducibili ii : tassi) {
			TassoInteresseLibretto t = new TassoInteresseLibretto();
			t.setData_fine_validita(ii.getData_fine_validita());
			t.setData_inizio_validita(ii.getData_inizio_validita());
			t.setTasso_interesse(ii.getTasso_interesse());
			double ammontarePeriodo = calcoloInteressePeriodo(request, dataAccredito, unLibretto, t);
			// process log/info for t,ammontarePeriodo
			interessi += ammontarePeriodo;
		}
		logger.info("Libretto " + unLibretto.getCodice_contratto() + " ha interessi deducibili per euro :" + interessi);
		return new Double(interessi);
	}

	private double calcoloInteressePeriodo(HttpServletRequest request, SerenaDate dataAccredito, Libretti unLibretto,
			TassoInteresseLibretto t) throws SerenaException {
		SerenaDate dataFinePeriodo = (SerenaDate) dataAccredito.clone();
		SerenaDate dataInzioPeriodo = (SerenaDate) dataFinePeriodo.clone();
		dataInzioPeriodo.addDays(-1);
		dataInzioPeriodo.addMonths(-12);
		SerenaDate t0 = new SerenaDate(t.getData_inizio_validita());
		SerenaDate t1 = null;
		if (t.getData_fine_validita() != null) {
			t1 = new SerenaDate(t.getData_fine_validita());
		} else {
			t1 = new SerenaDate(A_DAY_IN_THE_FUTURE);
		}

		int whichCase = AccreditoInteressi_Method.WorkoutWhichCase(t0, t1, dataInzioPeriodo, dataFinePeriodo);
		int ggInteressi = 0;

		switch (whichCase) {
		case 1:
			t1 = t1;
			t0 = t0;
			break;
		case 2:
			t1 = dataFinePeriodo;
			t0 = dataInzioPeriodo;
			break;
		case 3:
			t1 = t1;
			t0 = dataInzioPeriodo;
			break;
		case 4:
			t1 = dataFinePeriodo;
			t0 = t0;
			break;
		case 5:
			t1 = t0;
			t0 = t0;
			break;
		default:
			String error = "Caso switch periodo interessi non contemplato!!!";
			logger.fatal(error);
			throw new SerenaException(error);
		}
		ggInteressi = t1.diffInDays(t0);
		// normalisation bisestile:
		if (ggInteressi == 366) {
			ggInteressi = 365;
		}
		float tassoInteresse = t.getTasso_interesse().floatValue();
		MyLibretti l = new MyLibretti();
		// prima computo il saldo ad inizio periodo
		Double saldoRisparmio = l.saldoRisparmioAl(request, unLibretto.getId(), t0);
		double interessiPeriodo = saldoRisparmio.doubleValue() * tassoInteresse / 100 / 365 * ggInteressi;
		// poi ci aggiungo gli interessi dei movimenti postumi
		List<Movimenti_Libretti> movimentiPeriodo = l.getMovimentiDalAl(request, unLibretto.getId(), t0, t1);
		for (Movimenti_Libretti m : movimentiPeriodo) {
			SerenaDate dataMovimento = new SerenaDate(m.getData_movimento());
			int ggInteressiTmp = t1.diffInDays(dataMovimento);
			double tmp = m.getImporto().doubleValue() * tassoInteresse / 100 / 365 * ggInteressiTmp;
			interessiPeriodo += tmp;
		}
		logger.info("Interessi lordi libretto " + unLibretto.getCodice_contratto() + " dal " + t0.toString() + " per "
				+ ggInteressi + " gg  al tasso " + tassoInteresse + " = " + interessiPeriodo);
		return interessiPeriodo;
	}

	public static int WorkoutWhichCase(SerenaDate t0, SerenaDate t1, SerenaDate d0, SerenaDate d1)
			throws SerenaException {
		if ((d0.isBefore(t0) || d0.isDayEqual(t0)) && t0.isBefore(t1) && (t1.isBefore(d1) || t1.isDayEqual(d1))) {
			return 1; // d0 <= t0 < t1 <= d1
		} else if (t0.isBefore(d0) && d0.isBefore(d1) && d1.isBefore(t1)) {
			return 2; // t0 < d0 < d1 < t1
		} else if (t0.isBefore(d0) && (d0.isBefore(t1) || d0.isDayEqual(t1)) && t1.isBefore(d1)) {
			return 3; // t0 < d0 <= t1 < d1
		} else if (d0.isBefore(t0) && t0.isBefore(d1) && d1.isBefore(t1)) {
			return 4; // d0 < t0 < d1 < t1
		} else {
			return 5; // fuori periodo
		}
	}

	private List<Libretti> fecthLibrettiAttivi(HttpServletRequest request, String id_cooperativa)
			throws SerenaException {
		try {
			logger.info("Loading libretti");
			// compute condition
			final Document document = DocumentHelper.createDocument();
			document.setXMLEncoding("UTF-8");
			Element condition = document.addElement(ConstantsXSerena.TAG_AND);
			// condizione coopersativa
			Element item = condition.addElement(Libretti.SLOT_DATI_SOCIO);
			item = item.addElement(Soci.INSTANCE_NAME);
			item = item.addElement(Soci.SLOT_DI_COOPERATIVA);
			item = item.addElement(Cooperative.INSTANCE_NAME);
			item = item.addElement("ID");
			item.setText(id_cooperativa);
			// condizione non chiusi
			item = condition.addElement(Libretti.SLOT_STATO_LIBRETTO);
			item.setText(Libretti.STATO_LIBRETTO__ATTIVO);
			// TODO ... quesry esplicita!!!!
			return new ExaequoBeanDataManager().getLibrettiList(request, condition, 3);
		} catch (Exception any) {
			String msg = "Could not load libretti attivi: " + any.getMessage();
			logger.error(msg, any);
			throw new SerenaException(msg, any);
		}
	}

	private boolean movimentiDiAccreditoInteressiIl(HttpServletRequest request, String id_cooperativa,
			SerenaDate dataAccredito) throws SerenaException {

		boolean movimentiSi = false;
		try {
			logger.info(
					"cerco movimento di accredito interessi per " + id_cooperativa + " al " + dataAccredito.toString());
			Element currentElement = ObjectUtils.getXserenaRequestStandardHeader(request.getSession().getId(),
					ConstantsXSerena.ACTION_GET, Movimenti_Libretti.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET, ConstantsXSerena.TARGET_ALL);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS, "0");
			Element condition = currentElement.addElement(ConstantsXSerena.TAG_CONDITION);
			Element item = condition.addElement(Movimenti_Libretti.SLOT_DATA_MOVIMENTO);
			item.setText(dataAccredito.toString());
			item = condition.addElement(Movimenti_Libretti.SLOT_CAUSALE_LIBRETTO);
			item.setText(Movimenti_Libretti.CAUSALE_LIBRETTO__ACCREDITO_INTERESSI);
			item = condition.addElement(Movimenti_Libretti.SLOT_LIBRETTO);
			item = item.addElement(Libretti.INSTANCE_NAME);
			item = item.addElement(Libretti.SLOT_DATI_SOCIO);
			item = item.addElement(Soci.INSTANCE_NAME);
			item = item.addElement(Soci.SLOT_DI_COOPERATIVA);
			item = item.addElement("ID");
			item.setText(id_cooperativa);

			String[] messages = { "", "" };
			Document resultData = ApplicationLibrary.getData(currentElement.getDocument(), request);
			Element data = ApplicationLibrary.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages, Movimenti_Libretti.INSTANCE_NAME);

			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("Errore in ricerca movimenti di accredito interessi " + messages[0]);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				movimentiSi = false;
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {

				movimentiSi = true;
			}
			return movimentiSi;
		} catch (Exception any) {
			String msg = "Errore in ricerca movimenti di accredito interessi: " + any.getMessage();
			logger.error(msg, any);
			throw new SerenaException(msg, any);
		}
	}

	private boolean esisteEstrattocontoSpeditoIl(HttpServletRequest request, SerenaDate dataAccredito)
			throws SerenaException {

		boolean movimentiSi = false;
		try {
			logger.info("cerco estrattoconti spediti del " + dataAccredito.toString());
			Element currentElement = ObjectUtils.getXserenaRequestStandardHeader(request.getSession().getId(),
					ConstantsXSerena.ACTION_GET, Estrattoconto.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET, ConstantsXSerena.TARGET_ALL);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS, "0");
			Element condition = currentElement.addElement(ConstantsXSerena.TAG_CONDITION);
			Element item = condition.addElement(Estrattoconto.SLOT_DATA);
			item.setText(dataAccredito.toString());
			item = condition.addElement(Estrattoconto.SLOT_INVIATO_IL);
			item.setText(ConstantsXSerena.VAL_NULL);
			item.addAttribute(ConstantsXSerena.ATTR_OPERATOR, ConstantsXSerena.VAL_NOT);

			String[] messages = { "", "" };
			Document resultData = ApplicationLibrary.getData(currentElement.getDocument(), request);
			Element data = ApplicationLibrary.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages, Estrattoconto.INSTANCE_NAME);

			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("Errore in ricerca Estrattoconto " + messages[0]);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				movimentiSi = false;
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {

				movimentiSi = true;
			}
			return movimentiSi;
		} catch (Exception any) {
			String msg = "Errore in ricerca Estrattoconto: " + any.getMessage();
			logger.error(msg, any);
			throw new SerenaException(msg, any);
		}
	}

	/**
	 * Calcola la data accredito in base ai parametri di Reg. Prestito e alla
	 * data corrente ... a meno che l'anno non sia formato
	 * 
	 * @param r
	 * @param year
	 * @return
	 * @throws SerenaException
	 */
	public static SerenaDate computeDataAccredito(RegolamentoPrestito r, String year) throws SerenaException {
		SerenaDate sd = new SerenaDate();

		String whichYear = (year == null || year.isEmpty()) ? (new Integer(sd.getYear()).toString()) : year;

		return new SerenaDate(r.getAccredito_interessi() + "/" + whichYear);
	}

	public static RegolamentoPrestito loadRegolamentoPrestito(HttpServletRequest request, String id_cooperativa)
			throws SerenaException {
		// TODO Auto-generated method stub
		RegolamentoPrestito obj = null;
		try {
			logger.info("Loading regolamento prestito per coop " + id_cooperativa);
			Element currentElement = ObjectUtils.getXserenaRequestStandardHeader(request.getSession().getId(),
					ConstantsXSerena.ACTION_GET, RegolamentoPrestito.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET, ConstantsXSerena.TARGET_ALL);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS, "0");
			Element condition = currentElement.addElement(ConstantsXSerena.TAG_CONDITION);
			condition = condition.addElement(RegolamentoPrestito.SLOT_INVERSE_OF_REGOLAMENTO_PRESTITO);
			condition = condition.addElement(Cooperative.INSTANCE_NAME);
			condition = condition.addElement("ID");
			condition.setText(id_cooperativa);

			String[] messages = { "", "" };
			Document resultData = ApplicationLibrary.getData(currentElement.getDocument(), request);
			Element data = ApplicationLibrary.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages, RegolamentoPrestito.INSTANCE_NAME);

			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("Cannot load regolamento prestito " + messages[0]);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				logger.error("Cannot load regolamento prestito: NOT FOUND");
				throw new SerenaException("nessuna regolamento prestito per coop " + id_cooperativa);
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				Element regolamento = (Element) data.selectSingleNode(RegolamentoPrestito.INSTANCE_NAME);

				obj = new ExaequoBinder().createRegolamentoPrestito(regolamento);
			}
			logger.trace("DONE!");
			return obj;
		} catch (Exception any) {
			String msg = "Could not regolamento prestito: " + any.getMessage();
			logger.error(msg, any);
			throw new SerenaException(msg, any);
		}
	}
}

package eu.anastasis.serena.inziativesolidali;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import eu.anastasis.serena.application.modules.BirtReport.GiveMethod;
import eu.anastasis.serena.application.modules.BirtReport.engine.*;
import eu.anastasis.serena.application.core.modules.DefaultModule;
import eu.anastasis.serena.beans.CondizioniLibretto;
import eu.anastasis.serena.beans.Cooperative;
import eu.anastasis.serena.beans.ExaequoBeanDataManager;
import eu.anastasis.serena.beans.ExaequoBinder;
import eu.anastasis.serena.beans.Libretti;
import eu.anastasis.serena.beans.Movimenti_Libretti;
import eu.anastasis.serena.beans.RegolamentoPrestito;
import eu.anastasis.serena.beans.Soci;
import eu.anastasis.serena.beans.exaequo.MyLibretti;
import eu.anastasis.serena.common.SerenaDate;
import eu.anastasis.serena.exception.SerenaException;

// localhost:8080/Iniziative/ModuleIndex?q=iniziativesolidali/genera_modulo_accredito_interessi/CLS=Libretti/ID=130/DOC=ModuloAccreditoInteressi/FILE=Modulo_Accredito_130/TYPE=pdf

public class GeneraModuloAccreditoInteressiMethod extends GiveMethod {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(GeneraModuloAccreditoInteressiMethod.class);
	
	protected static final String VIRTUAL_VAR_OPZIONE_QUOTE_NUMERO = "opzione_quote_numero";
	protected static final String VIRTUAL_VAR_OPZIONE_QUOTE_VALORE = "opzione_quote_valore";
	protected static final String VIRTUAL_VAR_OPZIONE_QUOTE_VALORE_TOTALE = "opzione_quote_valore_totale";
	protected static final String VIRTUAL_VAR_OPZIONE_QUOTE_RESTO_IN_LIBRETTO = "opzione_quote_resto_in_libretto";
	protected static final String VIRTUAL_VAR_INTERESSI_NETTI = "libretto_interessi_netti";
	protected static final String VIRTUAL_VAR_DATA_0 = "data_0"; // fine anno																// precedente
	protected static final String VIRTUAL_VAR_DATA_1 = "data_1"; // fine anno
	protected static final String VIRTUAL_VAR_DATA_2 = "data_2"; // inziio nuovo

	protected static final String VIRTUAL_ERROR = "error";

	public static final String METHOD_NAME = "genera_modulo_accredito_interessi";


	public GeneraModuloAccreditoInteressiMethod(DefaultModule parentModule,
			String[] defaultParameters) {
		super(parentModule, defaultParameters);
	}

	public GeneraModuloAccreditoInteressiMethod() {
		super(null,null);
	}

	@Override
	/**
	 * servono: nome socio, id libretto, iban e banca, interessi netti, conversione in quote + resto in libretto, periodo interessi
	 */
	protected Document retrieveData(HttpServletRequest request,
			ReportEngine engine, File designFile) throws SerenaException {
		Document ret = null;
		try	{
			// prelevo l'xml ritornato dalla query
			ret = super.retrieveData(request, engine, designFile);
			postProcess(request,ret);
		} catch (Exception e)	{
			String theError = "Errore in generazione modulo accredito interessi libretto: "+ e.getMessage();
			logger.error(theError);
			throw new SerenaException(theError);
		}
		return ret;
	}
			
			
	public  void postProcess(HttpServletRequest request, Document ret)	throws SerenaException {
		try {
			
			Element libretto = (Element) ret.selectSingleNode(".//"
					+ Libretti.INSTANCE_NAME);
	
			ExaequoBinder eb = new ExaequoBinder();
			Libretti ilLibretto = eb.createLibretti(libretto);
			
			MyLibretti myLib = new MyLibretti(ilLibretto);
			
			String idLibretto = ilLibretto.getId();
			
			Element datiSocio =libretto.element("dati_socio").element("Soci"); 
			Soci ilSocio = eb.createSoci(datiSocio);		
			
			// fetch regolamento prestito
			RegolamentoPrestito rp = AccreditoInteressi_Method
					.loadRegolamentoPrestito(request, "1");   // exaequo e' cooperativa 1 //TODO manteniamo la parametrizzazione?!?!?!? 
			
			CondizioniLibretto cL = ilLibretto.getTipo_libretto();
			cL = new ExaequoBeanDataManager().getCondizioniLibretto(request, 2, cL.getId());
	
			Cooperative coop = cL.getInverse_of_condizioni_libretti();
			// controllo esistenza accrediti data corrente
			SerenaDate dataAccredito = AccreditoInteressi_Method
					.computeDataAccredito(rp,null);
			
			SerenaDate inizioPeriodo = (SerenaDate) dataAccredito.clone();
			
			inizioPeriodo.subtractYears(1);
			
	
			SerenaDate tmpDate = (SerenaDate) dataAccredito.clone();
			tmpDate.subtractDays(1);
			
			Element extra = libretto.addElement(VIRTUAL_VAR_DATA_2);
			extra.setText(tmpDate.toString());
	
			extra = libretto.addElement(VIRTUAL_VAR_DATA_1);
			extra.setText(inizioPeriodo.toString());
	
			extra = libretto.addElement(VIRTUAL_VAR_DATA_0);
			tmpDate.subtractYears(1);
			extra.setText(inizioPeriodo.toString());
			
			extra = libretto.addElement(VIRTUAL_VAR_OPZIONE_QUOTE_VALORE);			
			extra.setText(coop.getValore_quota().toString());
			double valoreQuota = coop.getValore_quota();
			
				// movimenti dalla data 0
	
			Element movimenti = myLib.getMovimentiAnno(request,inizioPeriodo);
	
			if (movimenti == null) {
				logger.error("Libretto ID " + idLibretto + " senza accredito! ");
				//TODO tornare errore!!!
			}
			List<Element> movs = movimenti.selectNodes(".//"
					+ Movimenti_Libretti.INSTANCE_NAME);
			
			Movimenti_Libretti accreditoInteressi = null;
			for (Element mov : movs) {
				String data = mov
						.elementText(Movimenti_Libretti.SLOT_DATA_MOVIMENTO);
				String causale = mov
						.elementText(Movimenti_Libretti.SLOT_CAUSALE_LIBRETTO);
				String accreditoNetto = mov
						.elementText(Movimenti_Libretti.SLOT_IMPORTO);
				if (new SerenaDate(data).equals(dataAccredito)
						&& Movimenti_Libretti.CAUSALE_LIBRETTO__ACCREDITO_INTERESSI
								.equals(causale)) {
					// movimento di accredito
					accreditoInteressi = eb.createMovimenti_Libretti(mov);
				} 
			}
			
			double importo = 0;
			if (accreditoInteressi==null){
				//TODO errore: movimento accredito non trovato!!!!
				String theError = "Movimento accredito interessi per libretto " + ilLibretto.getCodice_contratto() + " non trovato!";
				logger.error(theError);
				extra = libretto.addElement(VIRTUAL_ERROR);
				extra.setText(theError);
			} else {
				extra = libretto.addElement(VIRTUAL_VAR_INTERESSI_NETTI);
				extra.setText(accreditoInteressi.getImporto().toString());
				importo = accreditoInteressi.getImporto();
				double resto = importo % valoreQuota;
				int  numeroQuote = (int)(importo / valoreQuota);
				extra = libretto.addElement(VIRTUAL_VAR_OPZIONE_QUOTE_NUMERO);
				extra.setText(new Integer(numeroQuote).toString());
				extra = libretto.addElement(VIRTUAL_VAR_OPZIONE_QUOTE_VALORE_TOTALE);
				extra.setText(new Double(numeroQuote*valoreQuota).toString());
				extra = libretto.addElement(VIRTUAL_VAR_OPZIONE_QUOTE_RESTO_IN_LIBRETTO);
				extra.setText(new Double(resto).toString());
			}
		} catch (Exception e)	{
			String theError = "Errore in generazione modulo accredito interessi libretto: "+ e.getMessage();
			logger.error(theError);
			throw new SerenaException(theError);
		}
	}
	
	


	@Override
	protected String getName() {
		return METHOD_NAME;
	}
}

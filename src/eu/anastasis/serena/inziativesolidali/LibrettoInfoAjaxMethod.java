package eu.anastasis.serena.inziativesolidali;


import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import eu.anastasis.serena.application.core.modules.AjaxMethod;
import eu.anastasis.serena.application.core.modules.DefaultModule;
import eu.anastasis.serena.application.index.util.ApplicationLibrary;
import eu.anastasis.serena.application.modules.object.ObjectUtils;
import eu.anastasis.serena.beans.CondizioniLibretto;
import eu.anastasis.serena.beans.Cooperative;
import eu.anastasis.serena.beans.ExaequoBeanDataManager;
import eu.anastasis.serena.beans.ExaequoBinder;
import eu.anastasis.serena.beans.Libretti;
import eu.anastasis.serena.beans.RegolamentoPrestito;
import eu.anastasis.serena.beans.Soci;
import eu.anastasis.serena.beans.exaequo.MyLibretti;
import eu.anastasis.serena.beans.exaequo.MySoci;
import eu.anastasis.serena.common.XMessage;
import eu.anastasis.serena.constants.ConstantsXSerena;
import eu.anastasis.serena.exception.SerenaException;

/**
 * Metodo ajax per tornare tutti i dati "salienti" di un libretto, presi da tre istanze:
 * - condizioni libretto
 * - cooperativa
 * - regolamento prestito
 * @author afrascari
 *
 */
public class LibrettoInfoAjaxMethod extends AjaxMethod 
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LibrettoInfoAjaxMethod.class);


	private static final String METHOD_NAME = "infolibretto";

	
	public LibrettoInfoAjaxMethod(DefaultModule parentModule,String[] defaultParameters)
	{
		super(parentModule, defaultParameters);
	}

	@Override
	protected String getName()
	{
		return METHOD_NAME;
	}

	@Override
	public String doMethod(HttpServletRequest request,HttpServletResponse response) throws SerenaException
	{
		XMessage msg=null;
		String id=getMethodParameter(request,"id");
		try
		{
			msg=new XMessage("reply");
			Element mp=DocumentHelper.createElement("libretto");
			msg.add(mp);
			
			// load and compute ...
			CondizioniLibretto res = this.load(request, id);
			Libretti l = new ExaequoBeanDataManager().getLibretti(request, 0, id);
			MySoci ms = new MySoci();
			MyLibretti  ml = new MyLibretti(l); 
			ms.loadFromLibretto(request, id);
			Soci socio = ms.getMy_instance();
			Double saldo_capitale = ms.saldoCapitaleEsclusoRisparmio(request, socio.getId());
			Double saldo_risparmio = ml.saldoRisparmio(request, id);
			Double ultimo_accredito = ml.getUltimoAccredito(request, id).getImporto();
			
			
			Element node = mp.addElement("saldo_capitale");
			node.setText(saldo_capitale.toString());
			
			node = mp.addElement("saldo_risparmio");
			node.setText(saldo_risparmio.toString());
			
			node = mp.addElement("socio");
			node.setText("socio numero: "+socio.getNumero_socio()+" codice fiscale: "+socio.getCodice_fiscale());
			
			node = mp.addElement("ultimo_accredito");
			node.setText(ultimo_accredito.toString());
			
			node = mp.addElement("banca");
			node.setText(ml.getMy_instance().getBanca_di_riferimento());
			
			node = mp.addElement("iban");
			node.setText(ml.getMy_instance().getIban());
			
			node = mp.addElement(CondizioniLibretto.SLOT_TIPOLOGIA_DEPOSITO);
			node.setText(res.getTipologia_deposito());
			node = mp.addElement(CondizioniLibretto.SLOT_VINCOLO);
			node.setText(res.getVincolo());

			Cooperative coop = res.getInverse_of_condizioni_libretti();
			node = mp.addElement(Cooperative.SLOT_DESCRIZIONE);
			node.setText(coop.getDescrizione());			
			node = mp.addElement(Cooperative.SLOT_VALORE_QUOTA);
			node.setText(coop.getValore_quota().toString());
			
			RegolamentoPrestito reg = coop.getRegolamento_prestito();
			if (reg.getCosto_singola_operazione()!=null)	{
				node = mp.addElement(RegolamentoPrestito.SLOT_COSTO_SINGOLA_OPERAZIONE);
				node.setText(reg.getCosto_singola_operazione().toString());
			}
			if (reg.getGiorni_valuta()!=null)	{
				node = mp.addElement(RegolamentoPrestito.SLOT_GIORNI_VALUTA);
				node.setText(reg.getGiorni_valuta().toString());
			}
			node = mp.addElement(RegolamentoPrestito.SLOT_IMPORTO_MASSIMO_PRESTITO);
			node.setText(reg.getImporto_massimo_prestito().toString());
			node = mp.addElement(RegolamentoPrestito.SLOT_RAPPORTO_PRESTITO_CAPITALE);
			node.setText(reg.getRapporto_prestito_capitale().toString());
			
			/*available slots: 
			CondizioniLibretto.SLOT_DATA_INIZIO_VALIDITA
			CondizioniLibretto.SLOT_DATA_FINE_VALIDITA
			CondizioniLibretto.SLOT_MODALITA_CALCOLO_INTERESSI
			CondizioniLibretto.SLOT_TASSO_INTERESSE
			CondizioniLibretto.SLOT_TIPOLOGIA_DEPOSITO
			CondizioniLibretto.SLOT_VINCOLO
			
			Cooperative.SLOT_DESCRIZIONE
			Cooperative.SLOT_LIQUIDAZIONE_QUOTE_ESERCIZIO_GIORNI
			Cooperative.SLOT_NUMERO_QUOTE_ASSOCIAZIONE
			Cooperative.SLOT_VALORE_QUOTA
			
			RegolamentoPrestito.SLOT_COSTO_SINGOLA_OPERAZIONE
			RegolamentoPrestito.SLOT_ACCREDITO_INTERESSI
			RegolamentoPrestito.SLOT_APERTURA_LIBRETTO_DOPO_ADESIONE_GIORNI
			RegolamentoPrestito.SLOT_COMUNIQCAZIONE_MODIFICHE_GIORNI
			RegolamentoPrestito.SLOT_GIORNI_VALUTA
			RegolamentoPrestito.SLOT_IMPORTO_MASSIMO_PRESTITO
			RegolamentoPrestito.SLOT_LIQUIDAZIONE_INTERESSI_CHIUSURA
			RegolamentoPrestito.SLOT_RAPPORTO_PRESTITO_CAPITALE
			RegolamentoPrestito.SLOT_RITENUTA_FISCALE
			RegolamentoPrestito.SLOT_SPESE_RICHIESTA_DOCUMENTAZIONE
			RegolamentoPrestito.SLOT_SPESE_TENUTA_CONTO
			 */
 
		} catch (Exception e)
		{
			String errorMessage = "Impossibile trovare libretto " + id;
			msg=XMessage.getMessaggioErrore(errorMessage);
			logger.error(errorMessage, e);
			return msg.asXML();
		}
		return msg.asXML();
	}
	
	public CondizioniLibretto load(HttpServletRequest request, String idLibretto) throws SerenaException {
		// TODO Auto-generated method stub
		CondizioniLibretto condObj = null;
		try	{
			logger.info("Loading info libretto "+idLibretto);
			Element currentElement = ObjectUtils.getXserenaRequestStandardHeader(request.getSession().getId(), ConstantsXSerena.ACTION_GET, CondizioniLibretto.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET, ConstantsXSerena.TARGET_SPECIFIED);
			Element condition =currentElement.addElement(ConstantsXSerena.TAG_CONDITION); 
			condition =condition.addElement(CondizioniLibretto.SLOT_INVERSE_OF_TIPO_LIBRETTO);
			condition =condition.addElement(Libretti.INSTANCE_NAME);
			condition =condition.addElement("ID");
			condition.setText(idLibretto);
			
			currentElement.addElement(CondizioniLibretto.SLOT_DATA_INIZIO_VALIDITA);
			currentElement.addElement(CondizioniLibretto.SLOT_DATA_FINE_VALIDITA);
			currentElement.addElement(CondizioniLibretto.SLOT_MODALITA_CALCOLO_INTERESSI);
			currentElement.addElement(CondizioniLibretto.SLOT_TIPOLOGIA_DEPOSITO);
			currentElement.addElement(CondizioniLibretto.SLOT_VINCOLO);
			
			Element anItem =currentElement.addElement(CondizioniLibretto.SLOT_INVERSE_OF_CONDIZIONI_LIBRETTI); 
			anItem =anItem.addElement(Cooperative.INSTANCE_NAME);
			anItem.addElement(Cooperative.SLOT_DESCRIZIONE);
			anItem.addElement(Cooperative.SLOT_LIQUIDAZIONE_QUOTE_ESERCIZIO_GIORNI);
			anItem.addElement(Cooperative.SLOT_NUMERO_QUOTE_ASSOCIAZIONE);
			anItem.addElement(Cooperative.SLOT_VALORE_QUOTA);
			
			anItem =anItem.addElement(Cooperative.SLOT_REGOLAMENTO_PRESTITO);
			anItem =anItem.addElement(RegolamentoPrestito.INSTANCE_NAME);
			anItem.addElement(RegolamentoPrestito.SLOT_COSTO_SINGOLA_OPERAZIONE);
			anItem.addElement(RegolamentoPrestito.SLOT_ACCREDITO_INTERESSI);
			anItem.addElement(RegolamentoPrestito.SLOT_APERTURA_LIBRETTO_DOPO_ADESIONE_GIORNI);
			anItem.addElement(RegolamentoPrestito.SLOT_COMUNIQCAZIONE_MODIFICHE_GIORNI);
			anItem.addElement(RegolamentoPrestito.SLOT_GIORNI_VALUTA);
			anItem.addElement(RegolamentoPrestito.SLOT_IMPORTO_MASSIMO_PRESTITO);
			anItem.addElement(RegolamentoPrestito.SLOT_LIQUIDAZIONE_INTERESSI_CHIUSURA);
			anItem.addElement(RegolamentoPrestito.SLOT_RAPPORTO_PRESTITO_CAPITALE);
			anItem.addElement(RegolamentoPrestito.SLOT_RITENUTA_FISCALE);
			anItem.addElement(RegolamentoPrestito.SLOT_SPESE_RICHIESTA_DOCUMENTAZIONE);
			anItem.addElement(RegolamentoPrestito.SLOT_SPESE_TENUTA_CONTO);
			
			String[] messages={"",""};
			Document resultData=ApplicationLibrary.getData(currentElement.getDocument(), request);
			Element data = ApplicationLibrary.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages,CondizioniLibretto.INSTANCE_NAME);
	
			if (res==ConstantsXSerena.XSERENA_RESULT_ERROR)
			{
				logger.error("Cannot load CondizioniLibretto "+messages[0] );
				throw new SerenaException(messages[0],"generic_sql_error");
			}
			else if (res==ConstantsXSerena.XSERENA_RESULT_EMPTY)
			{
				logger.error("Cannot load CondizioniLibretto: NOT FOUND");
				throw new SerenaException("nessuna CondizioniLibretto");
			}
			else if (res==ConstantsXSerena.XSERENA_RESULT_SUCCESS)
			{
				Element condizioni = (Element)data.selectSingleNode(CondizioniLibretto.INSTANCE_NAME);
				if (condizioni==null)	{
					// errore: nessuna o troppe condizioni trovate!: //TODO
				}
				condObj = new CondizioniLibretto();
				
				condObj = new ExaequoBinder().createCondizioniLibretto(condizioni);

				/*
				
				SimpleDateFormat myDateFormat = new SimpleDateFormat(PersistenceConfiguration.GetInstance().getParametro(CostantiArchitettura.INTERFACE_DATE_FORMAT));
	
				condObj.setId(condizioni.elementText("ID"));
				String aDate = condizioni.elementText(CondizioniLibretto.SLOT_DATA_INIZIO_VALIDITA);
				Date myDate = myDateFormat.parse(aDate);
				condObj.setData_inizio_validita(myDate);
	
				aDate = condizioni.elementText(CondizioniLibretto.SLOT_DATA_FINE_VALIDITA);
				if (aDate!=null){			
					myDate = myDateFormat.parse(aDate);
					condObj.setData_fine_validita(myDate);
				}
				
				condObj.setModalita_calcolo_interessi(condizioni.elementText(CondizioniLibretto.SLOT_MODALITA_CALCOLO_INTERESSI));			
				condObj.setTasso_interesse(new Float(condizioni.elementText(CondizioniLibretto.SLOT_TASSO_INTERESSE)));
				condObj.setTipologia_deposito(condizioni.elementText(CondizioniLibretto.SLOT_TIPOLOGIA_DEPOSITO));
				condObj.setVincolo(condizioni.elementText(CondizioniLibretto.SLOT_VINCOLO));
				*/
			}
			
			logger.trace("DONE!");
			return condObj;
		} catch  (Exception any)	{
			String msg = "Could not load info libretto: "+any.getMessage();
			logger.error(msg,any);
			throw new SerenaException(msg,any);
			}
		}
	
	
	
	
	
	
	
	
}

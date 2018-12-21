package eu.anastasis.serena.beans.exaequo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import eu.anastasis.serena.application.core.tasks.CronPersistenceHome;
import eu.anastasis.serena.application.index.util.ApplicationLibrary;
import eu.anastasis.serena.application.modules.object.ObjectUtils;
import eu.anastasis.serena.beans.ExaequoBinder;
import eu.anastasis.serena.beans.Libretti;
import eu.anastasis.serena.beans.Movimenti_Quote;
import eu.anastasis.serena.beans.Soci;
import eu.anastasis.serena.constants.ConstantsXSerena;
import eu.anastasis.serena.exception.SerenaException;


public class MySoci {

	private static final Logger logger = Logger.getLogger(MySoci.class);	
	
	private Soci my_instance=null;
	
	public Soci getMy_instance() {
		return my_instance;
	}

	public void setMy_instance(Soci my_instance) {
		this.my_instance = my_instance;
	}

	/**
	 * Calcola il saldo del capitale del socio .... ESCLUSE LE QUOTE ASSOCIATE AL RISPARMIO
	 * @param request
	 * @param idSocio
	 * @return
	 * @throws SerenaException
	 */
	public Double saldoCapitaleEsclusoRisparmio(HttpServletRequest request, String idSocio ) throws SerenaException {
		return saldoCapitaleParametrizzato(request, idSocio, "saldi-capitale");
	}

	public Double saldoCapitaleEsclusoRisparmioEsclusaAdesione(HttpServletRequest request, String idSocio ) throws SerenaException {
		return saldoCapitaleParametrizzato(request, idSocio, "saldi-capitale-no-adesione");
	}
	
	public Double saldoCapitaleAdesione(HttpServletRequest request, String idSocio ) throws SerenaException {
		return saldoCapitaleParametrizzato(request, idSocio, "saldi-adesione");
	}
	
	public Double saldoCapitaleRisparmio(HttpServletRequest request, String idSocio ) throws SerenaException {
		return saldoCapitaleParametrizzato(request, idSocio, "saldi-risparmio");
	}
	
	public Double saldoCapitaleTotale(HttpServletRequest request, String idSocio ) throws SerenaException {
		return saldoCapitaleParametrizzato(request, idSocio, "saldi");
	}

	
	public Double saldoCapitaleParametrizzato(HttpServletRequest request, String idSocio, String datasource) throws SerenaException {
		// TODO Auto-generated method stub
		Double saldo = null;
		try	{
			logger.info("Saldo capitale socio "+idSocio);
			Element currentElement = ObjectUtils.getXserenaRequestStandardHeader(request.getSession().getId(), ConstantsXSerena.ACTION_GET, Movimenti_Quote.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET, ConstantsXSerena.TARGET_ALL);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS, "0");
			currentElement.addAttribute(ConstantsXSerena.ATTR_FORCED_DATASOURCE, datasource);
			
			Element condition =currentElement.addElement(ConstantsXSerena.TAG_CONDITION); 
			condition =condition.addElement(Movimenti_Quote.SLOT_SOCIO);
			condition =condition.addElement(Soci.INSTANCE_NAME);
			condition =condition.addElement("ID");
			condition.setText(idSocio);
						
			String[] messages={"",""};
			Document resultData=ApplicationLibrary.getData(currentElement.getDocument(), request);
			Element data = ApplicationLibrary.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages,Movimenti_Quote.INSTANCE_NAME);
	
			if (res==ConstantsXSerena.XSERENA_RESULT_ERROR)
			{
				logger.error("Cannot compute Saldo capitale socio "+messages[0] );
				throw new SerenaException(messages[0],"generic_sql_error");
			}
			else if (res==ConstantsXSerena.XSERENA_RESULT_EMPTY)
			{
				logger.info("Saldo Quote is 0");
				return new Double(0);
			}
			else if (res==ConstantsXSerena.XSERENA_RESULT_SUCCESS)
			{
				Element virtualquota= (Element)data.selectSingleNode(Movimenti_Quote.INSTANCE_NAME);
				if (virtualquota!=null && !virtualquota.elementText(Movimenti_Quote.SLOT_DI_VALORE).isEmpty())	{
					saldo = new Double(virtualquota.elementText(Movimenti_Quote.SLOT_DI_VALORE));
				} else {
					saldo = new Double(0);
				}
			}
			return saldo;
		} catch  (Exception any)	{
			String msg = "Cannot compute Saldo capitale socio: "+any.getMessage();
			logger.error(msg,any);
			throw new SerenaException(msg,any);
			}
	}
	
	 
	public  void loadFromLibretto(HttpServletRequest request, String idLibretto) throws SerenaException {
		// TODO Auto-generated method stub
		try	{
			logger.info("Loading socio di libretto "+idLibretto);
			Element currentElement = ObjectUtils.getXserenaRequestStandardHeader(request.getSession().getId(), ConstantsXSerena.ACTION_GET, Soci.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET, ConstantsXSerena.TARGET_ALL);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS, "0");
			Element condition =currentElement.addElement(ConstantsXSerena.TAG_CONDITION); 
			condition =condition.addElement(Soci.SLOT_RISPARMIO);
			condition =condition.addElement(Libretti.INSTANCE_NAME);
			condition =condition.addElement("ID");
			condition.setText(idLibretto);
						
			String[] messages={"",""};
			Document resultData=ApplicationLibrary.getData(currentElement.getDocument(), request);
			Element data = ApplicationLibrary.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages,Soci.INSTANCE_NAME);
	
			if (res==ConstantsXSerena.XSERENA_RESULT_ERROR)
			{
				logger.error("Cannot load socio "+messages[0] );
				throw new SerenaException(messages[0],"generic_sql_error");
			}
			else if (res==ConstantsXSerena.XSERENA_RESULT_EMPTY)
			{
				logger.error("Cannot load socio");
				throw new SerenaException("nessuna Cooperativa");
			}
			else if (res==ConstantsXSerena.XSERENA_RESULT_SUCCESS)
			{
				Element socio = (Element)data.selectSingleNode(Soci.INSTANCE_NAME);
				Soci s =new ExaequoBinder().createSoci(socio);
				this.setMy_instance(s);				
			}
		} catch  (Exception any)	{
			String msg = "Could not load socio: "+any.getMessage();
			logger.error(msg,any);
			throw new SerenaException(msg,any);
			}
	}
}

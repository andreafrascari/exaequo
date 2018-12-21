package eu.anastasis.serena.beans.exaequo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import eu.anastasis.serena.application.core.tasks.CronPersistenceHome;
import eu.anastasis.serena.application.index.util.ApplicationLibrary;
import eu.anastasis.serena.application.modules.object.ObjectUtils;
import eu.anastasis.serena.beans.Cooperative;
import eu.anastasis.serena.constants.ConstantsXSerena;
import eu.anastasis.serena.exception.SerenaException;


public class MyCooperative extends Cooperative {

	private static final Logger logger = Logger.getLogger(MyCooperative.class);	
	private static HashMap<String,MyCooperative> MYCACHE = null;
	
	public MyCooperative getInstance(String ID) throws SerenaException {
		if (MYCACHE==null)
			loadCache();
		return MYCACHE.get(ID);
	}
	
	public  Collection<MyCooperative> allInstances()	throws SerenaException {
		if (MYCACHE==null)
			loadCache();
		return MYCACHE.values();
	}
	 
	
	public void reasetCache() throws SerenaException {
		loadCache();
	}

	public void loadCache() throws SerenaException {
		// TODO Auto-generated method stub
	try	{
		MYCACHE = new HashMap<String, MyCooperative>();
		
		logger.trace("Loading cache cooperative...");
		Element currentElement = ObjectUtils.getXserenaRequestStandardHeader("opcache", ConstantsXSerena.ACTION_GET, INSTANCE_NAME);
		currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_SELECT);
		currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET, ConstantsXSerena.TARGET_ALL);
		currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS, "0");		
		String[] messages={"",""};
		Document resultData=new CronPersistenceHome().get(currentElement.getDocument());
		Element data = ApplicationLibrary.prepareDataForPresentation(resultData);
		int res = ConstantsXSerena.getXserenaRequestResult(data, messages,INSTANCE_NAME);

		if (res==ConstantsXSerena.XSERENA_RESULT_ERROR)
		{
			logger.error("Cannot startup Cooperative cache "+messages[0] );
			throw new SerenaException(messages[0],"generic_sql_error");
		}
		else if (res==ConstantsXSerena.XSERENA_RESULT_EMPTY)
		{
			logger.error("Cannot startup Cooperative cache: NO Cooperative FOUND");
			throw new SerenaException("nessuna Cooperativa");
		}
		else if (res==ConstantsXSerena.XSERENA_RESULT_SUCCESS)
		{
			List<Element> leCooperative= data.selectNodes(INSTANCE_NAME);
			for (Element unaCoop: leCooperative)	{
				MyCooperative unaCoopObj = new MyCooperative();
				String theID = unaCoop.elementText("ID");
				unaCoopObj.setId(theID);
				// da finire col beandatamanager
				MYCACHE.put(theID, unaCoopObj);				
			}			
		}
		logger.trace("DONE!");
	} catch  (Exception any)	{
		String msg = "Could not load Cooperative cache: "+any.getMessage();
		logger.error(msg);
		throw new SerenaException(msg);
		}
	}
}

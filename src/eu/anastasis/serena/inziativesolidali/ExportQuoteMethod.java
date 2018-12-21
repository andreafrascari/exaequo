package eu.anastasis.serena.inziativesolidali;


import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;

import eu.anastasis.serena.application.core.modules.DefaultModule;
import eu.anastasis.serena.application.modules.BirtReport.*;
import eu.anastasis.serena.application.modules.BirtReport.engine.ReportEngine;
import eu.anastasis.serena.beans.Movimenti_Quote;
import eu.anastasis.serena.exception.SerenaException;

//localhost:8080/Iniziative/ModuleIndex?q=iniziativesolidali/export_quote/CLS=Movimenti_Quote/DOC=Movimenti_Quote/FILE=SituazioneQuote/TYPE=pdf

public class ExportQuoteMethod extends GiveMethod {


	public static final String METHOD_NAME = "export_quote";


	public ExportQuoteMethod(DefaultModule parentModule,
			String[] defaultParameters) {
		super(parentModule, defaultParameters);
	}
	

	protected Document retrieveData(HttpServletRequest request,
			ReportEngine engine, File designFile) throws SerenaException {
		Document ret = null;
		try	{
			// prelevo l'xml ritornato dalla query
			ret = super.retrieveData(request, engine, designFile);
			// postProcess(request,ret);
		} catch (Exception e)	{
			String theError = "Errore in generazione modulo accredito interessi libretto: "+ e.getMessage();
			throw new SerenaException(theError);
		}
		return ret;
	}
			
			
	/*
	 * elimiano quote capitale? attenzione che pero' le vendite ci sono....
	 */
	public  void postProcess(HttpServletRequest request, Document ret)	throws SerenaException {
			List<Element> es = ret.selectNodes(".//"
					+ Movimenti_Quote.INSTANCE_NAME);
			for (Element e: es)	{
				if (e.elementText(Movimenti_Quote.SLOT_CAUSALE_QUOTA).equals(Movimenti_Quote.CAUSALE_QUOTA__QUOTA_DA_RISPARMIO)){
					e.getParent().remove(e);
				}
			}	
	}
	
			
	@Override
	protected String getName() {
		return METHOD_NAME;
	}
}

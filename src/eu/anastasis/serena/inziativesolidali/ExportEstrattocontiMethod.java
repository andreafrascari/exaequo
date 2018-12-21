package eu.anastasis.serena.inziativesolidali;


import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;

import eu.anastasis.serena.application.core.modules.DefaultModule;
import eu.anastasis.serena.application.modules.BirtReport.*;
import eu.anastasis.serena.application.modules.BirtReport.engine.ReportEngine;
import eu.anastasis.serena.beans.Estrattoconto;
import eu.anastasis.serena.beans.ExaequoBinder;
import eu.anastasis.serena.beans.Libretti;
import eu.anastasis.serena.common.SerenaDate;
import eu.anastasis.serena.exception.SerenaException;

//localhost:8080/Iniziative/ModuleIndex?q=iniziativesolidali/export_estrattoconti/CLS=Estrattoconto/DOC=Estrattoconto/FILE=SituazioneLibretti/TYPE=pdf

public class ExportEstrattocontiMethod extends GiveMethod {


	public static final String METHOD_NAME = "export_estrattoconti";


	public ExportEstrattocontiMethod(DefaultModule parentModule,
			String[] defaultParameters) {
		super(parentModule, defaultParameters);
	}
	

	protected Document retrieveData(HttpServletRequest request,
			ReportEngine engine, File designFile) throws SerenaException {
		Document ret = null;
		try	{
			// prelevo l'xml ritornato dalla query
			String dataAccreditoAnnoCorrente = "01/07/";
			int offset = 0;
			String offesetstr = request.getParameter("ANNO");
			if (offesetstr!=null && !offesetstr.isEmpty())	{
				offset = new Integer(offesetstr).intValue();
			}
			SerenaDate sd = new SerenaDate();
			int year = sd.getYear();
			/*
			if (offset == 0 && sd.isBefore(new SerenaDate(dataAccreditoAnnoCorrente))){
				// se siamo PRIMA della data accredito ... ci interessa lo scorso anno
				--year;
			}
			*/
			year+=offset;
			dataAccreditoAnnoCorrente+=(year);
			ret = super.retrieveData(request, engine, designFile);
			postProcess(request,ret,dataAccreditoAnnoCorrente);
		} catch (Exception e)	{
			String theError = "Errore in generazione modulo accredito interessi libretto: "+ e.getMessage();
			throw new SerenaException(theError);
		}
		return ret;
	}
			
			
	public  void postProcess(HttpServletRequest request, Document ret, String dateFilter)	throws SerenaException {
		if (dateFilter!=null && !dateFilter.isEmpty()){
			List<Element> es = ret.selectNodes(".//"
					+ Estrattoconto.INSTANCE_NAME);
			for (Element e: es)	{
				if (!e.elementText(Estrattoconto.SLOT_DATA).equals(dateFilter))	{
					e.getParent().remove(e);
				}
			}
		}
	}
			
	@Override
	protected String getName() {
		return METHOD_NAME;
	}
}

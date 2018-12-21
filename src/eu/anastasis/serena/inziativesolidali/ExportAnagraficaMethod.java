package eu.anastasis.serena.inziativesolidali;


import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import eu.anastasis.serena.application.core.modules.DefaultModule;
import eu.anastasis.serena.application.modules.BirtReport.*;
import eu.anastasis.serena.application.modules.BirtReport.engine.ReportEngine;
import eu.anastasis.serena.beans.CondizioniLibretto;
import eu.anastasis.serena.beans.Estrattoconto;
import eu.anastasis.serena.beans.Libretti;
import eu.anastasis.serena.beans.Movimenti_Quote;
import eu.anastasis.serena.beans.Soci;
import eu.anastasis.serena.exception.SerenaException;

//localhost:8080/Iniziative/ModuleIndex?q=iniziativesolidali/export_quote/CLS=Movimenti_Quote/DOC=Movimenti_Quote/FILE=SituazioneQuote/TYPE=pdf

public class ExportAnagraficaMethod extends GiveMethod {


	public static final String METHOD_NAME = "anagrafica";


	private static final Logger logger = Logger.getLogger(ExportAnagraficaMethod.class);

	public ExportAnagraficaMethod(DefaultModule parentModule,
			String[] defaultParameters) {
		super(parentModule, defaultParameters);
	}
	

	protected Document retrieveData(HttpServletRequest request,
			ReportEngine engine, File designFile) throws SerenaException {
		Document ret = null;
		try	{
			// prelevo l'xml ritornato dalla query
			ret = super.retrieveData(request, engine, designFile);
		    postProcess(request,ret);
			logger.debug("post proc ok");
		} catch (Exception e)	{
			String theError = "Errore in generazione modulo anagrafica: "+ e.getMessage();
			throw new SerenaException(theError);
		}
		return ret;
	}
			
			

	public  void postProcess(HttpServletRequest request, Document ret)	throws SerenaException {
		List<Element> es = ret.selectNodes(".//"
				+ Soci.INSTANCE_NAME);
		for (Element e: es)	{
			if (e.element(Soci.SLOT_RISPARMIO)!=null || e.element(Soci.SLOT_RISPARMIO).element(Libretti.INSTANCE_NAME)!=null)	{
				List<Element> libretti = e.selectNodes(".//"
						+ Libretti.INSTANCE_NAME);
				int i=1;
				for (Element l: libretti)	{
					Element fake = e.addElement(Libretti.SLOT_CODICE_CONTRATTO+"_"+i);
					fake.setText(l.elementText(Libretti.SLOT_CODICE_CONTRATTO));
					try	{
						fake = e.addElement(Libretti.SLOT_STATO_LIBRETTO+"_"+i);
						fake.setText(l.elementText(Libretti.SLOT_STATO_LIBRETTO));
						fake = e.addElement(Libretti.SLOT_DATA_APERTURA+"_"+i);
						fake.setText(l.elementText(Libretti.SLOT_DATA_APERTURA));
						String scadenza = l.elementText(Libretti.SLOT_DATA_SCADENZA);
						if (scadenza!=null)	{
							fake = e.addElement(Libretti.SLOT_DATA_SCADENZA+"_"+i);
							fake.setText(scadenza);
						}
						fake = e.addElement(CondizioniLibretto.SLOT_CODICE_CONDIZIONE+"_"+i);
						fake.setText(l.element(Libretti.SLOT_TIPO_LIBRETTO).element(CondizioniLibretto.INSTANCE_NAME).elementText(CondizioniLibretto.SLOT_CODICE_CONDIZIONE));
					} catch (Exception exx){
						logger.error(exx.toString());
					}
					i++;
				}
			}
		}
	}
	
			
	@Override
	protected String getName() {
		return METHOD_NAME;
	}
}

package eu.anastasis.serena.inziativesolidali;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;

import eu.anastasis.serena.application.core.modules.DefaultModule;
import eu.anastasis.serena.application.index.IndexQueryException;
import eu.anastasis.serena.application.modules.object.DetailEditMethod;
import eu.anastasis.serena.application.modules.object.ObjectUtils;
import eu.anastasis.serena.beans.CondizioniLibretto;
import eu.anastasis.serena.beans.Libretti;
import eu.anastasis.serena.beans.Movimenti_Libretti;
import eu.anastasis.serena.beans.Soci;
import eu.anastasis.serena.constants.ConstantsXSerena;

/**
 * Ridefinisce DetailEdit per la creazione atomica anche delle istanze figlie
 * @author afrascari
 *
 */
public class Prelievo_Method extends DetailEditMethod {

	public Prelievo_Method(DefaultModule defaultModule,
			String[] defaultParameters) {
		super(defaultModule, defaultParameters);
		// TODO Auto-generated constructor stub
	}
	
	public static final String METHOD_NAME = "prelievo";
	
	@Override
	protected Document buildQueryInsertFromHttpPost(HttpServletRequest request)
	throws IndexQueryException
	{
	
		Document theQuerySoFar = super.buildQueryInsertFromHttpPost(request);
		
		String id_libretto = request.getParameter("EXTRA_libretto");
		String vincolo = request.getParameter("EXTRA_tipologia_deposito");
				
		// root: libretti
		Element currentElement = ObjectUtils.getXserenaRequestStandardHeader(request.getSession().getId(), ConstantsXSerena.ACTION_SET, Libretti.INSTANCE_NAME);
		currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_UPDATE);
		Element condition = currentElement.addElement(ConstantsXSerena.TAG_CONDITION);
		condition =  condition.addElement("ID");
		condition.setText(id_libretto);
		
		// reperisco oggetto da form
		Element movimentoInserito = (Element)theQuerySoFar.selectSingleNode(".//"+Movimenti_Libretti.INSTANCE_NAME);

		String causale = movimentoInserito.elementText(Movimenti_Libretti.SLOT_CAUSALE_LIBRETTO); 
		
		/*
		 * Chiusura anticipata se VINCOLATO e NON prelievo interessi
		 */
		if (CondizioniLibretto.TIPOLOGIA_DEPOSITO__VINCOLATO.equals(vincolo) && !causale.equals(Movimenti_Libretti.CAUSALE_LIBRETTO__PRELIEVO_INTERESSI))	{
			Element stato = currentElement.addElement(Libretti.SLOT_STATO_LIBRETTO);
			stato.setText(Libretti.STATO_LIBRETTO__CHIUSURA_ANTICIPATA);
		}
		
		// up: socio
		Element socio = currentElement.addElement(Libretti.SLOT_DATI_SOCIO);
		socio = socio.addElement(Soci.INSTANCE_NAME);
		socio.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_UPDATE);
		
		
		Element prestito =  currentElement.addElement(Libretti.SLOT_MOVIMENTI);
		

		// ridefinisco  importo NEGATIVO
		Element imp =movimentoInserito.element(Movimenti_Libretti.SLOT_IMPORTO); 
		imp.setText("-"+imp.getText());
		/*
		Element attr = movimentoInserito.addElement(Movimenti_Libretti.SLOT_CAUSALE_LIBRETTO);
		attr.setText(Movimenti_Libretti.CAUSALE_LIBRETTO__PRELIEVO);
		*/
		
		// appendo oggetto da form in query
		prestito.add((Element)movimentoInserito.clone());
		
		return prestito.getDocument();
	}
	
	@Override
	protected String getName()
	{
		return METHOD_NAME;
	}
}

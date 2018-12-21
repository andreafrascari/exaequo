package eu.anastasis.serena.inziativesolidali;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;

import eu.anastasis.serena.application.core.modules.DefaultModule;
import eu.anastasis.serena.application.index.IndexQueryException;
import eu.anastasis.serena.application.modules.object.DetailEditMethod;
import eu.anastasis.serena.application.modules.object.ObjectUtils;
import eu.anastasis.serena.beans.Libretti;
import eu.anastasis.serena.beans.Movimenti_Libretti;
import eu.anastasis.serena.beans.Movimenti_Quote;
import eu.anastasis.serena.beans.Soci;
import eu.anastasis.serena.constants.ConstantsXSerena;

/**
 * Ridefinisce DetailEdit per la creazione atomica anche delle istanze figlie
 * @author afrascari
 *
 */
public class Versamento_Method extends DetailEditMethod {

	public Versamento_Method(DefaultModule defaultModule,
			String[] defaultParameters) {
		super(defaultModule, defaultParameters);
		// TODO Auto-generated constructor stub
	}
	
	public static final String METHOD_NAME = "versamento";
	
	@Override
	protected Document buildQueryInsertFromHttpPost(HttpServletRequest request)
	throws IndexQueryException
	{
	
		Document theQuerySoFar = super.buildQueryInsertFromHttpPost(request);
		
		String id_libretto = request.getParameter("EXTRA_libretto");
		String valore_quota = request.getParameter("EXTRA_valore_quota");
		String data_movimento = request.getParameter("INP_data_movimento");
		String numero_quote = request.getParameter("EXTRA_numero_quote");
		String importo_prestito = request.getParameter("EXTRA_importo_prestito");
				
		// root: libretti
		Element currentElement = ObjectUtils.getXserenaRequestStandardHeader(request.getSession().getId(), ConstantsXSerena.ACTION_SET, Libretti.INSTANCE_NAME);
		currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_UPDATE);
		Element condition = currentElement.addElement(ConstantsXSerena.TAG_CONDITION);
		condition =  condition.addElement("ID");
		condition.setText(id_libretto);
		
		// up: socio
		Element socio = currentElement.addElement(Libretti.SLOT_DATI_SOCIO);
		socio = socio.addElement(Soci.INSTANCE_NAME);
		socio.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_UPDATE);
		
		// quote capitale
		Element quote = socio.addElement(Soci.SLOT_MOVIMENTI_QUOTE);
		quote = quote.addElement(Movimenti_Quote.INSTANCE_NAME);
		quote.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_INSERT);
		Element item = quote.addElement(Movimenti_Quote.SLOT_CAUSALE_QUOTA);
		item.setText(Movimenti_Quote.CAUSALE_QUOTA__QUOTA_DA_RISPARMIO);
		item = quote.addElement(Movimenti_Quote.SLOT_DATA_MOVIMENTO);
		item.setText(data_movimento);
		item = quote.addElement(Movimenti_Quote.SLOT_DI_VALORE);
		item.setText(valore_quota);
		item = quote.addElement(Movimenti_Quote.SLOT_NUMERO_QUOTE);
		item.setText(numero_quote);
		item = quote.addElement(Movimenti_Quote.SLOT_DI_RISPARMIO);
		item = item.addElement(Libretti.INSTANCE_NAME);
		item = item.addElement("ID");
		item.setText(id_libretto);
		
		Element prestito =  currentElement.addElement(Libretti.SLOT_MOVIMENTI);
		
		// reperisco oggetto da form
		Element movimentoInserito = (Element)theQuerySoFar.selectSingleNode(".//"+Movimenti_Libretti.INSTANCE_NAME);

		// ridefinisco importo prestito e causale
		movimentoInserito.element(Movimenti_Libretti.SLOT_IMPORTO).setText(importo_prestito);
		Element causale = movimentoInserito.addElement(Movimenti_Libretti.SLOT_CAUSALE_LIBRETTO);
		causale.setText(Movimenti_Libretti.CAUSALE_LIBRETTO__VERSAMENTO);
		
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

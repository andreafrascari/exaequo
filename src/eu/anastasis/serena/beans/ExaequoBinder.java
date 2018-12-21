package eu.anastasis.serena.beans;

import org.dom4j.Document;
import org.dom4j.Element;
import eu.anastasis.serena.beans.Binder;
import eu.anastasis.serena.exception.BindingException;

public class ExaequoBinder extends Binder
{
	private static final java.lang.String PROJECT_NAME = "exaequo";
	private static final java.lang.String PACKAGE_PREFIX = "eu.anastasis.serena.beans";
	private static final java.lang.String BINDING_PREFIX = PROJECT_NAME;
	private static final java.lang.String PACKAGE_POSTFIX = "";




	public ExaequoBinder()
	{
		super(PACKAGE_PREFIX);
	}


	public Botteghe createBotteghe(Element element)
	{
		return (Botteghe) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(Botteghe obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(Botteghe obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public CondizioniLibretto createCondizioniLibretto(Element element)
	{
		return (CondizioniLibretto) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(CondizioniLibretto obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(CondizioniLibretto obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public Consumatori createConsumatori(Element element)
	{
		return (Consumatori) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(Consumatori obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(Consumatori obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public Cooperative createCooperative(Element element)
	{
		return (Cooperative) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(Cooperative obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(Cooperative obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public CorsiFormazione createCorsiFormazione(Element element)
	{
		return (CorsiFormazione) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(CorsiFormazione obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(CorsiFormazione obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public Estrattoconto createEstrattoconto(Element element)
	{
		return (Estrattoconto) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(Estrattoconto obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(Estrattoconto obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public Iniziative createIniziative(Element element)
	{
		return (Iniziative) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(Iniziative obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(Iniziative obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public InteressiIndeducibili createInteressiIndeducibili(Element element)
	{
		return (InteressiIndeducibili) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(InteressiIndeducibili obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(InteressiIndeducibili obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public Libretti createLibretti(Element element)
	{
		return (Libretti) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(Libretti obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(Libretti obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public Movimenti_Libretti createMovimenti_Libretti(Element element)
	{
		return (Movimenti_Libretti) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(Movimenti_Libretti obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(Movimenti_Libretti obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public Movimenti_Quote createMovimenti_Quote(Element element)
	{
		return (Movimenti_Quote) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(Movimenti_Quote obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(Movimenti_Quote obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public Newsletter createNewsletter(Element element)
	{
		return (Newsletter) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(Newsletter obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(Newsletter obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public Organizzazioni createOrganizzazioni(Element element)
	{
		return (Organizzazioni) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(Organizzazioni obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(Organizzazioni obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public Prodotti createProdotti(Element element)
	{
		return (Prodotti) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(Prodotti obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(Prodotti obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public RegolamentoPrestito createRegolamentoPrestito(Element element)
	{
		return (RegolamentoPrestito) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(RegolamentoPrestito obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(RegolamentoPrestito obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public SessioniCorsi createSessioniCorsi(Element element)
	{
		return (SessioniCorsi) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(SessioniCorsi obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(SessioniCorsi obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public SimulazioneEstrattoconto createSimulazioneEstrattoconto(Element element)
	{
		return (SimulazioneEstrattoconto) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(SimulazioneEstrattoconto obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(SimulazioneEstrattoconto obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public Soci createSoci(Element element)
	{
		return (Soci) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(Soci obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(Soci obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public Tag createTag(Element element)
	{
		return (Tag) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(Tag obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(Tag obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public TassoInteresseLibretto createTassoInteresseLibretto(Element element)
	{
		return (TassoInteresseLibretto) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(TassoInteresseLibretto obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(TassoInteresseLibretto obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

	public _system_document create_system_document(Element element)
	{
		return (_system_document) createObject(BINDING_PREFIX, PACKAGE_POSTFIX, element);
	}

	public Document createDocument(_system_document obj)
	throws BindingException
	{
		return createDocument(obj, BINDING_PREFIX);
	}

	public Element createElement(_system_document obj)
	throws BindingException
	{
		return createElement(obj, BINDING_PREFIX);
	}

}
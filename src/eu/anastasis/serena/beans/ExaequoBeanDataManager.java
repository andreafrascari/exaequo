package eu.anastasis.serena.beans;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.dom4j.Element;
import eu.anastasis.serena.beans.BeanCreator;
import eu.anastasis.serena.beans.BeanDataManager;
import eu.anastasis.serena.beans.ElementCreator;
import eu.anastasis.serena.beans.SerenaMarshallable;
import eu.anastasis.serena.dataManager.DataManagerException;
import eu.anastasis.serena.exception.BindingException;

public class ExaequoBeanDataManager extends BeanDataManager
{


	private ExaequoBinder binder;


	public ExaequoBeanDataManager()
	{
		super();
		this.binder = new ExaequoBinder();
	}


	@SuppressWarnings("unchecked")
	public Botteghe getBotteghe(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (Botteghe) getObject(request, "Botteghe", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Botteghe>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Botteghe newObject = binder.createBotteghe(element);
					((List<Botteghe>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Botteghe> getBottegheList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<Botteghe>) getObjects(request, "Botteghe", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Botteghe>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Botteghe newObject = binder.createBotteghe(element);
					((List<Botteghe>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertBotteghe(HttpServletRequest request, Botteghe object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((Botteghe) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public CondizioniLibretto getCondizioniLibretto(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (CondizioniLibretto) getObject(request, "CondizioniLibretto", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<CondizioniLibretto>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					CondizioniLibretto newObject = binder.createCondizioniLibretto(element);
					((List<CondizioniLibretto>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<CondizioniLibretto> getCondizioniLibrettoList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<CondizioniLibretto>) getObjects(request, "CondizioniLibretto", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<CondizioniLibretto>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					CondizioniLibretto newObject = binder.createCondizioniLibretto(element);
					((List<CondizioniLibretto>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertCondizioniLibretto(HttpServletRequest request, CondizioniLibretto object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((CondizioniLibretto) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public Consumatori getConsumatori(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (Consumatori) getObject(request, "Consumatori", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Consumatori>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Consumatori newObject = binder.createConsumatori(element);
					((List<Consumatori>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Consumatori> getConsumatoriList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<Consumatori>) getObjects(request, "Consumatori", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Consumatori>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Consumatori newObject = binder.createConsumatori(element);
					((List<Consumatori>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertConsumatori(HttpServletRequest request, Consumatori object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((Consumatori) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public Cooperative getCooperative(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (Cooperative) getObject(request, "Cooperative", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Cooperative>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Cooperative newObject = binder.createCooperative(element);
					((List<Cooperative>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Cooperative> getCooperativeList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<Cooperative>) getObjects(request, "Cooperative", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Cooperative>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Cooperative newObject = binder.createCooperative(element);
					((List<Cooperative>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertCooperative(HttpServletRequest request, Cooperative object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((Cooperative) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public CorsiFormazione getCorsiFormazione(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (CorsiFormazione) getObject(request, "CorsiFormazione", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<CorsiFormazione>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					CorsiFormazione newObject = binder.createCorsiFormazione(element);
					((List<CorsiFormazione>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<CorsiFormazione> getCorsiFormazioneList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<CorsiFormazione>) getObjects(request, "CorsiFormazione", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<CorsiFormazione>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					CorsiFormazione newObject = binder.createCorsiFormazione(element);
					((List<CorsiFormazione>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertCorsiFormazione(HttpServletRequest request, CorsiFormazione object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((CorsiFormazione) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public Estrattoconto getEstrattoconto(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (Estrattoconto) getObject(request, "Estrattoconto", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Estrattoconto>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Estrattoconto newObject = binder.createEstrattoconto(element);
					((List<Estrattoconto>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Estrattoconto> getEstrattocontoList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<Estrattoconto>) getObjects(request, "Estrattoconto", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Estrattoconto>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Estrattoconto newObject = binder.createEstrattoconto(element);
					((List<Estrattoconto>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertEstrattoconto(HttpServletRequest request, Estrattoconto object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((Estrattoconto) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public Iniziative getIniziative(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (Iniziative) getObject(request, "Iniziative", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Iniziative>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Iniziative newObject = binder.createIniziative(element);
					((List<Iniziative>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Iniziative> getIniziativeList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<Iniziative>) getObjects(request, "Iniziative", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Iniziative>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Iniziative newObject = binder.createIniziative(element);
					((List<Iniziative>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertIniziative(HttpServletRequest request, Iniziative object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((Iniziative) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public InteressiIndeducibili getInteressiIndeducibili(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (InteressiIndeducibili) getObject(request, "InteressiIndeducibili", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<InteressiIndeducibili>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					InteressiIndeducibili newObject = binder.createInteressiIndeducibili(element);
					((List<InteressiIndeducibili>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<InteressiIndeducibili> getInteressiIndeducibiliList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<InteressiIndeducibili>) getObjects(request, "InteressiIndeducibili", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<InteressiIndeducibili>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					InteressiIndeducibili newObject = binder.createInteressiIndeducibili(element);
					((List<InteressiIndeducibili>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertInteressiIndeducibili(HttpServletRequest request, InteressiIndeducibili object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((InteressiIndeducibili) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public Libretti getLibretti(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (Libretti) getObject(request, "Libretti", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Libretti>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Libretti newObject = binder.createLibretti(element);
					((List<Libretti>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Libretti> getLibrettiList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<Libretti>) getObjects(request, "Libretti", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Libretti>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Libretti newObject = binder.createLibretti(element);
					((List<Libretti>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertLibretti(HttpServletRequest request, Libretti object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((Libretti) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public Movimenti_Libretti getMovimenti_Libretti(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (Movimenti_Libretti) getObject(request, "Movimenti_Libretti", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Movimenti_Libretti>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Movimenti_Libretti newObject = binder.createMovimenti_Libretti(element);
					((List<Movimenti_Libretti>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Movimenti_Libretti> getMovimenti_LibrettiList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<Movimenti_Libretti>) getObjects(request, "Movimenti_Libretti", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Movimenti_Libretti>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Movimenti_Libretti newObject = binder.createMovimenti_Libretti(element);
					((List<Movimenti_Libretti>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertMovimenti_Libretti(HttpServletRequest request, Movimenti_Libretti object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((Movimenti_Libretti) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public Movimenti_Quote getMovimenti_Quote(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (Movimenti_Quote) getObject(request, "Movimenti_Quote", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Movimenti_Quote>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Movimenti_Quote newObject = binder.createMovimenti_Quote(element);
					((List<Movimenti_Quote>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Movimenti_Quote> getMovimenti_QuoteList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<Movimenti_Quote>) getObjects(request, "Movimenti_Quote", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Movimenti_Quote>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Movimenti_Quote newObject = binder.createMovimenti_Quote(element);
					((List<Movimenti_Quote>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertMovimenti_Quote(HttpServletRequest request, Movimenti_Quote object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((Movimenti_Quote) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public Newsletter getNewsletter(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (Newsletter) getObject(request, "Newsletter", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Newsletter>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Newsletter newObject = binder.createNewsletter(element);
					((List<Newsletter>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Newsletter> getNewsletterList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<Newsletter>) getObjects(request, "Newsletter", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Newsletter>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Newsletter newObject = binder.createNewsletter(element);
					((List<Newsletter>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertNewsletter(HttpServletRequest request, Newsletter object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((Newsletter) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public Organizzazioni getOrganizzazioni(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (Organizzazioni) getObject(request, "Organizzazioni", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Organizzazioni>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Organizzazioni newObject = binder.createOrganizzazioni(element);
					((List<Organizzazioni>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Organizzazioni> getOrganizzazioniList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<Organizzazioni>) getObjects(request, "Organizzazioni", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Organizzazioni>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Organizzazioni newObject = binder.createOrganizzazioni(element);
					((List<Organizzazioni>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertOrganizzazioni(HttpServletRequest request, Organizzazioni object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((Organizzazioni) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public Prodotti getProdotti(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (Prodotti) getObject(request, "Prodotti", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Prodotti>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Prodotti newObject = binder.createProdotti(element);
					((List<Prodotti>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Prodotti> getProdottiList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<Prodotti>) getObjects(request, "Prodotti", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Prodotti>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Prodotti newObject = binder.createProdotti(element);
					((List<Prodotti>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertProdotti(HttpServletRequest request, Prodotti object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((Prodotti) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public RegolamentoPrestito getRegolamentoPrestito(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (RegolamentoPrestito) getObject(request, "RegolamentoPrestito", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<RegolamentoPrestito>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					RegolamentoPrestito newObject = binder.createRegolamentoPrestito(element);
					((List<RegolamentoPrestito>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<RegolamentoPrestito> getRegolamentoPrestitoList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<RegolamentoPrestito>) getObjects(request, "RegolamentoPrestito", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<RegolamentoPrestito>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					RegolamentoPrestito newObject = binder.createRegolamentoPrestito(element);
					((List<RegolamentoPrestito>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertRegolamentoPrestito(HttpServletRequest request, RegolamentoPrestito object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((RegolamentoPrestito) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public SessioniCorsi getSessioniCorsi(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (SessioniCorsi) getObject(request, "SessioniCorsi", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<SessioniCorsi>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					SessioniCorsi newObject = binder.createSessioniCorsi(element);
					((List<SessioniCorsi>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<SessioniCorsi> getSessioniCorsiList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<SessioniCorsi>) getObjects(request, "SessioniCorsi", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<SessioniCorsi>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					SessioniCorsi newObject = binder.createSessioniCorsi(element);
					((List<SessioniCorsi>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertSessioniCorsi(HttpServletRequest request, SessioniCorsi object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((SessioniCorsi) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public SimulazioneEstrattoconto getSimulazioneEstrattoconto(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (SimulazioneEstrattoconto) getObject(request, "SimulazioneEstrattoconto", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<SimulazioneEstrattoconto>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					SimulazioneEstrattoconto newObject = binder.createSimulazioneEstrattoconto(element);
					((List<SimulazioneEstrattoconto>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<SimulazioneEstrattoconto> getSimulazioneEstrattocontoList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<SimulazioneEstrattoconto>) getObjects(request, "SimulazioneEstrattoconto", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<SimulazioneEstrattoconto>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					SimulazioneEstrattoconto newObject = binder.createSimulazioneEstrattoconto(element);
					((List<SimulazioneEstrattoconto>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertSimulazioneEstrattoconto(HttpServletRequest request, SimulazioneEstrattoconto object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((SimulazioneEstrattoconto) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public Soci getSoci(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (Soci) getObject(request, "Soci", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Soci>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Soci newObject = binder.createSoci(element);
					((List<Soci>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Soci> getSociList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<Soci>) getObjects(request, "Soci", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Soci>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Soci newObject = binder.createSoci(element);
					((List<Soci>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertSoci(HttpServletRequest request, Soci object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((Soci) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public Tag getTag(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (Tag) getObject(request, "Tag", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Tag>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Tag newObject = binder.createTag(element);
					((List<Tag>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<Tag> getTagList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<Tag>) getObjects(request, "Tag", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<Tag>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					Tag newObject = binder.createTag(element);
					((List<Tag>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertTag(HttpServletRequest request, Tag object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((Tag) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public TassoInteresseLibretto getTassoInteresseLibretto(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (TassoInteresseLibretto) getObject(request, "TassoInteresseLibretto", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<TassoInteresseLibretto>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					TassoInteresseLibretto newObject = binder.createTassoInteresseLibretto(element);
					((List<TassoInteresseLibretto>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<TassoInteresseLibretto> getTassoInteresseLibrettoList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<TassoInteresseLibretto>) getObjects(request, "TassoInteresseLibretto", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<TassoInteresseLibretto>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					TassoInteresseLibretto newObject = binder.createTassoInteresseLibretto(element);
					((List<TassoInteresseLibretto>) objectList).add(newObject);
				}
			}
		);
	}

	public String insertTassoInteresseLibretto(HttpServletRequest request, TassoInteresseLibretto object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((TassoInteresseLibretto) object);
				}
			}
		);
	}
	@SuppressWarnings("unchecked")
	public _system_document get_system_document(HttpServletRequest request, int targetLevels, String instanceId)
		throws DataManagerException
	{
		return (_system_document) getObject(request, "_system_document", instanceId, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<_system_document>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					_system_document newObject = binder.create_system_document(element);
					((List<_system_document>) objectList).add(newObject);
				}
			}
		);
	}

	@SuppressWarnings("unchecked")
	public List<_system_document> get_system_documentList(HttpServletRequest request, Element condition, int targetLevels)
		throws DataManagerException
	{
		return (List<_system_document>) getObjects(request, "_system_document", condition, targetLevels, new BeanCreator()
			{
				public List<? extends SerenaMarshallable> createObjectEmptyList()
				{
					return new ArrayList<_system_document>();
				}

				public void addObjectToList(List<? extends SerenaMarshallable> objectList, Element element)
				{
					_system_document newObject = binder.create_system_document(element);
					((List<_system_document>) objectList).add(newObject);
				}
			}
		);
	}

	public String insert_system_document(HttpServletRequest request, _system_document object)
		throws DataManagerException
	{
		return insertObject(request, object, new ElementCreator()
			{
				public Element createElement(SerenaMarshallable object) throws BindingException
				{
					return binder.createElement((_system_document) object);
				}
			}
		);
	}
}
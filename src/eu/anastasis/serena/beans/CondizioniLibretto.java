package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class CondizioniLibretto implements SerenaMarshallable
{

	public static final java.lang.String MODALITA_CALCOLO_INTERESSI__FISSO = "Fisso";
	public static final java.lang.String MODALITA_CALCOLO_INTERESSI__SCAGLIONI_NON_GESTITO = "Scaglioni non gestito";
	public static final java.lang.String MODALITA_CALCOLO_INTERESSI__SCAGLIONI_CAPITALE_NON_GESTITO = "Scaglioni Capitale non gestito";
	public static final java.lang.String MODALITA_CALCOLO_INTERESSI__PROPORZIONATO_NON_GESTITO = "Proporzionato non gestito";
	public static final java.lang.String MODALITA_CALCOLO_INTERESSI__FRAZIONATO_NON_GESTITO = "Frazionato non gestito";

	public static final java.lang.String TIPOLOGIA_DEPOSITO__ORDINARIO = "Ordinario";
	public static final java.lang.String TIPOLOGIA_DEPOSITO__VINCOLATO = "Vincolato";

	public static final java.lang.String VINCOLO__ANNUALE = "Annuale";
	public static final java.lang.String VINCOLO__TRIENNALE = "Triennale";
	public static final java.lang.String VINCOLO__QUINQUENNALE = "Quinquennale";
	public static final java.lang.String VINCOLO__ANTICIPIATO = "Anticipiato";


	public static final java.lang.String INSTANCE_NAME = "CondizioniLibretto";
	public static final java.lang.String SLOT_CODICE_CONDIZIONE = "codice_condizione";
	public static final java.lang.String SLOT_DATA_FINE_VALIDITA = "data_fine_validita";
	public static final java.lang.String SLOT_DATA_INIZIO_VALIDITA = "data_inizio_validita";
	public static final java.lang.String SLOT_INVERSE_OF_CONDIZIONI_LIBRETTI = "inverse_of_condizioni_libretti";
	public static final java.lang.String SLOT_INVERSE_OF_TIPO_LIBRETTO = "inverse_of_tipo_libretto";
	public static final java.lang.String SLOT_MODALITA_CALCOLO_INTERESSI = "modalita_calcolo_interessi";
	public static final java.lang.String SLOT_NOTE = "note";
	public static final java.lang.String SLOT_TASSI_DI_INTERESSE = "tassi_di_interesse";
	public static final java.lang.String SLOT_TIPOLOGIA_DEPOSITO = "tipologia_deposito";
	public static final java.lang.String SLOT_VINCOLO = "vincolo";

	protected java.lang.String codice_condizione;
	protected java.util.Date data_fine_validita;
	protected java.util.Date data_inizio_validita;
	protected Cooperative inverse_of_condizioni_libretti;
	protected java.util.ArrayList<Libretti> inverse_of_tipo_libretto;
	protected java.lang.String modalita_calcolo_interessi;
	protected java.lang.String note;
	protected java.util.ArrayList<TassoInteresseLibretto> tassi_di_interesse;
	protected java.lang.String tipologia_deposito;
	protected java.lang.String vincolo;
	protected String id;

	public CondizioniLibretto(){}

	public java.lang.String getCodice_condizione() {
		return codice_condizione;
	}

	public void setCodice_condizione(java.lang.String codice_condizione) {
		this.codice_condizione = codice_condizione;
	}

	public java.util.Date getData_fine_validita() {
		return data_fine_validita;
	}

	public void setData_fine_validita(java.util.Date data_fine_validita) {
		this.data_fine_validita = data_fine_validita;
	}

	public java.util.Date getData_inizio_validita() {
		return data_inizio_validita;
	}

	public void setData_inizio_validita(java.util.Date data_inizio_validita) {
		this.data_inizio_validita = data_inizio_validita;
	}

	public Cooperative getInverse_of_condizioni_libretti() {
		return inverse_of_condizioni_libretti;
	}

	public void setInverse_of_condizioni_libretti(Cooperative inverse_of_condizioni_libretti) {
		this.inverse_of_condizioni_libretti = inverse_of_condizioni_libretti;
	}

	public java.util.ArrayList<Libretti> getInverse_of_tipo_libretto() {
		return inverse_of_tipo_libretto;
	}

	public void setInverse_of_tipo_libretto(java.util.ArrayList<Libretti> inverse_of_tipo_libretto) {
		this.inverse_of_tipo_libretto = inverse_of_tipo_libretto;
	}

	public java.lang.String getModalita_calcolo_interessi() {
		return modalita_calcolo_interessi;
	}

	public void setModalita_calcolo_interessi(java.lang.String modalita_calcolo_interessi) {
		this.modalita_calcolo_interessi = modalita_calcolo_interessi;
	}

	public java.lang.String getNote() {
		return note;
	}

	public void setNote(java.lang.String note) {
		this.note = note;
	}

	public java.util.ArrayList<TassoInteresseLibretto> getTassi_di_interesse() {
		return tassi_di_interesse;
	}

	public void setTassi_di_interesse(java.util.ArrayList<TassoInteresseLibretto> tassi_di_interesse) {
		this.tassi_di_interesse = tassi_di_interesse;
	}

	public java.lang.String getTipologia_deposito() {
		return tipologia_deposito;
	}

	public void setTipologia_deposito(java.lang.String tipologia_deposito) {
		this.tipologia_deposito = tipologia_deposito;
	}

	public java.lang.String getVincolo() {
		return vincolo;
	}

	public void setVincolo(java.lang.String vincolo) {
		this.vincolo = vincolo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "CondizioniLibretto \n codice_condizione: "+codice_condizione+" data_fine_validita: "+data_fine_validita+" data_inizio_validita: "+data_inizio_validita+" modalita_calcolo_interessi: "+modalita_calcolo_interessi+" note: "+note+" tipologia_deposito: "+tipologia_deposito+" vincolo: "+vincolo;
	}

}
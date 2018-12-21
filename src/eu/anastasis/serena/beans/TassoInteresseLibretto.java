package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class TassoInteresseLibretto implements SerenaMarshallable
{


	public static final java.lang.String INSTANCE_NAME = "TassoInteresseLibretto";
	public static final java.lang.String SLOT_DATA_FINE_VALIDITA = "data_fine_validita";
	public static final java.lang.String SLOT_DATA_INIZIO_VALIDITA = "data_inizio_validita";
	public static final java.lang.String SLOT_INVERSE_OF_TASSI_DI_INTERESSE = "inverse_of_tassi_di_interesse";
	public static final java.lang.String SLOT_NOTE = "note";
	public static final java.lang.String SLOT_TASSO_INTERESSE = "tasso_interesse";

	protected java.util.Date data_fine_validita;
	protected java.util.Date data_inizio_validita;
	protected CondizioniLibretto inverse_of_tassi_di_interesse;
	protected java.lang.String note;
	protected java.lang.Float tasso_interesse;
	protected String id;

	public TassoInteresseLibretto(){}

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

	public CondizioniLibretto getInverse_of_tassi_di_interesse() {
		return inverse_of_tassi_di_interesse;
	}

	public void setInverse_of_tassi_di_interesse(CondizioniLibretto inverse_of_tassi_di_interesse) {
		this.inverse_of_tassi_di_interesse = inverse_of_tassi_di_interesse;
	}

	public java.lang.String getNote() {
		return note;
	}

	public void setNote(java.lang.String note) {
		this.note = note;
	}

	public java.lang.Float getTasso_interesse() {
		return tasso_interesse;
	}

	public void setTasso_interesse(java.lang.Float tasso_interesse) {
		this.tasso_interesse = tasso_interesse;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "TassoInteresseLibretto \n data_fine_validita: "+data_fine_validita+" data_inizio_validita: "+data_inizio_validita+" note: "+note+" tasso_interesse: "+tasso_interesse;
	}

}
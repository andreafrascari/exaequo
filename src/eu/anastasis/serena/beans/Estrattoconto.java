package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class Estrattoconto implements SerenaMarshallable
{


	public static final java.lang.String INSTANCE_NAME = "Estrattoconto";
	public static final java.lang.String SLOT_ALLEGATO = "allegato";
	public static final java.lang.String SLOT_DATA = "data";
	public static final java.lang.String SLOT_DI_LIBRETTO = "di_libretto";
	public static final java.lang.String SLOT_ESITO_INVIO = "esito_invio";
	public static final java.lang.String SLOT_IMPORTO_ALTRE_QUOTE = "importo_altre_quote";
	public static final java.lang.String SLOT_IMPORTO_CAPITALE = "importo_capitale";
	public static final java.lang.String SLOT_IMPORTO_PRESTITO = "importo_prestito";
	public static final java.lang.String SLOT_INTERESSI_INDEDUCIBILI = "interessi_indeducibili";
	public static final java.lang.String SLOT_INTERESSI_LORDI = "interessi_lordi";
	public static final java.lang.String SLOT_INTERESSI_NETTI = "interessi_netti";
	public static final java.lang.String SLOT_INVIATO_IL = "inviato_il";
	public static final java.lang.String SLOT_NOTE = "note";
	public static final java.lang.String SLOT_PDF = "pdf";

	protected java.lang.String allegato;
	protected java.util.Date data;
	protected Libretti di_libretto;
	protected java.lang.Boolean esito_invio;
	protected java.lang.Float importo_altre_quote;
	protected java.lang.Float importo_capitale;
	protected java.lang.Float importo_prestito;
	protected java.lang.Float interessi_indeducibili;
	protected java.lang.Float interessi_lordi;
	protected java.lang.Float interessi_netti;
	protected java.util.Date inviato_il;
	protected java.lang.String note;
	protected java.lang.String pdf;
	protected String id;

	public Estrattoconto(){}

	public java.lang.String getAllegato() {
		return allegato;
	}

	public void setAllegato(java.lang.String allegato) {
		this.allegato = allegato;
	}

	public java.util.Date getData() {
		return data;
	}

	public void setData(java.util.Date data) {
		this.data = data;
	}

	public Libretti getDi_libretto() {
		return di_libretto;
	}

	public void setDi_libretto(Libretti di_libretto) {
		this.di_libretto = di_libretto;
	}

	public java.lang.Boolean getEsito_invio() {
		return esito_invio;
	}

	public void setEsito_invio(java.lang.Boolean esito_invio) {
		this.esito_invio = esito_invio;
	}

	public java.lang.Float getImporto_altre_quote() {
		return importo_altre_quote;
	}

	public void setImporto_altre_quote(java.lang.Float importo_altre_quote) {
		this.importo_altre_quote = importo_altre_quote;
	}

	public java.lang.Float getImporto_capitale() {
		return importo_capitale;
	}

	public void setImporto_capitale(java.lang.Float importo_capitale) {
		this.importo_capitale = importo_capitale;
	}

	public java.lang.Float getImporto_prestito() {
		return importo_prestito;
	}

	public void setImporto_prestito(java.lang.Float importo_prestito) {
		this.importo_prestito = importo_prestito;
	}

	public java.lang.Float getInteressi_indeducibili() {
		return interessi_indeducibili;
	}

	public void setInteressi_indeducibili(java.lang.Float interessi_indeducibili) {
		this.interessi_indeducibili = interessi_indeducibili;
	}

	public java.lang.Float getInteressi_lordi() {
		return interessi_lordi;
	}

	public void setInteressi_lordi(java.lang.Float interessi_lordi) {
		this.interessi_lordi = interessi_lordi;
	}

	public java.lang.Float getInteressi_netti() {
		return interessi_netti;
	}

	public void setInteressi_netti(java.lang.Float interessi_netti) {
		this.interessi_netti = interessi_netti;
	}

	public java.util.Date getInviato_il() {
		return inviato_il;
	}

	public void setInviato_il(java.util.Date inviato_il) {
		this.inviato_il = inviato_il;
	}

	public java.lang.String getNote() {
		return note;
	}

	public void setNote(java.lang.String note) {
		this.note = note;
	}

	public java.lang.String getPdf() {
		return pdf;
	}

	public void setPdf(java.lang.String pdf) {
		this.pdf = pdf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "Estrattoconto \n allegato: "+allegato+" data: "+data+" esito_invio: "+esito_invio+" importo_altre_quote: "+importo_altre_quote+" importo_capitale: "+importo_capitale+" importo_prestito: "+importo_prestito+" interessi_indeducibili: "+interessi_indeducibili+" interessi_lordi: "+interessi_lordi+" interessi_netti: "+interessi_netti+" inviato_il: "+inviato_il+" note: "+note+" pdf: "+pdf;
	}

}
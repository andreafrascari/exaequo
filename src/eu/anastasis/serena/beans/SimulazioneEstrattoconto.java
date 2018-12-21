package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class SimulazioneEstrattoconto implements SerenaMarshallable
{


	public static final java.lang.String INSTANCE_NAME = "SimulazioneEstrattoconto";
	public static final java.lang.String SLOT_CODICE_LIBRETTO = "codice_libretto";
	public static final java.lang.String SLOT_DATA = "data";
	public static final java.lang.String SLOT_DI_SOCIO = "di_socio";
	public static final java.lang.String SLOT_IMPORTO_ALTRE_QUOTE = "importo_altre_quote";
	public static final java.lang.String SLOT_IMPORTO_CAPITALE = "importo_capitale";
	public static final java.lang.String SLOT_IMPORTO_PRESTITO = "importo_prestito";
	public static final java.lang.String SLOT_INTERESSI_INDEDUCIBILI = "interessi_indeducibili";
	public static final java.lang.String SLOT_INTERESSI_LORDI = "interessi_lordi";
	public static final java.lang.String SLOT_INTERESSI_NETTI = "interessi_netti";
	public static final java.lang.String SLOT_NOTE = "note";

	protected java.lang.String codice_libretto;
	protected java.util.Date data;
	protected java.lang.String di_socio;
	protected java.lang.Float importo_altre_quote;
	protected java.lang.Float importo_capitale;
	protected java.lang.Float importo_prestito;
	protected java.lang.Float interessi_indeducibili;
	protected java.lang.Float interessi_lordi;
	protected java.lang.Float interessi_netti;
	protected java.lang.String note;
	protected String id;

	public SimulazioneEstrattoconto(){}

	public java.lang.String getCodice_libretto() {
		return codice_libretto;
	}

	public void setCodice_libretto(java.lang.String codice_libretto) {
		this.codice_libretto = codice_libretto;
	}

	public java.util.Date getData() {
		return data;
	}

	public void setData(java.util.Date data) {
		this.data = data;
	}

	public java.lang.String getDi_socio() {
		return di_socio;
	}

	public void setDi_socio(java.lang.String di_socio) {
		this.di_socio = di_socio;
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

	public java.lang.String getNote() {
		return note;
	}

	public void setNote(java.lang.String note) {
		this.note = note;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "SimulazioneEstrattoconto \n codice_libretto: "+codice_libretto+" data: "+data+" di_socio: "+di_socio+" importo_altre_quote: "+importo_altre_quote+" importo_capitale: "+importo_capitale+" importo_prestito: "+importo_prestito+" interessi_indeducibili: "+interessi_indeducibili+" interessi_lordi: "+interessi_lordi+" interessi_netti: "+interessi_netti+" note: "+note;
	}

}
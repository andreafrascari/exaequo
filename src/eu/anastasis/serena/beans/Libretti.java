package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class Libretti implements SerenaMarshallable
{

	public static final java.lang.String DELEGA__SI = "SI";
	public static final java.lang.String DELEGA__NO = "NO";

	public static final java.lang.String MODALITA_RINNOVO__TACITO = "Tacito";
	public static final java.lang.String MODALITA_RINNOVO__COMUNICAZIONE = "Comunicazione";

	public static final java.lang.String STATO_LIBRETTO__ATTIVO = "Attivo";
	public static final java.lang.String STATO_LIBRETTO__CHIUSO = "Chiuso";
	public static final java.lang.String STATO_LIBRETTO__CHIUSURA_ANTICIPATA = "Chiusura Anticipata";
	public static final java.lang.String STATO_LIBRETTO__IN_ATTESA_DI_CHIUSURA = "In Attesa di Chiusura";


	public static final java.lang.String INSTANCE_NAME = "Libretti";
	public static final java.lang.String SLOT_BANCA_DI_RIFERIMENTO = "banca_di_riferimento";
	public static final java.lang.String SLOT_CODICE_CONTRATTO = "codice_contratto";
	public static final java.lang.String SLOT_CONTO_CORRENTE = "conto_corrente";
	public static final java.lang.String SLOT_DATA_APERTURA = "data_apertura";
	public static final java.lang.String SLOT_DATA_CHIUSURA = "data_chiusura";
	public static final java.lang.String SLOT_DATA_RINNOVO = "data_rinnovo";
	public static final java.lang.String SLOT_DATA_SCADENZA = "data_scadenza";
	public static final java.lang.String SLOT_DATI_SOCIO = "dati_socio";
	public static final java.lang.String SLOT_DELEGA = "delega";
	public static final java.lang.String SLOT_ESTRATTICONTO = "estratticonto";
	public static final java.lang.String SLOT_IBAN = "iban";
	public static final java.lang.String SLOT_MODALITA_RINNOVO = "modalita_rinnovo";
	public static final java.lang.String SLOT_MOTIVAZIONE_CHIUSURA = "motivazione_chiusura";
	public static final java.lang.String SLOT_MOVIMENTI = "movimenti";
	public static final java.lang.String SLOT_NOTE_CONTRATTO = "note_contratto";
	public static final java.lang.String SLOT_QUOTE_RELATIVE = "quote_relative";
	public static final java.lang.String SLOT_STATO_LIBRETTO = "stato_libretto";
	public static final java.lang.String SLOT_TIPO_LIBRETTO = "tipo_libretto";

	protected java.lang.String banca_di_riferimento;
	protected java.lang.String codice_contratto;
	protected java.lang.String conto_corrente;
	protected java.util.Date data_apertura;
	protected java.util.Date data_chiusura;
	protected java.util.Date data_rinnovo;
	protected java.util.Date data_scadenza;
	protected Soci dati_socio;
	protected java.lang.String delega;
	protected java.util.ArrayList<Estrattoconto> estratticonto;
	protected java.lang.String iban;
	protected java.lang.String modalita_rinnovo;
	protected java.lang.String motivazione_chiusura;
	protected java.util.ArrayList<Movimenti_Libretti> movimenti;
	protected java.lang.String note_contratto;
	protected java.util.ArrayList<Movimenti_Quote> quote_relative;
	protected java.lang.String stato_libretto;
	protected CondizioniLibretto tipo_libretto;
	protected String id;

	public Libretti(){}

	public java.lang.String getBanca_di_riferimento() {
		return banca_di_riferimento;
	}

	public void setBanca_di_riferimento(java.lang.String banca_di_riferimento) {
		this.banca_di_riferimento = banca_di_riferimento;
	}

	public java.lang.String getCodice_contratto() {
		return codice_contratto;
	}

	public void setCodice_contratto(java.lang.String codice_contratto) {
		this.codice_contratto = codice_contratto;
	}

	public java.lang.String getConto_corrente() {
		return conto_corrente;
	}

	public void setConto_corrente(java.lang.String conto_corrente) {
		this.conto_corrente = conto_corrente;
	}

	public java.util.Date getData_apertura() {
		return data_apertura;
	}

	public void setData_apertura(java.util.Date data_apertura) {
		this.data_apertura = data_apertura;
	}

	public java.util.Date getData_chiusura() {
		return data_chiusura;
	}

	public void setData_chiusura(java.util.Date data_chiusura) {
		this.data_chiusura = data_chiusura;
	}

	public java.util.Date getData_rinnovo() {
		return data_rinnovo;
	}

	public void setData_rinnovo(java.util.Date data_rinnovo) {
		this.data_rinnovo = data_rinnovo;
	}

	public java.util.Date getData_scadenza() {
		return data_scadenza;
	}

	public void setData_scadenza(java.util.Date data_scadenza) {
		this.data_scadenza = data_scadenza;
	}

	public Soci getDati_socio() {
		return dati_socio;
	}

	public void setDati_socio(Soci dati_socio) {
		this.dati_socio = dati_socio;
	}

	public java.lang.String getDelega() {
		return delega;
	}

	public void setDelega(java.lang.String delega) {
		this.delega = delega;
	}

	public java.util.ArrayList<Estrattoconto> getEstratticonto() {
		return estratticonto;
	}

	public void setEstratticonto(java.util.ArrayList<Estrattoconto> estratticonto) {
		this.estratticonto = estratticonto;
	}

	public java.lang.String getIban() {
		return iban;
	}

	public void setIban(java.lang.String iban) {
		this.iban = iban;
	}

	public java.lang.String getModalita_rinnovo() {
		return modalita_rinnovo;
	}

	public void setModalita_rinnovo(java.lang.String modalita_rinnovo) {
		this.modalita_rinnovo = modalita_rinnovo;
	}

	public java.lang.String getMotivazione_chiusura() {
		return motivazione_chiusura;
	}

	public void setMotivazione_chiusura(java.lang.String motivazione_chiusura) {
		this.motivazione_chiusura = motivazione_chiusura;
	}

	public java.util.ArrayList<Movimenti_Libretti> getMovimenti() {
		return movimenti;
	}

	public void setMovimenti(java.util.ArrayList<Movimenti_Libretti> movimenti) {
		this.movimenti = movimenti;
	}

	public java.lang.String getNote_contratto() {
		return note_contratto;
	}

	public void setNote_contratto(java.lang.String note_contratto) {
		this.note_contratto = note_contratto;
	}

	public java.util.ArrayList<Movimenti_Quote> getQuote_relative() {
		return quote_relative;
	}

	public void setQuote_relative(java.util.ArrayList<Movimenti_Quote> quote_relative) {
		this.quote_relative = quote_relative;
	}

	public java.lang.String getStato_libretto() {
		return stato_libretto;
	}

	public void setStato_libretto(java.lang.String stato_libretto) {
		this.stato_libretto = stato_libretto;
	}

	public CondizioniLibretto getTipo_libretto() {
		return tipo_libretto;
	}

	public void setTipo_libretto(CondizioniLibretto tipo_libretto) {
		this.tipo_libretto = tipo_libretto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "Libretti \n banca_di_riferimento: "+banca_di_riferimento+" codice_contratto: "+codice_contratto+" conto_corrente: "+conto_corrente+" data_apertura: "+data_apertura+" data_chiusura: "+data_chiusura+" data_rinnovo: "+data_rinnovo+" data_scadenza: "+data_scadenza+" delega: "+delega+" iban: "+iban+" modalita_rinnovo: "+modalita_rinnovo+" motivazione_chiusura: "+motivazione_chiusura+" note_contratto: "+note_contratto+" stato_libretto: "+stato_libretto;
	}

}
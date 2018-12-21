package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class Organizzazioni implements SerenaMarshallable
{






	public static final java.lang.String SETTORE_ATTIVITA__ASSOCIAZIONISMO = "associazionismo";
	public static final java.lang.String SETTORE_ATTIVITA__COMMERCIO = "commercio";

	public static final java.lang.String TIPO_ORGANIZZAZIONE__ASSOCIAZIONE = "associazione";
	public static final java.lang.String TIPO_ORGANIZZAZIONE__COOPERATIVA = "cooperativa";
	public static final java.lang.String TIPO_ORGANIZZAZIONE__COOPERATIVA_SOCIALE = "cooperativa sociale";
	public static final java.lang.String TIPO_ORGANIZZAZIONE__FONDAZIONE = "fondazione";
	public static final java.lang.String TIPO_ORGANIZZAZIONE__ONG = "ong";
	public static final java.lang.String TIPO_ORGANIZZAZIONE__IMPRESA = "impresa";
	public static final java.lang.String TIPO_ORGANIZZAZIONE__ENTE_LOCALE = "ente locale";

	public static final java.lang.String TIPO_VIA__VIA = "via";
	public static final java.lang.String TIPO_VIA__STRADA = "strada";
	public static final java.lang.String TIPO_VIA__VIALE = "viale";
	public static final java.lang.String TIPO_VIA__VICOLO = "vicolo";
	public static final java.lang.String TIPO_VIA__CORSO = "corso";
	public static final java.lang.String TIPO_VIA__PIAZZA = "piazza";
	public static final java.lang.String TIPO_VIA__PIAZZETTA = "piazzetta";
	public static final java.lang.String TIPO_VIA__CASELLA_POSTALE = "casella postale";
	public static final java.lang.String TIPO_VIA__GALLERIA = "galleria";


	public static final java.lang.String INSTANCE_NAME = "Organizzazioni";
	public static final java.lang.String SLOT_ANNO_ISCRIZIONE = "anno_iscrizione";
	public static final java.lang.String SLOT_ANNO_RINNOVO = "anno_rinnovo";
	public static final java.lang.String SLOT_CAP = "cap";
	public static final java.lang.String SLOT_COMUNE = "comune";
	public static final java.lang.String SLOT_DATI_ASSOCIAZIONE = "dati_associazione";
	public static final java.lang.String SLOT_DI_BOTTEGA = "di_bottega";
	public static final java.lang.String SLOT_EMAIL = "email";
	public static final java.lang.String SLOT_FAX = "fax";
	public static final java.lang.String SLOT_I_TAG_RELATIVI = "i_tag_relativi";
	public static final java.lang.String SLOT_INDIRIZZO = "indirizzo";
	public static final java.lang.String SLOT_LEGALE_RAPPRESENTANTE = "legale_rappresentante";
	public static final java.lang.String SLOT_NOME = "nome";
	public static final java.lang.String SLOT_NOTE = "note";
	public static final java.lang.String SLOT_NUMERO = "numero";
	public static final java.lang.String SLOT_PROVINCIA = "provincia";
	public static final java.lang.String SLOT_REGIONE = "regione";
	public static final java.lang.String SLOT_SETTORE_ATTIVITA = "settore_attivita";
	public static final java.lang.String SLOT_TELEFONO = "telefono";
	public static final java.lang.String SLOT_TIPO_ORGANIZZAZIONE = "tipo_organizzazione";
	public static final java.lang.String SLOT_TIPO_VIA = "tipo_via";
	public static final java.lang.String SLOT_WEB = "web";

	protected java.lang.String anno_iscrizione;
	protected java.lang.String anno_rinnovo;
	protected java.lang.String cap;
	protected java.lang.String comune;
	protected Soci dati_associazione;
	protected Botteghe di_bottega;
	protected java.lang.String email;
	protected java.lang.String fax;
	protected java.util.ArrayList<Tag> i_tag_relativi;
	protected java.lang.String indirizzo;
	protected java.lang.String legale_rappresentante;
	protected java.lang.String nome;
	protected java.lang.String note;
	protected java.lang.String numero;
	protected java.lang.String provincia;
	protected java.lang.String regione;
	protected java.lang.String settore_attivita;
	protected java.lang.String telefono;
	protected java.lang.String tipo_organizzazione;
	protected java.lang.String tipo_via;
	protected java.lang.String web;
	protected String id;

	public Organizzazioni(){}

	public java.lang.String getAnno_iscrizione() {
		return anno_iscrizione;
	}

	public void setAnno_iscrizione(java.lang.String anno_iscrizione) {
		this.anno_iscrizione = anno_iscrizione;
	}

	public java.lang.String getAnno_rinnovo() {
		return anno_rinnovo;
	}

	public void setAnno_rinnovo(java.lang.String anno_rinnovo) {
		this.anno_rinnovo = anno_rinnovo;
	}

	public java.lang.String getCap() {
		return cap;
	}

	public void setCap(java.lang.String cap) {
		this.cap = cap;
	}

	public java.lang.String getComune() {
		return comune;
	}

	public void setComune(java.lang.String comune) {
		this.comune = comune;
	}

	public Soci getDati_associazione() {
		return dati_associazione;
	}

	public void setDati_associazione(Soci dati_associazione) {
		this.dati_associazione = dati_associazione;
	}

	public Botteghe getDi_bottega() {
		return di_bottega;
	}

	public void setDi_bottega(Botteghe di_bottega) {
		this.di_bottega = di_bottega;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getFax() {
		return fax;
	}

	public void setFax(java.lang.String fax) {
		this.fax = fax;
	}

	public java.util.ArrayList<Tag> getI_tag_relativi() {
		return i_tag_relativi;
	}

	public void setI_tag_relativi(java.util.ArrayList<Tag> i_tag_relativi) {
		this.i_tag_relativi = i_tag_relativi;
	}

	public java.lang.String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(java.lang.String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public java.lang.String getLegale_rappresentante() {
		return legale_rappresentante;
	}

	public void setLegale_rappresentante(java.lang.String legale_rappresentante) {
		this.legale_rappresentante = legale_rappresentante;
	}

	public java.lang.String getNome() {
		return nome;
	}

	public void setNome(java.lang.String nome) {
		this.nome = nome;
	}

	public java.lang.String getNote() {
		return note;
	}

	public void setNote(java.lang.String note) {
		this.note = note;
	}

	public java.lang.String getNumero() {
		return numero;
	}

	public void setNumero(java.lang.String numero) {
		this.numero = numero;
	}

	public java.lang.String getProvincia() {
		return provincia;
	}

	public void setProvincia(java.lang.String provincia) {
		this.provincia = provincia;
	}

	public java.lang.String getRegione() {
		return regione;
	}

	public void setRegione(java.lang.String regione) {
		this.regione = regione;
	}

	public java.lang.String getSettore_attivita() {
		return settore_attivita;
	}

	public void setSettore_attivita(java.lang.String settore_attivita) {
		this.settore_attivita = settore_attivita;
	}

	public java.lang.String getTelefono() {
		return telefono;
	}

	public void setTelefono(java.lang.String telefono) {
		this.telefono = telefono;
	}

	public java.lang.String getTipo_organizzazione() {
		return tipo_organizzazione;
	}

	public void setTipo_organizzazione(java.lang.String tipo_organizzazione) {
		this.tipo_organizzazione = tipo_organizzazione;
	}

	public java.lang.String getTipo_via() {
		return tipo_via;
	}

	public void setTipo_via(java.lang.String tipo_via) {
		this.tipo_via = tipo_via;
	}

	public java.lang.String getWeb() {
		return web;
	}

	public void setWeb(java.lang.String web) {
		this.web = web;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "Organizzazioni \n anno_iscrizione: "+anno_iscrizione+" anno_rinnovo: "+anno_rinnovo+" cap: "+cap+" comune: "+comune+" email: "+email+" fax: "+fax+" indirizzo: "+indirizzo+" legale_rappresentante: "+legale_rappresentante+" nome: "+nome+" note: "+note+" numero: "+numero+" provincia: "+provincia+" regione: "+regione+" settore_attivita: "+settore_attivita+" telefono: "+telefono+" tipo_organizzazione: "+tipo_organizzazione+" tipo_via: "+tipo_via+" web: "+web;
	}

}
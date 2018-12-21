package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class Botteghe implements SerenaMarshallable
{





	public static final java.lang.String INSTANCE_NAME = "Botteghe";
	public static final java.lang.String SLOT_ALLEGATO = "allegato";
	public static final java.lang.String SLOT_APPARTIENE_A = "appartiene_a";
	public static final java.lang.String SLOT_CAP = "cap";
	public static final java.lang.String SLOT_COMUNE = "comune";
	public static final java.lang.String SLOT_CONSUMATORI = "consumatori";
	public static final java.lang.String SLOT_DESCRIZIONE = "descrizione";
	public static final java.lang.String SLOT_EMAIL = "email";
	public static final java.lang.String SLOT_FAX = "fax";
	public static final java.lang.String SLOT_FOTO = "foto";
	public static final java.lang.String SLOT_INDIRIZZO = "indirizzo";
	public static final java.lang.String SLOT_NOME = "nome";
	public static final java.lang.String SLOT_NOTE = "note";
	public static final java.lang.String SLOT_ORGANIZZAZIONI = "organizzazioni";
	public static final java.lang.String SLOT_PRODOTTI_MERCATINO = "prodotti_mercatino";
	public static final java.lang.String SLOT_PROVINCIA = "provincia";
	public static final java.lang.String SLOT_REGIONE = "regione";
	public static final java.lang.String SLOT_TELEFONO = "telefono";
	public static final java.lang.String SLOT_WEB = "web";

	protected java.lang.String allegato;
	protected Cooperative appartiene_a;
	protected java.lang.String cap;
	protected java.lang.String comune;
	protected java.util.ArrayList<Consumatori> consumatori;
	protected java.lang.String descrizione;
	protected java.lang.String email;
	protected java.lang.String fax;
	protected java.lang.String foto;
	protected java.lang.String indirizzo;
	protected java.lang.String nome;
	protected java.lang.String note;
	protected java.util.ArrayList<Organizzazioni> organizzazioni;
	protected java.util.ArrayList<Prodotti> prodotti_mercatino;
	protected java.lang.String provincia;
	protected java.lang.String regione;
	protected java.lang.String telefono;
	protected java.lang.String web;
	protected String id;

	public Botteghe(){}

	public java.lang.String getAllegato() {
		return allegato;
	}

	public void setAllegato(java.lang.String allegato) {
		this.allegato = allegato;
	}

	public Cooperative getAppartiene_a() {
		return appartiene_a;
	}

	public void setAppartiene_a(Cooperative appartiene_a) {
		this.appartiene_a = appartiene_a;
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

	public java.util.ArrayList<Consumatori> getConsumatori() {
		return consumatori;
	}

	public void setConsumatori(java.util.ArrayList<Consumatori> consumatori) {
		this.consumatori = consumatori;
	}

	public java.lang.String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(java.lang.String descrizione) {
		this.descrizione = descrizione;
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

	public java.lang.String getFoto() {
		return foto;
	}

	public void setFoto(java.lang.String foto) {
		this.foto = foto;
	}

	public java.lang.String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(java.lang.String indirizzo) {
		this.indirizzo = indirizzo;
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

	public java.util.ArrayList<Organizzazioni> getOrganizzazioni() {
		return organizzazioni;
	}

	public void setOrganizzazioni(java.util.ArrayList<Organizzazioni> organizzazioni) {
		this.organizzazioni = organizzazioni;
	}

	public java.util.ArrayList<Prodotti> getProdotti_mercatino() {
		return prodotti_mercatino;
	}

	public void setProdotti_mercatino(java.util.ArrayList<Prodotti> prodotti_mercatino) {
		this.prodotti_mercatino = prodotti_mercatino;
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

	public java.lang.String getTelefono() {
		return telefono;
	}

	public void setTelefono(java.lang.String telefono) {
		this.telefono = telefono;
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
		return "Botteghe \n allegato: "+allegato+" cap: "+cap+" comune: "+comune+" descrizione: "+descrizione+" email: "+email+" fax: "+fax+" foto: "+foto+" indirizzo: "+indirizzo+" nome: "+nome+" note: "+note+" provincia: "+provincia+" regione: "+regione+" telefono: "+telefono+" web: "+web;
	}

}
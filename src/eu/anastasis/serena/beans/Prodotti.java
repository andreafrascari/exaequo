package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class Prodotti implements SerenaMarshallable
{

	public static final java.lang.String CATEGORIA__ALIMENTARI = "alimentari";

	public static final java.lang.String FORNITORE__CTM = "CTM";

	public static final java.lang.String SOTTO_CATEGORIA__BISCOTTI = "biscotti";


	public static final java.lang.String INSTANCE_NAME = "Prodotti";
	public static final java.lang.String SLOT_ALLEGATO = "allegato";
	public static final java.lang.String SLOT_CATEGORIA = "categoria";
	public static final java.lang.String SLOT_CODICE = "codice";
	public static final java.lang.String SLOT_DESCRIZIONE = "descrizione";
	public static final java.lang.String SLOT_FORNITORE = "fornitore";
	public static final java.lang.String SLOT_FOTO = "foto";
	public static final java.lang.String SLOT_NOME = "nome";
	public static final java.lang.String SLOT_NOTE = "note";
	public static final java.lang.String SLOT_PREZZO = "prezzo";
	public static final java.lang.String SLOT_PRODOTTI_BOTTEGA = "prodotti_bottega";
	public static final java.lang.String SLOT_PRODUTTORE = "produttore";
	public static final java.lang.String SLOT_PROVENIENZA = "provenienza";
	public static final java.lang.String SLOT_QUANTITA = "quantita";
	public static final java.lang.String SLOT_SOTTO_CATEGORIA = "sotto_categoria";

	protected java.lang.String allegato;
	protected java.lang.String categoria;
	protected java.lang.String codice;
	protected java.lang.String descrizione;
	protected java.lang.String fornitore;
	protected java.lang.String foto;
	protected java.lang.String nome;
	protected java.lang.String note;
	protected java.lang.Integer prezzo;
	protected Botteghe prodotti_bottega;
	protected java.lang.String produttore;
	protected java.lang.String provenienza;
	protected java.lang.Integer quantita;
	protected java.lang.String sotto_categoria;
	protected String id;

	public Prodotti(){}

	public java.lang.String getAllegato() {
		return allegato;
	}

	public void setAllegato(java.lang.String allegato) {
		this.allegato = allegato;
	}

	public java.lang.String getCategoria() {
		return categoria;
	}

	public void setCategoria(java.lang.String categoria) {
		this.categoria = categoria;
	}

	public java.lang.String getCodice() {
		return codice;
	}

	public void setCodice(java.lang.String codice) {
		this.codice = codice;
	}

	public java.lang.String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(java.lang.String descrizione) {
		this.descrizione = descrizione;
	}

	public java.lang.String getFornitore() {
		return fornitore;
	}

	public void setFornitore(java.lang.String fornitore) {
		this.fornitore = fornitore;
	}

	public java.lang.String getFoto() {
		return foto;
	}

	public void setFoto(java.lang.String foto) {
		this.foto = foto;
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

	public java.lang.Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(java.lang.Integer prezzo) {
		this.prezzo = prezzo;
	}

	public Botteghe getProdotti_bottega() {
		return prodotti_bottega;
	}

	public void setProdotti_bottega(Botteghe prodotti_bottega) {
		this.prodotti_bottega = prodotti_bottega;
	}

	public java.lang.String getProduttore() {
		return produttore;
	}

	public void setProduttore(java.lang.String produttore) {
		this.produttore = produttore;
	}

	public java.lang.String getProvenienza() {
		return provenienza;
	}

	public void setProvenienza(java.lang.String provenienza) {
		this.provenienza = provenienza;
	}

	public java.lang.Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(java.lang.Integer quantita) {
		this.quantita = quantita;
	}

	public java.lang.String getSotto_categoria() {
		return sotto_categoria;
	}

	public void setSotto_categoria(java.lang.String sotto_categoria) {
		this.sotto_categoria = sotto_categoria;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "Prodotti \n allegato: "+allegato+" categoria: "+categoria+" codice: "+codice+" descrizione: "+descrizione+" fornitore: "+fornitore+" foto: "+foto+" nome: "+nome+" note: "+note+" prezzo: "+prezzo+" produttore: "+produttore+" provenienza: "+provenienza+" quantita: "+quantita+" sotto_categoria: "+sotto_categoria;
	}

}
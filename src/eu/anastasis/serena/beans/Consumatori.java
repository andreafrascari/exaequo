package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class Consumatori implements SerenaMarshallable
{






	public static final java.lang.String TIPO_VIA__VIA = "via";
	public static final java.lang.String TIPO_VIA__STRADA = "strada";
	public static final java.lang.String TIPO_VIA__VIALE = "viale";
	public static final java.lang.String TIPO_VIA__VICOLO = "vicolo";
	public static final java.lang.String TIPO_VIA__CORSO = "corso";
	public static final java.lang.String TIPO_VIA__PIAZZA = "piazza";
	public static final java.lang.String TIPO_VIA__PIAZZETTA = "piazzetta";
	public static final java.lang.String TIPO_VIA__CASELLA_POSTALE = "casella postale";
	public static final java.lang.String TIPO_VIA__GALLERIA = "galleria";


	public static final java.lang.String INSTANCE_NAME = "Consumatori";
	public static final java.lang.String SLOT_ANNO_ISCRIZIONE = "anno_iscrizione";
	public static final java.lang.String SLOT_ANNO_RINNOVO = "anno_rinnovo";
	public static final java.lang.String SLOT_ASSOCIAZIONE = "associazione";
	public static final java.lang.String SLOT_CAP = "cap";
	public static final java.lang.String SLOT_COGNOME = "cognome";
	public static final java.lang.String SLOT_COMUNE = "comune";
	public static final java.lang.String SLOT_CONSUMATORI_BOTTEGA = "consumatori_bottega";
	public static final java.lang.String SLOT_CONSUMATORI_TAGS = "consumatori_tags";
	public static final java.lang.String SLOT_EMAIL = "email";
	public static final java.lang.String SLOT_HA_PARTECIPATO_A = "ha_partecipato_a";
	public static final java.lang.String SLOT_INDIRIZZO = "indirizzo";
	public static final java.lang.String SLOT_NOME = "nome";
	public static final java.lang.String SLOT_NOTE = "note";
	public static final java.lang.String SLOT_PRESSO = "presso";
	public static final java.lang.String SLOT_PROVINCIA = "provincia";
	public static final java.lang.String SLOT_REGIONE = "regione";
	public static final java.lang.String SLOT_TIPO_VIA = "tipo_via";

	protected java.lang.String anno_iscrizione;
	protected java.lang.String anno_rinnovo;
	protected Soci associazione;
	protected java.lang.String cap;
	protected java.lang.String cognome;
	protected java.lang.String comune;
	protected Botteghe consumatori_bottega;
	protected java.util.ArrayList<Tag> consumatori_tags;
	protected java.lang.String email;
	protected java.util.ArrayList<Iniziative> ha_partecipato_a;
	protected java.lang.String indirizzo;
	protected java.lang.String nome;
	protected java.lang.String note;
	protected java.lang.String presso;
	protected java.lang.String provincia;
	protected java.lang.String regione;
	protected java.lang.String tipo_via;
	protected String id;

	public Consumatori(){}

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

	public Soci getAssociazione() {
		return associazione;
	}

	public void setAssociazione(Soci associazione) {
		this.associazione = associazione;
	}

	public java.lang.String getCap() {
		return cap;
	}

	public void setCap(java.lang.String cap) {
		this.cap = cap;
	}

	public java.lang.String getCognome() {
		return cognome;
	}

	public void setCognome(java.lang.String cognome) {
		this.cognome = cognome;
	}

	public java.lang.String getComune() {
		return comune;
	}

	public void setComune(java.lang.String comune) {
		this.comune = comune;
	}

	public Botteghe getConsumatori_bottega() {
		return consumatori_bottega;
	}

	public void setConsumatori_bottega(Botteghe consumatori_bottega) {
		this.consumatori_bottega = consumatori_bottega;
	}

	public java.util.ArrayList<Tag> getConsumatori_tags() {
		return consumatori_tags;
	}

	public void setConsumatori_tags(java.util.ArrayList<Tag> consumatori_tags) {
		this.consumatori_tags = consumatori_tags;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.util.ArrayList<Iniziative> getHa_partecipato_a() {
		return ha_partecipato_a;
	}

	public void setHa_partecipato_a(java.util.ArrayList<Iniziative> ha_partecipato_a) {
		this.ha_partecipato_a = ha_partecipato_a;
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

	public java.lang.String getPresso() {
		return presso;
	}

	public void setPresso(java.lang.String presso) {
		this.presso = presso;
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

	public java.lang.String getTipo_via() {
		return tipo_via;
	}

	public void setTipo_via(java.lang.String tipo_via) {
		this.tipo_via = tipo_via;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "Consumatori \n anno_iscrizione: "+anno_iscrizione+" anno_rinnovo: "+anno_rinnovo+" cap: "+cap+" cognome: "+cognome+" comune: "+comune+" email: "+email+" indirizzo: "+indirizzo+" nome: "+nome+" note: "+note+" presso: "+presso+" provincia: "+provincia+" regione: "+regione+" tipo_via: "+tipo_via;
	}

}
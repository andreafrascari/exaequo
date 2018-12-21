package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class Cooperative implements SerenaMarshallable
{




	public static final java.lang.String TIPO_COOPERATIVA__SOCIALE = "sociale";
	public static final java.lang.String TIPO_COOPERATIVA__PRODUZIONE_LAVORO = "produzione lavoro";
	public static final java.lang.String TIPO_COOPERATIVA__CONSUMATORI = "consumatori";


	public static final java.lang.String INSTANCE_NAME = "Cooperative";
	public static final java.lang.String SLOT_ALLEGATO = "allegato";
	public static final java.lang.String SLOT_BOTTEGHE = "botteghe";
	public static final java.lang.String SLOT_CAP = "cap";
	public static final java.lang.String SLOT_COMUNE = "comune";
	public static final java.lang.String SLOT_CONDIZIONI_LIBRETTI = "condizioni_libretti";
	public static final java.lang.String SLOT_COOPERATIVA_INIZIATIVE = "cooperativa_iniziative";
	public static final java.lang.String SLOT_DATA_CHIUSURA_BILANCIO = "data_chiusura_bilancio";
	public static final java.lang.String SLOT_DELIBERA_CDA_ADESIONE = "delibera_cda_adesione";
	public static final java.lang.String SLOT_DELIBERA_CDA_RECESSO = "delibera_cda_recesso";
	public static final java.lang.String SLOT_DESCRIZIONE = "descrizione";
	public static final java.lang.String SLOT_EMAIL = "email";
	public static final java.lang.String SLOT_EMAIL_ADMIN_MAILING_LIST = "email_admin_mailing_list";
	public static final java.lang.String SLOT_FAX = "fax";
	public static final java.lang.String SLOT_FOTO = "foto";
	public static final java.lang.String SLOT_I_SOCI = "i_soci";
	public static final java.lang.String SLOT_INDIRIZZO = "indirizzo";
	public static final java.lang.String SLOT_LIQUIDAZIONE_QUOTE_ESERCIZIO_GIORNI = "liquidazione_quote_esercizio_giorni";
	public static final java.lang.String SLOT_NEWSLETTER_DI_COOP = "newsletter_di_coop";
	public static final java.lang.String SLOT_NOME_MAILING_LIST = "nome_mailing_list";
	public static final java.lang.String SLOT_NUMERO_QUOTE_ASSOCIAZIONE = "numero_quote_associazione";
	public static final java.lang.String SLOT_PROVINCIA = "provincia";
	public static final java.lang.String SLOT_RAGIONE_SOCIALE = "ragione_sociale";
	public static final java.lang.String SLOT_REGIONE = "regione";
	public static final java.lang.String SLOT_REGOLAMENTO_PRESTITO = "regolamento_prestito";
	public static final java.lang.String SLOT_SEZ_MAILING_LIST = "sez_mailing_list";
	public static final java.lang.String SLOT_SEZ_STATUTO_REGOLAMENTI = "sez_statuto_regolamenti";
	public static final java.lang.String SLOT_TAG_COOP = "tag_coop";
	public static final java.lang.String SLOT_TELEFONO = "telefono";
	public static final java.lang.String SLOT_TIPO_COOPERATIVA = "tipo_cooperativa";
	public static final java.lang.String SLOT_VALORE_QUOTA = "valore_quota";
	public static final java.lang.String SLOT_WEB = "web";

	protected java.lang.String allegato;
	protected java.util.ArrayList<Botteghe> botteghe;
	protected java.lang.String cap;
	protected java.lang.String comune;
	protected java.util.ArrayList<CondizioniLibretto> condizioni_libretti;
	protected java.util.ArrayList<Iniziative> cooperativa_iniziative;
	protected java.lang.String data_chiusura_bilancio;
	protected java.lang.Integer delibera_cda_adesione;
	protected java.lang.Integer delibera_cda_recesso;
	protected java.lang.String descrizione;
	protected java.lang.String email;
	protected java.lang.String email_admin_mailing_list;
	protected java.lang.String fax;
	protected java.lang.String foto;
	protected java.util.ArrayList<Soci> i_soci;
	protected java.lang.String indirizzo;
	protected java.lang.String liquidazione_quote_esercizio_giorni;
	protected java.util.ArrayList<Newsletter> newsletter_di_coop;
	protected java.lang.String nome_mailing_list;
	protected java.lang.String numero_quote_associazione;
	protected java.lang.String provincia;
	protected java.lang.String ragione_sociale;
	protected java.lang.String regione;
	protected RegolamentoPrestito regolamento_prestito;
	protected java.lang.String sez_mailing_list;
	protected java.lang.String sez_statuto_regolamenti;
	protected java.util.ArrayList<Tag> tag_coop;
	protected java.lang.String telefono;
	protected java.lang.String tipo_cooperativa;
	protected java.lang.Integer valore_quota;
	protected java.lang.String web;
	protected String id;

	public Cooperative(){}

	public java.lang.String getAllegato() {
		return allegato;
	}

	public void setAllegato(java.lang.String allegato) {
		this.allegato = allegato;
	}

	public java.util.ArrayList<Botteghe> getBotteghe() {
		return botteghe;
	}

	public void setBotteghe(java.util.ArrayList<Botteghe> botteghe) {
		this.botteghe = botteghe;
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

	public java.util.ArrayList<CondizioniLibretto> getCondizioni_libretti() {
		return condizioni_libretti;
	}

	public void setCondizioni_libretti(java.util.ArrayList<CondizioniLibretto> condizioni_libretti) {
		this.condizioni_libretti = condizioni_libretti;
	}

	public java.util.ArrayList<Iniziative> getCooperativa_iniziative() {
		return cooperativa_iniziative;
	}

	public void setCooperativa_iniziative(java.util.ArrayList<Iniziative> cooperativa_iniziative) {
		this.cooperativa_iniziative = cooperativa_iniziative;
	}

	public java.lang.String getData_chiusura_bilancio() {
		return data_chiusura_bilancio;
	}

	public void setData_chiusura_bilancio(java.lang.String data_chiusura_bilancio) {
		this.data_chiusura_bilancio = data_chiusura_bilancio;
	}

	public java.lang.Integer getDelibera_cda_adesione() {
		return delibera_cda_adesione;
	}

	public void setDelibera_cda_adesione(java.lang.Integer delibera_cda_adesione) {
		this.delibera_cda_adesione = delibera_cda_adesione;
	}

	public java.lang.Integer getDelibera_cda_recesso() {
		return delibera_cda_recesso;
	}

	public void setDelibera_cda_recesso(java.lang.Integer delibera_cda_recesso) {
		this.delibera_cda_recesso = delibera_cda_recesso;
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

	public java.lang.String getEmail_admin_mailing_list() {
		return email_admin_mailing_list;
	}

	public void setEmail_admin_mailing_list(java.lang.String email_admin_mailing_list) {
		this.email_admin_mailing_list = email_admin_mailing_list;
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

	public java.util.ArrayList<Soci> getI_soci() {
		return i_soci;
	}

	public void setI_soci(java.util.ArrayList<Soci> i_soci) {
		this.i_soci = i_soci;
	}

	public java.lang.String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(java.lang.String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public java.lang.String getLiquidazione_quote_esercizio_giorni() {
		return liquidazione_quote_esercizio_giorni;
	}

	public void setLiquidazione_quote_esercizio_giorni(java.lang.String liquidazione_quote_esercizio_giorni) {
		this.liquidazione_quote_esercizio_giorni = liquidazione_quote_esercizio_giorni;
	}

	public java.util.ArrayList<Newsletter> getNewsletter_di_coop() {
		return newsletter_di_coop;
	}

	public void setNewsletter_di_coop(java.util.ArrayList<Newsletter> newsletter_di_coop) {
		this.newsletter_di_coop = newsletter_di_coop;
	}

	public java.lang.String getNome_mailing_list() {
		return nome_mailing_list;
	}

	public void setNome_mailing_list(java.lang.String nome_mailing_list) {
		this.nome_mailing_list = nome_mailing_list;
	}

	public java.lang.String getNumero_quote_associazione() {
		return numero_quote_associazione;
	}

	public void setNumero_quote_associazione(java.lang.String numero_quote_associazione) {
		this.numero_quote_associazione = numero_quote_associazione;
	}

	public java.lang.String getProvincia() {
		return provincia;
	}

	public void setProvincia(java.lang.String provincia) {
		this.provincia = provincia;
	}

	public java.lang.String getRagione_sociale() {
		return ragione_sociale;
	}

	public void setRagione_sociale(java.lang.String ragione_sociale) {
		this.ragione_sociale = ragione_sociale;
	}

	public java.lang.String getRegione() {
		return regione;
	}

	public void setRegione(java.lang.String regione) {
		this.regione = regione;
	}

	public RegolamentoPrestito getRegolamento_prestito() {
		return regolamento_prestito;
	}

	public void setRegolamento_prestito(RegolamentoPrestito regolamento_prestito) {
		this.regolamento_prestito = regolamento_prestito;
	}

	public java.lang.String getSez_mailing_list() {
		return sez_mailing_list;
	}

	public void setSez_mailing_list(java.lang.String sez_mailing_list) {
		this.sez_mailing_list = sez_mailing_list;
	}

	public java.lang.String getSez_statuto_regolamenti() {
		return sez_statuto_regolamenti;
	}

	public void setSez_statuto_regolamenti(java.lang.String sez_statuto_regolamenti) {
		this.sez_statuto_regolamenti = sez_statuto_regolamenti;
	}

	public java.util.ArrayList<Tag> getTag_coop() {
		return tag_coop;
	}

	public void setTag_coop(java.util.ArrayList<Tag> tag_coop) {
		this.tag_coop = tag_coop;
	}

	public java.lang.String getTelefono() {
		return telefono;
	}

	public void setTelefono(java.lang.String telefono) {
		this.telefono = telefono;
	}

	public java.lang.String getTipo_cooperativa() {
		return tipo_cooperativa;
	}

	public void setTipo_cooperativa(java.lang.String tipo_cooperativa) {
		this.tipo_cooperativa = tipo_cooperativa;
	}

	public java.lang.Integer getValore_quota() {
		return valore_quota;
	}

	public void setValore_quota(java.lang.Integer valore_quota) {
		this.valore_quota = valore_quota;
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
		return "Cooperative \n allegato: "+allegato+" cap: "+cap+" comune: "+comune+" data_chiusura_bilancio: "+data_chiusura_bilancio+" delibera_cda_adesione: "+delibera_cda_adesione+" delibera_cda_recesso: "+delibera_cda_recesso+" descrizione: "+descrizione+" email: "+email+" email_admin_mailing_list: "+email_admin_mailing_list+" fax: "+fax+" foto: "+foto+" indirizzo: "+indirizzo+" liquidazione_quote_esercizio_giorni: "+liquidazione_quote_esercizio_giorni+" nome_mailing_list: "+nome_mailing_list+" numero_quote_associazione: "+numero_quote_associazione+" provincia: "+provincia+" ragione_sociale: "+ragione_sociale+" regione: "+regione+" sez_mailing_list: "+sez_mailing_list+" sez_statuto_regolamenti: "+sez_statuto_regolamenti+" telefono: "+telefono+" tipo_cooperativa: "+tipo_cooperativa+" valore_quota: "+valore_quota+" web: "+web;
	}

}
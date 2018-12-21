package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class CorsiFormazione implements SerenaMarshallable
{
	/*
	 * Uno o piu' slot non sono presenti in questo bean a causa dei problemi seguenti:
	 * - abstract e' una parola riservata di Java
	 */
	public static final java.lang.String TEMA__COOPERAZIONE_DECENTRATA = "cooperazione decentrata";
	public static final java.lang.String TEMA__RISTORAZIONE_SOLIDALE = "ristorazione solidale";
	public static final java.lang.String TEMA__FAIR_TRADE = "fair trade";
	public static final java.lang.String TEMA__LEGISLAZIONE = "legislazione";


	public static final java.lang.String INSTANCE_NAME = "CorsiFormazione";
	public static final java.lang.String SLOT_ALLEGATO = "allegato";
	public static final java.lang.String SLOT_ALLEGATO_1 = "allegato_1";
	public static final java.lang.String SLOT_DOCUMENTI_CORSO = "documenti_corso";
	public static final java.lang.String SLOT_LOGO = "logo";
	public static final java.lang.String SLOT_LUOGO = "luogo";
	public static final java.lang.String SLOT_ORGANIZZATORE = "organizzatore";
	public static final java.lang.String SLOT_PERIODO = "periodo";
	public static final java.lang.String SLOT_SESSIONI = "sessioni";
	public static final java.lang.String SLOT_TEMA = "tema";
	public static final java.lang.String SLOT_TITOLO = "titolo";

	protected java.lang.String allegato;
	protected java.lang.String allegato_1;
	protected java.util.ArrayList<_system_document> documenti_corso;
	protected java.lang.String logo;
	protected java.lang.String luogo;
	protected java.lang.String organizzatore;
	protected java.lang.String periodo;
	protected java.util.ArrayList<SessioniCorsi> sessioni;
	protected java.lang.String tema;
	protected java.lang.String titolo;
	protected String id;

	public CorsiFormazione(){}

	public java.lang.String getAllegato() {
		return allegato;
	}

	public void setAllegato(java.lang.String allegato) {
		this.allegato = allegato;
	}

	public java.lang.String getAllegato_1() {
		return allegato_1;
	}

	public void setAllegato_1(java.lang.String allegato_1) {
		this.allegato_1 = allegato_1;
	}

	public java.util.ArrayList<_system_document> getDocumenti_corso() {
		return documenti_corso;
	}

	public void setDocumenti_corso(java.util.ArrayList<_system_document> documenti_corso) {
		this.documenti_corso = documenti_corso;
	}

	public java.lang.String getLogo() {
		return logo;
	}

	public void setLogo(java.lang.String logo) {
		this.logo = logo;
	}

	public java.lang.String getLuogo() {
		return luogo;
	}

	public void setLuogo(java.lang.String luogo) {
		this.luogo = luogo;
	}

	public java.lang.String getOrganizzatore() {
		return organizzatore;
	}

	public void setOrganizzatore(java.lang.String organizzatore) {
		this.organizzatore = organizzatore;
	}

	public java.lang.String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(java.lang.String periodo) {
		this.periodo = periodo;
	}

	public java.util.ArrayList<SessioniCorsi> getSessioni() {
		return sessioni;
	}

	public void setSessioni(java.util.ArrayList<SessioniCorsi> sessioni) {
		this.sessioni = sessioni;
	}

	public java.lang.String getTema() {
		return tema;
	}

	public void setTema(java.lang.String tema) {
		this.tema = tema;
	}

	public java.lang.String getTitolo() {
		return titolo;
	}

	public void setTitolo(java.lang.String titolo) {
		this.titolo = titolo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "CorsiFormazione \n allegato: "+allegato+" allegato_1: "+allegato_1+" logo: "+logo+" luogo: "+luogo+" organizzatore: "+organizzatore+" periodo: "+periodo+" tema: "+tema+" titolo: "+titolo;
	}

}
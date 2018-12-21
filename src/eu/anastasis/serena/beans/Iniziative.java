package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class Iniziative implements SerenaMarshallable
{


	public static final java.lang.String INSTANCE_NAME = "Iniziative";
	public static final java.lang.String SLOT_ALLEGATO = "allegato";
	public static final java.lang.String SLOT_ALLEGATO_1 = "allegato_1";
	public static final java.lang.String SLOT_DATA = "data";
	public static final java.lang.String SLOT_DESCRIZIONE = "descrizione";
	public static final java.lang.String SLOT_FOTO = "foto";
	public static final java.lang.String SLOT_INIZIATIVE_COOPERATIVA = "iniziative_cooperativa";
	public static final java.lang.String SLOT_NOME_INIZIATIVA = "nome_iniziativa";
	public static final java.lang.String SLOT_PARTECIPANTI = "partecipanti";

	protected java.lang.String allegato;
	protected java.lang.String allegato_1;
	protected java.util.Date data;
	protected java.lang.String descrizione;
	protected java.lang.String foto;
	protected Cooperative iniziative_cooperativa;
	protected java.lang.String nome_iniziativa;
	protected java.util.ArrayList<Consumatori> partecipanti;
	protected String id;

	public Iniziative(){}

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

	public java.util.Date getData() {
		return data;
	}

	public void setData(java.util.Date data) {
		this.data = data;
	}

	public java.lang.String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(java.lang.String descrizione) {
		this.descrizione = descrizione;
	}

	public java.lang.String getFoto() {
		return foto;
	}

	public void setFoto(java.lang.String foto) {
		this.foto = foto;
	}

	public Cooperative getIniziative_cooperativa() {
		return iniziative_cooperativa;
	}

	public void setIniziative_cooperativa(Cooperative iniziative_cooperativa) {
		this.iniziative_cooperativa = iniziative_cooperativa;
	}

	public java.lang.String getNome_iniziativa() {
		return nome_iniziativa;
	}

	public void setNome_iniziativa(java.lang.String nome_iniziativa) {
		this.nome_iniziativa = nome_iniziativa;
	}

	public java.util.ArrayList<Consumatori> getPartecipanti() {
		return partecipanti;
	}

	public void setPartecipanti(java.util.ArrayList<Consumatori> partecipanti) {
		this.partecipanti = partecipanti;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "Iniziative \n allegato: "+allegato+" allegato_1: "+allegato_1+" data: "+data+" descrizione: "+descrizione+" foto: "+foto+" nome_iniziativa: "+nome_iniziativa;
	}

}
package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class Tag implements SerenaMarshallable
{


	public static final java.lang.String INSTANCE_NAME = "Tag";
	public static final java.lang.String SLOT_DI_COOP = "di_coop";
	public static final java.lang.String SLOT_NOME = "nome";
	public static final java.lang.String SLOT_PER_CONSUMATORI = "per_consumatori";
	public static final java.lang.String SLOT_PER_ORGANIZZAZIONI = "per_organizzazioni";

	protected Cooperative di_coop;
	protected java.lang.String nome;
	protected java.util.ArrayList<Consumatori> per_consumatori;
	protected java.util.ArrayList<Organizzazioni> per_organizzazioni;
	protected String id;

	public Tag(){}

	public Cooperative getDi_coop() {
		return di_coop;
	}

	public void setDi_coop(Cooperative di_coop) {
		this.di_coop = di_coop;
	}

	public java.lang.String getNome() {
		return nome;
	}

	public void setNome(java.lang.String nome) {
		this.nome = nome;
	}

	public java.util.ArrayList<Consumatori> getPer_consumatori() {
		return per_consumatori;
	}

	public void setPer_consumatori(java.util.ArrayList<Consumatori> per_consumatori) {
		this.per_consumatori = per_consumatori;
	}

	public java.util.ArrayList<Organizzazioni> getPer_organizzazioni() {
		return per_organizzazioni;
	}

	public void setPer_organizzazioni(java.util.ArrayList<Organizzazioni> per_organizzazioni) {
		this.per_organizzazioni = per_organizzazioni;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "Tag \n nome: "+nome;
	}

}
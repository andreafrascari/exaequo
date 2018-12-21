package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class RegolamentoPrestito implements SerenaMarshallable
{

	public static final java.lang.String LIQUIDAZIONE_INTERESSI_CHIUSURA__FISSO = "Fisso";
	public static final java.lang.String LIQUIDAZIONE_INTERESSI_CHIUSURA__CONTESTUALE = "Contestuale";


	public static final java.lang.String INSTANCE_NAME = "RegolamentoPrestito";
	public static final java.lang.String SLOT_ACCREDITO_INTERESSI = "accredito_interessi";
	public static final java.lang.String SLOT_APERTURA_LIBRETTO_DOPO_ADESIONE_GIORNI = "apertura_libretto_dopo_adesione_giorni";
	public static final java.lang.String SLOT_COMUNIQCAZIONE_MODIFICHE_GIORNI = "comuniqcazione_modifiche_giorni";
	public static final java.lang.String SLOT_COSTO_SINGOLA_OPERAZIONE = "costo_singola_operazione";
	public static final java.lang.String SLOT_GIORNI_VALUTA = "giorni_valuta";
	public static final java.lang.String SLOT_IMPORTO_MASSIMO_PRESTITO = "importo_massimo_prestito";
	public static final java.lang.String SLOT_INVERSE_OF_REGOLAMENTO_PRESTITO = "inverse_of_regolamento_prestito";
	public static final java.lang.String SLOT_LIQUIDAZIONE_INTERESSI_CHIUSURA = "liquidazione_interessi_chiusura";
	public static final java.lang.String SLOT_RAPPORTO_PRESTITO_CAPITALE = "rapporto_prestito_capitale";
	public static final java.lang.String SLOT_RITENUTA_FISCALE = "ritenuta_fiscale";
	public static final java.lang.String SLOT_SPESE_RICHIESTA_DOCUMENTAZIONE = "spese_richiesta_documentazione";
	public static final java.lang.String SLOT_SPESE_TENUTA_CONTO = "spese_tenuta_conto";

	protected java.lang.String accredito_interessi;
	protected java.lang.Integer apertura_libretto_dopo_adesione_giorni;
	protected java.lang.Integer comuniqcazione_modifiche_giorni;
	protected java.lang.Float costo_singola_operazione;
	protected java.lang.Integer giorni_valuta;
	protected java.lang.Float importo_massimo_prestito;
	protected Cooperative inverse_of_regolamento_prestito;
	protected java.lang.String liquidazione_interessi_chiusura;
	protected java.lang.Integer rapporto_prestito_capitale;
	protected java.lang.Float ritenuta_fiscale;
	protected java.lang.Float spese_richiesta_documentazione;
	protected java.lang.Float spese_tenuta_conto;
	protected String id;

	public RegolamentoPrestito(){}

	public java.lang.String getAccredito_interessi() {
		return accredito_interessi;
	}

	public void setAccredito_interessi(java.lang.String accredito_interessi) {
		this.accredito_interessi = accredito_interessi;
	}

	public java.lang.Integer getApertura_libretto_dopo_adesione_giorni() {
		return apertura_libretto_dopo_adesione_giorni;
	}

	public void setApertura_libretto_dopo_adesione_giorni(java.lang.Integer apertura_libretto_dopo_adesione_giorni) {
		this.apertura_libretto_dopo_adesione_giorni = apertura_libretto_dopo_adesione_giorni;
	}

	public java.lang.Integer getComuniqcazione_modifiche_giorni() {
		return comuniqcazione_modifiche_giorni;
	}

	public void setComuniqcazione_modifiche_giorni(java.lang.Integer comuniqcazione_modifiche_giorni) {
		this.comuniqcazione_modifiche_giorni = comuniqcazione_modifiche_giorni;
	}

	public java.lang.Float getCosto_singola_operazione() {
		return costo_singola_operazione;
	}

	public void setCosto_singola_operazione(java.lang.Float costo_singola_operazione) {
		this.costo_singola_operazione = costo_singola_operazione;
	}

	public java.lang.Integer getGiorni_valuta() {
		return giorni_valuta;
	}

	public void setGiorni_valuta(java.lang.Integer giorni_valuta) {
		this.giorni_valuta = giorni_valuta;
	}

	public java.lang.Float getImporto_massimo_prestito() {
		return importo_massimo_prestito;
	}

	public void setImporto_massimo_prestito(java.lang.Float importo_massimo_prestito) {
		this.importo_massimo_prestito = importo_massimo_prestito;
	}

	public Cooperative getInverse_of_regolamento_prestito() {
		return inverse_of_regolamento_prestito;
	}

	public void setInverse_of_regolamento_prestito(Cooperative inverse_of_regolamento_prestito) {
		this.inverse_of_regolamento_prestito = inverse_of_regolamento_prestito;
	}

	public java.lang.String getLiquidazione_interessi_chiusura() {
		return liquidazione_interessi_chiusura;
	}

	public void setLiquidazione_interessi_chiusura(java.lang.String liquidazione_interessi_chiusura) {
		this.liquidazione_interessi_chiusura = liquidazione_interessi_chiusura;
	}

	public java.lang.Integer getRapporto_prestito_capitale() {
		return rapporto_prestito_capitale;
	}

	public void setRapporto_prestito_capitale(java.lang.Integer rapporto_prestito_capitale) {
		this.rapporto_prestito_capitale = rapporto_prestito_capitale;
	}

	public java.lang.Float getRitenuta_fiscale() {
		return ritenuta_fiscale;
	}

	public void setRitenuta_fiscale(java.lang.Float ritenuta_fiscale) {
		this.ritenuta_fiscale = ritenuta_fiscale;
	}

	public java.lang.Float getSpese_richiesta_documentazione() {
		return spese_richiesta_documentazione;
	}

	public void setSpese_richiesta_documentazione(java.lang.Float spese_richiesta_documentazione) {
		this.spese_richiesta_documentazione = spese_richiesta_documentazione;
	}

	public java.lang.Float getSpese_tenuta_conto() {
		return spese_tenuta_conto;
	}

	public void setSpese_tenuta_conto(java.lang.Float spese_tenuta_conto) {
		this.spese_tenuta_conto = spese_tenuta_conto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "RegolamentoPrestito \n accredito_interessi: "+accredito_interessi+" apertura_libretto_dopo_adesione_giorni: "+apertura_libretto_dopo_adesione_giorni+" comuniqcazione_modifiche_giorni: "+comuniqcazione_modifiche_giorni+" costo_singola_operazione: "+costo_singola_operazione+" giorni_valuta: "+giorni_valuta+" importo_massimo_prestito: "+importo_massimo_prestito+" liquidazione_interessi_chiusura: "+liquidazione_interessi_chiusura+" rapporto_prestito_capitale: "+rapporto_prestito_capitale+" ritenuta_fiscale: "+ritenuta_fiscale+" spese_richiesta_documentazione: "+spese_richiesta_documentazione+" spese_tenuta_conto: "+spese_tenuta_conto;
	}

}
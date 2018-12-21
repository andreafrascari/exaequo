package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class Movimenti_Libretti implements SerenaMarshallable
{

	public static final java.lang.String CAUSALE_LIBRETTO__VERSAMENTO = "Versamento";
	public static final java.lang.String CAUSALE_LIBRETTO__PRELIEVO = "Prelievo";
	public static final java.lang.String CAUSALE_LIBRETTO__ACCREDITO_INTERESSI = "Accredito interessi";
	public static final java.lang.String CAUSALE_LIBRETTO__ACCREDITO_SALDO = "Accredito saldo";
	public static final java.lang.String CAUSALE_LIBRETTO__PRELIEVO_INTERESSI = "Prelievo interessi";

	public static final java.lang.String MEZZO__ASSEGNO_BANCARIO = "Assegno bancario";
	public static final java.lang.String MEZZO__ASSEGNO_CIRCOLARE = "Assegno circolare";
	public static final java.lang.String MEZZO__CONTANTI = "Contanti";
	public static final java.lang.String MEZZO__BANCOMAT = "Bancomat";
	public static final java.lang.String MEZZO__BONIFICO_BANCARIO = "Bonifico bancario";
	public static final java.lang.String MEZZO__CONTO_CORRENTE_POSTALE = "Conto Corrente postale";
	public static final java.lang.String MEZZO__VAGLIA_POSTALE = "Vaglia postale";
	public static final java.lang.String MEZZO__GIROCONTO = "Giroconto";

	public static final java.lang.String INSTANCE_NAME = "Movimenti_Libretti";
	public static final java.lang.String SLOT_ALLEGATO = "allegato";
	public static final java.lang.String SLOT_BANCA_DI_RIFERIMENTO_MOVIMENTO = "banca_di_riferimento_movimento";
	public static final java.lang.String SLOT_CAUSALE_LIBRETTO = "causale_libretto";
	public static final java.lang.String SLOT_DATA_MOVIMENTO = "data_movimento";
	public static final java.lang.String SLOT_DATA_VALUTA = "data_valuta";
	public static final java.lang.String SLOT_IMPORTO = "importo";
	public static final java.lang.String SLOT_LIBRETTO = "libretto";
	public static final java.lang.String SLOT_MEZZO = "mezzo";
	public static final java.lang.String SLOT_NOTE = "note";
	public static final java.lang.String SLOT_NUMERO_EFFETTO = "numero_effetto";

	protected java.lang.String allegato;
	protected java.lang.String banca_di_riferimento_movimento;
	protected java.lang.String causale_libretto;
	protected java.util.Date data_movimento;
	protected java.util.Date data_valuta;
	protected java.lang.Double importo;
	protected Libretti libretto;
	protected java.lang.String mezzo;
	protected java.lang.String note;
	protected java.lang.String numero_effetto;
	protected String id;

	public Movimenti_Libretti(){}

	public java.lang.String getAllegato() {
		return allegato;
	}

	public void setAllegato(java.lang.String allegato) {
		this.allegato = allegato;
	}

	public java.lang.String getBanca_di_riferimento_movimento() {
		return banca_di_riferimento_movimento;
	}

	public void setBanca_di_riferimento_movimento(java.lang.String banca_di_riferimento_movimento) {
		this.banca_di_riferimento_movimento = banca_di_riferimento_movimento;
	}

	public java.lang.String getCausale_libretto() {
		return causale_libretto;
	}

	public void setCausale_libretto(java.lang.String causale_libretto) {
		this.causale_libretto = causale_libretto;
	}

	public java.util.Date getData_movimento() {
		return data_movimento;
	}

	public void setData_movimento(java.util.Date data_movimento) {
		this.data_movimento = data_movimento;
	}

	public java.util.Date getData_valuta() {
		return data_valuta;
	}

	public void setData_valuta(java.util.Date data_valuta) {
		this.data_valuta = data_valuta;
	}

	public java.lang.Double getImporto() {
		return importo;
	}

	public void setImporto(java.lang.Double importo) {
		this.importo = importo;
	}

	public Libretti getLibretto() {
		return libretto;
	}

	public void setLibretto(Libretti libretto) {
		this.libretto = libretto;
	}

	public java.lang.String getMezzo() {
		return mezzo;
	}

	public void setMezzo(java.lang.String mezzo) {
		this.mezzo = mezzo;
	}

	public java.lang.String getNote() {
		return note;
	}

	public void setNote(java.lang.String note) {
		this.note = note;
	}

	public java.lang.String getNumero_effetto() {
		return numero_effetto;
	}

	public void setNumero_effetto(java.lang.String numero_effetto) {
		this.numero_effetto = numero_effetto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "Movimenti_Libretti \n allegato: "+allegato+" banca_di_riferimento_movimento: "+banca_di_riferimento_movimento+" causale_libretto: "+causale_libretto+" data_movimento: "+data_movimento+" data_valuta: "+data_valuta+" importo: "+importo+" mezzo: "+mezzo+" note: "+note+" numero_effetto: "+numero_effetto;
	}

}
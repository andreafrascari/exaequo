package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class Movimenti_Quote implements SerenaMarshallable
{

	public static final java.lang.String CAUSALE_QUOTA__ACCREDITO_SALDO = "Accredito saldo";
	public static final java.lang.String CAUSALE_QUOTA__ACQUISTO_QUOTE_DA_SOCI = "Acquisto quote da soci";
	public static final java.lang.String CAUSALE_QUOTA__PERDITA_PER_RIDUZIONE_CAPITALE = "Perdita per riduzione capitale";
	public static final java.lang.String CAUSALE_QUOTA__QUOTA_DA_RISPARMIO = "Quota da risparmio";
	public static final java.lang.String CAUSALE_QUOTA__QUOTA_DI_ADESIONE = "Quota di adesione";
	public static final java.lang.String CAUSALE_QUOTA__RIMBORSO_PARZIALE = "Rimborso parziale";
	public static final java.lang.String CAUSALE_QUOTA__RIMBORSO_QUOTE_PER_RECESSO = "Rimborso quote per recesso";
	public static final java.lang.String CAUSALE_QUOTA__SOTTOSCRIZIONE_NUOVE_QUOTE = "Sottoscrizione nuove quote";
	public static final java.lang.String CAUSALE_QUOTA__VENDITA_QUOTE = "Vendita quote";


	public static final java.lang.String INSTANCE_NAME = "Movimenti_Quote";
	public static final java.lang.String SLOT_CAUSALE_QUOTA = "causale_quota";
	public static final java.lang.String SLOT_DATA_MOVIMENTO = "data_movimento";
	public static final java.lang.String SLOT_DI_RISPARMIO = "di_risparmio";
	public static final java.lang.String SLOT_DI_VALORE = "di_valore";
	public static final java.lang.String SLOT_NOTE = "note";
	public static final java.lang.String SLOT_NUMERO_QUOTE = "numero_quote";
	public static final java.lang.String SLOT_NUMERO_QUOTE_RIMBORSATE = "numero_quote_rimborsate";
	public static final java.lang.String SLOT_SOCIO = "socio";

	protected java.lang.String causale_quota;
	protected java.util.Date data_movimento;
	protected Libretti di_risparmio;
	protected java.lang.Integer di_valore;
	protected java.lang.String note;
	protected java.lang.Integer numero_quote;
	protected java.lang.Integer numero_quote_rimborsate;
	protected Soci socio;
	protected String id;

	public Movimenti_Quote(){}

	public java.lang.String getCausale_quota() {
		return causale_quota;
	}

	public void setCausale_quota(java.lang.String causale_quota) {
		this.causale_quota = causale_quota;
	}

	public java.util.Date getData_movimento() {
		return data_movimento;
	}

	public void setData_movimento(java.util.Date data_movimento) {
		this.data_movimento = data_movimento;
	}

	public Libretti getDi_risparmio() {
		return di_risparmio;
	}

	public void setDi_risparmio(Libretti di_risparmio) {
		this.di_risparmio = di_risparmio;
	}

	public java.lang.Integer getDi_valore() {
		return di_valore;
	}

	public void setDi_valore(java.lang.Integer di_valore) {
		this.di_valore = di_valore;
	}

	public java.lang.String getNote() {
		return note;
	}

	public void setNote(java.lang.String note) {
		this.note = note;
	}

	public java.lang.Integer getNumero_quote() {
		return numero_quote;
	}

	public void setNumero_quote(java.lang.Integer numero_quote) {
		this.numero_quote = numero_quote;
	}

	public java.lang.Integer getNumero_quote_rimborsate() {
		return numero_quote_rimborsate;
	}

	public void setNumero_quote_rimborsate(java.lang.Integer numero_quote_rimborsate) {
		this.numero_quote_rimborsate = numero_quote_rimborsate;
	}

	public Soci getSocio() {
		return socio;
	}

	public void setSocio(Soci socio) {
		this.socio = socio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "Movimenti_Quote \n causale_quota: "+causale_quota+" data_movimento: "+data_movimento+" di_valore: "+di_valore+" note: "+note+" numero_quote: "+numero_quote+" numero_quote_rimborsate: "+numero_quote_rimborsate;
	}

}
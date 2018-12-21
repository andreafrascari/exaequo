package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class Soci implements SerenaMarshallable
{


	public static final java.lang.String GENERE__MASCHIO = "Maschio";
	public static final java.lang.String GENERE__FEMMINA = "Femmina";








	public static final java.lang.String INSTANCE_NAME = "Soci";
	public static final java.lang.String SLOT_CARICA = "carica";
	public static final java.lang.String SLOT_CODICE_FISCALE = "codice_fiscale";
	public static final java.lang.String SLOT_COMUNE_NASCITA = "comune_nascita";
	public static final java.lang.String SLOT_DATA_AMMISSIONE = "data_ammissione";
	public static final java.lang.String SLOT_DATA_DELIBERA_DOMANDA_ORGANIZZAZIONE = "data_delibera_domanda_organizzazione";
	public static final java.lang.String SLOT_DATA_DELIBERA_RECESSO = "data_delibera_recesso";
	public static final java.lang.String SLOT_DATA_DOMANDA = "data_domanda";
	public static final java.lang.String SLOT_DATA_DOMANDA_RECESSO = "data_domanda_recesso";
	public static final java.lang.String SLOT_DATA_NASCITA = "data_nascita";
	public static final java.lang.String SLOT_DATI_CONSUMATORE = "dati_consumatore";
	public static final java.lang.String SLOT_DATI_ORGANIZZAZIONE = "dati_organizzazione";
	public static final java.lang.String SLOT_DI_COOPERATIVA = "di_cooperativa";
	public static final java.lang.String SLOT_GENERE = "genere";
	public static final java.lang.String SLOT_MOVIMENTI_QUOTE = "movimenti_quote";
	public static final java.lang.String SLOT_NUMERO_DOMANDA = "numero_domanda";
	public static final java.lang.String SLOT_NUMERO_SOCIO = "numero_socio";
	public static final java.lang.String SLOT_PARTITA_IVA = "partita_iva";
	public static final java.lang.String SLOT_PROFESSIONE = "professione";
	public static final java.lang.String SLOT_PROVINCIA_NASCITA = "provincia_nascita";
	public static final java.lang.String SLOT_REGIONE_NASCITA = "regione_nascita";
	public static final java.lang.String SLOT_RESIDENZA_CAP = "residenza_cap";
	public static final java.lang.String SLOT_RESIDENZA_COMUNE = "residenza_comune";
	public static final java.lang.String SLOT_RESIDENZA_INDIRIZZO = "residenza_indirizzo";
	public static final java.lang.String SLOT_RESIDENZA_NUMERO = "residenza_numero";
	public static final java.lang.String SLOT_RESIDENZA_PROVINCIA = "residenza_provincia";
	public static final java.lang.String SLOT_RESIDENZA_REGIONE = "residenza_regione";
	public static final java.lang.String SLOT_RESIDENZA_TIPO_VIA = "residenza_tipo_via";
	public static final java.lang.String SLOT_RISPARMIO = "risparmio";
	public static final java.lang.String SLOT_STATO_NASCITA = "stato_nascita";
	public static final java.lang.String SLOT_TELEFONO_CASA = "telefono_casa";
	public static final java.lang.String SLOT_TELEFONO_CELLULARE = "telefono_cellulare";
	public static final java.lang.String SLOT_TELEFONO_LAVORO = "telefono_lavoro";

	protected java.lang.String carica;
	protected java.lang.String codice_fiscale;
	protected java.lang.String comune_nascita;
	protected java.util.Date data_ammissione;
	protected java.util.Date data_delibera_domanda_organizzazione;
	protected java.util.Date data_delibera_recesso;
	protected java.util.Date data_domanda;
	protected java.util.Date data_domanda_recesso;
	protected java.util.Date data_nascita;
	protected Consumatori dati_consumatore;
	protected Organizzazioni dati_organizzazione;
	protected Cooperative di_cooperativa;
	protected java.lang.String genere;
	protected java.util.ArrayList<Movimenti_Quote> movimenti_quote;
	protected java.lang.String numero_domanda;
	protected java.lang.String numero_socio;
	protected java.lang.String partita_iva;
	protected java.lang.String professione;
	protected java.lang.String provincia_nascita;
	protected java.lang.String regione_nascita;
	protected java.lang.String residenza_cap;
	protected java.lang.String residenza_comune;
	protected java.lang.String residenza_indirizzo;
	protected java.lang.String residenza_numero;
	protected java.lang.String residenza_provincia;
	protected java.lang.String residenza_regione;
	protected java.lang.String residenza_tipo_via;
	protected java.util.ArrayList<Libretti> risparmio;
	protected java.lang.String stato_nascita;
	protected java.lang.String telefono_casa;
	protected java.lang.String telefono_cellulare;
	protected java.lang.String telefono_lavoro;
	protected String id;

	public Soci(){}

	public java.lang.String getCarica() {
		return carica;
	}

	public void setCarica(java.lang.String carica) {
		this.carica = carica;
	}

	public java.lang.String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(java.lang.String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public java.lang.String getComune_nascita() {
		return comune_nascita;
	}

	public void setComune_nascita(java.lang.String comune_nascita) {
		this.comune_nascita = comune_nascita;
	}

	public java.util.Date getData_ammissione() {
		return data_ammissione;
	}

	public void setData_ammissione(java.util.Date data_ammissione) {
		this.data_ammissione = data_ammissione;
	}

	public java.util.Date getData_delibera_domanda_organizzazione() {
		return data_delibera_domanda_organizzazione;
	}

	public void setData_delibera_domanda_organizzazione(java.util.Date data_delibera_domanda_organizzazione) {
		this.data_delibera_domanda_organizzazione = data_delibera_domanda_organizzazione;
	}

	public java.util.Date getData_delibera_recesso() {
		return data_delibera_recesso;
	}

	public void setData_delibera_recesso(java.util.Date data_delibera_recesso) {
		this.data_delibera_recesso = data_delibera_recesso;
	}

	public java.util.Date getData_domanda() {
		return data_domanda;
	}

	public void setData_domanda(java.util.Date data_domanda) {
		this.data_domanda = data_domanda;
	}

	public java.util.Date getData_domanda_recesso() {
		return data_domanda_recesso;
	}

	public void setData_domanda_recesso(java.util.Date data_domanda_recesso) {
		this.data_domanda_recesso = data_domanda_recesso;
	}

	public java.util.Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(java.util.Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public Consumatori getDati_consumatore() {
		return dati_consumatore;
	}

	public void setDati_consumatore(Consumatori dati_consumatore) {
		this.dati_consumatore = dati_consumatore;
	}

	public Organizzazioni getDati_organizzazione() {
		return dati_organizzazione;
	}

	public void setDati_organizzazione(Organizzazioni dati_organizzazione) {
		this.dati_organizzazione = dati_organizzazione;
	}

	public Cooperative getDi_cooperativa() {
		return di_cooperativa;
	}

	public void setDi_cooperativa(Cooperative di_cooperativa) {
		this.di_cooperativa = di_cooperativa;
	}

	public java.lang.String getGenere() {
		return genere;
	}

	public void setGenere(java.lang.String genere) {
		this.genere = genere;
	}

	public java.util.ArrayList<Movimenti_Quote> getMovimenti_quote() {
		return movimenti_quote;
	}

	public void setMovimenti_quote(java.util.ArrayList<Movimenti_Quote> movimenti_quote) {
		this.movimenti_quote = movimenti_quote;
	}

	public java.lang.String getNumero_domanda() {
		return numero_domanda;
	}

	public void setNumero_domanda(java.lang.String numero_domanda) {
		this.numero_domanda = numero_domanda;
	}

	public java.lang.String getNumero_socio() {
		return numero_socio;
	}

	public void setNumero_socio(java.lang.String numero_socio) {
		this.numero_socio = numero_socio;
	}

	public java.lang.String getPartita_iva() {
		return partita_iva;
	}

	public void setPartita_iva(java.lang.String partita_iva) {
		this.partita_iva = partita_iva;
	}

	public java.lang.String getProfessione() {
		return professione;
	}

	public void setProfessione(java.lang.String professione) {
		this.professione = professione;
	}

	public java.lang.String getProvincia_nascita() {
		return provincia_nascita;
	}

	public void setProvincia_nascita(java.lang.String provincia_nascita) {
		this.provincia_nascita = provincia_nascita;
	}

	public java.lang.String getRegione_nascita() {
		return regione_nascita;
	}

	public void setRegione_nascita(java.lang.String regione_nascita) {
		this.regione_nascita = regione_nascita;
	}

	public java.lang.String getResidenza_cap() {
		return residenza_cap;
	}

	public void setResidenza_cap(java.lang.String residenza_cap) {
		this.residenza_cap = residenza_cap;
	}

	public java.lang.String getResidenza_comune() {
		return residenza_comune;
	}

	public void setResidenza_comune(java.lang.String residenza_comune) {
		this.residenza_comune = residenza_comune;
	}

	public java.lang.String getResidenza_indirizzo() {
		return residenza_indirizzo;
	}

	public void setResidenza_indirizzo(java.lang.String residenza_indirizzo) {
		this.residenza_indirizzo = residenza_indirizzo;
	}

	public java.lang.String getResidenza_numero() {
		return residenza_numero;
	}

	public void setResidenza_numero(java.lang.String residenza_numero) {
		this.residenza_numero = residenza_numero;
	}

	public java.lang.String getResidenza_provincia() {
		return residenza_provincia;
	}

	public void setResidenza_provincia(java.lang.String residenza_provincia) {
		this.residenza_provincia = residenza_provincia;
	}

	public java.lang.String getResidenza_regione() {
		return residenza_regione;
	}

	public void setResidenza_regione(java.lang.String residenza_regione) {
		this.residenza_regione = residenza_regione;
	}

	public java.lang.String getResidenza_tipo_via() {
		return residenza_tipo_via;
	}

	public void setResidenza_tipo_via(java.lang.String residenza_tipo_via) {
		this.residenza_tipo_via = residenza_tipo_via;
	}

	public java.util.ArrayList<Libretti> getRisparmio() {
		return risparmio;
	}

	public void setRisparmio(java.util.ArrayList<Libretti> risparmio) {
		this.risparmio = risparmio;
	}

	public java.lang.String getStato_nascita() {
		return stato_nascita;
	}

	public void setStato_nascita(java.lang.String stato_nascita) {
		this.stato_nascita = stato_nascita;
	}

	public java.lang.String getTelefono_casa() {
		return telefono_casa;
	}

	public void setTelefono_casa(java.lang.String telefono_casa) {
		this.telefono_casa = telefono_casa;
	}

	public java.lang.String getTelefono_cellulare() {
		return telefono_cellulare;
	}

	public void setTelefono_cellulare(java.lang.String telefono_cellulare) {
		this.telefono_cellulare = telefono_cellulare;
	}

	public java.lang.String getTelefono_lavoro() {
		return telefono_lavoro;
	}

	public void setTelefono_lavoro(java.lang.String telefono_lavoro) {
		this.telefono_lavoro = telefono_lavoro;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "Soci \n carica: "+carica+" codice_fiscale: "+codice_fiscale+" comune_nascita: "+comune_nascita+" data_ammissione: "+data_ammissione+" data_delibera_domanda_organizzazione: "+data_delibera_domanda_organizzazione+" data_delibera_recesso: "+data_delibera_recesso+" data_domanda: "+data_domanda+" data_domanda_recesso: "+data_domanda_recesso+" data_nascita: "+data_nascita+" genere: "+genere+" numero_domanda: "+numero_domanda+" numero_socio: "+numero_socio+" partita_iva: "+partita_iva+" professione: "+professione+" provincia_nascita: "+provincia_nascita+" regione_nascita: "+regione_nascita+" residenza_cap: "+residenza_cap+" residenza_comune: "+residenza_comune+" residenza_indirizzo: "+residenza_indirizzo+" residenza_numero: "+residenza_numero+" residenza_provincia: "+residenza_provincia+" residenza_regione: "+residenza_regione+" residenza_tipo_via: "+residenza_tipo_via+" stato_nascita: "+stato_nascita+" telefono_casa: "+telefono_casa+" telefono_cellulare: "+telefono_cellulare+" telefono_lavoro: "+telefono_lavoro;
	}

}
package eu.anastasis.serena.inziativesolidali;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import eu.anastasis.serena.application.index.util.ApplicationLibrary;
import eu.anastasis.serena.application.modules.BirtReport.*;
import eu.anastasis.serena.application.modules.BirtReport.engine.*;
import eu.anastasis.serena.application.modules.object.ObjectUtils;
import eu.anastasis.serena.application.core.modules.DefaultModule;
import eu.anastasis.serena.beans.Cooperative;
import eu.anastasis.serena.beans.Libretti;
import eu.anastasis.serena.beans.Movimenti_Libretti;
import eu.anastasis.serena.beans.RegolamentoPrestito;
import eu.anastasis.serena.beans.Soci;
import eu.anastasis.serena.beans.exaequo.MyLibretti;
import eu.anastasis.serena.beans.exaequo.MySoci;
import eu.anastasis.serena.common.SerenaDate;
import eu.anastasis.serena.constants.ConstantsXSerena;
import eu.anastasis.serena.exception.SerenaException;

public class BalanceReportMethod extends GiveMethod {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(BalanceReportMethod.class);

	public static final String METHOD_NAME = "balance_give";

	protected static final String VIRTUAL_VAR_SALDO_CAPITALE_ADESIONE = "saldo_capitale_adesione";
	protected static final String VIRTUAL_VAR_SALDO_CAPITALE_NON_RISPARMIO = "saldo_capitale_non_risparmio";

	protected static final String VIRTUAL_VAR_SALDO_LIBRETTO_CAPITALE = "saldo_libretto_capitale";
	protected static final String VIRTUAL_VAR_SALDO_LIBRETTO_RISPARMIO = "saldo_libretto_risparmio";
	protected static final String VIRTUAL_VAR_SALDO_LIBRETTO_RISPARMIO_ANNO_PRECEDENTE = "saldo_libretto_risparmio_anno_precedente";
	protected static final String VIRTUAL_VAR_LIBRETTO_INTERESSI_LORDI = "libretto_interessi_lordi";
	protected static final String VIRTUAL_VAR_LIBRETTO_RITENUTA_INTERESSI = "libretto_ritenuta_interessi";
	protected static final String VIRTUAL_VAR_INTERESSI_NETTI = "libretto_interessi_netti";
	protected static final String VIRTUAL_VAR_INTERESSI_PERCENTUALE = "libretto_interessi_percentuale";
	protected static final String VIRTUAL_VAR_RITENUTA_PERCENTUALE = "libretto_ritenuta_percentuale";
	protected static final String VIRTUAL_VAR_DATA_0 = "data_0"; // fine anno
																// precedente
	protected static final String VIRTUAL_VAR_DATA_1 = "data_1"; // fine anno
	protected static final String VIRTUAL_VAR_DATA_2 = "data_2"; // inziio nuovo
																// anno

	public BalanceReportMethod(DefaultModule parentModule,
			String[] defaultParameters) {
		super(parentModule, defaultParameters);
	}
	
	public BalanceReportMethod() {
		super(null, null);
	}

	@Override
	protected Document retrieveData(HttpServletRequest request,
			ReportEngine engine, File designFile) throws SerenaException {
		
		try	{
	
			// prelevo l'xml ritornato dalla query
			Document ret = super.retrieveData(request, engine, designFile);
			
			postProcess(request,ret);
			return ret;
		} catch(Exception e){
			String error = "Errore in generazione report estrattoconto";
			logger.error(error);
			throw new SerenaException(error);
		}
	}

		
	public void postProcess(HttpServletRequest request, Document ret)	throws SerenaException {	
		Element socio = (Element) ret.selectSingleNode(".//"
				+ Soci.INSTANCE_NAME);

		String idSocio = socio.elementText("ID");

		// calcolo saldo quote capitale

		MySoci s = new MySoci();
		Double saldoAdesione = s.saldoCapitaleAdesione(request, idSocio);
		Double saldoQuotePure = s.saldoCapitaleEsclusoRisparmioEsclusaAdesione(
				request, idSocio);

		Element extra = socio.addElement(VIRTUAL_VAR_SALDO_CAPITALE_ADESIONE);
		extra.setText(saldoAdesione.toString());

		extra = socio.addElement(VIRTUAL_VAR_SALDO_CAPITALE_NON_RISPARMIO);
		extra.setText(saldoQuotePure.toString());

		String id_cooperativa = socio.element(Soci.SLOT_DI_COOPERATIVA)
				.element(Cooperative.INSTANCE_NAME).elementText("ID");

		// fetch regolamento prestito
		RegolamentoPrestito rp = AccreditoInteressi_Method
				.loadRegolamentoPrestito(request, id_cooperativa);

		// controllo esistenza accrediti data corrente
		SerenaDate dataAccredito = AccreditoInteressi_Method
				.computeDataAccredito(rp,null);

		List<Element> libretti = socio.element(Soci.SLOT_RISPARMIO).elements();

		for (Element lib : libretti) {
			String idLibretto = lib.elementText("ID");

			SerenaDate tmpDate = (SerenaDate) dataAccredito.clone();

			extra = lib.addElement(VIRTUAL_VAR_DATA_2);
			extra.setText(dataAccredito.toString());

			extra = lib.addElement(VIRTUAL_VAR_DATA_1);
			tmpDate.subtractDays(1);
			extra.setText(tmpDate.toString());

			extra = lib.addElement(VIRTUAL_VAR_DATA_0);
			tmpDate.subtractYears(1);
			extra.setText(tmpDate.toString());

			MyLibretti myl = new MyLibretti();

			Double saldo_libretto_capitale = myl.saldoQuoteRisparmio(request,
					idLibretto);
			Double saldo_libretto_risparmio = myl.saldoRisparmio(request,
					idLibretto);
			extra = lib.addElement(VIRTUAL_VAR_SALDO_LIBRETTO_CAPITALE);
			extra.setText(saldo_libretto_capitale.toString());
			extra = lib.addElement(VIRTUAL_VAR_SALDO_LIBRETTO_RISPARMIO);
			extra.setText(saldo_libretto_risparmio.toString());
			extra = lib.addElement(VIRTUAL_VAR_RITENUTA_PERCENTUALE);
			extra.setText(rp.getRitenuta_fiscale().toString());
			extra = lib.addElement(VIRTUAL_VAR_INTERESSI_PERCENTUALE);
			try {
				extra.setText(myl.tassoInteresseAttuale(request, idLibretto));
			} catch (Exception e) {
				logger.warn("Libretto ID " + idLibretto + " senza tasso interesse!");
				extra = lib.addElement(VIRTUAL_VAR_LIBRETTO_INTERESSI_LORDI);
				extra.setText("0");
				extra = lib.addElement(VIRTUAL_VAR_INTERESSI_NETTI);
				extra.setText("0");
				extra = lib.addElement(VIRTUAL_VAR_LIBRETTO_RITENUTA_INTERESSI);
				extra.setText("0");
				continue;
			}

			// movimenti dalla data 0

			Element movimenti = myl.getMovimentiAnno(request, idLibretto,
					tmpDate);

			if (movimenti == null) {
				logger.warn("Libretto ID " + idLibretto + " senza accredito! ");
				extra = lib.addElement(VIRTUAL_VAR_LIBRETTO_INTERESSI_LORDI);
				extra.setText("0");
				extra = lib.addElement(VIRTUAL_VAR_INTERESSI_NETTI);
				extra.setText("0");
				extra = lib.addElement(VIRTUAL_VAR_LIBRETTO_RITENUTA_INTERESSI);
				extra.setText("0");
				continue;
			}
			Element movElem = lib.element(Libretti.SLOT_MOVIMENTI);
			// cancello i movimenti originali (probabilmente tutti quelli da
			// inizio gestione)
			movElem.getParent().remove(movElem);
			movElem = lib.addElement(Libretti.SLOT_MOVIMENTI);
			double totMovimenti = 0;
			List<Element> movs = movimenti.selectNodes(".//"
					+ Movimenti_Libretti.INSTANCE_NAME);
			for (Element mov : movs) {
				String data = mov
						.elementText(Movimenti_Libretti.SLOT_DATA_MOVIMENTO);
				String causale = mov
						.elementText(Movimenti_Libretti.SLOT_CAUSALE_LIBRETTO);
				String accreditoNetto = mov
						.elementText(Movimenti_Libretti.SLOT_IMPORTO);
				totMovimenti += Double.valueOf(accreditoNetto);
				if (new SerenaDate(data).equals(dataAccredito)
						&& Movimenti_Libretti.CAUSALE_LIBRETTO__ACCREDITO_INTERESSI
								.equals(causale)) {
					// movimento di accredito
					extra = lib.addElement(VIRTUAL_VAR_INTERESSI_NETTI);
					extra.setText(accreditoNetto);
					String accreditoLordo = this.getAccreditoLordo(
							accreditoNetto, rp);
					extra = lib
							.addElement(VIRTUAL_VAR_LIBRETTO_INTERESSI_LORDI);
					extra.setText(accreditoLordo);
					String ritenutaFiscale = this.getRitenutaFiscale(
							accreditoNetto, accreditoLordo);
					extra = lib
							.addElement(VIRTUAL_VAR_LIBRETTO_RITENUTA_INTERESSI);
					extra.setText(ritenutaFiscale);
				} else {
					movElem.add((Element) mov.clone());
				}
			}
			extra = lib
					.addElement(VIRTUAL_VAR_SALDO_LIBRETTO_RISPARMIO_ANNO_PRECEDENTE);
			extra.setText(Double.valueOf(
					saldo_libretto_risparmio.doubleValue() - totMovimenti)
					.toString());
		}

	}

	private String getRitenutaFiscale(String accreditoNetto,
			String accreditoLordo) {
		double lordo = Double.valueOf(accreditoLordo).doubleValue();
		double netto = Double.valueOf(accreditoNetto).doubleValue();
		return Double.valueOf(lordo - netto).toString();
	}

	private String getAccreditoLordo(String accreditoNetto,
			RegolamentoPrestito rp) {
		double ritenuta = rp.getRitenuta_fiscale().floatValue();
		double lordo = (Double.valueOf(accreditoNetto).doubleValue() * 100)
				/ (100 - ritenuta);
		return Double.valueOf(lordo).toString();
	}


	@Override
	protected String getName() {
		return METHOD_NAME;
	}
}

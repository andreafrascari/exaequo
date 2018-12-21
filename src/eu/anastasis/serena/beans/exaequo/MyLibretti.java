package eu.anastasis.serena.beans.exaequo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import eu.anastasis.serena.application.index.util.ApplicationLibrary;
import eu.anastasis.serena.application.modules.object.ObjectUtils;
import eu.anastasis.serena.beans.CondizioniLibretto;
import eu.anastasis.serena.beans.ExaequoBinder;
import eu.anastasis.serena.beans.Libretti;
import eu.anastasis.serena.beans.Movimenti_Libretti;
import eu.anastasis.serena.beans.Movimenti_Quote;
import eu.anastasis.serena.beans.TassoInteresseLibretto;
import eu.anastasis.serena.common.SerenaDate;
import eu.anastasis.serena.constants.ConstantsXSerena;
import eu.anastasis.serena.exception.SerenaException;

public class MyLibretti {

	private static final Logger logger = Logger.getLogger(MyLibretti.class);

	private Libretti my_instance = null;

	public MyLibretti() {
		// TODO Auto-generated constructor stub
	}

	public MyLibretti(Libretti l) {
		super();
		setMy_instance(l);
	}

	public Libretti getMy_instance() {
		return my_instance;
	}

	public void setMy_instance(Libretti my_instance) {
		this.my_instance = my_instance;
	}

	/**
	 * Calcola il saldo delle quote di capitale sociale ASSOCIATE a movimenti di
	 * risparmio del libretto passato
	 * 
	 * @param request
	 * @param idSocio
	 * @return
	 * @throws SerenaException
	 */
	public Double saldoQuoteRisparmio(HttpServletRequest request,
			String idLibretto) throws SerenaException {
		// TODO Auto-generated method stub
		Double saldo = null;
		try {
			logger.info("Saldo quote riparmio libretto " + idLibretto);
			Element currentElement = ObjectUtils
					.getXserenaRequestStandardHeader(request.getSession()
							.getId(), ConstantsXSerena.ACTION_GET,
							Movimenti_Quote.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION,
					ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET,
					ConstantsXSerena.TARGET_ALL);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS,
					"0");
			currentElement.addAttribute(
					ConstantsXSerena.ATTR_FORCED_DATASOURCE, "saldi-risparmio");

			Element condition = currentElement
					.addElement(ConstantsXSerena.TAG_CONDITION);
			condition = condition.addElement(Movimenti_Quote.SLOT_DI_RISPARMIO);
			condition = condition.addElement(Libretti.INSTANCE_NAME);
			condition = condition.addElement("ID");
			condition.setText(idLibretto);

			String[] messages = { "", "" };
			Document resultData = ApplicationLibrary.getData(
					currentElement.getDocument(), request);
			Element data = ApplicationLibrary
					.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages,
					Movimenti_Quote.INSTANCE_NAME);

			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("Cannot compute Saldo capitale socio "
						+ messages[0]);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				logger.info("Saldo Quote is 0");
				return new Double(0);
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				Element virtualquota = (Element) data
						.selectSingleNode(Movimenti_Quote.INSTANCE_NAME);
				if (virtualquota != null
						&& !virtualquota.elementText(
								Movimenti_Quote.SLOT_DI_VALORE).isEmpty()) {
					saldo = new Double(
							virtualquota
									.elementText(Movimenti_Quote.SLOT_DI_VALORE));
				} else {
					saldo = new Double(0);
				}
			}
			return saldo;
		} catch (Exception any) {
			String msg = "Cannot compute Saldo capitale socio: "
					+ any.getMessage();
			logger.error(msg, any);
			throw new SerenaException(msg, any);
		}
	}

	public Double saldoRisparmio(HttpServletRequest request, String idLibretto)
			throws SerenaException {
		// TODO Auto-generated method stub
		Double saldo = null;
		try {
			logger.info("Saldo libretto " + idLibretto);
			Element currentElement = ObjectUtils
					.getXserenaRequestStandardHeader(request.getSession()
							.getId(), ConstantsXSerena.ACTION_GET,
							Movimenti_Libretti.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION,
					ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET,
					ConstantsXSerena.TARGET_ALL);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS,
					"0");
			currentElement.addAttribute(
					ConstantsXSerena.ATTR_FORCED_DATASOURCE, "saldi");

			Element condition = currentElement
					.addElement(ConstantsXSerena.TAG_CONDITION);
			condition = condition.addElement(Movimenti_Libretti.SLOT_LIBRETTO);
			condition = condition.addElement(Libretti.INSTANCE_NAME);
			condition = condition.addElement("ID");
			condition.setText(idLibretto);

			String[] messages = { "", "" };
			Document resultData = ApplicationLibrary.getData(
					currentElement.getDocument(), request);
			Element data = ApplicationLibrary
					.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages,
					Movimenti_Libretti.INSTANCE_NAME);

			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("Cannot compute Saldo Libretto " + messages[0]);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				logger.info("Saldo Libretto is 0");
				return new Double(0);
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				Element virtualquota = (Element) data
						.selectSingleNode(Movimenti_Libretti.INSTANCE_NAME);
				if (virtualquota != null
						&& !virtualquota.elementText(
								Movimenti_Libretti.SLOT_IMPORTO).isEmpty()) {
					saldo = new Double(
							virtualquota
									.elementText(Movimenti_Libretti.SLOT_IMPORTO));
				} else {
					saldo = new Double(0);
				}
			}
			return saldo;
		} catch (Exception any) {
			String msg = "Cannot compute Saldo Libretto: " + any.getMessage();
			logger.error(msg, any);
			throw new SerenaException(msg, any);
		}
	}

	public List<Movimenti_Libretti> getMovimentiDalAl(
			HttpServletRequest request, String idLibretto, SerenaDate dal,
			SerenaDate al) throws SerenaException {

		List<Movimenti_Libretti> movPeriodo = new ArrayList<Movimenti_Libretti>();
		try {
			logger.info("getMovimentiDalAl " + idLibretto + " dal " +dal.toString() + " al " +al.toString() );
			Element currentElement = ObjectUtils
					.getXserenaRequestStandardHeader(request.getSession()
							.getId(), ConstantsXSerena.ACTION_GET,
							Movimenti_Libretti.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION,
					ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET,
					ConstantsXSerena.TARGET_ALL);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS,
					"0");

			Element condition = currentElement
					.addElement(ConstantsXSerena.TAG_CONDITION);

			Element lib = condition
					.addElement(Movimenti_Libretti.SLOT_LIBRETTO);
			lib = lib.addElement(Libretti.INSTANCE_NAME);
			lib = lib.addElement("ID");
			lib.setText(idLibretto);

			Element da = condition
					.addElement(Movimenti_Libretti.SLOT_DATA_MOVIMENTO);
			da.addAttribute(ConstantsXSerena.ATTR_OPERATOR,
					ConstantsXSerena.VAL_GREATER_EQUAL_THAN);
			da.setText(dal.toString());

			Element a = condition
					.addElement(Movimenti_Libretti.SLOT_DATA_MOVIMENTO);
			a.addAttribute(ConstantsXSerena.ATTR_OPERATOR,
					ConstantsXSerena.VAL_LESS_THAN);
			a.setText(al.toString());

			String[] messages = { "", "" };
			Document resultData = ApplicationLibrary.getData(
					currentElement.getDocument(), request);
			Element data = ApplicationLibrary
					.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages,
					Movimenti_Libretti.INSTANCE_NAME);

			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("Cannot compute Saldo Libretto " + messages[0]);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				;
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				List<Element> movs = data
						.selectNodes(Movimenti_Libretti.INSTANCE_NAME);
				ExaequoBinder binder = new ExaequoBinder();
				if (movs != null && !movs.isEmpty()) {
					for (Element m : movs) {
						movPeriodo.add(binder.createMovimenti_Libretti(m));
					}
				}
			}
			return movPeriodo;
		} catch (Exception any) {
			String msg = "Cannot compute getMovimentiDalAl: "
					+ any.getMessage();
			logger.error(msg, any);
			throw new SerenaException(msg, any);
		}

	}

	/**
	 * Attenzione: se trova il prelievo corrispondente, torna 0, perchè lo
	 * considera già stornato!!!
	 * 
	 * @param request
	 * @param idLibretto
	 * @return
	 * @throws SerenaException
	 */
	public Movimenti_Libretti getUltimoAccredito(HttpServletRequest request,
			String idLibretto) throws SerenaException {
		Movimenti_Libretti ultimoAccredito = null;
		try {
			logger.info("getUltimoAccredito " + idLibretto);
			Element currentElement = ObjectUtils
					.getXserenaRequestStandardHeader(request.getSession()
							.getId(), ConstantsXSerena.ACTION_GET,
							Movimenti_Libretti.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION,
					ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET,
					ConstantsXSerena.TARGET_ALL);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS,
					"0");
			currentElement.addAttribute(ConstantsXSerena.ATTR_ORDER_BY,
					Movimenti_Libretti.SLOT_DATA_MOVIMENTO + " desc");

			Element condition = currentElement
					.addElement(ConstantsXSerena.TAG_CONDITION);

			Element lib = condition
					.addElement(Movimenti_Libretti.SLOT_LIBRETTO);
			lib = lib.addElement(Libretti.INSTANCE_NAME);
			lib = lib.addElement("ID");
			lib.setText(idLibretto);

			Element da = condition
					.addElement(Movimenti_Libretti.SLOT_CAUSALE_LIBRETTO);
			da.setText(Movimenti_Libretti.CAUSALE_LIBRETTO__ACCREDITO_INTERESSI);

			String[] messages = { "", "" };
			Document resultData = ApplicationLibrary.getData(
					currentElement.getDocument(), request);
			Element data = ApplicationLibrary
					.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages,
					Movimenti_Libretti.INSTANCE_NAME);

			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("Cannot load movimenti accredito " + messages[0]);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				;
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				List<Element> movs = data
						.selectNodes(Movimenti_Libretti.INSTANCE_NAME);
				ExaequoBinder binder = new ExaequoBinder();
				if (movs != null && !movs.isEmpty()) {
					ultimoAccredito = binder.createMovimenti_Libretti(movs
							.get(0));
					boolean pagato = accreditoPrelevato(request,
							ultimoAccredito, idLibretto);
					if (pagato) {
						ultimoAccredito.setImporto(new Double(0));
					}
				}
			}
			return ultimoAccredito;
		} catch (Exception any) {
			String msg = "Cannot compute getMovimentiDalAl: "
					+ any.getMessage();
			logger.error(msg, any);
			throw new SerenaException(msg, any);
		}

	}

	private boolean accreditoPrelevato(HttpServletRequest request,
			Movimenti_Libretti accredito, String idLibretto)
			throws SerenaException {
		try {
			logger.info("getUltimoAccredito " + idLibretto);
			Element currentElement = ObjectUtils
					.getXserenaRequestStandardHeader(request.getSession()
							.getId(), ConstantsXSerena.ACTION_GET,
							Movimenti_Libretti.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION,
					ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET,
					ConstantsXSerena.TARGET_ALL);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS,
					"0");
			currentElement.addAttribute(ConstantsXSerena.ATTR_ORDER_BY,
					Movimenti_Libretti.SLOT_DATA_MOVIMENTO + " desc");

			Element condition = currentElement
					.addElement(ConstantsXSerena.TAG_CONDITION);

			Element lib = condition
					.addElement(Movimenti_Libretti.SLOT_LIBRETTO);
			lib = lib.addElement(Libretti.INSTANCE_NAME);
			lib = lib.addElement("ID");
			lib.setText(idLibretto);

			Element da = condition
					.addElement(Movimenti_Libretti.SLOT_CAUSALE_LIBRETTO);
			da.setText(Movimenti_Libretti.CAUSALE_LIBRETTO__PRELIEVO);

			String[] messages = { "", "" };
			Document resultData = ApplicationLibrary.getData(
					currentElement.getDocument(), request);
			Element data = ApplicationLibrary
					.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages,
					Movimenti_Libretti.INSTANCE_NAME);

			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("Cannot load movimenti accredito " + messages[0]);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				return false;
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				List<Element> movs = data
						.selectNodes(Movimenti_Libretti.INSTANCE_NAME);
				ExaequoBinder binder = new ExaequoBinder();
				if (movs != null && !movs.isEmpty()) {
					Movimenti_Libretti prelievo = binder
							.createMovimenti_Libretti(movs.get(0));
					if (prelievo.getImporto() == -accredito.getImporto()) {
						logger.debug("Trovato prelievo di "
								+ prelievo.getImporto().toString()
								+ " quindi l'accredito interessi mi sembra gia prelevato!");
						return true;
					}
				}
			}
			return false;
		} catch (Exception any) {
			String msg = "Cannot compute getMovimentiDalAl: "
					+ any.getMessage();
			logger.error(msg, any);
			throw new SerenaException(msg, any);
		}

	}

	public Double saldoRisparmioAl(HttpServletRequest request,
			String idLibretto, SerenaDate al) throws SerenaException {
		// TODO Auto-generated method stub
		Double saldo = null;
		try {
			logger.info("Saldo libretto " + idLibretto + " al " + al.toString());
			Element currentElement = ObjectUtils
					.getXserenaRequestStandardHeader(request.getSession()
							.getId(), ConstantsXSerena.ACTION_GET,
							Movimenti_Libretti.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION,
					ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET,
					ConstantsXSerena.TARGET_ALL);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS,
					"0");

			Element condition = currentElement
					.addElement(ConstantsXSerena.TAG_CONDITION);

			Element lib = condition
					.addElement(Movimenti_Libretti.SLOT_LIBRETTO);
			lib = lib.addElement(Libretti.INSTANCE_NAME);
			lib = lib.addElement("ID");
			lib.setText(idLibretto);

			Element alEl = condition
					.addElement(Movimenti_Libretti.SLOT_DATA_MOVIMENTO);
			alEl.addAttribute(ConstantsXSerena.ATTR_OPERATOR,
					ConstantsXSerena.VAL_LESS_THAN);
			alEl.setText(al.toString());

			String[] messages = { "", "" };
			Document resultData = ApplicationLibrary.getData(
					currentElement.getDocument(), request);
			Element data = ApplicationLibrary
					.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages,
					Movimenti_Libretti.INSTANCE_NAME);

			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("Cannot compute Saldo Libretto " + messages[0]);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				logger.info("Saldo Libretto is 0");
				return new Double(0);
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				List<Element> movs = data
						.selectNodes(Movimenti_Libretti.INSTANCE_NAME);

				if (movs != null && !movs.isEmpty()) {
					double saldoTmp = 0;
					for (Element m : movs) {
						saldoTmp += new Double(
								m.elementText(Movimenti_Libretti.SLOT_IMPORTO))
								.doubleValue();
					}
					return new Double(saldoTmp);
				} else {
					saldo = new Double(0);
				}
			}
			return saldo;
		} catch (Exception any) {
			String msg = "Cannot compute Saldo Libretto: " + any.getMessage();
			logger.error(msg, any);
			throw new SerenaException(msg, any);
		}
	}

	public String tassoInteresseAttuale(HttpServletRequest request,
			String idLibretto) throws SerenaException {
		try {
			logger.info("Tasso libretto " + idLibretto);
			Element currentElement = ObjectUtils
					.getXserenaRequestStandardHeader(request.getSession()
							.getId(), ConstantsXSerena.ACTION_GET,
							TassoInteresseLibretto.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION,
					ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET,
					ConstantsXSerena.TARGET_ALL);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS,
					"0");
			currentElement
					.addAttribute(ConstantsXSerena.ATTR_ORDER_BY,
							TassoInteresseLibretto.SLOT_DATA_INIZIO_VALIDITA
									+ " DESC ");

			Element condition = currentElement
					.addElement(ConstantsXSerena.TAG_CONDITION);
			condition = condition
					.addElement(TassoInteresseLibretto.SLOT_INVERSE_OF_TASSI_DI_INTERESSE);
			condition = condition.addElement(CondizioniLibretto.INSTANCE_NAME);
			condition = condition
					.addElement(CondizioniLibretto.SLOT_INVERSE_OF_TIPO_LIBRETTO);
			condition = condition.addElement(Libretti.INSTANCE_NAME);
			condition = condition.addElement("ID");
			condition.setText(idLibretto);

			String[] messages = { "", "" };
			Document resultData = ApplicationLibrary.getData(
					currentElement.getDocument(), request);
			Element data = ApplicationLibrary
					.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages,
					TassoInteresseLibretto.INSTANCE_NAME);

			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("Cannot compute Saldo Libretto " + messages[0]);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				logger.error("Nessun Tasso Interesso Libretto " + idLibretto);
				return null;
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				List<Element> tassi = data
						.selectNodes(TassoInteresseLibretto.INSTANCE_NAME);
				// primo elemento perche ordinamento desc sulla data
				return tassi.get(0).elementText(
						TassoInteresseLibretto.SLOT_TASSO_INTERESSE);
			}
			return null;
		} catch (Exception any) {
			String msg = "Cannot determine tasso libretto: " + any.getMessage();
			logger.error(msg, any);
			throw new SerenaException(msg, any);
		}
	}

	public Element getMovimentiAnno(HttpServletRequest request,
			SerenaDate dataAccredito) throws SerenaException {
		String idLibretto = this.my_instance.getId();
		return getMovimentiAnno(request, idLibretto, dataAccredito);
	}

	public Element getMovimentiAnno(HttpServletRequest request,
			String idLibretto, SerenaDate dataAccredito) throws SerenaException {
		try {
			logger.info("cerco movimenti dal " + dataAccredito.toString()
					+ " per libretto " + idLibretto);
			Element currentElement = ObjectUtils
					.getXserenaRequestStandardHeader(request.getSession()
							.getId(), ConstantsXSerena.ACTION_GET,
							Movimenti_Libretti.INSTANCE_NAME);
			currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION,
					ConstantsXSerena.VAL_SELECT);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET,
					ConstantsXSerena.TARGET_ALL);
			currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS,
					"0");
			Element condition = currentElement
					.addElement(ConstantsXSerena.TAG_CONDITION);
			Element item = condition
					.addElement(Movimenti_Libretti.SLOT_DATA_MOVIMENTO);
			item.setText(dataAccredito.toString());
			item.addAttribute(ConstantsXSerena.ATTR_OPERATOR,
					ConstantsXSerena.VAL_GREATER_THAN);
			/*
			 * item = condition
			 * .addElement(Movimenti_Libretti.SLOT_CAUSALE_LIBRETTO);
			 * item.setText
			 * (Movimenti_Libretti.CAUSALE_LIBRETTO__ACCREDITO_INTERESSI);
			 */
			item = condition.addElement(Movimenti_Libretti.SLOT_LIBRETTO);
			item = item.addElement(Libretti.INSTANCE_NAME);
			item = item.addElement("ID");
			item.setText(idLibretto);

			String[] messages = { "", "" };
			Document resultData = ApplicationLibrary.getData(
					currentElement.getDocument(), request);
			Element data = ApplicationLibrary
					.prepareDataForPresentation(resultData);
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages,
					Movimenti_Libretti.INSTANCE_NAME);

			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("Errore in ricerca movimenti " + messages[0]);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				return null;
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				return data;
			} else {
				return null;
			}
		} catch (Exception any) {
			String msg = "Errore in ricerca movimenti " + any.getMessage();
			logger.error(msg, any);
			throw new SerenaException(msg, any);
		}
	}

}

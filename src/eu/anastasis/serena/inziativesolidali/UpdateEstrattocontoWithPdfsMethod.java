package eu.anastasis.serena.inziativesolidali;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.anastasis.serena.application.core.modules.DefaultMethod;
import eu.anastasis.serena.application.core.modules.DefaultModule;
import eu.anastasis.serena.application.index.util.ApplicationLibrary;
import eu.anastasis.serena.application.index.util.AttachmentBean;
import eu.anastasis.serena.application.modules.BirtReport.engine.PdfStrategy;
import eu.anastasis.serena.application.modules.BirtReport.engine.ReportEngine;
import eu.anastasis.serena.application.modules.BirtReport.engine.ReportException;
import eu.anastasis.serena.application.modules.object.ObjectUtils;
import eu.anastasis.serena.beans.Estrattoconto;
import eu.anastasis.serena.beans.ExaequoBeanDataManager;
import eu.anastasis.serena.beans.Libretti;
import eu.anastasis.serena.beans.Soci;
import eu.anastasis.serena.constants.ConstantsBaseLibrary;
import eu.anastasis.serena.constants.ConstantsXSerena;
import eu.anastasis.serena.exception.SerenaException;
import eu.anastasis.serena.presentation.templates.ActiveTemplate;
import eu.anastasis.serena.presentation.templates.TemplateFactory;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 * Da un birt report + dati descrittivi crea e registra un'istanza di Documento
 * 
 * @author afrascari
 * 
 */
public class UpdateEstrattocontoWithPdfsMethod extends DefaultMethod {

	private static final String METHOD_NAME = "updateEstrattocontoWithPdfsMethod";

	private static final Logger logger = Logger
			.getLogger(UpdateEstrattocontoWithPdfsMethod.class);

	public UpdateEstrattocontoWithPdfsMethod(DefaultModule parentModule,
			String[] defaultParameters) {
		super(parentModule, defaultParameters);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * for direct call
	 */
	public UpdateEstrattocontoWithPdfsMethod() {
		super(null, null);
	}

	@Override
	public String doMethod(HttpServletRequest request,
			HttpServletResponse response) throws SerenaException {
		ActiveTemplate template = new ActiveTemplate(
				TemplateFactory.getTemplate(retrieveDefaultTemplateContext(),
						retrieveTemplateContext(), getName()));

		String eId = request.getParameter("ID");
		try {
			logger.info("UpdateEstrattocontoWithPdfsMethod.doMethod has been called");
			Estrattoconto e = new ExaequoBeanDataManager().getEstrattoconto(
					request, 2, eId);
			doUpdate(request, e);
			
		} catch (Exception ex) {
			String errorMessage = "Errore in generazione pdf estrattoconto "
					+ eId;
			logger.error(errorMessage, ex);
			template.replaceTagInBlock("ERROR_MESSAGE", "RESULT_ERROR",
					errorMessage);
			template.publishBlock("RESULT_ERROR");
			template.publish();
			return template.getContenuto();
		}
		template.replaceTagInBlock("ID", "RESULT_SUCCESS", eId);
		template.publishBlock("RESULT_SUCCESS");
		template.publish();
		return template.getContenuto();

	}
	
	
	public void doUpdate(HttpServletRequest request, Estrattoconto e) throws Exception {
		String estrattocontoPdfId = registerAttachmentFromBirtReport(
				Soci.INSTANCE_NAME, "Estrattoconto_Libretto", e, request,
				BalanceReportMethod.METHOD_NAME, "CurrentBalance");
		e.setPdf(estrattocontoPdfId);
		if (e.getInteressi_netti().floatValue() >= 25) {
			String moduloAccreditoPdfId = registerAttachmentFromBirtReport(
					Libretti.INSTANCE_NAME, "ModuloAccredito_Libretto", e,
					request, GeneraModuloAccreditoInteressiMethod.METHOD_NAME,
					"ModuloAccreditoInteressi");
			e.setAllegato(moduloAccreditoPdfId);
		}
		try {
			updateEstrattoconto(e, request);
		} catch (Exception up) {
			// needs some rolling back!
			deleteAttachment(e.getPdf(), request);
			deleteAttachment(e.getAllegato(), request);
			throw new Exception(
					"Generazione report ok, ma fallisce aggiornamento Estrattoconto");
		}
	}

	private void updateEstrattoconto(Estrattoconto e, HttpServletRequest request)
			throws Exception {
		Element currentElement = ObjectUtils.getXserenaRequestStandardHeader(
				request.getSession().getId(), ConstantsXSerena.ACTION_SET,
				Estrattoconto.INSTANCE_NAME);
		currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION,
				ConstantsXSerena.VAL_UPDATE);
		Element condition = currentElement
				.addElement(ConstantsXSerena.TAG_CONDITION);
		condition = condition.addElement("ID");
		condition.setText(e.getId());
		Element pdf = currentElement.addElement(Estrattoconto.SLOT_PDF);
		pdf.setText(e.getPdf());
		if (e.getAllegato() != null && !e.getAllegato().equals("0")) {
			pdf = currentElement.addElement(Estrattoconto.SLOT_ALLEGATO);
			pdf.setText(e.getAllegato());
		}
		ApplicationLibrary.setData(currentElement.getDocument(), request);
		logger.debug("Update estrattoconto " + e.getId() + " OK ");
	}

	private boolean deleteAttachment(String attachmentID,
			HttpServletRequest request) {
		AttachmentBean anAttach = new AttachmentBean();
		anAttach.setID(attachmentID);
		try {
			if (anAttach.load(request)) {
				// cancellazione fisica
				final File theFile = new File(anAttach.getMyPath()
						+ anAttach.getSa_filename());
				theFile.delete();
				return anAttach.physicalDelete(request);
			} else {
				logger.error("Cannot load attach " + attachmentID
						+ " for deletion");
				return false;
			}
		} catch (final Exception e) {
			logger.error("Cannot delete attach " + attachmentID);
			return false;
		}
	}

	private String registerAttachmentFromBirtReport(String theClass,
			String preTitolo, Estrattoconto e, HttpServletRequest request,
			String methodName, String reportName) throws IOException,
			SerenaException {
		try {
			AttachmentBean anAttach = new AttachmentBean();
			String titolo = preTitolo + "_"
					+ e.getDi_libretto().getCodice_contratto() + ".pdf";
			String filePath = anAttach.getMyPath() + titolo;
			// 1: bort report 2 file
			reportName += ".rptdesign";
			File designFile = new File(ConstantsBaseLibrary.realpath + "/"
					+ ConstantsBaseLibrary.TEMPLATE_DIR + "/"
					+ Iniziative_Module.MODULE_NAME + "/" + methodName + "/"
					+ theClass, reportName);
			File attachmentFile = new File(filePath);
			if (attachmentFile.exists()) {
				logger.error("File " + filePath
						+ " already existent: overwriting!");
				attachmentFile.delete();
//				throw new IOException("File " + filePath + " gia esistente");
			}
			OutputStream output = new FileOutputStream(attachmentFile);
			ReportEngine engine = ReportEngine.getInstance(request);
			Document theInstance = null;
			if (theClass.equals(Libretti.INSTANCE_NAME))	{
				theInstance = createInstance4Estrattoconto(request, engine, designFile,
						theClass, e.getDi_libretto().getId());
			} else if (theClass.equals(Soci.INSTANCE_NAME))	{
				theInstance = createInstance4Soci(request, engine, designFile,
						theClass, e.getDi_libretto().getDati_socio().getId());
			} else {
				throw new SerenaException("Wrong class!!!!");
			}
			
			engine.createReport(designFile, theInstance, output,
					PdfStrategy.OUTPUT_FORMAT);
			anAttach.setOperationInsert();
			// Default content type
			anAttach.setSa_content_type(AttachmentBean.PDF_CONTENT_TYPE);
			anAttach.setSa_size(attachmentFile.length());
			anAttach.setSa_filename(titolo);
			anAttach.setSa_alt_text(anAttach.getSa_filename());
			anAttach.setSa_link_text(anAttach.getSa_filename());
			anAttach.setSa_type("20");
			// INSERT ATTACHMENT
			String retID = anAttach.insert(request);
			logger.trace("File " + anAttach.getSa_filename()
					+ " has been saved");
			// 2: file to _system_attachment
			return retID;
		} catch (ReportException re) {
			logger.error("Problema ai report engine: " + re.getMessage());
			throw new SerenaException(re.getMessage());
		}
	}

	private Document createInstance4Soci(HttpServletRequest request,
			ReportEngine engine, File designFile, String theClass, String theID)
			throws SerenaException {
		try {
			Document dataQuery = engine.createQuery(designFile);
			Element theClassElement = (Element) dataQuery
					.selectSingleNode(".//" + theClass);
			Element theCondition = theClassElement
					.addElement(ConstantsXSerena.TAG_CONDITION);
			theCondition = theCondition.addElement("ID");
			theCondition.setText(theID);
			Document data = ApplicationLibrary.getData(dataQuery, request);

			Element dataElem = ApplicationLibrary
					.prepareDataForPresentation(data);
			String[] messages = { "", "" };
			int res = ConstantsXSerena.getXserenaRequestResult(dataElem,
					messages, theClass);

			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("createInstance:" + messages[0]);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				logger.error("createInstance: empty");
				throw new SerenaException(messages[0], "empty");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				new BalanceReportMethod().postProcess(request, data); 
				return data;
			} else {
				logger.error("createInstance: ?");
				throw new SerenaException(messages[0], "?");
			}
		} catch (Exception e) {
			String msg = "createInstance has resulted into exception:"
					+ e.getMessage() + " most probably: instance " + theID + " of class " + theClass + " does not exists.";
			logger.error(msg);
			throw new SerenaException(msg);
		}
	}

	
	private Document createInstance4Estrattoconto(HttpServletRequest request,
			ReportEngine engine, File designFile, String theClass, String theID)
			throws SerenaException {
		try {
			Document dataQuery = engine.createQuery(designFile);
			Element theClassElement = (Element) dataQuery
					.selectSingleNode(".//" + theClass);
			Element theCondition = theClassElement
					.addElement(ConstantsXSerena.TAG_CONDITION);
			theCondition = theCondition.addElement("ID");
			theCondition.setText(theID);
			Document data = ApplicationLibrary.getData(dataQuery, request);

			Element dataElem = ApplicationLibrary
					.prepareDataForPresentation(data);
			String[] messages = { "", "" };
			int res = ConstantsXSerena.getXserenaRequestResult(dataElem,
					messages, theClass);

			if (res == ConstantsXSerena.XSERENA_RESULT_ERROR) {
				logger.error("createInstance:" + messages[0]);
				throw new SerenaException(messages[0], "generic_sql_error");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_EMPTY) {
				logger.error("createInstance: empty");
				throw new SerenaException(messages[0], "empty");
			} else if (res == ConstantsXSerena.XSERENA_RESULT_SUCCESS) {
				new GeneraModuloAccreditoInteressiMethod().postProcess(request, data);
				return data;
			} else {
				logger.error("createInstance: ?");
				throw new SerenaException(messages[0], "?");
			}
		} catch (Exception e) {
			String msg = "createInstance has resulted into exception:"
					+ e.getMessage() + " most probably: instance " + theID + " of class " + theClass + " does not exists.";
			logger.error(msg);
			throw new SerenaException(msg);
		}
	}

	@Override
	protected String getName() {
		return METHOD_NAME;
	}

}

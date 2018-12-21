package eu.anastasis.serena.inziativesolidali;


import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import eu.anastasis.serena.application.core.modules.DefaultMethod;
import eu.anastasis.serena.application.core.modules.DefaultModule;
import eu.anastasis.serena.application.index.util.ApplicationLibrary;
import eu.anastasis.serena.application.index.util.AttachmentBean;
import eu.anastasis.serena.application.index.util.MailHandler;
import eu.anastasis.serena.application.index.util.ModuleParameterConfiguration;
import eu.anastasis.serena.application.modules.object.ObjectUtils;
import eu.anastasis.serena.auth.exceptions.PermissionException;
import eu.anastasis.serena.beans.Consumatori;
import eu.anastasis.serena.beans.Estrattoconto;
import eu.anastasis.serena.beans.ExaequoBeanDataManager;
import eu.anastasis.serena.beans.Libretti;
import eu.anastasis.serena.beans.Organizzazioni;
import eu.anastasis.serena.beans.Soci;
import eu.anastasis.serena.common.SerenaDate;
import eu.anastasis.serena.constants.ConstantsEntityBean;
import eu.anastasis.serena.constants.ConstantsXSerena;
import eu.anastasis.serena.dataManager.DataManagerException;
import eu.anastasis.serena.exception.SerenaException;
import eu.anastasis.serena.presentation.templates.ActiveTemplate;
import eu.anastasis.serena.presentation.templates.TemplateException;
import eu.anastasis.serena.presentation.templates.TemplateFactory;


public class InviaModuliMethod extends DefaultMethod

{		
	public static final String METHOD_NAME = "inviaModuli";
	
	private static final String ID_PARAM = "ID";
	
	private MailHandler mailHandler=null;
	
	private static final Logger logger = Logger.getLogger(InviaModuliMethod.class);
	
	public InviaModuliMethod(DefaultModule parentModule, String[] defaultParameters) {
		super(parentModule, defaultParameters);
		mailHandler=new MailHandler();
	}
	
	private boolean generaModuloAccredito (Estrattoconto e){
		return e.getInteressi_netti()>=25;
	}
		
	@Override
	public String doMethod(HttpServletRequest request, HttpServletResponse response) throws SerenaException {
		Estrattoconto e = null;
		ActiveTemplate template = new ActiveTemplate(
				TemplateFactory.getTemplate(retrieveDefaultTemplateContext(),
						retrieveTemplateContext(), getName()));
		try	{
			String theID = request.getParameter(ID_PARAM);
			
			e = new ExaequoBeanDataManager().getEstrattoconto(request, 4, theID);	// cosi' persca anche il socio del libretto
			
			if (e.getPdf()==null){
				new UpdateEstrattocontoWithPdfsMethod().doUpdate(request, e);
			}
			manuallyUpdateAttachments(request,e);

			send(request,e);
			
			this.upgradeEstrattoconto(e,request);
			
			logger.debug("Inviato con successo estrattoconto libretto " + e.getDi_libretto().getCodice_contratto());
			template.replaceTagInBlock("ID", "RESULT_SUCCESS", e.getId());
			template.publishBlock("RESULT_SUCCESS");
		}catch (Exception s){
			String errore = "Errore in invio estrattoconto libretto " + e.getDi_libretto().getCodice_contratto()+ " - "+s.getMessage();
			logger.error(errore);
			template.replaceTagInBlock("ERROR_MESSAGE", "RESULT_ERROR", errore);
			template.publishBlock("RESULT_ERROR");
		}
		template.publish();
		return template.getContenuto();
	}
	
	/**
	 * Due to a CarnazzoBean limitation, attachments are not fetched....
	 * @param request
	 * @param e
	 */
	private void manuallyUpdateAttachments(HttpServletRequest request,
			Estrattoconto e) throws SerenaException {
		Element currentElement = ObjectUtils.getXserenaRequestStandardHeader(request.getSession().getId(), ConstantsXSerena.ACTION_GET, Estrattoconto.INSTANCE_NAME);
		currentElement.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_SELECT);
		currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET, ConstantsXSerena.TARGET_ALL);
		currentElement.addAttribute(ConstantsXSerena.ATTR_TARGET_LEVELS, "2");	
		Element cond = currentElement.addElement(ConstantsXSerena.TAG_CONDITION);
		cond=cond.addElement(ConstantsEntityBean.ID);
		cond.setText(e.getId());
		String[] messages={"",""};
		Document resultData=ApplicationLibrary.getData(currentElement.getDocument(),request);
		Element data = ApplicationLibrary.prepareDataForPresentation(resultData);
		int res = ConstantsXSerena.getXserenaRequestResult(data, messages,Estrattoconto.INSTANCE_NAME);

		if (res==ConstantsXSerena.XSERENA_RESULT_ERROR)
		{
			logger.error("Cannot startup manuallyUpdateAttachments "+messages[0] );
			throw new SerenaException(messages[0],"generic_sql_error");
		}
		else if (res==ConstantsXSerena.XSERENA_RESULT_EMPTY)
		{
			; // lecito
		}
		else if (res==ConstantsXSerena.XSERENA_RESULT_SUCCESS)
		{
			Element estrattoconto= (Element)data.selectSingleNode(Estrattoconto.INSTANCE_NAME);
			Element pdf = estrattoconto.element(Estrattoconto.SLOT_PDF);
			if (pdf!=null && pdf.element("_system_attachment")!=null){
				String pdfName = pdf.element("_system_attachment").elementText("sa_filename");
				e.setPdf(pdfName);
			}
			Element moduloAccredito = estrattoconto.element(Estrattoconto.SLOT_ALLEGATO);
			if (moduloAccredito!=null && moduloAccredito.element("_system_attachment")!=null){
				String moduloAccreditoName = moduloAccredito.element("_system_attachment").elementText("sa_filename");
				e.setAllegato(moduloAccreditoName);
			}
		}
	}

	private void upgradeEstrattoconto(Estrattoconto e,
			HttpServletRequest request) {
		try	{
			Element root = ObjectUtils.getXserenaRequestStandardHeader(request.getSession().getId(), ConstantsXSerena.ACTION_SET,Estrattoconto.INSTANCE_NAME);
			root.addAttribute(ConstantsXSerena.ATTR_OPERATION, ConstantsXSerena.VAL_UPDATE);
			Element x = root.addElement(Estrattoconto.SLOT_INVIATO_IL);
			x.setText(new SerenaDate().toString());
			x = root.addElement(Estrattoconto.SLOT_ESITO_INVIO);
			x.setText("1");
			Element cond = root.addElement(ConstantsXSerena.TAG_CONDITION);
			cond=cond.addElement(ConstantsEntityBean.ID);
			cond.setText(e.getId());
			Document data = ApplicationLibrary.setData(root.getDocument(),request);
			String[] messages2={"",""};
			int res = ConstantsXSerena.getXserenaRequestResult(data, messages2,Estrattoconto.INSTANCE_NAME);
			if (res==ConstantsXSerena.XSERENA_RESULT_ERROR)
			{
				logger.error("[SendMailMethod]->upgradeTicketThreadStep has resulted into error:"+messages2[0]);
			}
			else if (res==ConstantsXSerena.XSERENA_RESULT_SUCCESS)	{
			}		
		} catch (PermissionException ex) {
			logger.error("[SendMailMethod]->upgradeTicketThreadStep has resulted into permission error"+ex.getMessage());
		} catch (DataManagerException ex) {
			logger.error("[SendMailMethod]->upgradeTicketThreadStep has resulted into sql error"+ex.getMessage());
		} catch (Exception ex) {
			logger.error("[SendMailMethod]->upgradeTicketThreadStep has resulted into error"+ex.getMessage());
		}
	}
	
	/* esito invio localhost -> katamail 
	 * 
	Jun 28 09:08:48 andrea-VirtualBox postfix/qmgr[3343]: 171EF360614: from=<finanzasolidale@exaequo.bo.it>, size=135925, nrcpt=2 (queue active)
	Jun 28 09:08:48 andrea-VirtualBox postfix/qmgr[3343]: E2B3B360612: from=<finanzasolidale@exaequo.bo.it>, size=135925, nrcpt=2 (queue active)
	Jun 28 09:08:49 andrea-VirtualBox postfix/smtp[5275]: 171EF360614: to=<andreafrascari@katamail.com>, relay=newmx.katamail.com[62.149.157.151]:25, delay=496, delays=495/0/1.
	1/0, dsn=4.0.0, status=deferred (host newmx.katamail.com[62.149.157.151] refused to talk to me: 554 mxcm02-pc.ad.aruba.it bizsmtp lj8n1q00R5BVujS01 Connection refused from 
	78.13.160.240. See http://www.spamhaus.org/query/bl?ip=78.13.160.240 for more information.)
	Jun 28 09:08:49 andrea-VirtualBox postfix/smtp[5276]: E2B3B360612: to=<andreafrascari@katamail.com>, relay=newmx.katamail.com[62.149.157.151]:25, delay=1148, delays=1147/0/
	1.3/0, dsn=4.0.0, status=deferred (host newmx.katamail.com[62.149.157.151] refused to talk to me: 554 mxcm02-pc.ad.aruba.it bizsmtp lj8n1q00W5BVujS01 Connection refused fro
	m 78.13.160.240. See http://www.spamhaus.org/query/bl?ip=78.13.160.240 for more information.)
	 */

	 
	protected String[] processAttachments(Estrattoconto e)	{
		String[] attaches = new String[2];
		
		AttachmentBean anAtBean = new AttachmentBean();
		anAtBean.setSa_type(new Integer(ConstantsEntityBean.CAMPO_ATTACHMENT).toString());
		String aPath ="";
		try {
			aPath = anAtBean.getMyPath();
		} catch (SerenaException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		int attachCounter=0;
		if (e.getPdf()!=null && !e.getPdf().isEmpty())	
			attaches[attachCounter++] = aPath+e.getPdf();
		if (generaModuloAccredito(e))	{
			if (e.getAllegato()!=null && !e.getAllegato().isEmpty())	
				attaches[attachCounter++] = aPath+e.getAllegato();
		}
		return attaches;
	}


	protected String processBody(Estrattoconto es) throws SerenaException	{
		ActiveTemplate templateBody =null;
		try {
			
			String bodyTpl = (generaModuloAccredito(es))?"tpl_mail_body_interessi":"tpl_mail_body_no_interessi";
			templateBody = new ActiveTemplate(
							TemplateFactory.getTemplate(retrieveDefaultTemplateContext(),
									retrieveTemplateContext(),bodyTpl));
			
			SerenaDate sD = new SerenaDate(es.getData());
			String data = sD.toString();
			templateBody.replaceTag("DATA", data);
			templateBody.replaceTag("ANNO", new Integer(sD.getYear()).toString());
			SerenaDate s0 = (SerenaDate)sD.clone();
			s0.subtractDays(365);
			String periodo = s0.toString() + " - " + data;
			templateBody.replaceTag("PERIODO", periodo);
			//tmp = tmp.replace("\n", "<br />");  //PEGO: nooo! ora è un campo editor,ce li mette da solo i br

		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String msg = "[SendMailMethod] cannot fetch mail template";
			logger.error(msg);
			throw new SerenaException(msg);
		}
		return templateBody.getContenuto();
	}

	protected String processSubject(Estrattoconto es) throws SerenaException	{
		ActiveTemplate templateSubject =null;
		try {
			templateSubject = new ActiveTemplate(
					TemplateFactory.getTemplate(retrieveDefaultTemplateContext(),
							retrieveTemplateContext(), "tpl_mail_subject"));

			
			
			String data = new SerenaDate(es.getData()).toString();
			templateSubject.replaceTag("DATA", data);
			

		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String msg = "[SendMailMethod] cannot fetch mail template";
			logger.error(msg);
			throw new SerenaException(msg);
		}
		return templateSubject.getContenuto();
	}

	public boolean send(HttpServletRequest request, Estrattoconto es) throws SerenaException
	{
		String content_type=MailHandler.CONTENT_TYPE_HTML;

		Libretti l = es.getDi_libretto();
		Soci s = l.getDati_socio();
		s = new ExaequoBeanDataManager().getSoci(request, 2, s.getId());
		Consumatori c = s.getDati_consumatore();
		Organizzazioni o = s.getDati_organizzazione();
		
		String to=null;
		
		if (c!=null)	{
			to=c.getEmail();
		} else {
			to = o.getEmail();
		}
		
		if (to==null || to.isEmpty()){
			String msg = "Impossibile inviare email a socio " + s.getNumero_socio() + " causa assenza indirizzo mail!";
			logger.error(msg);
			throw new SerenaException(msg);
		}
		
		String from=ModuleParameterConfiguration.getInstance().getValue("iniziativesolidali","email-libretti-from");
		String ccn=ModuleParameterConfiguration.getInstance().getValue("iniziativesolidali","email-libretti-ccn");
		
		String subject = processSubject(es);
		String body = processBody(es);

		String[] recipients ={to};
		String[] bcc ={ccn};
		/* prova
		String[] recipients ={"afrascari@gmail.com"};
		String[] bcc ={};
		*/
		
		String[] attachments=processAttachments(es);
		String[] arrayFrom = {from};
		
		MimeMessage theSentMsg = mailHandler.sendAndReturnMsg(from, arrayFrom, recipients,null, bcc, subject,body, content_type, attachments);
		if(theSentMsg==null)
		{
			logger.error("[SendMailMethod]->send: Errore nell'invio della mail: "+subject + "a: "+to);
			throw new SerenaException("Errore nell'invio della mail.");
		}		
		return true;
	}
	
	 

	@Override
	public String getName()	{
		return METHOD_NAME;
	}

}


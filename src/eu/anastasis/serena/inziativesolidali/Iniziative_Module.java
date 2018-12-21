package eu.anastasis.serena.inziativesolidali;

import eu.anastasis.serena.application.core.modules.DefaultModule;


public class Iniziative_Module extends DefaultModule {
public final static String MODULE_NAME = "iniziativesolidali";

	protected void setUpMethods()
	{
		addMethod(new Versamento_Method(this, getDefaultParameters()));
		addMethod(new Prelievo_Method(this, getDefaultParameters()));
		addMethod(new Interessi2Quote_Method(this, getDefaultParameters()));
		addMethod(new Reset_Method(this, getDefaultParameters()));
		addMethod(new LibrettoInfoAjaxMethod(this, getDefaultParameters()));
		addMethod(new AccreditoInteressi_Method(this, getDefaultParameters()));
		addMethod(new GeneraModuloAccreditoInteressiMethod(this, getDefaultParameters()));
		addMethod(new BalanceReportMethod(this, getDefaultParameters()));
		addMethod(new InviaModuliMethod(this, getDefaultParameters()));
		addMethod(new UpdateEstrattocontoWithPdfsMethod(this, getDefaultParameters()));
		addMethod(new ExportEstrattocontiMethod(this, getDefaultParameters()));
		addMethod(new ExportSimulazioneEstrattocontiMethod(this, getDefaultParameters()));
		addMethod(new ExportQuoteMethod(this, getDefaultParameters()));
		addMethod(new ExportAnagraficaMethod(this, getDefaultParameters()));
	}
	
	@Override
	public String getDefaultName() 
	{
		return MODULE_NAME;
	}

}

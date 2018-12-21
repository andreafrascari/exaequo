
package eu.anastasis.serena.inziativesolidali;


import eu.anastasis.serena.application.core.modules.DefaultModule;
import eu.anastasis.serena.application.modules.BirtReport.*;


//localhost:8080/Iniziative/ModuleIndex?q=iniziativesolidali/export_simulazione_estrattoconti/CLS=SimulazioneEstrattoconto/DOC=SimulazioneEstrattoconto/FILE=Simulazione/TYPE=pdf

public class ExportSimulazioneEstrattocontiMethod extends GiveMethod {


	public static final String METHOD_NAME = "export_simulazione_estrattoconti";


	public ExportSimulazioneEstrattocontiMethod(DefaultModule parentModule,
			String[] defaultParameters) {
		super(parentModule, defaultParameters);
	}
	
			
	@Override
	protected String getName() {
		return METHOD_NAME;
	}
}

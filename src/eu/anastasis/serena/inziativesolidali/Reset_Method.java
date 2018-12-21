package eu.anastasis.serena.inziativesolidali;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.anastasis.serena.application.core.modules.DefaultMethod;
import eu.anastasis.serena.application.core.modules.DefaultModule;
import eu.anastasis.serena.beans.exaequo.MyCooperative;
import eu.anastasis.serena.exception.SerenaException;

/**
 * Ridefinisce DetailEdit per la creazione atomica anche delle istanze figlie
 * @author afrascari
 *
 */
public class Reset_Method extends DefaultMethod {

	public Reset_Method(DefaultModule defaultModule,
			String[] defaultParameters) {
		super(defaultModule, defaultParameters);
		// TODO Auto-generated constructor stub
	}
	
	public static final String METHOD_NAME = "reset";
 
	
	@Override
	protected String getName()
	{
		return METHOD_NAME;
	}


	@Override
	public String doMethod(HttpServletRequest request,
			HttpServletResponse response) throws SerenaException {
		new MyCooperative().reasetCache();
		return "All cache have been resetted.";
	}
}

package eu.anastasis.serena.beans.exaequo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import eu.anastasis.serena.beans.ExaequoBeanDataManager;
import eu.anastasis.serena.beans.InteressiIndeducibili;
import eu.anastasis.serena.common.SerenaDate;
import eu.anastasis.serena.constants.ConstantsXSerena;
import eu.anastasis.serena.dataManager.DataManagerException;
import eu.anastasis.serena.exception.SerenaException;
import eu.anastasis.serena.inziativesolidali.AccreditoInteressi_Method;

public class MyInteressiDeducibili {
	
	private static List<InteressiIndeducibili> listaTassi = null;
	
	public static MyInteressiDeducibili GetInstance(HttpServletRequest request) throws SerenaException {
		try	{
			if (listaTassi==null)	{
				final Document document = DocumentHelper.createDocument();
				document.setXMLEncoding("UTF-8");
				Element condElement = document.addElement(InteressiIndeducibili.INSTANCE_NAME);
				Element fake = condElement.addElement("ID");
				fake.addAttribute(ConstantsXSerena.ATTR_OPERATOR, ConstantsXSerena.VAL_GREATER_THAN);
				fake.setText("0");
				listaTassi = new ExaequoBeanDataManager().getInteressiIndeducibiliList(request, condElement, 1);
			}
		} catch (DataManagerException d){
			throw new SerenaException("Errore in reperimento lista interessi indeducibili");
		}
		if (listaTassi==null || listaTassi.isEmpty())	{
			throw new SerenaException("Errore in reperimento lista interessi indeducibili");	
		}
		return new MyInteressiDeducibili();
	}
	
	public  List<InteressiIndeducibili> getListaTassi()	{
		return listaTassi;
	}
	
	public static void Reset(){
		listaTassi=null;
		
	}
	
	public double getTassoPeriodo(SerenaDate d0, SerenaDate d1) throws SerenaException	{
		double tasso = 0;
		for (InteressiIndeducibili id: listaTassi)	{
			SerenaDate t0 = new SerenaDate(id.getData_inizio_validita());
			SerenaDate t1 = new SerenaDate(id.getData_fine_validita());
			if (t1 == null) {
				t1 = new SerenaDate(AccreditoInteressi_Method.A_DAY_IN_THE_FUTURE);
			}
			int whichCase = AccreditoInteressi_Method.WorkoutWhichCase(t0,t1,d0,d1);
			switch (whichCase) {
				case 1: //  d0 <= t0 < t1 <= d1 -> il tasso varia DENTRO il periodo: errore!!!
					throw new SerenaException("Errore: Variazione interessi indeducibili variano dentro il periodo in considerazione: " + d0.toString() + " - " + d1.toString());
				case 2: // t0 < d0 < d1 < t1
					tasso = id.getTasso_interesse().doubleValue();
					return tasso;
				case 3: // t0 < d0 <= t1 < d1
					throw new SerenaException("Errore: Variazione interessi indeducibili variano dentro il periodo in considerazione: " + d0.toString() + " - " + d1.toString());
				case 4: // d0 < t0 < d1 < t1
					throw new SerenaException("Errore: Variazione interessi indeducibili variano dentro il periodo in considerazione: " + d0.toString() + " - " + d1.toString());	
				case 5:
					break;
				}
		}
		throw new SerenaException("Nessun tasso trovato nel periodo in considerazione: " + d0.toString() + " - " + d1.toString());	
	}

}

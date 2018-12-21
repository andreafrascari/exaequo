package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class SessioniCorsi implements SerenaMarshallable
{


	public static final java.lang.String INSTANCE_NAME = "SessioniCorsi";
	public static final java.lang.String SLOT_ARGOMENTI = "argomenti";
	public static final java.lang.String SLOT_DATA = "data";
	public static final java.lang.String SLOT_DI_CORSO = "di_corso";
	public static final java.lang.String SLOT_DOCENTI = "docenti";
	public static final java.lang.String SLOT_DOCUMENTI = "documenti";
	public static final java.lang.String SLOT_LUOGO = "luogo";
	public static final java.lang.String SLOT_TITLE = "title";

	protected java.lang.String argomenti;
	protected java.util.Date data;
	protected CorsiFormazione di_corso;
	protected java.lang.String docenti;
	protected java.util.ArrayList<_system_document> documenti;
	protected java.lang.String luogo;
	protected java.lang.String title;
	protected String id;

	public SessioniCorsi(){}

	public java.lang.String getArgomenti() {
		return argomenti;
	}

	public void setArgomenti(java.lang.String argomenti) {
		this.argomenti = argomenti;
	}

	public java.util.Date getData() {
		return data;
	}

	public void setData(java.util.Date data) {
		this.data = data;
	}

	public CorsiFormazione getDi_corso() {
		return di_corso;
	}

	public void setDi_corso(CorsiFormazione di_corso) {
		this.di_corso = di_corso;
	}

	public java.lang.String getDocenti() {
		return docenti;
	}

	public void setDocenti(java.lang.String docenti) {
		this.docenti = docenti;
	}

	public java.util.ArrayList<_system_document> getDocumenti() {
		return documenti;
	}

	public void setDocumenti(java.util.ArrayList<_system_document> documenti) {
		this.documenti = documenti;
	}

	public java.lang.String getLuogo() {
		return luogo;
	}

	public void setLuogo(java.lang.String luogo) {
		this.luogo = luogo;
	}

	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String toString() {
		return "SessioniCorsi \n argomenti: "+argomenti+" data: "+data+" docenti: "+docenti+" luogo: "+luogo+" title: "+title;
	}

}
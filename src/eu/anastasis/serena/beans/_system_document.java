package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class _system_document implements SerenaMarshallable
{

	public static final java.lang.String CATEGORY__MODULI = "moduli";
	public static final java.lang.String CATEGORY__FORMAZIONE = "formazione";

	public static final java.lang.String FILE_TYPE__PDF = "pdf";
	public static final java.lang.String FILE_TYPE__DOC = "doc";
	public static final java.lang.String FILE_TYPE__PPT = "ppt";
	public static final java.lang.String FILE_TYPE__ODT = "odt";
	public static final java.lang.String FILE_TYPE__XLS = "xls";
	public static final java.lang.String FILE_TYPE__ODS = "ods";
	public static final java.lang.String FILE_TYPE__MDB = "mdb";


	public static final java.lang.String INSTANCE_NAME = "_system_document";
	public static final java.lang.String SLOT_ATTACHMENT = "attachment";
	public static final java.lang.String SLOT_ATTACHMENT_1 = "attachment_1";
	public static final java.lang.String SLOT_AUTHOR = "author";
	public static final java.lang.String SLOT_CATEGORY = "category";
	public static final java.lang.String SLOT_DI_SESSIONE = "di_sessione";
	public static final java.lang.String SLOT_FILE_TYPE = "file_type";
	public static final java.lang.String SLOT_PER_CORSO = "per_corso";
	public static final java.lang.String SLOT_TEASER = "teaser";
	public static final java.lang.String SLOT_THUMBNAIL = "thumbnail";
	public static final java.lang.String SLOT_TITLE = "title";

	protected java.lang.String attachment;
	protected java.lang.String attachment_1;
	protected java.lang.String author;
	protected java.lang.String category;
	protected java.util.ArrayList<SessioniCorsi> di_sessione;
	protected java.lang.String file_type;
	protected java.util.ArrayList<CorsiFormazione> per_corso;
	protected java.lang.String teaser;
	protected java.lang.String thumbnail;
	protected java.lang.String title;
	protected String id;

	public _system_document(){}

	public java.lang.String getAttachment() {
		return attachment;
	}

	public void setAttachment(java.lang.String attachment) {
		this.attachment = attachment;
	}

	public java.lang.String getAttachment_1() {
		return attachment_1;
	}

	public void setAttachment_1(java.lang.String attachment_1) {
		this.attachment_1 = attachment_1;
	}

	public java.lang.String getAuthor() {
		return author;
	}

	public void setAuthor(java.lang.String author) {
		this.author = author;
	}

	public java.lang.String getCategory() {
		return category;
	}

	public void setCategory(java.lang.String category) {
		this.category = category;
	}

	public java.util.ArrayList<SessioniCorsi> getDi_sessione() {
		return di_sessione;
	}

	public void setDi_sessione(java.util.ArrayList<SessioniCorsi> di_sessione) {
		this.di_sessione = di_sessione;
	}

	public java.lang.String getFile_type() {
		return file_type;
	}

	public void setFile_type(java.lang.String file_type) {
		this.file_type = file_type;
	}

	public java.util.ArrayList<CorsiFormazione> getPer_corso() {
		return per_corso;
	}

	public void setPer_corso(java.util.ArrayList<CorsiFormazione> per_corso) {
		this.per_corso = per_corso;
	}

	public java.lang.String getTeaser() {
		return teaser;
	}

	public void setTeaser(java.lang.String teaser) {
		this.teaser = teaser;
	}

	public java.lang.String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(java.lang.String thumbnail) {
		this.thumbnail = thumbnail;
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
		return "_system_document \n attachment: "+attachment+" attachment_1: "+attachment_1+" author: "+author+" category: "+category+" file_type: "+file_type+" teaser: "+teaser+" thumbnail: "+thumbnail+" title: "+title;
	}

}
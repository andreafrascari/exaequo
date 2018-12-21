package eu.anastasis.serena.beans;

import eu.anastasis.serena.beans.SerenaMarshallable;

public class Newsletter implements SerenaMarshallable
{


	public static final java.lang.String INSTANCE_NAME = "Newsletter";
	public static final java.lang.String SLOT_ALLEGATO = "allegato";
	public static final java.lang.String SLOT_ALLEGATO_1 = "allegato_1";
	public static final java.lang.String SLOT_BODY = "body";
	public static final java.lang.String SLOT_NEWSLETTER_COOP = "newsletter_coop";
	public static final java.lang.String SLOT_TEASER = "teaser";
	public static final java.lang.String SLOT_THUMBNAIL = "thumbnail";
	public static final java.lang.String SLOT_TITLE = "title";

	protected java.lang.String allegato;
	protected java.lang.String allegato_1;
	protected java.lang.String body;
	protected Cooperative newsletter_coop;
	protected java.lang.String teaser;
	protected java.lang.String thumbnail;
	protected java.lang.String title;
	protected String id;

	public Newsletter(){}

	public java.lang.String getAllegato() {
		return allegato;
	}

	public void setAllegato(java.lang.String allegato) {
		this.allegato = allegato;
	}

	public java.lang.String getAllegato_1() {
		return allegato_1;
	}

	public void setAllegato_1(java.lang.String allegato_1) {
		this.allegato_1 = allegato_1;
	}

	public java.lang.String getBody() {
		return body;
	}

	public void setBody(java.lang.String body) {
		this.body = body;
	}

	public Cooperative getNewsletter_coop() {
		return newsletter_coop;
	}

	public void setNewsletter_coop(Cooperative newsletter_coop) {
		this.newsletter_coop = newsletter_coop;
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
		return "Newsletter \n allegato: "+allegato+" allegato_1: "+allegato_1+" body: "+body+" teaser: "+teaser+" thumbnail: "+thumbnail+" title: "+title;
	}

}
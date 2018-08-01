package com.ziehe.demorest;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Indexed
@Entity
public class Mitarbeiter {


	
	@Id
	private int Id;
	@Field
	private String Abteilung; 
	@Field
	private String Email; 
	@Field
	private String Fax; 
	@Field
	private String Nachname; 
	@Field
	private String Namenszusatz; 
	@Field
	private String Raum; 
	@Field
	private String show_only_altPhone;
	@Field
	private String Struktureinheiten; 
	@Field
	private String Suchbegriffe;
	@Field
	private String Telefon; 
	@Field
	private String Vorname; 
	@Field
	private String zweitesTelefon; 
	@Field
	private String PCFax; 
	@Field
	private String gueltigbis; 
	@Field
	private String Titel; 
	@Field
	private String Email_Langform;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getAbteilung() {
		return Abteilung;
	}

	public void setAbteilung(String abteilung) {
		Abteilung = abteilung;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public String getNachname() {
		return Nachname;
	}

	public void setNachname(String nachname) {
		Nachname = nachname;
	}

	public String getNamenszusatz() {
		return Namenszusatz;
	}

	public void setNamenszusatz(String namenszusatz) {
		Namenszusatz = namenszusatz;
	}

	public String getRaum() {
		return Raum;
	}

	public void setRaum(String raum) {
		Raum = raum;
	}

	public String getShow_only_altPhone() {
		return show_only_altPhone;
	}

	public void setShow_only_altPhone(String show_only_altPhone) {
		this.show_only_altPhone = show_only_altPhone;
	}

	public String getStruktureinheiten() {
		return Struktureinheiten;
	}

	public void setStruktureinheit(String struktureinheit) {
		Struktureinheiten = struktureinheit;
	}

	public String getSuchbegriffe() {
		return Suchbegriffe;
	}

	public void setSuchbegriffe(String suchbegriffe) {
		Suchbegriffe = suchbegriffe;
	}

	public String getTelefon() {
		return Telefon;
	}

	public void setTelefon(String telefon) {
		Telefon = telefon;
	}

	public String getVorname() {
		return Vorname;
	}

	public void setVorname(String vorname) {
		Vorname = vorname;
	}

	public String getZweitesTelefon() {
		return zweitesTelefon;
	}

	public void setZweitesTelefon(String zweitesTelefon) {
		this.zweitesTelefon = zweitesTelefon;
	}

	public String getPCFax() {
		return PCFax;
	}

	public void setPCFax(String pCFax) {
		PCFax = pCFax;
	}

	public String getGueltigbis() {
		return gueltigbis;
	}

	public void setGueltigbis(String gueltigbis) {
		this.gueltigbis = gueltigbis;
	}

	public String getTitel() {
		return Titel;
	}

	public void setTitel(String titel) {
		Titel = titel;
	}

	public String getEmail_Langform() {
		return Email_Langform;
	}

	public void setEmail_Langform(String email_Langform) {
		Email_Langform = email_Langform;
	}

	@Override
	public String toString() {
		return "Mitarbeiter [Id=" + Id + ", Abteilung=" + Abteilung + ", Email=" + Email + ", Fax=" + Fax
				+ ", Nachname=" + Nachname + ", Namenszusatz=" + Namenszusatz + ", Raum=" + Raum
				+ ", show_only_altPhone=" + show_only_altPhone + ", Struktureinheiten=" + Struktureinheiten
				+ ", Suchbegriffe=" + Suchbegriffe + ", Telefon=" + Telefon + ", Vorname=" + Vorname
				+ ", zweitesTelefon=" + zweitesTelefon + ", PCFax=" + PCFax + ", gueltigbis=" + gueltigbis + ", Titel="
				+ Titel + ", Email_Langform=" + Email_Langform + "]";
	} 	
}

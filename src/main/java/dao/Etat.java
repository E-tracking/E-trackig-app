package dao;

import java.util.Date;

import com.mkyong.users.model.User;

public class Etat {
	private int idEtat;
	private Date date;
	private Dossier dossier;
	private User user;
	private String position;
	private String coordonnee;
	private String typeNotification;
	private boolean lu;
	private boolean luCommercial;
	private boolean luTransporteur;
	private boolean luTransit;
	
	public Etat() {
	}
	
	public Etat(Date date, Dossier dossier, User user, String position,
			String coordonnee,String typeNotification) {
		
		this.date = date;
		this.dossier = dossier;
		this.user = user;
		this.position = position;
		this.coordonnee = coordonnee;
		this.typeNotification = typeNotification;
	}
	public Etat(Date date, Dossier dossier, User user, String position,
			String coordonnee, String typeNotification, boolean lu,
			boolean luCommercial, boolean luTransporteur, boolean luTransit) {
		super();
		this.date = date;
		this.dossier = dossier;
		this.user = user;
		this.position = position;
		this.coordonnee = coordonnee;
		this.typeNotification = typeNotification;
		this.lu = lu;
		this.luCommercial = luCommercial;
		this.luTransporteur = luTransporteur;
		this.luTransit = luTransit;
	}

	public int getIdEtat() {
		return idEtat;
	}
	public void setIdEtat(int idEtat) {
		this.idEtat = idEtat;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Dossier getDossier() {
		return dossier;
	}
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCoordonnee() {
		return coordonnee;
	}
	public void setCoordonnee(String coordonnee) {
		this.coordonnee = coordonnee;
	}

	public String getTypeNotification() {
		return typeNotification;
	}

	public void setTypeNotification(String typeNotification) {
		this.typeNotification = typeNotification;
	}

	public boolean isLu() {
		return lu;
	}

	public void setLu(boolean lu) {
		this.lu = lu;
	}

	public boolean isLuCommercial() {
		return luCommercial;
	}

	public void setLuCommercial(boolean luCommercial) {
		this.luCommercial = luCommercial;
	}

	public boolean isLuTransporteur() {
		return luTransporteur;
	}

	public void setLuTransporteur(boolean luTransporteur) {
		this.luTransporteur = luTransporteur;
	}

	public boolean isLuTransit() {
		return luTransit;
	}

	public void setLuTransit(boolean luTransit) {
		this.luTransit = luTransit;
	}
	
	
}

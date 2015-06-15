package dao;

import java.util.Date;

import com.mkyong.users.model.User;

public class Comment {
	
	private int id;
	private String commentaire;
	private Date date;
	private Dossier dossier;
	private User user;
	
	
	public Comment() {
	}

	public Comment(String commentaire, Date date, Dossier dossier, User user) {
		super();
		this.commentaire = commentaire;
		this.date = date;
		this.dossier = dossier;
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
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
	
}

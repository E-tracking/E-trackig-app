package dao;

// Generated 4 mars 2015 09:46:52 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import com.mkyong.users.model.User;

/**
 * Commercial generated by hbm2java
 */
public class Commercial implements java.io.Serializable {

	private Integer idcommercial;
	private User user;
	private boolean notification;
	private Set<Dossier> dossiers = new HashSet<Dossier>(0);
	
	public Integer getIdcommercial() {
		return idcommercial;
	}

	public void setIdcommercial(Integer idcommercial) {
		this.idcommercial = idcommercial;
	}

	public Commercial() {
	}

	public Set<Dossier> getDossiers() {
		return this.dossiers;
	}

	public void setDossiers(Set<Dossier> dossiers) {
		this.dossiers = dossiers;
	}

	public boolean isNotification() {
		return notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}

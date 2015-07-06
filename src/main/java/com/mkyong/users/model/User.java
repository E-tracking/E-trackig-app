package com.mkyong.users.model;

import java.util.HashSet;
import java.util.Set;

import dao.Etat;

public class User{

	private String username;
	private String password;
	private String emailuser;
	private String nomuser;
	private String phoneuser;
	private String prenomuser;
	private boolean enabled;
	private int userId;
	private String logo;
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	private Set<Etat> etats = new HashSet<Etat>(0);

	public User() {
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}



	public User(String username, String password, String emailuser,
			String nomuser, String phoneuser, String prenomuser,
			boolean enabled, int userId, Set<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.emailuser = emailuser;
		this.nomuser = nomuser;
		this.phoneuser = phoneuser;
		this.prenomuser = prenomuser;
		this.enabled = enabled;
		this.userId = userId;
		this.userRole = userRole;
	}

	public User(String username, String password, String emailuser,
			String nomuser, String phoneuser, String prenomuser) {
		super();
		this.username = username;
		this.password = password;
		this.emailuser = emailuser;
		this.nomuser = nomuser;
		this.phoneuser = phoneuser;
		this.prenomuser = prenomuser;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}


	public String getEmailuser() {
		return emailuser;
	}

	public void setEmailuser(String emailuser) {
		this.emailuser = emailuser;
	}

	public String getNomuser() {
		return nomuser;
	}

	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}

	public String getPhoneuser() {
		return phoneuser;
	}

	public void setPhoneuser(String phoneuser) {
		this.phoneuser = phoneuser;
	}

	public String getPrenomuser() {
		return prenomuser;
	}

	public void setPrenomuser(String prenomuser) {
		this.prenomuser = prenomuser;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Set<Etat> getEtats() {
		return etats;
	}

	public void setEtats(Set<Etat> etats) {
		this.etats = etats;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	
	
}

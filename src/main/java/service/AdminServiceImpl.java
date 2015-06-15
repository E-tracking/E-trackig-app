package service;

import java.io.Serializable;

import dao.Admin;
import dao.AdminDao;

public class AdminServiceImpl implements AdminService , Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AdminDao dao;
	
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	@Override
	public Admin Authentification(String login, String mdp) 
	{
		return dao.getAdmin(login, mdp);
	}

}

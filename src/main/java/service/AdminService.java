package service;

import dao.Admin;
import dao.Commercial;

public interface AdminService
{
	public Admin Authentification(String login,String mdp);
}

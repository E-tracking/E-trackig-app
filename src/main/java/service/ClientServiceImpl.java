package service;

import java.io.Serializable;
import java.util.List;

import dao.Client;
import dao.ClientDao;
import dao.Dossier;
import dao.DossierDao;

public class ClientServiceImpl implements ClientService ,Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientDao dao;
	private DossierDao daoD;
	
	public void setDao(ClientDao dao)
	{
		this.dao = dao;
	}

	@Override
	public Client Authentification(String login, String mdp) 
	{
		return dao.getClient(login, mdp);
	}

	@Override
	public Client getClient(int id) 
	{
		return dao.getClient(id);
	}

	@Override
	public void inscription(Client C)
	{
		dao.newClient(C);
	}

	@Override
	public List<Client> getAllClient() 
	{
		return dao.getAllClients();
	}

	@Override
	public void updateClient(Client C) 
	{
		dao.UpdateClient(C);
	}

	@Override
	public void deleteClient(int id) 
	{
		dao.DeleteClient(id);
	}

	@Override
	public void validateDossier(int id) 
	{
		Dossier D=daoD.getDossier(id);
		D.setValidationclient(true);
		daoD.UpdateDossier(D);
	}

}

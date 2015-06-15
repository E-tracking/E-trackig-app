package service;

import java.util.List;
import dao.Client;

public interface ClientService
{
	public Client Authentification(String login,String mdp);
	public Client getClient(int id);
	public void inscription(Client C);
	public List<Client> getAllClient();
	public void updateClient(Client C);
	public void deleteClient(int id);
	public void validateDossier(int id);
}

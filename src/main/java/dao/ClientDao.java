package dao;

import java.util.List;

public interface ClientDao
{
	public Client getClient(int id);
	public Client getClient(String login,String mdp);
	public List<Client> getAllClients();
	public void newClient(Client C);
	public void UpdateClient(Client C);
	public void DeleteClient(int id);
}

package service;

import java.util.List;

import com.mkyong.users.model.User;

import dao.Transit;

public interface TransitService 
{
	public Transit Authentification(String login,String mdp);
	public void Inscription(Transit C);
	public List<User> getAllTransits();
	public void DeleteTransit(int id);
	public void UpdateTransit(Transit C);
	public Transit getTransit(int id);
	public void CotationDossier(Double Cotation,int numDossier);
	public void UpdateEtatDossier(String etat,int numDossier);
	public Boolean isTransportEnd(int numDossier);
	public void TerminateTransport(int numDossier);
	public int LastTransitId();
}

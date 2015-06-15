package service;

import java.util.List;

import com.mkyong.users.model.User;

import dao.Transporteur;

public interface TransporteurService 
{
	public Transporteur Authentification(String login,String mdp);
	public Transporteur getTransporteurById(int id);
	public void Inscription(Transporteur C);
	public List<User> getAllTransporteurs();
	public void DeleteTransporteur(int id);
	public void UpdateTransporteur(Transporteur C);
	public void CotationDossier(Double Cotation,int numDossier);
	public void UpdateEtatDossier(String etat,int numDossier);
	public Boolean isTransportEnd(int numDossier);
	public void TerminateTransport(int numDossier);
	public int LastTransporteurId();
}

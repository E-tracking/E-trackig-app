package service;

import java.util.List;

import dao.Dossier;

public interface DossierService 
{
	public void newDossier(Dossier D);
	public Dossier getDossier(int numero);
	public void changerEtatDossier(int id,String etat);
	public void updateDossier(Dossier D);
	public void deleteDossier(int id);
	public void affecterDossierToCommercial(int id,int idC);
	public void affecterDossierToTransit(int id,int iT);
	public void affecterDossierToTransporteur(int id,int iT);
	public List<Dossier> getAllDossiers();
	public List<Dossier> getAllDossiersByUserId(int id,String userType);
	public List<Dossier> getDossiersRecents();
	public List<Dossier> getAllDossiersAttente(int idcommercial,String userType);
	public void validerDossier(int idDossier,int userId,String userType);
	public void removeAffetation(int idC,String usertype);
}

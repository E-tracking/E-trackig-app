package dao;

import java.util.List;

public interface DossierDao 
{
	public void AddDossier(Dossier C);
	public Dossier getDossier(int id);
	public List<Dossier> getAllDossiers();
	public List<Dossier> getAllDossiersByUserId(int id,String userType);
	public List<Dossier> getDossiersRecents();
	public void DeleteDossier(int id);
	public void UpdateDossier(int id,Dossier d);
	public void UpdateDossier(Dossier d);
	public void ChangerEtatDossier(int id,String etat);
}

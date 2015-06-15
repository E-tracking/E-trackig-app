package service;

import java.util.List;

import com.mkyong.users.model.User;

import dao.Dossier;
import dao.Etat;

public interface EtatService {
	public void addEtat(Etat etat);
	public void update(Etat etat);
	public List<Etat> getAllchangedEtat(User user,String userType);
	public List<Etat> getAllAffectedDossier(int userId,String userType);
	public List<Etat> getEtatByIdDossier(int idDossier);
	public Etat getEtat(int idEtat);
	public int getNbrAffectedDossier(int userId,String userType);
	public int getNbrChangementDossier(User user,String userType);
}

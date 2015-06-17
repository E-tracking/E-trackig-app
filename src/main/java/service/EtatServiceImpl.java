package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mkyong.users.model.User;
import com.mkyong.users.model.UserRole;

import dao.Dossier;
import dao.Etat;
import dao.EtatDao;

public class EtatServiceImpl implements EtatService {

	private EtatDao dao;

	public EtatDao getDao() {
		return dao;
	}

	public void setDao(EtatDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Etat> getAllchangedEtat(User user,String userType) {
		List<Etat> etats = dao.getAllEtat();
		List<Etat> etatList = new ArrayList<Etat>();
		for (Etat etat : etats) 
		{
			if(userType.equals("transit"))
			{
					if ((etat.getTypeNotification().equals("changement") || etat.getTypeNotification().equals("Commentaire"))
							&& etat.getDossier().getTransit() != null
							&& etat.getDossier().getTransit().getIdtransit() == user.getUserId()
							&& !etat.getUser().getUsername().equals(user.getUsername())
							)
						etatList.add(etat);
			}
			else if(userType.equals("transporteur"))
			{
				if ((etat.getTypeNotification().equals("changement") || etat.getTypeNotification().equals("Commentaire"))
						&& etat.getDossier().getTransporteur() != null
						&& etat.getDossier().getTransporteur().getIdtransporteur() == user.getUserId()
						&& !etat.getUser().getUsername().equals(user.getUsername())
						)
					etatList.add(etat);
			}
			else
			{
				if ((etat.getTypeNotification().equals("changement") || etat.getTypeNotification().equals("Commentaire"))
						&& etat.getDossier().getCommercial() != null
						&& etat.getDossier().getCommercial().getIdcommercial() == user.getUserId()
						&& !etat.getUser().getUsername().equals(user.getUsername())
						)
					etatList.add(etat);
			}
			
		}
		return etatList;
	}
	

	@Override
	public int getNbrChangementDossier(User user, String userType) {
		List<Etat> etats = dao.getAllEtat();
		int nbr = 0;
		for (Etat etat : etats) {
			if(userType.equals("transit")){
				if ((etat.getTypeNotification().equals("changement") || etat.getTypeNotification().equals("Commentaire"))
						&& etat.getDossier().getTransit() != null
						&& etat.getDossier().getTransit().getIdtransit() == user.getUserId()
						&& !etat.isLuTransit()
						&& !etat.getUser().getUsername().equals(user.getUsername())
						)
					nbr++;
			}
			else if(userType.equals("transporteur")){
				if ((etat.getTypeNotification().equals("changement") || etat.getTypeNotification().equals("Commentaire"))
						&& etat.getDossier().getTransporteur() != null
						&& etat.getDossier().getTransporteur().getIdtransporteur() == user.getUserId()
						&& !etat.isLuTransporteur()
						&& !etat.getUser().getUsername().equals(user.getUsername())
						)
					nbr++;
			}
			else{
				if ((etat.getTypeNotification().equals("changement") || etat.getTypeNotification().equals("Commentaire"))
						&& etat.getDossier().getCommercial() != null
						&& etat.getDossier().getCommercial().getIdcommercial() == user.getUserId()
						&& !etat.isLuCommercial()
						&& !etat.getUser().getUsername().equals(user.getUsername())
						)
					nbr++;
			}
		}
		return nbr;
	}

	@Override
	public void addEtat(Etat etat) {

		dao.addEtat(etat);
	}

	@Override
	public List<Etat> getEtatByIdDossier(int idDossier) {
		List<Etat> etats = new ArrayList<Etat>();
		for (Etat etat : dao.getAllEtat()) {
			if (etat.getDossier().getNumdossier() == idDossier)
				etats.add(etat);
		}
		return etats;
	}

	@Override
	public Etat getEtat(int idEtat) {

		return dao.getEtat(idEtat);
	}

	@Override
	public void update(Etat etat) {
		dao.update(etat);
	}
	
	@Override
	public List<Etat> getAllAffectedDossier(int userId,String userType) {
		List<Etat> etats = dao.getAllEtat();
		List<Etat> etatList = new ArrayList<Etat>();
		for (Etat etat : etats) {
			for (Iterator<UserRole> it = etat.getUser().getUserRole()
					.iterator(); it.hasNext();) {
				UserRole f = it.next();
			if (etat.getTypeNotification().equals("notification")
					&& etat.getDossier().getTransit() != null
					&& etat.getDossier().getTransit().getIdtransit() == userId
					&& f.getRole().equals("ROLE_TRANSIT")
					&& userType.equals("transit"))
				etatList.add(etat);
			else if (etat.getTypeNotification().equals("notification")
					&& etat.getDossier().getTransporteur() != null
					&& etat.getDossier().getTransporteur().getIdtransporteur() == userId
					&& f.getRole().equals("ROLE_TRANSPORTEUR")
					&& userType.equals("transporteur"))
				etatList.add(etat);
			else if (etat.getTypeNotification().equals("notification")
					&& etat.getDossier().getCommercial() != null
					&& etat.getDossier().getCommercial().getIdcommercial() == userId
					&& f.getRole().equals("ROLE_COMMERCIAL")
					&& userType.equals("commercial"))
				etatList.add(etat);
			}
		}
		return etatList;
	}
	
	@Override
	public int getNbrAffectedDossier(int userId, String userType) {
		List<Etat> etats = dao.getAllEtat();
		int nbr = 0;
		for (Etat etat : etats) {
			for (Iterator<UserRole> it = etat.getUser().getUserRole()
					.iterator(); it.hasNext();) {
				UserRole f = it.next();
				if (!etat.isLu()
						&& etat.getTypeNotification().equals("notification")
						&& etat.getDossier().getTransit() != null
						&& etat.getDossier().getTransit().getIdtransit() == userId
						&& f.getRole().equals("ROLE_TRANSIT")
						&& etat.getUser().getUserId() == userId
						&& userType.equals("transit"))
					nbr++;
				else if (!etat.isLu()
						&& etat.getTypeNotification().equals("notification")
						&& etat.getDossier().getTransporteur() != null
						&& etat.getDossier().getTransporteur().getIdtransporteur() == userId
						&& etat.getUser().getUserId() == userId
						&& userType.equals("transporteur"))
					nbr++;
				else if (!etat.isLu()
						&& etat.getTypeNotification().equals("notification")
						&& etat.getDossier().getCommercial() != null
						&& etat.getDossier().getCommercial().getIdcommercial() == userId
						&& etat.getUser().getUserId() == userId
						&& f.getRole().equals("ROLE_COMMERCIAL")
						&& userType.equals("commercial"))
					nbr++;
			}
		}
		return nbr;
	}

}

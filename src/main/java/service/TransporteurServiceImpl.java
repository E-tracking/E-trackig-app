package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.users.dao.UserDao;
import com.mkyong.users.dao.UserDaoImpl;
import com.mkyong.users.model.User;
import com.mkyong.users.model.UserRole;

import dao.Commercial;
import dao.Dossier;
import dao.DossierDao;
import dao.Transit;
import dao.Transporteur;
import dao.TransporteurDao;

public class TransporteurServiceImpl implements TransporteurService ,Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private TransporteurDao dao;
	@Autowired
	private DossierDao daoD;
	@Autowired
	private UserDao userdao;
	
	public void setDao(TransporteurDao dao) {
		this.dao = dao;
	}

	@Override
	public Transporteur Authentification(String login, String mdp) 
	{
		return dao.getTransporteur(login, mdp);
	}

	@Override
	public void Inscription(Transporteur C) 
	{
		dao.AddTransporteur(C);
	}

	@Override
	public List<User> getAllTransporteurs()
	{
	
		List<User> listeTransporteur = new ArrayList<User>();
		List<Transporteur> transporteurs = dao.getAllTransporteur();
		List<User> users = userdao.getAllUsers();
		for (User user : users) {
			for (Transporteur transporteur : transporteurs) {
				for (Iterator<UserRole> it = user.getUserRole().iterator(); it.hasNext();) {
					UserRole f = it.next();
					if (user.getUserId() == transporteur.getIdtransporteur() && f.getRole().equals("ROLE_TRANSPORTEUR"))
						listeTransporteur.add(user);
					}
			}
		}
		return listeTransporteur;
	}

	@Override
	public void DeleteTransporteur(int id) 
	{
		dao.DeleteTransporteur(id);
	}

	@Override
	public void UpdateTransporteur(Transporteur C) 
	{
		dao.UpdateTransporteur(C);
	}

	@Override
	public Transporteur getTransporteurById(int id) 
	{
		return dao.getTransporteur(id);
	}

	@Override
	public void CotationDossier(Double Cotation, int numDossier) 
	{
		Dossier D=daoD.getDossier(numDossier);
		D.setCotation(Cotation);
		daoD.UpdateDossier(D);
	}

	@Override
	public void UpdateEtatDossier(String etat, int numDossier)
	{
		Dossier D=daoD.getDossier(numDossier);
		D.setEtat(etat);
		daoD.UpdateDossier(D);
	}

	@Override
	public Boolean isTransportEnd(int numDossier) 
	{
		return daoD.getDossier(numDossier).getFintransport();
	}

	@Override
	public void TerminateTransport(int numDossier) 
	{
		daoD.getDossier(numDossier).setFintransport(true);
	}
	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public int LastTransporteurId() {
		List<Transporteur> List =dao.getAllTransporteur();
		int max=0;
		for(int i=0;i<List.size();i++)
		{
			if(List.get(i).getIdtransporteur()>max)
				max=List.get(i).getIdtransporteur();
		}
		return max;
	}
}

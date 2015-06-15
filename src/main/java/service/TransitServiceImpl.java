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
import dao.CommercialDao;
import dao.Dossier;
import dao.DossierDao;
import dao.Transit;
import dao.TransitDao;
import dao.Transporteur;

public class TransitServiceImpl implements TransitService ,Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private DossierDao daoD;
	@Autowired
	private TransitDao dao;
	@Autowired
	private UserDao userdao;

	public void setDao(TransitDao dao) {
		this.dao = dao;
	}

	@Override
	public Transit Authentification(String login, String mdp) 
	{
		return dao.getTransit(login, mdp);
	}

	@Override
	public void Inscription(Transit C) 
	{
		dao.AddTransit(C);
	}

	@Override
	public List<User> getAllTransits() 
	{
		List<User> listeTransit = new ArrayList<User>();
		List<Transit> transits = dao.getAllTransit();
		List<User> users = userdao.getAllUsers();
		for (User user : users) {
			for (Transit transporteur : transits) {
				for (Iterator<UserRole> it = user.getUserRole().iterator(); it.hasNext();) {
					UserRole f = it.next();
					if (user.getUserId() == transporteur.getIdtransit() && f.getRole().equals("ROLE_TRANSIT"))
						listeTransit.add(user);
					}
			}
		}
		return listeTransit;
	}

	@Override
	public void DeleteTransit(int id) 
	{
		dao.DeleteTransit(id);
	}

	@Override
	public void UpdateTransit(Transit C) 
	{
		dao.updateTransit(C);
	}

	@Override
	public Transit getTransit(int id) 
	{
		return dao.getTransit(id);
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

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	@Override
	public int LastTransitId() {
		List<Transit> List =dao.getAllTransit();
		int max=0;
		for(int i=0;i<List.size();i++)
		{
			if(List.get(i).getIdtransit()>max)
				max=List.get(i).getIdtransit();
		}
		return max;
	}
}

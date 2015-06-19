package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class DossierImpl implements DossierDao,Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void init()
	{
		System.out.println("Dao Dossier");
	}
	
	@Override
	public void AddDossier(Dossier C) 
	{
		Session session =  getSessionFactory().openSession();
		try {
		    session.getTransaction().begin();

		    // do some work
		    session.save(C);
		    session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}finally {
	        if (session.isOpen()) {
	            session.close();
	        }
	    }
		
	}

	@Override
	public Dossier getDossier(int id) 
	{
		Session session =  getSessionFactory().openSession();
		Dossier C = null;
		try {
		    session.getTransaction().begin();

		    // do some work
		    C = (Dossier) session.load(Dossier.class, id);
		    session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}finally {
	        if (session.isOpen()) {
	            session.close();
	        }
	    }
		
		return C;
	}
	
	@Override
	public List<Dossier> getAllDossiers() 
	{
		List<Dossier> dossiers;
		Session session =  getSessionFactory().getCurrentSession();
		dossiers = session.createQuery("from Dossier").list();
		return dossiers;
	}
	
	@Override
	public List<Dossier> getAllDossiersByUserId(int id,String userType) 
	{
		Session session =  getSessionFactory().openSession();
		List<Dossier> listeDossier = null;
		try {
		    session.getTransaction().begin();

		    // do some work
		    if(userType.equals("commercial")){
		    	listeDossier = session.createQuery("from Dossier d where d.commercial.idcommercial = :id").setParameter("id",id).list();
			}else if(userType.equals("transit")){
				listeDossier = session.createQuery("from Dossier d where d.transit.idtransit = :id").setParameter("id",id).list();
			}else{
				listeDossier = session.createQuery("from Dossier d where d.transporteur.idtransporteur = :id").setParameter("id",id).list();
			}
		    session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}finally {
	        if (session.isOpen()) {
	            session.close();
	        }
	    }
		return listeDossier;
	}
	
	@Override
	public void DeleteDossier(int id) 
	{
		Session session =  getSessionFactory().openSession();
		try {
		    session.getTransaction().begin();

		    // do some work
		    Dossier C = (Dossier) session.load(Dossier.class, id);
			session.delete(C);

		    session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}finally {
	        if (session.isOpen()) {
	            session.close();
	        }
	    }
		
	}

	@Override
	public void UpdateDossier(int id,Dossier d)
	{
		Session session =  getSessionFactory().getCurrentSession();
		try {
		    session.getTransaction().begin();

		    // do some work
		    Dossier help=new Dossier(d.getClient(), d.getTransporteur(), d.getPortByIdport(), d.getPortByPorIdport(), d.getMoyennetransport(), d.getTransit(), d.getCommercial(), d.getCotation(), d.getDate(), d.getEtat(), d.getIncoter(), d.getTypetransport(), d.getFintransport(), d.getValidationclient());
			session.merge(help);

		    session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}finally {
	        if (session.isOpen()) {
	            session.close();
	        }
	    }
		
	}
	
	@Override
	public void UpdateDossier(Dossier d)
	{
		
		Session session =  getSessionFactory().openSession();
		try {
		    session.getTransaction().begin();

		    // do some work
			session.merge(d);
		    session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}finally {
	        if (session.isOpen()) {
	            session.close();
	        }
	    }
		
	}

	@Override
	public void ChangerEtatDossier(int id, String etat) {
		
		Session session =  getSessionFactory().openSession();
		try {
		    session.getTransaction().begin();

		    // do some work
		    Dossier dossier = getDossier(id);
			dossier.setEtat(etat);
			session.merge(dossier);

		    session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}finally {
	        if (session.isOpen()) {
	            session.close();
	        }
	    }
		
		
	}

	@Override
	public List<Dossier> getDossiersRecents() {
		Session session =  getSessionFactory().openSession();
		List<Dossier> listeDossier = null;
		try {
		    session.getTransaction().begin();

		    // do some work
		    listeDossier = session.createQuery("from Dossier d order by date DESC").setMaxResults(5).list();
		    session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}finally {
	        if (session.isOpen()) {
	            session.close();
	        }
	    }
		return listeDossier;
	}
	

}

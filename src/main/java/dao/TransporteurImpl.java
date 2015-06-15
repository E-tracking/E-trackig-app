package dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class TransporteurImpl implements TransporteurDao ,Serializable
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
		System.out.println("Dao transporteur");
	}
	
	@Override
	public void AddTransporteur(Transporteur T) 
	{
		Session session =  getSessionFactory().openSession();
		try {
		    session.getTransaction().begin();

		    // do some work
		    session.save(T);
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
	public Transporteur getTransporteur(int id) 
	{
		Session session =  getSessionFactory().openSession();
		Transporteur C = null;
		try {
		    session.getTransaction().begin();

		    // do some work
		    C = (Transporteur) session.load(Transporteur.class, id);
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
	public Transporteur getTransporteur(String login, String mdp) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Criteria Cr=session.createCriteria(Transporteur.class);
		Cr.add(Restrictions.eq("login", login));
		Cr.add(Restrictions.eq("password", mdp));
		List R=Cr.list();
		Transporteur C=null;
		for (Iterator iterator = R.iterator(); iterator.hasNext();)
		{
			 C = (Transporteur) iterator.next();
			 break;
		}
		return C;
	}

	@Override
	public List<Transporteur> getAllTransporteur() 
	{
		Session session =  getSessionFactory().getCurrentSession();
		return session.createQuery("from Transporteur").list();
	}

	@Override
	public void DeleteTransporteur(int id) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Transporteur C = (Transporteur) session.load(Transporteur.class, id);
		session.delete(C);
	}

	@Override
	public void UpdateTransporteur(Transporteur T) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		session.merge(T);
	}

}

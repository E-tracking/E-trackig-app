package dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class TransitImpl implements TransitDao ,Serializable
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
		System.out.println("Dao Transit");
	}


	@Override
	public void AddTransit(Transit C) 
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
	public Transit getTransit(int id) 
	{
		Session session =  getSessionFactory().openSession();
		Transit C = null;
		try {
		    session.getTransaction().begin();

		    // do some work
		    C = (Transit) session.load(Transit.class, id);
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
	public Transit getTransit(String login, String mdp) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Criteria Cr=session.createCriteria(Transit.class);
		Cr.add(Restrictions.eq("login", login));
		Cr.add(Restrictions.eq("password", mdp));
		List R=Cr.list();
		Transit C=null;
		for (Iterator iterator = R.iterator(); iterator.hasNext();)
		{
			 C = (Transit) iterator.next();
			 break;
		}
		return C;
	}

	@Override
	public List<Transit> getAllTransit() 
	{
		Session session =  getSessionFactory().getCurrentSession();
		return session.createQuery("from Transit").list();
	}

	@Override
	public void DeleteTransit(int id) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Transit C = (Transit) session.load(Transit.class, id);
		session.delete(C);
	}

	@Override
	public void updateTransit(Transit T) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		session.merge(T);
	}

}

package dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CommercialImpl implements CommercialDao ,Serializable {
	
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
		System.out.println("Dao Commercial");
	}


	@Override
	public void AddCommercial(Commercial C) 
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
	public Commercial getCommercial(int id) 
	{
		Session session =  getSessionFactory().openSession();
		Commercial C = null;
		try {
		    session.getTransaction().begin();

		    // do some work
		    C = (Commercial) session.load(Commercial.class, id);
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
	public List<Commercial> getAllCommercial() 
	{
		Session session =  getSessionFactory().getCurrentSession();
		return session.createQuery("from Commercial").list();
	}

	@Override
	public void DeleteCommercial(int id) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Commercial C = (Commercial) session.load(Commercial.class, id);
		session.delete(C);
	}


	@Override
	public void UpdateCommercial(Commercial C)
	{
		Session session =  getSessionFactory().getCurrentSession();
		session.merge(C);
	}

	@Override
	public void notified(int id) {
		Session session =  getSessionFactory().getCurrentSession();
		Commercial C = (Commercial) session.load(Commercial.class, id);
		C.setNotification(true);
		session.merge(C);
	}

}

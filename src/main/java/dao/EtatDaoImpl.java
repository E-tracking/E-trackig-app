package dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.users.model.User;

public class EtatDaoImpl implements EtatDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEtat(Etat etat) {
		
		Session session =  getSessionFactory().openSession();
		try {
		    session.getTransaction().begin();

		    // do some work
			session.save(etat);
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
	public List<Etat> getAllEtat() {
		Session session =  getSessionFactory().openSession();
		List<Etat> etats = null;
		try {
		    session.getTransaction().begin();

		    // do some work
		    etats = session.createQuery("from Etat order by date DESC").list();
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
		return etats;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Etat getEtat(int idEtat) {
		Session session =  getSessionFactory().openSession();
		List<Etat> etats = null;
		try {
		    session.getTransaction().begin();

		    // do some work
		    etats = session.createQuery("from Etat where idEtat = :id").setParameter("id",idEtat).list();
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
		return etats.get(0);
	}

	@Override
	public void update(Etat etat) {
		Session session =  getSessionFactory().openSession();
		List<Etat> etats = null;
		try {
		    session.getTransaction().begin();

		    // do some work
		    session.update(etat);
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

	

}

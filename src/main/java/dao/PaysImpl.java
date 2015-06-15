package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PaysImpl implements PaysDao ,Serializable
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
		System.out.println("Dao Pays");
	}
	
	@Override
	public Pays getPays(int id) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Pays C = (Pays) session.load(Pays.class, id);
		return C;
	}

	@Override
	public List<Pays> getAllPays() 
	{
		Session session =  getSessionFactory().getCurrentSession();
		return session.createQuery("from Pays").list();
	}

	@Override
	public void AddPays(Pays P) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		session.save(P);
	}

	@Override
	public void updatePays(Pays P) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		session.merge(P);
	}

	@Override
	public void deletePays(int id) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Pays C = (Pays) session.load(Pays.class, id);
		session.delete(C);
	}

}

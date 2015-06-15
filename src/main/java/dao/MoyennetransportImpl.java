package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MoyennetransportImpl implements MoyennetransportDao,Serializable
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
		System.out.println("Dao Moyennetransport");
	}
	
	@Override
	public List<Moyennetransport> getAllMoyenne()
	{
		Session session =  getSessionFactory().getCurrentSession();
		return session.createQuery("from Moyennetransport").list();
	}

	@Override
	public Moyennetransport getMoyennetransport(int id)
	{
		Session session =  getSessionFactory().getCurrentSession();
		Moyennetransport C = (Moyennetransport) session.load(Moyennetransport.class, id);
		return C;
	}

	@Override
	public void addMoyennetransport(Moyennetransport M)
	{
		Session session =  getSessionFactory().getCurrentSession();
		session.save(M);
	}

	@Override
	public void deleteMoyennetransport(int id) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Moyennetransport C = (Moyennetransport) session.load(Moyennetransport.class, id);
		session.delete(C);
	}

	@Override
	public void updateMoyennetransport(Moyennetransport M) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		session.merge(M);
	}

}

package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PortImpl implements PortDao ,Serializable
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
		System.out.println("Dao Port");
	}
	
	@Override
	public Port getPort(int id)
	{
		Session session =  getSessionFactory().getCurrentSession();
		Port C = (Port) session.load(Port.class, id);
		return C;
	}

	@Override
	public List<Port> getAllPorts()
	{
		Session session =  getSessionFactory().getCurrentSession();
		return session.createQuery("from Port").list();
	}

	@Override
	public void AddPort(Port P)
	{
		Session session =  getSessionFactory().getCurrentSession();
		session.save(P);
	}

	@Override
	public void updatePort(Port P) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		session.merge(P);
	}

	@Override
	public void deletePort(int id) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Port C = (Port) session.load(Port.class, id);
		session.delete(C);
	}

}

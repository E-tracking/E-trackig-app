package dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientImpl implements ClientDao,Serializable 
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
		System.out.println("Dao Client");
	}

	@Override
	public Client getClient(int id) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Client C = (Client) session.load(Client.class, id);
		return C;
	}

	@Override
	public Client getClient(String login, String mdp)
	{
		Session session =  getSessionFactory().getCurrentSession();
		Criteria Cr=session.createCriteria(Client.class);
		Cr.add(Restrictions.eq("login", login));
		Cr.add(Restrictions.eq("password", mdp));
		List R=Cr.list();
		Client C=null;
		for (Iterator iterator = R.iterator(); iterator.hasNext();)
		{
			 C = (Client) iterator.next();
			 break;
		}
		return C;
	}

	@Override
	public List<Client> getAllClients() 
	{
		List<Client> clients;
		Session session =  getSessionFactory().getCurrentSession();
		clients = session.createQuery("from Client").list();
		return clients;
	}

	@Override
	public void newClient(Client C) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		session.save(C);
	}

	@Override
	public void UpdateClient(Client C) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		session.merge(C);
	}

	@Override
	public void DeleteClient(int id) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Client C = (Client) session.load(Client.class, id);
		session.delete(C);
	}

}

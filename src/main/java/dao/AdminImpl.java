package dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminImpl implements AdminDao,Serializable
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
		System.out.println("Dao Admin");
	}

	@Override
	public Admin getAdmin(int id) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Admin C = (Admin) session.get(Admin.class, id);
		return C;
	}

	@Override
	public Admin getAdmin(String login, String mdp) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Criteria Cr=session.createCriteria(Admin.class);
		Cr.add(Restrictions.eq("login", login));
		Cr.add(Restrictions.eq("password", mdp));
		List R=Cr.list();
		Admin C=null;
		for (Iterator iterator = R.iterator(); iterator.hasNext();)
		{
			 C = (Admin) iterator.next();
			 break;
		}
		return C;
	}

}

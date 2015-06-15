package com.mkyong.users.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.users.model.UserRole;

public class UserRoleDaoImpl implements UserRoleDao ,Serializable{

private static final long serialVersionUID = 1L;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void AddUserRole(UserRole u) 
	{
		Session session =  getSessionFactory().openSession();
		try 
		{	
			session.getTransaction().begin();
			session.save(u);
			session.getTransaction().commit();
		}
		catch (RuntimeException e) 
		{
			session.getTransaction().rollback();
		    throw e;
		}
		finally 
		{
	        if (session.isOpen()) 
	        {
	            session.close();
	        }
	    }
	}

}

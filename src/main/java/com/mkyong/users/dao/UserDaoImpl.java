package com.mkyong.users.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.users.model.User;
import com.mkyong.users.model.UserRole;

public class UserDaoImpl implements UserDao ,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();
		Session session = getSessionFactory().openSession();
		
		try {
		    session.getTransaction().begin();

		    // do some work
		    users = session.createQuery("from User where username=?")
					.setParameter(0, username).list();
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
		if (users.size() > 0) {
			
			return users.get(0);
		} else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public int findUserId(String username) {
		
		List<User> users = new ArrayList<User>();
		Session session = getSessionFactory().openSession();
		try {
		    session.getTransaction().begin();

		    // do some work
		    users = session.createQuery("from User where username=?")
					.setParameter(0, username).list();
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
		if (users.size() > 0) {
			return users.get(0).getUserId();
		} else
			return 0;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		List<User> users = null;
		Session session = getSessionFactory().openSession();
		try {
		    session.getTransaction().begin();
		    // do some work
		    users = session.createQuery("from User").list();
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
		return users;
	}
	
	@Override
	public void AddUSer(User U)
	{
		Session session =  getSessionFactory().openSession();
		try 
		{	
			session.getTransaction().begin();
			session.save(U);
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
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")
	public User findUserByUserId(int userId,String userType) {
		List<User> users = new ArrayList<User>();
		Session session = getSessionFactory().openSession();
		try {
		    session.getTransaction().begin();
		    // do some work
		    users = session.createQuery("from User").list();
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
		if (users.size() > 0) {
			for (User user : users) {
				for (Iterator<UserRole> it = user.getUserRole().iterator(); it.hasNext(); ) {
			        UserRole f = it.next();
			        if (user.getUserId() == userId  && f.getRole().equals("ROLE_TRANSIT") && userType.equals("transit"))
			        	return user;
			        else if(user.getUserId() == userId && f.getRole().equals("ROLE_TRANSPORTEUR") && userType.equals("transporteur"))
						return user;
					else if(user.getUserId() == userId && f.getRole().equals("ROLE_COMMERCIAL") && userType.equals("commercial"))
						return user;
			    }
			}
		}
		return null;
	}

	@Override
	public void deleteUser(User user) {
		Session session =  getSessionFactory().openSession();
		try 
		{	
			session.getTransaction().begin();
			session.delete(user);
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

	@Override
	public void update(User user) {
		Session session = getSessionFactory().openSession();
		
		try {
		    session.getTransaction().begin();
		    // do some work
		    session.update(user);
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
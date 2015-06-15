package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentImpl implements CommentDao ,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void AddComment(Comment C) {
		
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
	public Comment getComment(int id) {
		Session session =  getSessionFactory().openSession();
		Comment C = null;
		try {
		    session.getTransaction().begin();

		    // do some work
		    C = (Comment) session.load(Comment.class, id);
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
	public List<Comment> getAllComment() {
		Session session =  getSessionFactory().openSession();
		List<Comment> commentsList = new ArrayList<Comment>();
		try {
		    session.getTransaction().begin();

		    // do some work
		    commentsList =  session.createQuery("from Comment order by IDCOMMENT DESC").list();
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
		
		return commentsList;
	}

	@Override
	public void DeleteComment(int id) {
		Session session =  getSessionFactory().getCurrentSession();
		try {
		    session.getTransaction().begin();

		    // do some work
			Comment C = (Comment) session.load(Comment.class, id);
			session.delete(C);

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
	public void UpdateComment(Comment C) {
		Session session =  getSessionFactory().getCurrentSession();
		
		try {
		    session.getTransaction().begin();

		    // do some work
		    session.merge(C);
		    session.delete(C);

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

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

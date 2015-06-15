package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.Comment;
import dao.CommentDao;

public class CommentServiceImpl implements CommentService ,Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CommentDao dao;
	
	@Override
	public void AddComment(Comment C) {
		dao.AddComment(C);
	}
	@Override
	public Comment getComment(int id) {
		return dao.getComment(id);
	}
	@Override
	public List<Comment> getAllComment() {
		return dao.getAllComment();
	}
	@Override
	public void DeleteComment(int id) {
		dao.DeleteComment(id);
	}
	@Override
	public void UpdateComment(Comment C) {
		dao.UpdateComment(C);
	}
	@Override
	public List<Comment> getCommentbyId(int idDossier, int userId) {
		
		List<Comment> comments = dao.getAllComment();
		List<Comment> commentsList = new ArrayList<Comment>();
		if(comments != null){
			for (Comment comment : comments) {
				if(comment.getDossier().getNumdossier() == idDossier)
					commentsList.add(comment);
			}
			
			return commentsList;
		}
		return null;
	}
	
	public CommentDao getDao() {
		return dao;
	}
	public void setDao(CommentDao dao) {
		this.dao = dao;
	}

	
}

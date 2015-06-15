package service;

import java.util.List;

import dao.Comment;

public interface CommentService
{
	public void AddComment(Comment C);
	public Comment getComment(int id);
	public List<Comment> getAllComment();
	public void DeleteComment(int id);
	public void UpdateComment(Comment C);
	public List<Comment> getCommentbyId(int idDossier, int userId);
}

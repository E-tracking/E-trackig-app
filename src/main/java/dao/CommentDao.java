package dao;

import java.util.List;

public interface CommentDao 
{
	public void AddComment(Comment C);
	public Comment getComment(int id);
	public List<Comment> getAllComment();
	public void DeleteComment(int id);
	public void UpdateComment(Comment C);
}

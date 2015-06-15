package dao;

public interface AdminDao 
{
	public Admin getAdmin(int id);
	public Admin getAdmin(String login,String mdp);
}

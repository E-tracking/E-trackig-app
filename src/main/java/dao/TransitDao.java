package dao;

import java.util.List;

public interface TransitDao 
{
	public void AddTransit(Transit C);
	public Transit getTransit(int id);
	public Transit getTransit(String login,String mdp);
	public List<Transit> getAllTransit();
	public void DeleteTransit(int id);
	public void updateTransit(Transit T);
}

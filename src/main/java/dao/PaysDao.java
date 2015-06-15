package dao;

import java.util.List;

public interface PaysDao 
{
	public Pays getPays(int id);
	public List<Pays> getAllPays();
	public void AddPays(Pays P);
	public void updatePays(Pays P);
	public void deletePays(int id);
}

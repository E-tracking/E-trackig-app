package service;

import java.util.List;
import dao.Pays;

public interface PaysService 
{
	public void addPays(Pays P);
	public void update(Pays P);
	public void delete(int id);
	public Pays getPays(int id);
	public List<Pays> getAllPays();
}

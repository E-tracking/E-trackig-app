package dao;

import java.util.List;

import com.mkyong.users.model.User;

public interface EtatDao {
	public void addEtat(Etat etat);
	public void update(Etat etat);
	public List<Etat> getAllEtat();
	public Etat getEtat(int idEtat);
}

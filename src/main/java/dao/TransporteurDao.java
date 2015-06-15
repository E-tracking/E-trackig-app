package dao;

import java.util.List;

public interface TransporteurDao 
{
	public void AddTransporteur(Transporteur T);
	public Transporteur getTransporteur(int id);
	public Transporteur getTransporteur(String login,String mdp);
	public List<Transporteur> getAllTransporteur();
	public void DeleteTransporteur(int id);
	public void UpdateTransporteur(Transporteur T);
}

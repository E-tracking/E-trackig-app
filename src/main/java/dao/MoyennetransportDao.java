package dao;

import java.util.List;

public interface MoyennetransportDao 
{
	public List<Moyennetransport> getAllMoyenne();
	public Moyennetransport getMoyennetransport(int id);
	public void addMoyennetransport(Moyennetransport M);
	public void deleteMoyennetransport(int id);
	public void updateMoyennetransport(Moyennetransport M);
}

package service;

import java.util.List;

import dao.Moyennetransport;

public interface MoyennetransportService 
{
	public Moyennetransport getMoyennetransport(int id);
	public List<Moyennetransport> getAllMoyennetransport();
	public void updateMoyennetransport(Moyennetransport M);
	public void deleteMoyennetransport(int id);
	public void addMoyennetransport(Moyennetransport M);
}

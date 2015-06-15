package service;

import java.io.Serializable;
import java.util.List;

import dao.Moyennetransport;
import dao.MoyennetransportDao;

public class MoyennetransportServiceImpl implements MoyennetransportService ,Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MoyennetransportDao dao;
	
	public void setDao(MoyennetransportDao dao) 
	{
		this.dao = dao;
	}

	@Override
	public Moyennetransport getMoyennetransport(int id)
	{
		return dao.getMoyennetransport(id);
	}

	@Override
	public List<Moyennetransport> getAllMoyennetransport() 
	{
		return dao.getAllMoyenne();
	}

	@Override
	public void updateMoyennetransport(Moyennetransport M)
	{
		dao.updateMoyennetransport(M);
	}

	@Override
	public void deleteMoyennetransport(int id)
	{
		dao.deleteMoyennetransport(id);
	}

	@Override
	public void addMoyennetransport(Moyennetransport M) 
	{
		dao.addMoyennetransport(M);
	}

}

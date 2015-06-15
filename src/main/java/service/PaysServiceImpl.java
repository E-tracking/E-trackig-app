package service;

import java.io.Serializable;
import java.util.List;

import dao.Pays;
import dao.PaysDao;

public class PaysServiceImpl implements PaysService,Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PaysDao dao;
	
	public void setDao(PaysDao dao)
	{
		this.dao = dao;
	}

	@Override
	public void addPays(Pays P) 
	{
		dao.AddPays(P);
	}

	@Override
	public void update(Pays P) 
	{
		dao.updatePays(P);
	}

	@Override
	public void delete(int id)
	{
		dao.deletePays(id);
	}

	@Override
	public Pays getPays(int id) 
	{
		return dao.getPays(id);
	}

	@Override
	public List<Pays> getAllPays() 
	{
		return dao.getAllPays();
	}

}

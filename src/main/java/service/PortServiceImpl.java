package service;

import java.io.Serializable;
import java.util.List;

import dao.Port;
import dao.PortDao;

public class PortServiceImpl implements PortService ,Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PortDao dao;
	
	public void setDao(PortDao dao)
	{
		this.dao = dao;
	}

	@Override
	public void addPort(Port P) 
	{
		dao.AddPort(P);
	}

	@Override
	public void update(Port P) 
	{
		dao.updatePort(P);
	}

	@Override
	public void delete(int id) 
	{
		dao.deletePort(id);
	}

	@Override
	public Port getPort(int id) 
	{
		return dao.getPort(id);
	}

	@Override
	public List<Port> getAllPorts() 
	{
		return dao.getAllPorts();
	}

}

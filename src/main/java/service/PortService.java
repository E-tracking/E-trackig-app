package service;

import java.util.List;
import dao.Port;

public interface PortService 
{
	public void addPort(Port P);
	public void update(Port P);
	public void delete(int id);
	public Port getPort(int id);
	public List<Port> getAllPorts();
}

package dao;

import java.util.List;

public interface PortDao 
{
	public Port getPort(int id);
	public List<Port> getAllPorts();
	public void AddPort(Port P);
	public void updatePort(Port P);
	public void deletePort(int id);
}

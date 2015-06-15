package dao;

import java.util.List;

public interface CommercialDao 
{
	public void AddCommercial(Commercial C);
	public Commercial getCommercial(int id);
	public List<Commercial> getAllCommercial();
	public void DeleteCommercial(int id);
	public void UpdateCommercial(Commercial C);
	public void notified(int id);
}

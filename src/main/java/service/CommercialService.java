package service;

import java.util.List;

import com.mkyong.users.model.User;

import dao.Commercial;

public interface CommercialService 
{
	public Commercial getCommercialByIf(int id);
	public void Inscription(Commercial C);
	public List<User> getAllCommercials();
	public void DeleteCommercial(int id);
	public void UpdateCommercial(Commercial C);
	public int LastCommercialId();
}

package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.users.dao.UserDao;
import com.mkyong.users.dao.UserDaoImpl;
import com.mkyong.users.model.User;
import com.mkyong.users.model.UserRole;

import dao.Commercial;
import dao.CommercialDao;

public class CommercialServiceImpl implements CommercialService ,Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private CommercialDao dao;
	@Autowired
	private UserDao userdao;
	
	
	public void setDao(CommercialDao dao) {
		this.dao = dao;
	}

	

	@Override
	public void Inscription(Commercial C) 
	{
		dao.AddCommercial(C);
	}

	@Override
	public List<User> getAllCommercials() 
	{
		
		List<User> listeCommercials = new ArrayList<User>();
		List<Commercial> commercials = dao.getAllCommercial();
		List<User> users = userdao.getAllUsers();
		for (User user : users) {
			for (Commercial commercial : commercials) {
				for (Iterator<UserRole> it = user.getUserRole().iterator(); it.hasNext();) {
					UserRole f = it.next();
					if (user.getUserId() == commercial.getIdcommercial() && f.getRole().equals("ROLE_COMMERCIAL"))
						listeCommercials.add(user);
					}
			}
		}
		return listeCommercials;
	}

	@Override
	public void DeleteCommercial(int id) 
	{
		dao.DeleteCommercial(id);
	}

	@Override
	public void UpdateCommercial(Commercial C) 
	{
		dao.UpdateCommercial(C);
	}

	@Override
	public Commercial getCommercialByIf(int id) 
	{
		return dao.getCommercial(id);
	}



	public UserDao getUserdao() {
		return userdao;
	}



	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}


	@Override
	public int LastCommercialId() 
	{
		List<Commercial> List =dao.getAllCommercial();
		int max=0;
		for(int i=0;i<List.size();i++)
		{
			if(List.get(i).getIdcommercial()>max)
				max=List.get(i).getIdcommercial();
		}
		return max;
	}


}

package controle;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.AdminService;
import service.ClientService;
import service.CommercialService;
import service.DossierService;
import service.MoyennetransportService;
import service.PortService;
import service.TransitService;
import service.TransporteurService;

import com.mkyong.users.dao.UserDao;
import com.mkyong.users.model.User;

import dao.Commercial;

@Controller
@Scope("session")
public class AdminController implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	CommercialService serviceCom;
	
	@Autowired
	TransitService serviceTs;
	
	@Autowired
	AdminService serviceAdmin;
	
	@Autowired
	TransporteurService serviceTr;
	
	@Autowired
	DossierService serviceD;
	
	@Autowired
	MoyennetransportService serviceM;
	
	@Autowired
	PortService serviceP;
	
	@Autowired
	ClientService serviceCl;
	
	@Autowired
    UserDao userDao;
	
	

	@RequestMapping(value="/Admin/index")
	public String View(Model m,HttpServletRequest req)
	{
		
		m.addAttribute("listeCommercial",serviceCom.getAllCommercials());
		m.addAttribute("listeTransit",serviceTs.getAllTransits());
		m.addAttribute("listeTransporteur",serviceTr.getAllTransporteurs());
		return "Admin/profilAdmin";
	}
	
	
	@RequestMapping(value="/Admin/AdminTransitView")
	public String TransitView(Model m,HttpServletRequest req)
	{
		
			m.addAttribute("IsCommercialViewActive", "");
			m.addAttribute("IsTransitViewActive", "active");
			m.addAttribute("IsTransporteurViewActive", "");
			m.addAttribute("listeTransit",serviceTs.getAllTransits());
			return "Admin/AdminTransitView";
	}
	
	
	@RequestMapping(value="/Admin/AdminCommercialView")
	public String CommercialView(Model m,HttpServletRequest req)
	{
		
			m.addAttribute("IsCommercialViewActive", "active");
			m.addAttribute("IsTransitViewActive", "");
			m.addAttribute("IsTransporteurViewActive", "");
			m.addAttribute("listeCommercial",serviceCom.getAllCommercials());
			return "Admin/AdminCommercialView";
	}
	
	
	@RequestMapping(value="/Admin/AdminTransporterView")
	public String TransporterView(Model m,HttpServletRequest req)
	{
		
			m.addAttribute("IsCommercialViewActive", "");
			m.addAttribute("IsTransitViewActive", "");
			m.addAttribute("IsTransporteurViewActive", "active");
			m.addAttribute("listeTransporteur",serviceTr.getAllTransporteurs());
			return "Admin/AdminTransporterView";
	}
	
	@RequestMapping(value="/Admin/deleteCom")
	public String DeleteCom(Model m,@RequestParam int idC,@RequestParam String username,HttpServletRequest request)
	{
		serviceD.removeAffetation(idC,"commercial");
		serviceCom.DeleteCommercial(idC);
		List<User> users = userDao.getAllUsers();
		for (User user : users) {
			if(user.getUserId() == idC)
				userDao.deleteUser(user);
		}
		m.addAttribute("listeCommercial",serviceCom.getAllCommercials());
		m.addAttribute("listeTransit",serviceTs.getAllTransits());
		m.addAttribute("listeTransporteur",serviceTr.getAllTransporteurs());
		return "redirect:AdminCommercialView";
	}
	
	
	@RequestMapping(value="/Admin/deleteTr")
	public String DeleteTran(Model m,@RequestParam int idT,HttpServletRequest request)
	{
		serviceD.removeAffetation(idT,"transit");
		serviceTs.DeleteTransit(idT);
		List<User> users = userDao.getAllUsers();
		for (User user : users) {
			if(user.getUserId() == idT)
				userDao.deleteUser(user);
		}
		m.addAttribute("listeCommercial",serviceCom.getAllCommercials());
		m.addAttribute("listeTransit",serviceTs.getAllTransits());
		m.addAttribute("listeTransporteur",serviceTr.getAllTransporteurs());
		return "Admin/profilAdmin";
	}
	
	
	@RequestMapping(value="/Admin/deleteT")
	public String DeleteTransp(Model m,@RequestParam int id,HttpServletRequest request)
	{
		serviceD.removeAffetation(id,"transporteur");
		serviceTr.DeleteTransporteur(id);
		List<User> users = userDao.getAllUsers();
		for (User user : users) {
			if(user.getUserId() == id)
				userDao.deleteUser(user);
		}
		m.addAttribute("listeCommercial",serviceCom.getAllCommercials());
		m.addAttribute("listeTransit",serviceTs.getAllTransits());
		m.addAttribute("listeTransporteur",serviceTr.getAllTransporteurs());
		return "Admin/profilAdmin";
	}
	
	@RequestMapping(value="/Admin/createUser")
	public String CreateUser(Model m,Commercial C,@RequestParam String role)
	{
		return "";
	}
	
	@RequestMapping(value="/Admin/validerUser")
	public String validerUser(Model m,@RequestParam String username,HttpServletRequest request)
	{
		User user = userDao.findByUserName(username);
		user.setEnabled(true);
		userDao.update(user);
		return "redirect:index";
	}
	
	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}







package controle;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.AdminService;
import service.CommercialService;
import service.DossierService;
import service.EtatService;
import service.TransitService;
import service.TransporteurService;

import com.mkyong.users.dao.UserDao;
import com.mkyong.users.dao.UserRoleDao;
import com.mkyong.users.model.User;
import com.mkyong.users.model.UserRole;

import dao.Admin;
import dao.Commercial;
import dao.Transit;
import dao.Transporteur;

@Controller
@Scope("session")
public class AppController implements Serializable
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
    UserDao userDao;
	
	@Autowired
	EtatService serviceEtat;
	
	@Autowired
    UserRoleDao userRoleDao;
	
	@RequestMapping(value="/votreRole")
	public String pageIndex(Model m,@RequestParam String role,HttpServletRequest request,HttpServletResponse Response)
	{
		
		Commercial commercial;
		Transit transit;
		Transporteur transporteur;
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			if(role.equals("Commercial")){
				commercial = serviceCom.getCommercialByIf(userDao.findUserId(userDetail.getUsername()));
				request.getSession().setAttribute("Commercial", commercial);
				request.getSession().setAttribute("user", userDao.findByUserName(userDetail.getUsername()));
				return "redirect:/Commercial/index";
			}else if(role.equals("Admin")){
				request.getSession().setAttribute("userAdmin", userDao.findByUserName(userDetail.getUsername()));
				return "redirect:/Admin/index";
			}else if(role.equals("Transit")){
				transit = serviceTs.getTransit(userDao.findUserId(userDetail.getUsername()));
				request.getSession().setAttribute("Transit", transit);
				request.getSession().setAttribute("user", userDao.findByUserName(userDetail.getUsername()));
				return "redirect:/Transit/index";
			}else if(role.equals("Transporteur")){
				transporteur = serviceTr.getTransporteurById(userDao.findUserId(userDetail.getUsername()));
				request.getSession().setAttribute("Transporteur", transporteur);
				request.getSession().setAttribute("user", userDao.findByUserName(userDetail.getUsername()));
				return "redirect:/Transporteur/index";
			}
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value="/whoami")
	public String pageIndex(Model m,HttpServletRequest request,HttpServletResponse Response)
	{
		return "whoami";
	}
	
	@RequestMapping(value="/summary")
	public String Summary(Model m,HttpServletRequest req,HttpServletResponse Response)
	{
		m.addAttribute("listeDossiers",serviceD.getAllDossiers());
		
		
		return "Summary";
	}
	
	@RequestMapping(value="/affichage")
	public String affichage(Model m,HttpServletRequest req)
	{
		m.addAttribute("listeDossiers",serviceD.getAllDossiers());
		return "affichage";
	}
	
	@RequestMapping(value="/createUser")
	public String CreateUser(Model m,User U,@RequestParam String role)
	{
		if(userDao.findByUserName(U.getUsername()) == null){
			if(role.equals("Commercial"))
			{
				serviceCom.Inscription(new Commercial());
				int id=serviceCom.LastCommercialId();
				U.setUserId(id);
				U.setEnabled(false);
				
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashed = passwordEncoder.encode(U.getPassword());
				U.setPassword(hashed);
				
				userDao.AddUSer(U);
				UserRole userRole=new UserRole(U, "ROLE_COMMERCIAL");
				userRoleDao.AddUserRole(userRole);
				
			}
			if(role.equals("Transit"))
			{
				serviceTs.Inscription(new Transit());
				int id=serviceTs.LastTransitId();
				U.setUserId(id);
				U.setEnabled(false);
				
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashed = passwordEncoder.encode(U.getPassword());
				U.setPassword(hashed);
				
				userDao.AddUSer(U);
				UserRole userRole=new UserRole(U, "ROLE_TRANSIT");
				userRoleDao.AddUserRole(userRole);
			}
			if(role.equals("Transporteur"))
			{
				serviceTr.Inscription(new Transporteur());
				int id=serviceTr.LastTransporteurId();
				U.setUserId(id);
				U.setEnabled(false);
				
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashed = passwordEncoder.encode(U.getPassword());
				U.setPassword(hashed);
				
				userDao.AddUSer(U);
				UserRole userRole=new UserRole(U, "ROLE_TRANSPORTEUR");
				userRoleDao.AddUserRole(userRole);
			}
		}
		return "redirect:/login";
	}
	
	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	@RequestMapping(value="/inscription")
	public String inscription(Model m,HttpServletRequest req)
	{
		return "inscription";
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	
	
}

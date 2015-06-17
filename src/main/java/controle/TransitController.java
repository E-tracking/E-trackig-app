package controle;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.AdminService;
import service.ClientService;
import service.CommentService;
import service.CommercialService;
import service.DossierService;
import service.EtatService;
import service.MoyennetransportService;
import service.PortService;
import service.SendMailSSL;
import service.TransitService;
import service.TransporteurService;

import com.mkyong.users.dao.UserDao;
import com.mkyong.users.model.User;

import dao.Client;
import dao.Comment;
import dao.Dossier;
import dao.Etat;
import dao.Transit;

@Controller
@Scope("session")
public class TransitController implements Serializable
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
	CommentService serviceCmt;
	
	@Autowired
	EtatService serviceEtat;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/Transit/index")
	public String indexView(Model m,HttpServletRequest req)
	{
		HttpSession s=req.getSession();
		Transit C=(Transit) s.getAttribute("Transit");
		User user=(User) s.getAttribute("user");
		m.addAttribute("found",C);
		m.addAttribute("user",user);
		m.addAttribute("listeClients",serviceCl.getAllClient());
		m.addAttribute("changementsEtat",serviceEtat.getAllchangedEtat(user,"transit"));
		m.addAttribute("affectations",serviceEtat.getAllAffectedDossier(user.getUserId(),"transit"));
		
		int nbrAffectation = serviceEtat.getNbrAffectedDossier(user.getUserId(),"transit");
		if(nbrAffectation != 0)
			m.addAttribute("nbrAffectations",nbrAffectation);
		int nbrChangement = serviceEtat.getNbrChangementDossier(user,"transit");
		if(nbrChangement != 0)
			m.addAttribute("nbrChangements",nbrChangement);
		
		return "Transit/TransitProfil";
	}
	
	@RequestMapping(value="/Transit/dossiers")
	public String DossiersView(Model m,HttpServletRequest req)
	{
		HttpSession s=req.getSession();
		Transit C=(Transit) s.getAttribute("Transit");
		m.addAttribute("found",C);
		User user=(User) s.getAttribute("user");
 		m.addAttribute("user",user);
		m.addAttribute("notifications",serviceEtat.getAllchangedEtat(user,"transit"));
		m.addAttribute("listeDossiers",serviceD.getAllDossiersByUserId(C.getIdtransit(),"transit"));
		m.addAttribute("dossierReccents",serviceD.getDossiersRecents());
		m.addAttribute("changementsEtat",serviceEtat.getAllchangedEtat(user,"transit"));
		m.addAttribute("affectations",serviceEtat.getAllAffectedDossier(user.getUserId(),"transit"));
		
		int nbrAffectation = serviceEtat.getNbrAffectedDossier(user.getUserId(),"transit");
		if(nbrAffectation != 0)
			m.addAttribute("nbrAffectations",nbrAffectation);
		int nbrChangement = serviceEtat.getNbrChangementDossier(user,"transit");
		if(nbrChangement != 0)
			m.addAttribute("nbrChangements",nbrChangement);
		return "Transit/dossiers";
	}
	@RequestMapping(value="/Transit/dossiersAttente")
	public String DossiersAttenteView(Model m,HttpServletRequest req)
	{
		HttpSession s=req.getSession();
		Transit C=(Transit) s.getAttribute("Transit");
		m.addAttribute("found",C);
		User user=(User) s.getAttribute("user");
		m.addAttribute("user",user);
		m.addAttribute("notifications",serviceEtat.getAllchangedEtat(user,"transit"));
		m.addAttribute("listeDossiers",serviceD.getAllDossiersAttente(C.getIdtransit(),"transit"));
		m.addAttribute("dossierReccents",serviceD.getDossiersRecents());
		m.addAttribute("changementsEtat",serviceEtat.getAllchangedEtat(user,"transit"));
		m.addAttribute("affectations",serviceEtat.getAllAffectedDossier(user.getUserId(),"transit"));
		
		int nbrAffectation = serviceEtat.getNbrAffectedDossier(user.getUserId(),"transit");
		if(nbrAffectation != 0)
			m.addAttribute("nbrAffectations",nbrAffectation);
		int nbrChangement = serviceEtat.getNbrChangementDossier(user,"transit");
		if(nbrChangement != 0)
			m.addAttribute("nbrChangements",nbrChangement);
		return "Transit/dossiersAttente";
	}
	
	@RequestMapping(value="/Transit/supprimerClient")
	public String supprimerClientView(Model m,HttpServletRequest req,HttpServletResponse httpResponse,
			@RequestParam int idClient
	)
	{
		serviceCl.deleteClient(idClient);
 	   	return "redirect:index";
	}
	
	@RequestMapping(value="/Transit/supprimerDossier")
	public String supprimerDossierView(Model m,HttpServletRequest req,HttpServletResponse httpResponse,
			@RequestParam int idDossier
			)
	{
		serviceD.deleteDossier(idDossier);
		return "redirect:dossiers";
	}
	
	@RequestMapping(value="/Transit/ModifClient")
	public String ModClientView(Model m,HttpServletRequest req,HttpServletResponse httpResponse,
			@RequestParam int idClient
	)
	{
		m.addAttribute("D",serviceCl.getClient(idClient));
		return "Transit/modifierClient";
	}
	
	@RequestMapping(value="/Transit/updateClient")
	public String updateclient(Model m,Client C) 
	{
		serviceCl.updateClient(C);
		return "redirect:index";
	}
	
	@RequestMapping(value="/Transit/AjouterClient")
	public String AjouterClient(Model m,HttpServletRequest req,HttpServletResponse httpResponse
	)
	{
		return "Transit/AjouterClient";
	}
	
	@RequestMapping(value="/Transit/addClient")
	public String AddClient(Model m,Client C) 
	{
		serviceCl.inscription(C);
		return "redirect:index";
	}
	
	@RequestMapping(value="/Transit/ajouterDossier")
	public ModelAndView AjouerDossierView(Model m,HttpServletRequest req,
			@RequestParam String clientId,
			@RequestParam String moyenneTransportId,
			@RequestParam String typeTransport,
			@RequestParam String portDepartId,
			@RequestParam String portArriveeId,
			@RequestParam double cotation,
			@RequestParam int delaiTransit,
			@RequestParam String etat,
			@RequestParam String date,
			@RequestParam String incoterm)
	{
//		m.addAttribute("listeTransporteur",serviceTr.getAllTransporteurs());
//		m.addAttribute("listeCommercial",serviceCom.getAllCommercials());
//		m.addAttribute("listeMoyenneTransport",serviceM.getAllMoyennetransport());
//		m.addAttribute("listePort",serviceP.getAllPorts());
//		m.addAttribute("listeClient",serviceCl.getAllClient());
		Date d = null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		HttpSession s=req.getSession();
		User user=(User) s.getAttribute("user");
		Boolean validationClient = false;
		Boolean fintransport = false;
		Dossier dossier = new Dossier(delaiTransit, serviceCl.getClient(Integer.parseInt(clientId)),
				serviceP.getPort(Integer.parseInt(portDepartId)),
				serviceP.getPort(Integer.parseInt(portArriveeId)),
				serviceM.getMoyennetransport(Integer.parseInt(moyenneTransportId)),
				cotation,d,etat, incoterm,typeTransport,serviceTs.getTransit(user.getUserId()),
				validationClient,fintransport
		);
		serviceD.newDossier(dossier);
		return new ModelAndView("redirect:" + "dossiers");
	}
	
	@RequestMapping(value="/Transit/updateDossier")
	public ModelAndView updatedossier(Model m,HttpServletRequest req,
			@RequestParam int numdossier,
			@RequestParam int clientId,
			@RequestParam int moyenneTransportId,
			@RequestParam String typeTransport,
			@RequestParam int portDepartId,
			@RequestParam int portArriveeId,
			@RequestParam int delaiTransit,
			@RequestParam Double cotation,
			@RequestParam String etat,
			@RequestParam String date,
			@RequestParam String incoterm
			) throws ParseException
	{
		Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		HttpSession s=req.getSession();
		User user=(User) s.getAttribute("user");
		Dossier dossier = serviceD.getDossier(numdossier);
		dossier.setDelaiTransit(delaiTransit);
		dossier.setClient(serviceCl.getClient(clientId)); 
		dossier.setPortByIdport(serviceP.getPort(portDepartId));
		dossier.setPortByPorIdport(serviceP.getPort(portArriveeId));
		dossier.setMoyennetransport(serviceM.getMoyennetransport(moyenneTransportId));
		dossier.setTransit(serviceTs.getTransit(user.getUserId()));
		dossier.setCotation(cotation);
		dossier.setDate(d);
		dossier.setEtat(etat);
		dossier.setIncoter(incoterm);
		dossier.setTypetransport(typeTransport);
		serviceD.updateDossier(dossier);
		return new ModelAndView("redirect:" + "dossiers");
	}
	
	@RequestMapping(value="/Transit/ajouterDossierFormulaire")
	public String AjouerDossierView(Model m,HttpServletRequest req)
	{
//		m.addAttribute("listeTransporteur",serviceTr.getAllTransporteurs());
//		m.addAttribute("listeTransit",serviceCom.getAllCommercials());
//		m.addAttribute("listeTransit",serviceTs.getAllTransits());
		m.addAttribute("listeMoyenneTransport",serviceM.getAllMoyennetransport());
		m.addAttribute("listePort",serviceP.getAllPorts());
		m.addAttribute("listeClient",serviceCl.getAllClient());
		return "Transit/ajouterDossierFormulaire";
	}
	
	@RequestMapping(value="/Transit/ModifDossier")
	public String ModDossierView(Model m,HttpServletRequest req,HttpServletResponse httpResponse,
			@RequestParam int idDossier
	)
	{
		m.addAttribute("D",serviceD.getDossier(idDossier));
//		m.addAttribute("listeTransporteur",serviceTr.getAllTransporteurs());
//		m.addAttribute("listeCommercial",serviceCom.getAllCommercials());
//		m.addAttribute("listeTransit",serviceTs.getAllTransits());
		m.addAttribute("listeMoyenneTransport",serviceM.getAllMoyennetransport());
		m.addAttribute("listePort",serviceP.getAllPorts());
		m.addAttribute("listeClient",serviceCl.getAllClient());
		return "Transit/modifierDossier";
	}
	@RequestMapping(value="/Transit/ChangerEtat")
	public String ChangerEtatDossierView(Model m,HttpServletRequest req,HttpServletResponse httpResponse,
			@RequestParam int idDossier
			)
	{
		m.addAttribute("D",serviceD.getDossier(idDossier));
		return "Transit/changerEtat";
	}
	

	@RequestMapping(value="/Transit/ChangerEtatAction")
	public String chagerEtatView(Model m,HttpServletRequest req,@RequestParam int idDossier,@RequestParam String etat
			,@RequestParam String position
			,@RequestParam(defaultValue = "false") String notifier
			,@RequestParam String emailclient
			,@RequestParam String coordonnee)
	{
		HttpSession s=req.getSession();
//		Transit C=(Transit) s.getAttribute("Transit")
		User user=(User) s.getAttribute("user");
		serviceD.changerEtatDossier(idDossier, etat);
		serviceEtat.addEtat(new Etat(new Date(),serviceD.getDossier(idDossier),user,position,coordonnee,"changement"));
		if(notifier.equals("true"))	{
			SendMailSSL mail = new SendMailSSL(emailclient,"Changement d'etat",etat,new Date().toString());
			mail.send();
		}
		//		m.addAttribute("found",C);
//		m.addAttribute("listeDossiers",serviceD.getAllDossiersByUserId(C.getIdtransit(),"transit"));
		return "redirect:dossiers";
	}
	
	@RequestMapping(value="/Transit/SingleDossier", method = RequestMethod.GET)
	public String SingleDossierView(Model m,HttpServletRequest req,@RequestParam int idDossier)
	{
		HttpSession s=req.getSession();
		Transit C=(Transit) s.getAttribute("Transit");
		User user=(User) s.getAttribute("user");
		String etatMap = new String();
		m.addAttribute("found",C);
		m.addAttribute("user",user);
		for (Dossier dossier : serviceD.getAllDossiersByUserId(C.getIdtransit(),"transit")) {
			for (Etat etat : serviceEtat.getEtatByIdDossier(dossier.getNumdossier())) {
				etatMap += "{latLng: ["+etat.getCoordonnee()+"], name: '"+etat.getPosition()+"'},";
			}
		}
		m.addAttribute("comments",serviceCmt.getCommentbyId(idDossier,user.getUserId()));
		m.addAttribute("etatMap",etatMap);
		m.addAttribute("dossier",serviceD.getDossier(idDossier));
		m.addAttribute("changementsEtat",serviceEtat.getAllchangedEtat(user,"transit"));
		m.addAttribute("affectations",serviceEtat.getAllAffectedDossier(user.getUserId(),"transit"));
		
		int nbrAffectation = serviceEtat.getNbrAffectedDossier(user.getUserId(),"transit");
		if(nbrAffectation != 0)
			m.addAttribute("nbrAffectations",nbrAffectation);
		int nbrChangement = serviceEtat.getNbrChangementDossier(user,"transit");
		if(nbrChangement != 0)
			m.addAttribute("nbrChangements",nbrChangement);
		return "/Transit/singleDossier";
	}
	
	@RequestMapping(value="/Transit/envoyerEmail")
	public String envoyerEmailView(Model m,HttpServletRequest req,@RequestParam String message,@RequestParam String emailto,@RequestParam String subject)
	{
		HttpSession s=req.getSession();
		Transit C=(Transit) s.getAttribute("Transit");
		m.addAttribute("found",C);
		m.addAttribute("listeDossiers",serviceD.getAllDossiersByUserId(C.getIdtransit(),"transit"));
		SendMailSSL mail = new SendMailSSL(emailto,subject,message);
		mail.send();
		return "redirect:index";
	}
	
	@RequestMapping(value="/Transit/valider", method = RequestMethod.GET)
	public String validerDossierView(Model m,HttpServletRequest req,@RequestParam int idDossier)
	{
		HttpSession s=req.getSession();
		User user=(User) s.getAttribute("user");
		serviceD.validerDossier(idDossier,user.getUserId(),"transit");
		return "redirect:dossiersAttente";
	}
	@RequestMapping(value="/Transit/comments", method = RequestMethod.GET)
	public String commentsDossierView(Model m,HttpServletRequest req,@RequestParam int idDossier)
	{
		HttpSession s=req.getSession();
		User user=(User) s.getAttribute("user");
		m.addAttribute("comments",serviceCmt.getCommentbyId(idDossier,user.getUserId()));
		m.addAttribute("idDossier",idDossier);
		return "/Transit/comments";
	}
	@RequestMapping(value="/Transit/ajouterCommentaire")
	public String ajouterCommentaireView(Model m,HttpServletRequest req,@RequestParam String comment,@RequestParam int idDossier)
	{
		HttpSession s=req.getSession();
		User user=(User) s.getAttribute("user");
		Dossier dossier = (Dossier) serviceD.getDossier(idDossier);
		Comment cmt = new Comment(comment, new Date(),dossier ,user);
		serviceCmt.AddComment(cmt);
		m.addAttribute("comments",serviceCmt.getCommentbyId(idDossier,user.getUserId()));
		m.addAttribute("idDossier",idDossier);
		return "redirect:SingleDossier";
	}
	@RequestMapping(value="/Transit/affecter")
	public String affecterView(Model m,HttpServletRequest req,HttpServletResponse httpResponse,
			@RequestParam int idDossier
	)
	{
		m.addAttribute("D",serviceD.getDossier(idDossier));
		m.addAttribute("listeTransporteur",serviceTr.getAllTransporteurs());
		m.addAttribute("listeCommercial",serviceCom.getAllCommercials());
		return "Transit/affecter";
	}
	@RequestMapping(value="/Transit/affecterAction")
	public String affecterActionView(Model m,HttpServletRequest req,HttpServletResponse httpResponse,
			@RequestParam int idDossier,
			@RequestParam int transporteurId,
			@RequestParam int commercialId,
			@RequestParam String choix
			)
	{
		Dossier dossier = (Dossier) serviceD.getDossier(idDossier);
		if((choix.equals("transporteur") || choix.equals("deux")) && dossier.getTransporteur() == null){
					dossier.setTransporteur(serviceTr.getTransporteurById(transporteurId));
					serviceEtat.addEtat(new Etat(new Date(),serviceD.getDossier(idDossier),
							userDao.findUserByUserId(transporteurId,"transporteur")
							,null,null,"notification",false,false,false,false));
				
		}else if((choix.equals("commercial") || choix.equals("deux")) && dossier.getCommercial() == null){
			dossier.setCommercial(serviceCom.getCommercialByIf(commercialId));
			serviceEtat.addEtat(new Etat(new Date(),serviceD.getDossier(idDossier),
					userDao.findUserByUserId(commercialId,"commercial")
					,null,null,"notification",false,false,false,false));
		}
		serviceD.updateDossier(dossier);
		return "redirect:dossiersAttente";
	}
	
	@RequestMapping(value="/Transit/SingleDossierFromNotifications", method = RequestMethod.GET)
	public String SingleDossierFromNotificationsView(Model m,HttpServletRequest req,
			@RequestParam int idDossier,@RequestParam int idEtat,@RequestParam String changement)
	{
		HttpSession s=req.getSession();
		Transit C=(Transit) s.getAttribute("Transit");
		User user=(User) s.getAttribute("user");
		String etatMap = new String();
		Etat etatNonLu = serviceEtat.getEtat(idEtat);
		if(changement.equals("affectation"))
			etatNonLu.setLu(true);
		else
			etatNonLu.setLuTransit(true);
		serviceEtat.update(etatNonLu);
		m.addAttribute("found",C);
		m.addAttribute("user",user);
		for (Dossier dossier : serviceD.getAllDossiersByUserId(C.getIdtransit(),"transit")) {
			for (Etat etat : serviceEtat.getEtatByIdDossier(dossier.getNumdossier())) {
				etatMap += "{latLng: ["+etat.getCoordonnee()+"], name: '"+etat.getPosition()+"'},";
			}
		}
		m.addAttribute("comments",serviceCmt.getCommentbyId(idDossier,user.getUserId()));
		m.addAttribute("etatMap",etatMap);
		m.addAttribute("dossier",serviceD.getDossier(idDossier));
		m.addAttribute("changementsEtat",serviceEtat.getAllchangedEtat(user,"transit"));
		m.addAttribute("affectations",serviceEtat.getAllAffectedDossier(user.getUserId(),"transit"));
		
		int nbrAffectation = serviceEtat.getNbrAffectedDossier(user.getUserId(),"transit");
		if(nbrAffectation != 0)
			m.addAttribute("nbrAffectations",nbrAffectation);
		int nbrChangement = serviceEtat.getNbrChangementDossier(user,"transit");
		if(nbrChangement != 0)
			m.addAttribute("nbrChangements",nbrChangement);
		return "/Transit/singleDossier";
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}


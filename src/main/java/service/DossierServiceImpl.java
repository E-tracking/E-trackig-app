package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dao.Commercial;
import dao.CommercialDao;
import dao.Dossier;
import dao.DossierDao;
import dao.Transit;
import dao.TransitDao;
import dao.Transporteur;
import dao.TransporteurDao;

public class DossierServiceImpl implements DossierService ,Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DossierDao dao;
	private CommercialDao daoC;
	private TransitDao daoT;
	private TransporteurDao daoTT;
	
	public void setDao(DossierDao dao) 
	{	
		this.dao = dao;
	}

	public void setDaoC(CommercialDao daoC) {
		this.daoC = daoC;
	}

	public void setDaoT(TransitDao daoT) {
		this.daoT = daoT;
	}

	public void setDaoTT(TransporteurDao daoTT) {
		this.daoTT = daoTT;
	}

	@Override
	public void newDossier(Dossier D) 
	{
		dao.AddDossier(D);
	}

	@Override
	public Dossier getDossier(int numero) 
	{
		return dao.getDossier(numero);
	}
	
	@Override
	public void updateDossier(Dossier D) 
	{
		dao.UpdateDossier(D);
	}

	@Override
	public void affecterDossierToCommercial(int id,int idC) 
	{
		Commercial C=daoC.getCommercial(idC);
		Dossier D=dao.getDossier(id);
		D.setCommercial(C);
		dao.UpdateDossier(D);
	}

	@Override
	public void affecterDossierToTransit(int id,int iT) 
	{
		Transit C=daoT.getTransit(iT);
		Dossier D=dao.getDossier(id);
		D.setTransit(C);
		dao.UpdateDossier(D);
	}

	@Override
	public void affecterDossierToTransporteur(int id,int iT) 
	{
		Transporteur C=daoTT.getTransporteur(iT);
		Dossier D=dao.getDossier(id);
		D.setTransporteur(C);
		dao.UpdateDossier(D);
	}

	@Override
	public List<Dossier> getAllDossiers() 
	{
		return dao.getAllDossiers();
	}
	
	@Override
	public void deleteDossier(int id) {
		dao.DeleteDossier(id);
	}

	@Override
	public List<Dossier> getAllDossiersByUserId(int id,String userType) {
		List<Dossier> dossiers = null;
		if(userType.equals("commercial")){
			dossiers = dao.getAllDossiersByUserId(id,"commercial");
		}else if(userType.equals("transit")){
			dossiers = dao.getAllDossiersByUserId(id,"transit");
		}else{
			dossiers = dao.getAllDossiersByUserId(id,"transporteur");
		}
		List<Dossier> dossiersNonValides = new ArrayList<Dossier>();
		for (Dossier dossier : dossiers) {
			if(dossier.getValidationclient())
				dossiersNonValides.add(dossier);
		}
		return dossiersNonValides;
	}

	@Override
	public void changerEtatDossier(int id,String etat) {
		
		dao.ChangerEtatDossier(id, etat);
	}

	@Override
	public List<Dossier> getDossiersRecents() {
		
		return dao.getDossiersRecents();
	}

	@Override
	public List<Dossier> getAllDossiersAttente(int idcommercial,String userType) {
		List<Dossier> dossiers = dao.getAllDossiersByUserId(idcommercial,userType);
		List<Dossier> dossiersNonValides = new ArrayList<Dossier>();
		if(userType.equals("commercial")){
			for (Dossier dossier : dossiers) {
				if(!dossier.getValidationclient() && dossier.getCommercial() != null)
					dossiersNonValides.add(dossier);
			}
		}else if(userType.equals("transit")){
			for (Dossier dossier : dossiers) {
				if(!dossier.getValidationclient() && dossier.getTransit() != null)
					dossiersNonValides.add(dossier);
			}
		}else{
			for (Dossier dossier : dossiers) {
				if(!dossier.getValidationclient() && dossier.getTransporteur() != null)
					dossiersNonValides.add(dossier);
			}
		}
		
		return dossiersNonValides;
	}

	@Override
	public void validerDossier(int idDossier,int userId,String userType) {
		List<Dossier> dossiers = dao.getAllDossiersByUserId(userId,userType);
		for (Dossier dossier : dossiers) {
			if(dossier.getNumdossier() == idDossier){
				dossier.setValidationclient(true);
				dao.UpdateDossier(dossier);
			}
				
		}
	}

	@Override
	public void removeAffetation(int id,String usertype) {
		List<Dossier> dossiers = dao.getAllDossiersByUserId(id,usertype);
		if(usertype.equals("commercial")){
			System.out.println("######################## " +dossiers.size());
			for (Dossier dossier : dossiers) {
				if(dossier.getCommercial().getIdcommercial() == id){
					dossier.setCommercial(null);
					dao.UpdateDossier(dossier);
				}
					
			}
		}else if(usertype.equals("transporteur")){
			for (Dossier dossier : dossiers) {
				if(dossier.getTransporteur().getIdtransporteur() == id){
					dossier.setCommercial(null);
					dao.UpdateDossier(dossier);
				}
					
			}
		}else{
			for (Dossier dossier : dossiers) {
				if(dossier.getTransit().getIdtransit() == id){
					dossier.setCommercial(null);
					dao.UpdateDossier(dossier);
				}
			}
		}
	}
}

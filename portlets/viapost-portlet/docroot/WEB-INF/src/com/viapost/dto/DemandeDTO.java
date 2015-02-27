package com.viapost.dto;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.viapost.stock.model.Demande;
import com.viapost.stock.model.EtapeDemande;
import com.viapost.stock.service.EtapeDemandeLocalServiceUtil;

public class DemandeDTO {
	
	private final String demande;
	private final String question;
	private List<String> etapes = new ArrayList<String>();
	
	public DemandeDTO(final Demande demande) throws SystemException {
		this.demande = demande.getRequest();
		this.question = demande.getQuestion();
		
		final List<EtapeDemande> etapeDemandes = EtapeDemandeLocalServiceUtil.findByDemandeId(demande.getDemandeId());
		for(final EtapeDemande etapeDemande : etapeDemandes) {
			etapes.add(etapeDemande.getDecription());
		}
	}

	public List<String> getEtapes() {
		return etapes;
	}

	public void setEtapes(final List<String> etapes) {
		this.etapes = etapes;
	}

	public String getDemande() {
		return demande;
	}

	public String getQuestion() {
		return question;
	}
	
	

}

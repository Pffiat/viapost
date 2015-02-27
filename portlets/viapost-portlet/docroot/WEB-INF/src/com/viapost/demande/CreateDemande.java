package com.viapost.demande;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viapost.stock.service.DemandeLocalServiceUtil;

/**
 * Portlet implementation class CreateDemande
 */
public class CreateDemande extends MVCPortlet {
	
	public void addDemande(final ActionRequest request, final ActionResponse response) throws SystemException {
		DemandeLocalServiceUtil.addDemandeFromRequest(request);
	}
 

}

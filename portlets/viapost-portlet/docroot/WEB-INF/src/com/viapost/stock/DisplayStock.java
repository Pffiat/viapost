package com.viapost.stock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viapost.dto.DemandeDTO;
import com.viapost.stock.model.Demande;
import com.viapost.stock.model.Product;
import com.viapost.stock.model.UserDemande;
import com.viapost.stock.service.DemandeLocalServiceUtil;
import com.viapost.stock.service.ProductLocalServiceUtil;
import com.viapost.stock.service.UserDemandeLocalServiceUtil;

/**
 * Portlet implementation class DisplayStock
 */
public class DisplayStock extends MVCPortlet {
	 
		private final static Log LOG = LogFactoryUtil.getLog(DisplayStock.class);

	    protected String viewTemplate;
	    
		@Override
		public void init() {
			viewTemplate = getInitParameter("view-template");
		}
		
		@Override
		public void doView(final RenderRequest request, final RenderResponse response){
			try {
				
				final List<Demande> demandes = DemandeLocalServiceUtil.getDemandes(0, DemandeLocalServiceUtil.getDemandesCount());
				final List<DemandeDTO> demandeDTOs = new ArrayList<DemandeDTO>();
				for(final Demande demande : demandes) {
					demandeDTOs.add(new DemandeDTO(demande));
				}				
				request.setAttribute("demandeDTOs", demandeDTOs);

				final List<Product> produits = ProductLocalServiceUtil.getProducts(0, ProductLocalServiceUtil.getProductsCount());				
				request.setAttribute("produits", produits);
 				
			} catch (final SystemException e) {
				LOG.debug("problème system exception");
			}
			try {
				include(viewTemplate, request, response);
			} catch (IOException | PortletException e) {
				LOG.debug("no include");
			}
		}

	    @Override
		protected void include(
	            final String path, final RenderRequest renderRequest,
	            final RenderResponse renderResponse)
	        throws IOException, PortletException {

	        final PortletRequestDispatcher portletRequestDispatcher =
	            getPortletContext().getRequestDispatcher(path);

	        if (portletRequestDispatcher == null) {
	            LOG.error(path + " is not a valid include");
	        }
	        else {
	            portletRequestDispatcher.include(renderRequest, renderResponse);
	        }
	    }
	    
		public void validationUserDemande(final ActionRequest request, final ActionResponse response) throws PortalException, SystemException, Exception {

			final UserDemande userDemande = UserDemandeLocalServiceUtil.addUserDemande(request);

			final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			final long groupId = themeDisplay.getScopeGroupId();
			
			final String workflowDefinition = ParamUtil.getString(request, "workflowDefinition");
			LOG.info(workflowDefinition);
						
			WorkflowDefinitionLinkLocalServiceUtil.updateWorkflowDefinitionLink(themeDisplay.getUserId(), themeDisplay.getCompanyId(), groupId,
					UserDemande.class.getName(), userDemande.getDemandeId(), 0, workflowDefinition);
			
		}
}

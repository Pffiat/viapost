package com.viapost.demande;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.kernel.workflow.WorkflowDefinitionManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viapost.stock.DisplayStock;
import com.viapost.stock.model.UserDemande;
import com.viapost.stock.service.UserDemandeLocalServiceUtil;

/**
 * Portlet implementation class MesDemandes
 */
public class MesDemandes extends MVCPortlet {
	 
		private final static Log LOG = LogFactoryUtil.getLog(DisplayStock.class);

	    protected String viewTemplate;
	    
		@Override
		public void init() {
			viewTemplate = getInitParameter("view-template");
		}
		
		@Override
		public void doView(final RenderRequest request, final RenderResponse response) {
			try {
				

				final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				
				
					
				final List<WorkflowDefinition> workflowDefinitions = WorkflowDefinitionManagerUtil.getActiveWorkflowDefinitions(themeDisplay.getCompanyId(), 0, 100, null);
				for (final WorkflowDefinition workflowDefinition : workflowDefinitions) {
					LOG.info(workflowDefinition.getName() + StringPool.AT + workflowDefinition.getVersion());
				}
				
				
				
				
				
				
				final List<UserDemande> userDemandes = UserDemandeLocalServiceUtil.findByUserId(themeDisplay.getUserId());
				
				request.setAttribute("userDemandes", userDemandes);
				
			} catch (final SystemException | WorkflowException e) {
				LOG.debug("problème system exception");
			}
			try {
				include(viewTemplate, request, response);
			} catch (IOException | PortletException e) {
				LOG.debug("no include");
			}
		}

	    @Override
		protected void include( final String path, final RenderRequest renderRequest, final RenderResponse renderResponse) throws IOException, PortletException {

	        final PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

	        if (portletRequestDispatcher == null) {
	            LOG.error(path + " is not a valid include");
	        }
	        else {
	            portletRequestDispatcher.include(renderRequest, renderResponse);
	        }
	    }
	    
	
	

}

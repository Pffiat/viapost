package com.meera.feedback;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.meera.db.model.Feedback;
import com.meera.db.service.FeedbackLocalServiceUtil;

/**
 * Portlet implementation class FeedbackAction
 */
public class FeedbackWorkflowHandler extends BaseWorkflowHandler{
 
    @Override
	public String getClassName() {
        return CLASS_NAME;
    }
 
    @Override
	public String getType(final Locale locale) {
        return LanguageUtil.get(locale, "model.resource." + CLASS_NAME);
    }
 
    @Override
	public Object updateStatus(final int status, final Map<String, Serializable> workflowContext) throws PortalException, SystemException {
        final long userId = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        final long resourcePrimKey = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        final ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");
        return FeedbackLocalServiceUtil.updateStatus(userId, resourcePrimKey,status, serviceContext);
    }
 
    public static final String CLASS_NAME = Feedback.class.getName();

}

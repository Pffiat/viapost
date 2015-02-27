package com.meera.feedback;

import java.io.IOException;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.meera.db.model.Feedback;
import com.meera.db.model.impl.FeedbackImpl;
import com.meera.db.service.FeedbackLocalServiceUtil;

/**
 * Portlet implementation class FeedbackAction
 */
public class FeedbackAction extends MVCPortlet {
	public void submitFeedback(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, AddressException, SystemException, PortalException {
		System.out.println("====submitFeedback===");
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String feedBackMessage = ParamUtil.getString(actionRequest, "editor");
		String feedbackSubject = ParamUtil.getString(actionRequest, "feedbackSubject");
		System.out.println("1111" + feedBackMessage);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Feedback.class.getName(), actionRequest);
		try {
			Feedback feedback=new FeedbackImpl();
			feedback.setCompanyId(themeDisplay.getCompanyId());
			feedback.setGroupId(themeDisplay.getScopeGroupId());
			feedback.setFeedbackDate(new Date());
			feedback.setFeedbackText(feedBackMessage);
			feedback.setFeedbackSubject(feedbackSubject);
			FeedbackLocalServiceUtil.addFeedback(feedback, themeDisplay.getUserId(), serviceContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

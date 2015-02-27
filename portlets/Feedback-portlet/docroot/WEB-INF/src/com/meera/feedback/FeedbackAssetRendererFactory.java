package com.meera.feedback;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.meera.db.model.Feedback;
import com.meera.db.service.FeedbackLocalServiceUtil;

/**
 * Portlet implementation class FeedbackAction
 */
public class FeedbackAssetRendererFactory extends BaseAssetRendererFactory {
    @Override
    public AssetRenderer getAssetRenderer(long classPK, int type)
            throws PortalException, SystemException {
        Feedback feedback = FeedbackLocalServiceUtil.getFeedback(classPK);
        return new com.meera.feedback.FeedbackAssetRenderer(feedback);
    }
 
    @Override
    public String getClassName() {
		return CLASS_NAME;
	}
    @Override
	public String getType() {
		return TYPE;
	}
    public static final String TYPE = "feedback";
    public static final String CLASS_NAME = Feedback.class.getName();
}

package com.meera.feedback;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.meera.db.model.Feedback;

/**
 * Portlet implementation class FeedbackAction
 */
public class FeedbackAssetRenderer extends BaseAssetRenderer{
 
    private Feedback _feedback;
     
    public FeedbackAssetRenderer(Feedback feedback) {
        _feedback = feedback;
    }
 
    public long getClassPK() {
        return _feedback.getFeedbackId();
    }
 
    public long getGroupId() {
        return _feedback.getGroupId();
    }
 
    public String getSummary(Locale arg0) {
        return _feedback.getFeedbackText();
    }
 
    public String getTitle(Locale arg0) {
        return "Feedback Contest Entry";
    }
 
    public long getUserId() {
        return _feedback.getUserId();
    }
 
    public String getUuid() {
        return _feedback.getUuid();
    }
 
    public String render(RenderRequest request, RenderResponse response, String template)
        throws Exception 
    {
        if (template.equals(TEMPLATE_FULL_CONTENT)) {
            return "/html/jsps/view_feedbck.jsp";
        }
        else
        {
            return null;
        }
    }
 
    @Override
    public String getUserName() {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}
 

}

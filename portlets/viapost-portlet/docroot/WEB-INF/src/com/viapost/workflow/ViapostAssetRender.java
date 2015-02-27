package com.viapost.workflow;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.viapost.stock.model.UserDemande;

public class ViapostAssetRender extends BaseAssetRenderer {
	
	private static final Log LOG = LogFactoryUtil.getLog(ViapostAssetRender.class);
	private final UserDemande userDemande;
	
	public ViapostAssetRender(final UserDemande userDemande) {
		this.userDemande = userDemande;
	}

	@Override
	public String getClassName() {
		return ViapostAssetRender.class.getName();
	}

	@Override
	public long getClassPK() {
		return userDemande.getUserDemandeId();
	}

	@Override
	public long getGroupId() {
		return userDemande.getGroupId();
	}

	@Override
	public String getTitle(final Locale locale) {
		return "user demande ";
	}

	@Override
	public String getSummary(final Locale locale) {
		return null;
	}

	@Override
	public long getUserId() {
		return userDemande.getUserId();
	}

	@Override
	public String getUserName() {
		String name = "no name";
		try {
			name =  UserLocalServiceUtil.getUser(userDemande.getUserId()).getFullName();
		} catch (PortalException | SystemException e) {
			LOG.debug("can't retrieve user");
		}
		return name;
	}

	@Override
	public String getUuid() {
		String uuid = "uuid";
		try {
			uuid = userDemande.getUserUuid();
		} catch (final SystemException e) {
			LOG.debug("can't retrieve uuid");
		}
		return uuid;
	}

	@Override
	public String render(final RenderRequest renderRequest,	final RenderResponse renderResponse, final String template) throws Exception {
		String render = null;
		if(template.equals(TEMPLATE_FULL_CONTENT)) {
			render = "html/mesdemandes/view.jsp";
		}
		return render;
	}

}

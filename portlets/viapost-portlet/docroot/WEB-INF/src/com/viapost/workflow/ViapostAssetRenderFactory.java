package com.viapost.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.viapost.stock.model.UserDemande;
import com.viapost.stock.service.UserDemandeLocalServiceUtil;

public class ViapostAssetRenderFactory extends BaseAssetRendererFactory {
	
	private static final String TYPE = "userDemande";
	private static final String CLASS_NAME = UserDemande.class.getName();

	@Override
	public AssetRenderer getAssetRenderer(final long classPK, final int type) throws PortalException, SystemException {
		final UserDemande userDemande = UserDemandeLocalServiceUtil.getUserDemande(classPK);
		return new ViapostAssetRender(userDemande);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}

}

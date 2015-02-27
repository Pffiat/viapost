/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.viapost.stock.service.impl;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.viapost.stock.model.UserDemande;
import com.viapost.stock.service.DemandeLocalServiceUtil;
import com.viapost.stock.service.base.UserDemandeLocalServiceBaseImpl;

/**
 * The implementation of the user demande local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viapost.stock.service.UserDemandeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pif
 * @see com.viapost.stock.service.base.UserDemandeLocalServiceBaseImpl
 * @see com.viapost.stock.service.UserDemandeLocalServiceUtil
 */
public class UserDemandeLocalServiceImpl extends UserDemandeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viapost.stock.service.UserDemandeLocalServiceUtil} to access the user demande local service.
	 */
	
	@Override
	public UserDemande addUserDemande(final ActionRequest request) throws PortalException, SystemException {
		final UserDemande userDemande = userDemandePersistence.create(counterLocalService.increment(UserDemande.class.getName()));

		final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		final long userId = themeDisplay.getUserId();
		final ServiceContext serviceContext = ServiceContextFactory.getInstance(UserDemande.class.getName(), request);
		userDemande.setCompanyId(themeDisplay.getCompanyId());
		userDemande.setGroupId(themeDisplay.getScopeGroupId());
		userDemande.setDate(new Date());
		userDemande.setArticle(ParamUtil.getLong(request, "produit"));
		userDemande.setDemandeId(DemandeLocalServiceUtil.findByQuestion(ParamUtil.getString(request, "question")));
		userDemande.setStatus(WorkflowConstants.STATUS_PENDING);
		userDemandePersistence.update(userDemande);
		
		assetEntryLocalService.updateEntry(userId, userDemande.getGroupId(), UserDemande.class.getName(), 
				userDemande.getPrimaryKey(), serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames());
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(themeDisplay.getCompanyId(), userId, UserDemande.class.getName(), 
				userDemande.getPrimaryKey(), userDemande, serviceContext);
		
		return userDemande;
	}
	
	@Override
	public List<UserDemande> findByUserId(final long userId) throws SystemException {
		return userDemandePersistence.findByUserId(userId);
	}
	
	@Override
	public UserDemande updateStatus(final long userId, final long resourcePrimaryKey, final int status, final ServiceContext serviceContext) throws PortalException, SystemException {
		final User user = userLocalService.getUser(userId);
		final UserDemande userDemande = getUserDemande(resourcePrimaryKey);
		userDemande.setStatus(status);
		userDemande.setStatusByUserId(userId);
		userDemande.setStatusByUserName(user.getFullName());
		userDemande.setStatusByDate(serviceContext.getModifiedDate());
		userDemandePersistence.update(userDemande);
		if ( status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateVisible(UserDemande.class.getName(), resourcePrimaryKey, /*visible*/ true);
		} else {
			assetEntryLocalService.updateVisible(UserDemande.class.getName(), resourcePrimaryKey, /*visible*/ false);
		}
		return userDemande;
	}
}
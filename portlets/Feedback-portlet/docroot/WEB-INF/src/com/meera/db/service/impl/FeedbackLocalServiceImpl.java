/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.meera.db.service.impl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.meera.db.model.Feedback;
import com.meera.db.service.base.FeedbackLocalServiceBaseImpl;

/**
 * The implementation of the feedback local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.meera.db.service.FeedbackLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author E5410
 * @see com.meera.db.service.base.FeedbackLocalServiceBaseImpl
 * @see com.meera.db.service.FeedbackLocalServiceUtil
 */
public class FeedbackLocalServiceImpl extends FeedbackLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.meera.db.service.FeedbackLocalServiceUtil} to access the feedback
	 * local service.
	 */
	public Feedback addFeedback(Feedback newFeedback, long userId,
			ServiceContext serviceContext) throws SystemException,
			PortalException {
		Feedback feedback = feedbackPersistence.create(counterLocalService.increment(Feedback.class.getName()));
		feedback.setCompanyId(newFeedback.getCompanyId());
		feedback.setGroupId(newFeedback.getGroupId());
		feedback.setUserId(serviceContext.getUserId());
		feedback.setFeedbackDate(newFeedback.getFeedbackDate());
		feedback.setFeedbackText(newFeedback.getFeedbackText());
		feedback.setFeedbackSubject(newFeedback.getFeedbackSubject());
		feedback.setStatus(WorkflowConstants.STATUS_DRAFT);
		feedbackPersistence.update(feedback, false);

		assetEntryLocalService.updateEntry(userId, feedback.getGroupId(),
				Feedback.class.getName(), feedback.getFeedbackId(),
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames());
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				feedback.getCompanyId(), feedback.getGroupId(), userId,
				Feedback.class.getName(), feedback.getPrimaryKey(), feedback,
				serviceContext);

		return feedback;
	}

	public void deleteFeedbacks(Feedback feedback) throws SystemException,
			PortalException {

		assetEntryLocalService.deleteEntry(Feedback.class.getName(),
				feedback.getFeedbackId());

		feedbackPersistence.remove(feedback);
	}
	 public Feedback updateStatus(long userId, long resourcePrimKey, int status,
	            ServiceContext serviceContext) throws PortalException,
	            SystemException {
	        User user = userLocalService.getUser(userId);
	        Feedback feedback = getFeedback(resourcePrimKey);
	        feedback.setStatus(status);
	        feedback.setStatusByUserId(userId);
	        feedback.setStatusByUserName(user.getFullName());
	        feedback.setStatusDate(serviceContext.getModifiedDate());
	        feedbackPersistence.update(feedback, false);
	        if (status == WorkflowConstants.STATUS_APPROVED) {
	            assetEntryLocalService.updateVisible(Feedback.class.getName(),
	                    resourcePrimKey, true);
	        } else {
	            assetEntryLocalService.updateVisible(Feedback.class.getName(),
	                    resourcePrimKey, false);
	        }
	        return feedback;
	    }
}
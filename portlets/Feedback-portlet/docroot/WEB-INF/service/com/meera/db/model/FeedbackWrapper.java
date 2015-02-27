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

package com.meera.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Feedback}.
 * </p>
 *
 * @author E5410
 * @see Feedback
 * @generated
 */
public class FeedbackWrapper implements Feedback, ModelWrapper<Feedback> {
	public FeedbackWrapper(Feedback feedback) {
		_feedback = feedback;
	}

	@Override
	public Class<?> getModelClass() {
		return Feedback.class;
	}

	@Override
	public String getModelClassName() {
		return Feedback.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("feedbackId", getFeedbackId());
		attributes.put("feedbackDate", getFeedbackDate());
		attributes.put("feedbackText", getFeedbackText());
		attributes.put("feedbackSubject", getFeedbackSubject());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long feedbackId = (Long)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
		}

		Date feedbackDate = (Date)attributes.get("feedbackDate");

		if (feedbackDate != null) {
			setFeedbackDate(feedbackDate);
		}

		String feedbackText = (String)attributes.get("feedbackText");

		if (feedbackText != null) {
			setFeedbackText(feedbackText);
		}

		String feedbackSubject = (String)attributes.get("feedbackSubject");

		if (feedbackSubject != null) {
			setFeedbackSubject(feedbackSubject);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this feedback.
	*
	* @return the primary key of this feedback
	*/
	@Override
	public long getPrimaryKey() {
		return _feedback.getPrimaryKey();
	}

	/**
	* Sets the primary key of this feedback.
	*
	* @param primaryKey the primary key of this feedback
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_feedback.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this feedback.
	*
	* @return the uuid of this feedback
	*/
	@Override
	public java.lang.String getUuid() {
		return _feedback.getUuid();
	}

	/**
	* Sets the uuid of this feedback.
	*
	* @param uuid the uuid of this feedback
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_feedback.setUuid(uuid);
	}

	/**
	* Returns the feedback ID of this feedback.
	*
	* @return the feedback ID of this feedback
	*/
	@Override
	public long getFeedbackId() {
		return _feedback.getFeedbackId();
	}

	/**
	* Sets the feedback ID of this feedback.
	*
	* @param feedbackId the feedback ID of this feedback
	*/
	@Override
	public void setFeedbackId(long feedbackId) {
		_feedback.setFeedbackId(feedbackId);
	}

	/**
	* Returns the feedback date of this feedback.
	*
	* @return the feedback date of this feedback
	*/
	@Override
	public java.util.Date getFeedbackDate() {
		return _feedback.getFeedbackDate();
	}

	/**
	* Sets the feedback date of this feedback.
	*
	* @param feedbackDate the feedback date of this feedback
	*/
	@Override
	public void setFeedbackDate(java.util.Date feedbackDate) {
		_feedback.setFeedbackDate(feedbackDate);
	}

	/**
	* Returns the feedback text of this feedback.
	*
	* @return the feedback text of this feedback
	*/
	@Override
	public java.lang.String getFeedbackText() {
		return _feedback.getFeedbackText();
	}

	/**
	* Sets the feedback text of this feedback.
	*
	* @param feedbackText the feedback text of this feedback
	*/
	@Override
	public void setFeedbackText(java.lang.String feedbackText) {
		_feedback.setFeedbackText(feedbackText);
	}

	/**
	* Returns the feedback subject of this feedback.
	*
	* @return the feedback subject of this feedback
	*/
	@Override
	public java.lang.String getFeedbackSubject() {
		return _feedback.getFeedbackSubject();
	}

	/**
	* Sets the feedback subject of this feedback.
	*
	* @param feedbackSubject the feedback subject of this feedback
	*/
	@Override
	public void setFeedbackSubject(java.lang.String feedbackSubject) {
		_feedback.setFeedbackSubject(feedbackSubject);
	}

	/**
	* Returns the status of this feedback.
	*
	* @return the status of this feedback
	*/
	@Override
	public int getStatus() {
		return _feedback.getStatus();
	}

	/**
	* Sets the status of this feedback.
	*
	* @param status the status of this feedback
	*/
	@Override
	public void setStatus(int status) {
		_feedback.setStatus(status);
	}

	/**
	* Returns the status by user ID of this feedback.
	*
	* @return the status by user ID of this feedback
	*/
	@Override
	public long getStatusByUserId() {
		return _feedback.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this feedback.
	*
	* @param statusByUserId the status by user ID of this feedback
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_feedback.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this feedback.
	*
	* @return the status by user uuid of this feedback
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedback.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this feedback.
	*
	* @param statusByUserUuid the status by user uuid of this feedback
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_feedback.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this feedback.
	*
	* @return the status by user name of this feedback
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _feedback.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this feedback.
	*
	* @param statusByUserName the status by user name of this feedback
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_feedback.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this feedback.
	*
	* @return the status date of this feedback
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _feedback.getStatusDate();
	}

	/**
	* Sets the status date of this feedback.
	*
	* @param statusDate the status date of this feedback
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_feedback.setStatusDate(statusDate);
	}

	/**
	* Returns the company ID of this feedback.
	*
	* @return the company ID of this feedback
	*/
	@Override
	public long getCompanyId() {
		return _feedback.getCompanyId();
	}

	/**
	* Sets the company ID of this feedback.
	*
	* @param companyId the company ID of this feedback
	*/
	@Override
	public void setCompanyId(long companyId) {
		_feedback.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this feedback.
	*
	* @return the group ID of this feedback
	*/
	@Override
	public long getGroupId() {
		return _feedback.getGroupId();
	}

	/**
	* Sets the group ID of this feedback.
	*
	* @param groupId the group ID of this feedback
	*/
	@Override
	public void setGroupId(long groupId) {
		_feedback.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this feedback.
	*
	* @return the user ID of this feedback
	*/
	@Override
	public long getUserId() {
		return _feedback.getUserId();
	}

	/**
	* Sets the user ID of this feedback.
	*
	* @param userId the user ID of this feedback
	*/
	@Override
	public void setUserId(long userId) {
		_feedback.setUserId(userId);
	}

	/**
	* Returns the user uuid of this feedback.
	*
	* @return the user uuid of this feedback
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedback.getUserUuid();
	}

	/**
	* Sets the user uuid of this feedback.
	*
	* @param userUuid the user uuid of this feedback
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_feedback.setUserUuid(userUuid);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _feedback.getApproved();
	}

	/**
	* Returns <code>true</code> if this feedback is approved.
	*
	* @return <code>true</code> if this feedback is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _feedback.isApproved();
	}

	/**
	* Returns <code>true</code> if this feedback is denied.
	*
	* @return <code>true</code> if this feedback is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _feedback.isDenied();
	}

	/**
	* Returns <code>true</code> if this feedback is a draft.
	*
	* @return <code>true</code> if this feedback is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _feedback.isDraft();
	}

	/**
	* Returns <code>true</code> if this feedback is expired.
	*
	* @return <code>true</code> if this feedback is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _feedback.isExpired();
	}

	/**
	* Returns <code>true</code> if this feedback is inactive.
	*
	* @return <code>true</code> if this feedback is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _feedback.isInactive();
	}

	/**
	* Returns <code>true</code> if this feedback is incomplete.
	*
	* @return <code>true</code> if this feedback is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _feedback.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this feedback is pending.
	*
	* @return <code>true</code> if this feedback is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _feedback.isPending();
	}

	/**
	* Returns <code>true</code> if this feedback is scheduled.
	*
	* @return <code>true</code> if this feedback is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _feedback.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _feedback.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_feedback.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _feedback.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_feedback.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _feedback.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _feedback.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_feedback.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _feedback.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_feedback.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_feedback.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_feedback.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FeedbackWrapper((Feedback)_feedback.clone());
	}

	@Override
	public int compareTo(com.meera.db.model.Feedback feedback) {
		return _feedback.compareTo(feedback);
	}

	@Override
	public int hashCode() {
		return _feedback.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.meera.db.model.Feedback> toCacheModel() {
		return _feedback.toCacheModel();
	}

	@Override
	public com.meera.db.model.Feedback toEscapedModel() {
		return new FeedbackWrapper(_feedback.toEscapedModel());
	}

	@Override
	public com.meera.db.model.Feedback toUnescapedModel() {
		return new FeedbackWrapper(_feedback.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _feedback.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _feedback.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_feedback.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeedbackWrapper)) {
			return false;
		}

		FeedbackWrapper feedbackWrapper = (FeedbackWrapper)obj;

		if (Validator.equals(_feedback, feedbackWrapper._feedback)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Feedback getWrappedFeedback() {
		return _feedback;
	}

	@Override
	public Feedback getWrappedModel() {
		return _feedback;
	}

	@Override
	public void resetOriginalValues() {
		_feedback.resetOriginalValues();
	}

	private Feedback _feedback;
}
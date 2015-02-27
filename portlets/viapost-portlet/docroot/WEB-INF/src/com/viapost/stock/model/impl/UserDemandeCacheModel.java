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

package com.viapost.stock.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viapost.stock.model.UserDemande;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserDemande in entity cache.
 *
 * @author pif
 * @see UserDemande
 * @generated
 */
public class UserDemandeCacheModel implements CacheModel<UserDemande>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{userDemandeId=");
		sb.append(userDemandeId);
		sb.append(", demandeId=");
		sb.append(demandeId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", date=");
		sb.append(date);
		sb.append(", origine=");
		sb.append(origine);
		sb.append(", article=");
		sb.append(article);
		sb.append(", resourcePrimaryKey=");
		sb.append(resourcePrimaryKey);
		sb.append(", title=");
		sb.append(title);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusByDate=");
		sb.append(statusByDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserDemande toEntityModel() {
		UserDemandeImpl userDemandeImpl = new UserDemandeImpl();

		userDemandeImpl.setUserDemandeId(userDemandeId);
		userDemandeImpl.setDemandeId(demandeId);
		userDemandeImpl.setUserId(userId);
		userDemandeImpl.setCompanyId(companyId);
		userDemandeImpl.setGroupId(groupId);

		if (date == Long.MIN_VALUE) {
			userDemandeImpl.setDate(null);
		}
		else {
			userDemandeImpl.setDate(new Date(date));
		}

		if (origine == null) {
			userDemandeImpl.setOrigine(StringPool.BLANK);
		}
		else {
			userDemandeImpl.setOrigine(origine);
		}

		userDemandeImpl.setArticle(article);
		userDemandeImpl.setResourcePrimaryKey(resourcePrimaryKey);

		if (title == null) {
			userDemandeImpl.setTitle(StringPool.BLANK);
		}
		else {
			userDemandeImpl.setTitle(title);
		}

		userDemandeImpl.setStatus(status);
		userDemandeImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			userDemandeImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			userDemandeImpl.setStatusByUserName(statusByUserName);
		}

		if (statusByDate == Long.MIN_VALUE) {
			userDemandeImpl.setStatusByDate(null);
		}
		else {
			userDemandeImpl.setStatusByDate(new Date(statusByDate));
		}

		userDemandeImpl.resetOriginalValues();

		return userDemandeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userDemandeId = objectInput.readLong();
		demandeId = objectInput.readLong();
		userId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		date = objectInput.readLong();
		origine = objectInput.readUTF();
		article = objectInput.readLong();
		resourcePrimaryKey = objectInput.readLong();
		title = objectInput.readUTF();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusByDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userDemandeId);
		objectOutput.writeLong(demandeId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(date);

		if (origine == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(origine);
		}

		objectOutput.writeLong(article);
		objectOutput.writeLong(resourcePrimaryKey);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusByDate);
	}

	public long userDemandeId;
	public long demandeId;
	public long userId;
	public long companyId;
	public long groupId;
	public long date;
	public String origine;
	public long article;
	public long resourcePrimaryKey;
	public String title;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusByDate;
}
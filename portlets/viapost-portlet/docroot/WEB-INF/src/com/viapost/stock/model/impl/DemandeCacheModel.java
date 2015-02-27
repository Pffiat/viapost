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

import com.viapost.stock.model.Demande;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Demande in entity cache.
 *
 * @author pif
 * @see Demande
 * @generated
 */
public class DemandeCacheModel implements CacheModel<Demande>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{demandeId=");
		sb.append(demandeId);
		sb.append(", question=");
		sb.append(question);
		sb.append(", request=");
		sb.append(request);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Demande toEntityModel() {
		DemandeImpl demandeImpl = new DemandeImpl();

		demandeImpl.setDemandeId(demandeId);

		if (question == null) {
			demandeImpl.setQuestion(StringPool.BLANK);
		}
		else {
			demandeImpl.setQuestion(question);
		}

		if (request == null) {
			demandeImpl.setRequest(StringPool.BLANK);
		}
		else {
			demandeImpl.setRequest(request);
		}

		demandeImpl.resetOriginalValues();

		return demandeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		demandeId = objectInput.readLong();
		question = objectInput.readUTF();
		request = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(demandeId);

		if (question == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question);
		}

		if (request == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(request);
		}
	}

	public long demandeId;
	public String question;
	public String request;
}
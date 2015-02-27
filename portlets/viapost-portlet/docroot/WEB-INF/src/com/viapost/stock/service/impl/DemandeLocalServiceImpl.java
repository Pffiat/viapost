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

import javax.portlet.ActionRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.viapost.stock.NoSuchDemandeException;
import com.viapost.stock.model.Demande;
import com.viapost.stock.model.EtapeDemande;
import com.viapost.stock.service.DemandeLocalServiceUtil;
import com.viapost.stock.service.base.DemandeLocalServiceBaseImpl;

/**
 * The implementation of the demande local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viapost.stock.service.DemandeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pif
 * @see com.viapost.stock.service.base.DemandeLocalServiceBaseImpl
 * @see com.viapost.stock.service.DemandeLocalServiceUtil
 */
public class DemandeLocalServiceImpl extends DemandeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viapost.stock.service.DemandeLocalServiceUtil} to access the demande local service.
	 */	
	
	private final static Log LOG = LogFactoryUtil.getLog(DemandeLocalServiceUtil.class);
	
	@Override
	public long findByQuestion(final String question) throws NoSuchDemandeException, SystemException {
		return demandePersistence.findByQuestion(question).getDemandeId();
	}
	
	@Override
	public void addDemandeFromRequest(final ActionRequest request) throws SystemException {

		long primaryKey = CounterLocalServiceUtil.increment(Demande.class.getName());
		final Demande demande = demandePersistence.create(primaryKey);
		demande.setRequest(ParamUtil.getString(request, "demande"));
		demande.setQuestion(ParamUtil.getString(request, "question"));
		demandePersistence.update(demande);
		
		final int numberOfStep = ParamUtil.getInteger(request, "numberOfStep");
		for(int index = 1; index <= numberOfStep; index++) {

			primaryKey = CounterLocalServiceUtil.increment(EtapeDemande.class.getName());
			final EtapeDemande etape = etapeDemandePersistence.create(primaryKey);
			etape.setDemandeId(demande.getPrimaryKey());
			etape.setOrder(index);
			etape.setDecription(ParamUtil.getString(request, "etape"+ index));
			etapeDemandePersistence.update(etape);
		}
	}
}
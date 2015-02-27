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

package com.viapost.stock.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.viapost.stock.model.DemandeClp;
import com.viapost.stock.model.EtapeDemandeClp;
import com.viapost.stock.model.ProductClp;
import com.viapost.stock.model.UserDemandeClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pif
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"viapost-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"viapost-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "viapost-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(DemandeClp.class.getName())) {
			return translateInputDemande(oldModel);
		}

		if (oldModelClassName.equals(EtapeDemandeClp.class.getName())) {
			return translateInputEtapeDemande(oldModel);
		}

		if (oldModelClassName.equals(ProductClp.class.getName())) {
			return translateInputProduct(oldModel);
		}

		if (oldModelClassName.equals(UserDemandeClp.class.getName())) {
			return translateInputUserDemande(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputDemande(BaseModel<?> oldModel) {
		DemandeClp oldClpModel = (DemandeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDemandeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEtapeDemande(BaseModel<?> oldModel) {
		EtapeDemandeClp oldClpModel = (EtapeDemandeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEtapeDemandeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProduct(BaseModel<?> oldModel) {
		ProductClp oldClpModel = (ProductClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProductRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserDemande(BaseModel<?> oldModel) {
		UserDemandeClp oldClpModel = (UserDemandeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserDemandeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.viapost.stock.model.impl.DemandeImpl")) {
			return translateOutputDemande(oldModel);
		}

		if (oldModelClassName.equals(
					"com.viapost.stock.model.impl.EtapeDemandeImpl")) {
			return translateOutputEtapeDemande(oldModel);
		}

		if (oldModelClassName.equals("com.viapost.stock.model.impl.ProductImpl")) {
			return translateOutputProduct(oldModel);
		}

		if (oldModelClassName.equals(
					"com.viapost.stock.model.impl.UserDemandeImpl")) {
			return translateOutputUserDemande(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.viapost.stock.NoSuchDemandeException")) {
			return new com.viapost.stock.NoSuchDemandeException();
		}

		if (className.equals("com.viapost.stock.NoSuchEtapeDemandeException")) {
			return new com.viapost.stock.NoSuchEtapeDemandeException();
		}

		if (className.equals("com.viapost.stock.NoSuchProductException")) {
			return new com.viapost.stock.NoSuchProductException();
		}

		if (className.equals("com.viapost.stock.NoSuchUserDemandeException")) {
			return new com.viapost.stock.NoSuchUserDemandeException();
		}

		return throwable;
	}

	public static Object translateOutputDemande(BaseModel<?> oldModel) {
		DemandeClp newModel = new DemandeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDemandeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEtapeDemande(BaseModel<?> oldModel) {
		EtapeDemandeClp newModel = new EtapeDemandeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEtapeDemandeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProduct(BaseModel<?> oldModel) {
		ProductClp newModel = new ProductClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProductRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserDemande(BaseModel<?> oldModel) {
		UserDemandeClp newModel = new UserDemandeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserDemandeRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}
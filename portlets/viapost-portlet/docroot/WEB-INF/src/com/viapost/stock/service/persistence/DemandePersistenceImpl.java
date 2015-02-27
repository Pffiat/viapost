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

package com.viapost.stock.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.viapost.stock.NoSuchDemandeException;
import com.viapost.stock.model.Demande;
import com.viapost.stock.model.impl.DemandeImpl;
import com.viapost.stock.model.impl.DemandeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the demande service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pif
 * @see DemandePersistence
 * @see DemandeUtil
 * @generated
 */
public class DemandePersistenceImpl extends BasePersistenceImpl<Demande>
	implements DemandePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DemandeUtil} to access the demande persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DemandeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DemandeModelImpl.ENTITY_CACHE_ENABLED,
			DemandeModelImpl.FINDER_CACHE_ENABLED, DemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DemandeModelImpl.ENTITY_CACHE_ENABLED,
			DemandeModelImpl.FINDER_CACHE_ENABLED, DemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DemandeModelImpl.ENTITY_CACHE_ENABLED,
			DemandeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_QUESTION = new FinderPath(DemandeModelImpl.ENTITY_CACHE_ENABLED,
			DemandeModelImpl.FINDER_CACHE_ENABLED, DemandeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByQuestion",
			new String[] { String.class.getName() },
			DemandeModelImpl.QUESTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QUESTION = new FinderPath(DemandeModelImpl.ENTITY_CACHE_ENABLED,
			DemandeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestion",
			new String[] { String.class.getName() });

	/**
	 * Returns the demande where question = &#63; or throws a {@link com.viapost.stock.NoSuchDemandeException} if it could not be found.
	 *
	 * @param question the question
	 * @return the matching demande
	 * @throws com.viapost.stock.NoSuchDemandeException if a matching demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Demande findByQuestion(String question)
		throws NoSuchDemandeException, SystemException {
		Demande demande = fetchByQuestion(question);

		if (demande == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("question=");
			msg.append(question);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDemandeException(msg.toString());
		}

		return demande;
	}

	/**
	 * Returns the demande where question = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param question the question
	 * @return the matching demande, or <code>null</code> if a matching demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Demande fetchByQuestion(String question) throws SystemException {
		return fetchByQuestion(question, true);
	}

	/**
	 * Returns the demande where question = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param question the question
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching demande, or <code>null</code> if a matching demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Demande fetchByQuestion(String question, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { question };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_QUESTION,
					finderArgs, this);
		}

		if (result instanceof Demande) {
			Demande demande = (Demande)result;

			if (!Validator.equals(question, demande.getQuestion())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DEMANDE_WHERE);

			boolean bindQuestion = false;

			if (question == null) {
				query.append(_FINDER_COLUMN_QUESTION_QUESTION_1);
			}
			else if (question.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_QUESTION_QUESTION_3);
			}
			else {
				bindQuestion = true;

				query.append(_FINDER_COLUMN_QUESTION_QUESTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindQuestion) {
					qPos.add(question);
				}

				List<Demande> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUESTION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DemandePersistenceImpl.fetchByQuestion(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Demande demande = list.get(0);

					result = demande;

					cacheResult(demande);

					if ((demande.getQuestion() == null) ||
							!demande.getQuestion().equals(question)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUESTION,
							finderArgs, demande);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_QUESTION,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Demande)result;
		}
	}

	/**
	 * Removes the demande where question = &#63; from the database.
	 *
	 * @param question the question
	 * @return the demande that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Demande removeByQuestion(String question)
		throws NoSuchDemandeException, SystemException {
		Demande demande = findByQuestion(question);

		return remove(demande);
	}

	/**
	 * Returns the number of demandes where question = &#63;.
	 *
	 * @param question the question
	 * @return the number of matching demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByQuestion(String question) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_QUESTION;

		Object[] finderArgs = new Object[] { question };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEMANDE_WHERE);

			boolean bindQuestion = false;

			if (question == null) {
				query.append(_FINDER_COLUMN_QUESTION_QUESTION_1);
			}
			else if (question.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_QUESTION_QUESTION_3);
			}
			else {
				bindQuestion = true;

				query.append(_FINDER_COLUMN_QUESTION_QUESTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindQuestion) {
					qPos.add(question);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_QUESTION_QUESTION_1 = "demande.question IS NULL";
	private static final String _FINDER_COLUMN_QUESTION_QUESTION_2 = "demande.question = ?";
	private static final String _FINDER_COLUMN_QUESTION_QUESTION_3 = "(demande.question IS NULL OR demande.question = '')";

	public DemandePersistenceImpl() {
		setModelClass(Demande.class);
	}

	/**
	 * Caches the demande in the entity cache if it is enabled.
	 *
	 * @param demande the demande
	 */
	@Override
	public void cacheResult(Demande demande) {
		EntityCacheUtil.putResult(DemandeModelImpl.ENTITY_CACHE_ENABLED,
			DemandeImpl.class, demande.getPrimaryKey(), demande);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUESTION,
			new Object[] { demande.getQuestion() }, demande);

		demande.resetOriginalValues();
	}

	/**
	 * Caches the demandes in the entity cache if it is enabled.
	 *
	 * @param demandes the demandes
	 */
	@Override
	public void cacheResult(List<Demande> demandes) {
		for (Demande demande : demandes) {
			if (EntityCacheUtil.getResult(
						DemandeModelImpl.ENTITY_CACHE_ENABLED,
						DemandeImpl.class, demande.getPrimaryKey()) == null) {
				cacheResult(demande);
			}
			else {
				demande.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all demandes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DemandeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DemandeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the demande.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Demande demande) {
		EntityCacheUtil.removeResult(DemandeModelImpl.ENTITY_CACHE_ENABLED,
			DemandeImpl.class, demande.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(demande);
	}

	@Override
	public void clearCache(List<Demande> demandes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Demande demande : demandes) {
			EntityCacheUtil.removeResult(DemandeModelImpl.ENTITY_CACHE_ENABLED,
				DemandeImpl.class, demande.getPrimaryKey());

			clearUniqueFindersCache(demande);
		}
	}

	protected void cacheUniqueFindersCache(Demande demande) {
		if (demande.isNew()) {
			Object[] args = new Object[] { demande.getQuestion() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUESTION, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUESTION, args,
				demande);
		}
		else {
			DemandeModelImpl demandeModelImpl = (DemandeModelImpl)demande;

			if ((demandeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_QUESTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { demande.getQuestion() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUESTION, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUESTION, args,
					demande);
			}
		}
	}

	protected void clearUniqueFindersCache(Demande demande) {
		DemandeModelImpl demandeModelImpl = (DemandeModelImpl)demande;

		Object[] args = new Object[] { demande.getQuestion() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_QUESTION, args);

		if ((demandeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_QUESTION.getColumnBitmask()) != 0) {
			args = new Object[] { demandeModelImpl.getOriginalQuestion() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTION, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_QUESTION, args);
		}
	}

	/**
	 * Creates a new demande with the primary key. Does not add the demande to the database.
	 *
	 * @param demandeId the primary key for the new demande
	 * @return the new demande
	 */
	@Override
	public Demande create(long demandeId) {
		Demande demande = new DemandeImpl();

		demande.setNew(true);
		demande.setPrimaryKey(demandeId);

		return demande;
	}

	/**
	 * Removes the demande with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande that was removed
	 * @throws com.viapost.stock.NoSuchDemandeException if a demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Demande remove(long demandeId)
		throws NoSuchDemandeException, SystemException {
		return remove((Serializable)demandeId);
	}

	/**
	 * Removes the demande with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the demande
	 * @return the demande that was removed
	 * @throws com.viapost.stock.NoSuchDemandeException if a demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Demande remove(Serializable primaryKey)
		throws NoSuchDemandeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Demande demande = (Demande)session.get(DemandeImpl.class, primaryKey);

			if (demande == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDemandeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(demande);
		}
		catch (NoSuchDemandeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Demande removeImpl(Demande demande) throws SystemException {
		demande = toUnwrappedModel(demande);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(demande)) {
				demande = (Demande)session.get(DemandeImpl.class,
						demande.getPrimaryKeyObj());
			}

			if (demande != null) {
				session.delete(demande);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (demande != null) {
			clearCache(demande);
		}

		return demande;
	}

	@Override
	public Demande updateImpl(com.viapost.stock.model.Demande demande)
		throws SystemException {
		demande = toUnwrappedModel(demande);

		boolean isNew = demande.isNew();

		Session session = null;

		try {
			session = openSession();

			if (demande.isNew()) {
				session.save(demande);

				demande.setNew(false);
			}
			else {
				session.merge(demande);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DemandeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(DemandeModelImpl.ENTITY_CACHE_ENABLED,
			DemandeImpl.class, demande.getPrimaryKey(), demande);

		clearUniqueFindersCache(demande);
		cacheUniqueFindersCache(demande);

		return demande;
	}

	protected Demande toUnwrappedModel(Demande demande) {
		if (demande instanceof DemandeImpl) {
			return demande;
		}

		DemandeImpl demandeImpl = new DemandeImpl();

		demandeImpl.setNew(demande.isNew());
		demandeImpl.setPrimaryKey(demande.getPrimaryKey());

		demandeImpl.setDemandeId(demande.getDemandeId());
		demandeImpl.setQuestion(demande.getQuestion());
		demandeImpl.setRequest(demande.getRequest());

		return demandeImpl;
	}

	/**
	 * Returns the demande with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the demande
	 * @return the demande
	 * @throws com.viapost.stock.NoSuchDemandeException if a demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Demande findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDemandeException, SystemException {
		Demande demande = fetchByPrimaryKey(primaryKey);

		if (demande == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDemandeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return demande;
	}

	/**
	 * Returns the demande with the primary key or throws a {@link com.viapost.stock.NoSuchDemandeException} if it could not be found.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande
	 * @throws com.viapost.stock.NoSuchDemandeException if a demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Demande findByPrimaryKey(long demandeId)
		throws NoSuchDemandeException, SystemException {
		return findByPrimaryKey((Serializable)demandeId);
	}

	/**
	 * Returns the demande with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the demande
	 * @return the demande, or <code>null</code> if a demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Demande fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Demande demande = (Demande)EntityCacheUtil.getResult(DemandeModelImpl.ENTITY_CACHE_ENABLED,
				DemandeImpl.class, primaryKey);

		if (demande == _nullDemande) {
			return null;
		}

		if (demande == null) {
			Session session = null;

			try {
				session = openSession();

				demande = (Demande)session.get(DemandeImpl.class, primaryKey);

				if (demande != null) {
					cacheResult(demande);
				}
				else {
					EntityCacheUtil.putResult(DemandeModelImpl.ENTITY_CACHE_ENABLED,
						DemandeImpl.class, primaryKey, _nullDemande);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DemandeModelImpl.ENTITY_CACHE_ENABLED,
					DemandeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return demande;
	}

	/**
	 * Returns the demande with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande, or <code>null</code> if a demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Demande fetchByPrimaryKey(long demandeId) throws SystemException {
		return fetchByPrimaryKey((Serializable)demandeId);
	}

	/**
	 * Returns all the demandes.
	 *
	 * @return the demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Demande> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the demandes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.DemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @return the range of demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Demande> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the demandes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.DemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Demande> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Demande> list = (List<Demande>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEMANDE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEMANDE;

				if (pagination) {
					sql = sql.concat(DemandeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Demande>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Demande>(list);
				}
				else {
					list = (List<Demande>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the demandes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Demande demande : findAll()) {
			remove(demande);
		}
	}

	/**
	 * Returns the number of demandes.
	 *
	 * @return the number of demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DEMANDE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the demande persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viapost.stock.model.Demande")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Demande>> listenersList = new ArrayList<ModelListener<Demande>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Demande>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(DemandeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DEMANDE = "SELECT demande FROM Demande demande";
	private static final String _SQL_SELECT_DEMANDE_WHERE = "SELECT demande FROM Demande demande WHERE ";
	private static final String _SQL_COUNT_DEMANDE = "SELECT COUNT(demande) FROM Demande demande";
	private static final String _SQL_COUNT_DEMANDE_WHERE = "SELECT COUNT(demande) FROM Demande demande WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "demande.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Demande exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Demande exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DemandePersistenceImpl.class);
	private static Demande _nullDemande = new DemandeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Demande> toCacheModel() {
				return _nullDemandeCacheModel;
			}
		};

	private static CacheModel<Demande> _nullDemandeCacheModel = new CacheModel<Demande>() {
			@Override
			public Demande toEntityModel() {
				return _nullDemande;
			}
		};
}
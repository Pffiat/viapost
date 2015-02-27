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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.viapost.stock.NoSuchEtapeDemandeException;
import com.viapost.stock.model.EtapeDemande;
import com.viapost.stock.model.impl.EtapeDemandeImpl;
import com.viapost.stock.model.impl.EtapeDemandeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the etape demande service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pif
 * @see EtapeDemandePersistence
 * @see EtapeDemandeUtil
 * @generated
 */
public class EtapeDemandePersistenceImpl extends BasePersistenceImpl<EtapeDemande>
	implements EtapeDemandePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EtapeDemandeUtil} to access the etape demande persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EtapeDemandeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
			EtapeDemandeModelImpl.FINDER_CACHE_ENABLED, EtapeDemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
			EtapeDemandeModelImpl.FINDER_CACHE_ENABLED, EtapeDemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
			EtapeDemandeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEMANDEID =
		new FinderPath(EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
			EtapeDemandeModelImpl.FINDER_CACHE_ENABLED, EtapeDemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDemandeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEMANDEID =
		new FinderPath(EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
			EtapeDemandeModelImpl.FINDER_CACHE_ENABLED, EtapeDemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDemandeId",
			new String[] { Long.class.getName() },
			EtapeDemandeModelImpl.DEMANDEID_COLUMN_BITMASK |
			EtapeDemandeModelImpl.ORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEMANDEID = new FinderPath(EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
			EtapeDemandeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDemandeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the etape demandes where demandeId = &#63;.
	 *
	 * @param demandeId the demande ID
	 * @return the matching etape demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EtapeDemande> findByDemandeId(long demandeId)
		throws SystemException {
		return findByDemandeId(demandeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the etape demandes where demandeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.EtapeDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param demandeId the demande ID
	 * @param start the lower bound of the range of etape demandes
	 * @param end the upper bound of the range of etape demandes (not inclusive)
	 * @return the range of matching etape demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EtapeDemande> findByDemandeId(long demandeId, int start, int end)
		throws SystemException {
		return findByDemandeId(demandeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the etape demandes where demandeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.EtapeDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param demandeId the demande ID
	 * @param start the lower bound of the range of etape demandes
	 * @param end the upper bound of the range of etape demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching etape demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EtapeDemande> findByDemandeId(long demandeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEMANDEID;
			finderArgs = new Object[] { demandeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEMANDEID;
			finderArgs = new Object[] { demandeId, start, end, orderByComparator };
		}

		List<EtapeDemande> list = (List<EtapeDemande>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EtapeDemande etapeDemande : list) {
				if ((demandeId != etapeDemande.getDemandeId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ETAPEDEMANDE_WHERE);

			query.append(_FINDER_COLUMN_DEMANDEID_DEMANDEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EtapeDemandeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(demandeId);

				if (!pagination) {
					list = (List<EtapeDemande>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EtapeDemande>(list);
				}
				else {
					list = (List<EtapeDemande>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first etape demande in the ordered set where demandeId = &#63;.
	 *
	 * @param demandeId the demande ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching etape demande
	 * @throws com.viapost.stock.NoSuchEtapeDemandeException if a matching etape demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EtapeDemande findByDemandeId_First(long demandeId,
		OrderByComparator orderByComparator)
		throws NoSuchEtapeDemandeException, SystemException {
		EtapeDemande etapeDemande = fetchByDemandeId_First(demandeId,
				orderByComparator);

		if (etapeDemande != null) {
			return etapeDemande;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("demandeId=");
		msg.append(demandeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEtapeDemandeException(msg.toString());
	}

	/**
	 * Returns the first etape demande in the ordered set where demandeId = &#63;.
	 *
	 * @param demandeId the demande ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching etape demande, or <code>null</code> if a matching etape demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EtapeDemande fetchByDemandeId_First(long demandeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EtapeDemande> list = findByDemandeId(demandeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last etape demande in the ordered set where demandeId = &#63;.
	 *
	 * @param demandeId the demande ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching etape demande
	 * @throws com.viapost.stock.NoSuchEtapeDemandeException if a matching etape demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EtapeDemande findByDemandeId_Last(long demandeId,
		OrderByComparator orderByComparator)
		throws NoSuchEtapeDemandeException, SystemException {
		EtapeDemande etapeDemande = fetchByDemandeId_Last(demandeId,
				orderByComparator);

		if (etapeDemande != null) {
			return etapeDemande;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("demandeId=");
		msg.append(demandeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEtapeDemandeException(msg.toString());
	}

	/**
	 * Returns the last etape demande in the ordered set where demandeId = &#63;.
	 *
	 * @param demandeId the demande ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching etape demande, or <code>null</code> if a matching etape demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EtapeDemande fetchByDemandeId_Last(long demandeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDemandeId(demandeId);

		if (count == 0) {
			return null;
		}

		List<EtapeDemande> list = findByDemandeId(demandeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the etape demandes before and after the current etape demande in the ordered set where demandeId = &#63;.
	 *
	 * @param etapeId the primary key of the current etape demande
	 * @param demandeId the demande ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next etape demande
	 * @throws com.viapost.stock.NoSuchEtapeDemandeException if a etape demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EtapeDemande[] findByDemandeId_PrevAndNext(long etapeId,
		long demandeId, OrderByComparator orderByComparator)
		throws NoSuchEtapeDemandeException, SystemException {
		EtapeDemande etapeDemande = findByPrimaryKey(etapeId);

		Session session = null;

		try {
			session = openSession();

			EtapeDemande[] array = new EtapeDemandeImpl[3];

			array[0] = getByDemandeId_PrevAndNext(session, etapeDemande,
					demandeId, orderByComparator, true);

			array[1] = etapeDemande;

			array[2] = getByDemandeId_PrevAndNext(session, etapeDemande,
					demandeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EtapeDemande getByDemandeId_PrevAndNext(Session session,
		EtapeDemande etapeDemande, long demandeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ETAPEDEMANDE_WHERE);

		query.append(_FINDER_COLUMN_DEMANDEID_DEMANDEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EtapeDemandeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(demandeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(etapeDemande);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EtapeDemande> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the etape demandes where demandeId = &#63; from the database.
	 *
	 * @param demandeId the demande ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDemandeId(long demandeId) throws SystemException {
		for (EtapeDemande etapeDemande : findByDemandeId(demandeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(etapeDemande);
		}
	}

	/**
	 * Returns the number of etape demandes where demandeId = &#63;.
	 *
	 * @param demandeId the demande ID
	 * @return the number of matching etape demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDemandeId(long demandeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEMANDEID;

		Object[] finderArgs = new Object[] { demandeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ETAPEDEMANDE_WHERE);

			query.append(_FINDER_COLUMN_DEMANDEID_DEMANDEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(demandeId);

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

	private static final String _FINDER_COLUMN_DEMANDEID_DEMANDEID_2 = "etapeDemande.demandeId = ?";

	public EtapeDemandePersistenceImpl() {
		setModelClass(EtapeDemande.class);
	}

	/**
	 * Caches the etape demande in the entity cache if it is enabled.
	 *
	 * @param etapeDemande the etape demande
	 */
	@Override
	public void cacheResult(EtapeDemande etapeDemande) {
		EntityCacheUtil.putResult(EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
			EtapeDemandeImpl.class, etapeDemande.getPrimaryKey(), etapeDemande);

		etapeDemande.resetOriginalValues();
	}

	/**
	 * Caches the etape demandes in the entity cache if it is enabled.
	 *
	 * @param etapeDemandes the etape demandes
	 */
	@Override
	public void cacheResult(List<EtapeDemande> etapeDemandes) {
		for (EtapeDemande etapeDemande : etapeDemandes) {
			if (EntityCacheUtil.getResult(
						EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
						EtapeDemandeImpl.class, etapeDemande.getPrimaryKey()) == null) {
				cacheResult(etapeDemande);
			}
			else {
				etapeDemande.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all etape demandes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EtapeDemandeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EtapeDemandeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the etape demande.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EtapeDemande etapeDemande) {
		EntityCacheUtil.removeResult(EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
			EtapeDemandeImpl.class, etapeDemande.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EtapeDemande> etapeDemandes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EtapeDemande etapeDemande : etapeDemandes) {
			EntityCacheUtil.removeResult(EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
				EtapeDemandeImpl.class, etapeDemande.getPrimaryKey());
		}
	}

	/**
	 * Creates a new etape demande with the primary key. Does not add the etape demande to the database.
	 *
	 * @param etapeId the primary key for the new etape demande
	 * @return the new etape demande
	 */
	@Override
	public EtapeDemande create(long etapeId) {
		EtapeDemande etapeDemande = new EtapeDemandeImpl();

		etapeDemande.setNew(true);
		etapeDemande.setPrimaryKey(etapeId);

		return etapeDemande;
	}

	/**
	 * Removes the etape demande with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param etapeId the primary key of the etape demande
	 * @return the etape demande that was removed
	 * @throws com.viapost.stock.NoSuchEtapeDemandeException if a etape demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EtapeDemande remove(long etapeId)
		throws NoSuchEtapeDemandeException, SystemException {
		return remove((Serializable)etapeId);
	}

	/**
	 * Removes the etape demande with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the etape demande
	 * @return the etape demande that was removed
	 * @throws com.viapost.stock.NoSuchEtapeDemandeException if a etape demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EtapeDemande remove(Serializable primaryKey)
		throws NoSuchEtapeDemandeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EtapeDemande etapeDemande = (EtapeDemande)session.get(EtapeDemandeImpl.class,
					primaryKey);

			if (etapeDemande == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEtapeDemandeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(etapeDemande);
		}
		catch (NoSuchEtapeDemandeException nsee) {
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
	protected EtapeDemande removeImpl(EtapeDemande etapeDemande)
		throws SystemException {
		etapeDemande = toUnwrappedModel(etapeDemande);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(etapeDemande)) {
				etapeDemande = (EtapeDemande)session.get(EtapeDemandeImpl.class,
						etapeDemande.getPrimaryKeyObj());
			}

			if (etapeDemande != null) {
				session.delete(etapeDemande);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (etapeDemande != null) {
			clearCache(etapeDemande);
		}

		return etapeDemande;
	}

	@Override
	public EtapeDemande updateImpl(
		com.viapost.stock.model.EtapeDemande etapeDemande)
		throws SystemException {
		etapeDemande = toUnwrappedModel(etapeDemande);

		boolean isNew = etapeDemande.isNew();

		EtapeDemandeModelImpl etapeDemandeModelImpl = (EtapeDemandeModelImpl)etapeDemande;

		Session session = null;

		try {
			session = openSession();

			if (etapeDemande.isNew()) {
				session.save(etapeDemande);

				etapeDemande.setNew(false);
			}
			else {
				session.merge(etapeDemande);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EtapeDemandeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((etapeDemandeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEMANDEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						etapeDemandeModelImpl.getOriginalDemandeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEMANDEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEMANDEID,
					args);

				args = new Object[] { etapeDemandeModelImpl.getDemandeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEMANDEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEMANDEID,
					args);
			}
		}

		EntityCacheUtil.putResult(EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
			EtapeDemandeImpl.class, etapeDemande.getPrimaryKey(), etapeDemande);

		return etapeDemande;
	}

	protected EtapeDemande toUnwrappedModel(EtapeDemande etapeDemande) {
		if (etapeDemande instanceof EtapeDemandeImpl) {
			return etapeDemande;
		}

		EtapeDemandeImpl etapeDemandeImpl = new EtapeDemandeImpl();

		etapeDemandeImpl.setNew(etapeDemande.isNew());
		etapeDemandeImpl.setPrimaryKey(etapeDemande.getPrimaryKey());

		etapeDemandeImpl.setEtapeId(etapeDemande.getEtapeId());
		etapeDemandeImpl.setDemandeId(etapeDemande.getDemandeId());
		etapeDemandeImpl.setDecription(etapeDemande.getDecription());
		etapeDemandeImpl.setOrder(etapeDemande.getOrder());

		return etapeDemandeImpl;
	}

	/**
	 * Returns the etape demande with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the etape demande
	 * @return the etape demande
	 * @throws com.viapost.stock.NoSuchEtapeDemandeException if a etape demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EtapeDemande findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEtapeDemandeException, SystemException {
		EtapeDemande etapeDemande = fetchByPrimaryKey(primaryKey);

		if (etapeDemande == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEtapeDemandeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return etapeDemande;
	}

	/**
	 * Returns the etape demande with the primary key or throws a {@link com.viapost.stock.NoSuchEtapeDemandeException} if it could not be found.
	 *
	 * @param etapeId the primary key of the etape demande
	 * @return the etape demande
	 * @throws com.viapost.stock.NoSuchEtapeDemandeException if a etape demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EtapeDemande findByPrimaryKey(long etapeId)
		throws NoSuchEtapeDemandeException, SystemException {
		return findByPrimaryKey((Serializable)etapeId);
	}

	/**
	 * Returns the etape demande with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the etape demande
	 * @return the etape demande, or <code>null</code> if a etape demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EtapeDemande fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EtapeDemande etapeDemande = (EtapeDemande)EntityCacheUtil.getResult(EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
				EtapeDemandeImpl.class, primaryKey);

		if (etapeDemande == _nullEtapeDemande) {
			return null;
		}

		if (etapeDemande == null) {
			Session session = null;

			try {
				session = openSession();

				etapeDemande = (EtapeDemande)session.get(EtapeDemandeImpl.class,
						primaryKey);

				if (etapeDemande != null) {
					cacheResult(etapeDemande);
				}
				else {
					EntityCacheUtil.putResult(EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
						EtapeDemandeImpl.class, primaryKey, _nullEtapeDemande);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EtapeDemandeModelImpl.ENTITY_CACHE_ENABLED,
					EtapeDemandeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return etapeDemande;
	}

	/**
	 * Returns the etape demande with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param etapeId the primary key of the etape demande
	 * @return the etape demande, or <code>null</code> if a etape demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EtapeDemande fetchByPrimaryKey(long etapeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)etapeId);
	}

	/**
	 * Returns all the etape demandes.
	 *
	 * @return the etape demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EtapeDemande> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the etape demandes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.EtapeDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of etape demandes
	 * @param end the upper bound of the range of etape demandes (not inclusive)
	 * @return the range of etape demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EtapeDemande> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the etape demandes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.EtapeDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of etape demandes
	 * @param end the upper bound of the range of etape demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of etape demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EtapeDemande> findAll(int start, int end,
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

		List<EtapeDemande> list = (List<EtapeDemande>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ETAPEDEMANDE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ETAPEDEMANDE;

				if (pagination) {
					sql = sql.concat(EtapeDemandeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EtapeDemande>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EtapeDemande>(list);
				}
				else {
					list = (List<EtapeDemande>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the etape demandes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EtapeDemande etapeDemande : findAll()) {
			remove(etapeDemande);
		}
	}

	/**
	 * Returns the number of etape demandes.
	 *
	 * @return the number of etape demandes
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

				Query q = session.createQuery(_SQL_COUNT_ETAPEDEMANDE);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the etape demande persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viapost.stock.model.EtapeDemande")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EtapeDemande>> listenersList = new ArrayList<ModelListener<EtapeDemande>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EtapeDemande>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EtapeDemandeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ETAPEDEMANDE = "SELECT etapeDemande FROM EtapeDemande etapeDemande";
	private static final String _SQL_SELECT_ETAPEDEMANDE_WHERE = "SELECT etapeDemande FROM EtapeDemande etapeDemande WHERE ";
	private static final String _SQL_COUNT_ETAPEDEMANDE = "SELECT COUNT(etapeDemande) FROM EtapeDemande etapeDemande";
	private static final String _SQL_COUNT_ETAPEDEMANDE_WHERE = "SELECT COUNT(etapeDemande) FROM EtapeDemande etapeDemande WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "etapeDemande.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EtapeDemande exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EtapeDemande exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EtapeDemandePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"order"
			});
	private static EtapeDemande _nullEtapeDemande = new EtapeDemandeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EtapeDemande> toCacheModel() {
				return _nullEtapeDemandeCacheModel;
			}
		};

	private static CacheModel<EtapeDemande> _nullEtapeDemandeCacheModel = new CacheModel<EtapeDemande>() {
			@Override
			public EtapeDemande toEntityModel() {
				return _nullEtapeDemande;
			}
		};
}
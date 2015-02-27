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

import com.viapost.stock.NoSuchUserDemandeException;
import com.viapost.stock.model.UserDemande;
import com.viapost.stock.model.impl.UserDemandeImpl;
import com.viapost.stock.model.impl.UserDemandeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the user demande service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pif
 * @see UserDemandePersistence
 * @see UserDemandeUtil
 * @generated
 */
public class UserDemandePersistenceImpl extends BasePersistenceImpl<UserDemande>
	implements UserDemandePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserDemandeUtil} to access the user demande persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserDemandeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
			UserDemandeModelImpl.FINDER_CACHE_ENABLED, UserDemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
			UserDemandeModelImpl.FINDER_CACHE_ENABLED, UserDemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
			UserDemandeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
			UserDemandeModelImpl.FINDER_CACHE_ENABLED, UserDemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
			UserDemandeModelImpl.FINDER_CACHE_ENABLED, UserDemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			UserDemandeModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
			UserDemandeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user demandes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDemande> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user demandes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user demandes
	 * @param end the upper bound of the range of user demandes (not inclusive)
	 * @return the range of matching user demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDemande> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user demandes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user demandes
	 * @param end the upper bound of the range of user demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDemande> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<UserDemande> list = (List<UserDemande>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserDemande userDemande : list) {
				if ((userId != userDemande.getUserId())) {
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

			query.append(_SQL_SELECT_USERDEMANDE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserDemandeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<UserDemande>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserDemande>(list);
				}
				else {
					list = (List<UserDemande>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user demande
	 * @throws com.viapost.stock.NoSuchUserDemandeException if a matching user demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserDemandeException, SystemException {
		UserDemande userDemande = fetchByUserId_First(userId, orderByComparator);

		if (userDemande != null) {
			return userDemande;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserDemandeException(msg.toString());
	}

	/**
	 * Returns the first user demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user demande, or <code>null</code> if a matching user demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserDemande> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user demande
	 * @throws com.viapost.stock.NoSuchUserDemandeException if a matching user demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserDemandeException, SystemException {
		UserDemande userDemande = fetchByUserId_Last(userId, orderByComparator);

		if (userDemande != null) {
			return userDemande;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserDemandeException(msg.toString());
	}

	/**
	 * Returns the last user demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user demande, or <code>null</code> if a matching user demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<UserDemande> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user demandes before and after the current user demande in the ordered set where userId = &#63;.
	 *
	 * @param userDemandeId the primary key of the current user demande
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user demande
	 * @throws com.viapost.stock.NoSuchUserDemandeException if a user demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande[] findByUserId_PrevAndNext(long userDemandeId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchUserDemandeException, SystemException {
		UserDemande userDemande = findByPrimaryKey(userDemandeId);

		Session session = null;

		try {
			session = openSession();

			UserDemande[] array = new UserDemandeImpl[3];

			array[0] = getByUserId_PrevAndNext(session, userDemande, userId,
					orderByComparator, true);

			array[1] = userDemande;

			array[2] = getByUserId_PrevAndNext(session, userDemande, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserDemande getByUserId_PrevAndNext(Session session,
		UserDemande userDemande, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERDEMANDE_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(UserDemandeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userDemande);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserDemande> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user demandes where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (UserDemande userDemande : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userDemande);
		}
	}

	/**
	 * Returns the number of user demandes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERDEMANDE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userDemande.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESOURCEANDSTATUS =
		new FinderPath(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
			UserDemandeModelImpl.FINDER_CACHE_ENABLED, UserDemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResourceAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEANDSTATUS =
		new FinderPath(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
			UserDemandeModelImpl.FINDER_CACHE_ENABLED, UserDemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByResourceAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			UserDemandeModelImpl.RESOURCEPRIMARYKEY_COLUMN_BITMASK |
			UserDemandeModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESOURCEANDSTATUS = new FinderPath(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
			UserDemandeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResourceAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the user demandes where resourcePrimaryKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimaryKey the resource primary key
	 * @param status the status
	 * @return the matching user demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDemande> findByResourceAndStatus(long resourcePrimaryKey,
		int status) throws SystemException {
		return findByResourceAndStatus(resourcePrimaryKey, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user demandes where resourcePrimaryKey = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param resourcePrimaryKey the resource primary key
	 * @param status the status
	 * @param start the lower bound of the range of user demandes
	 * @param end the upper bound of the range of user demandes (not inclusive)
	 * @return the range of matching user demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDemande> findByResourceAndStatus(long resourcePrimaryKey,
		int status, int start, int end) throws SystemException {
		return findByResourceAndStatus(resourcePrimaryKey, status, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the user demandes where resourcePrimaryKey = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param resourcePrimaryKey the resource primary key
	 * @param status the status
	 * @param start the lower bound of the range of user demandes
	 * @param end the upper bound of the range of user demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDemande> findByResourceAndStatus(long resourcePrimaryKey,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEANDSTATUS;
			finderArgs = new Object[] { resourcePrimaryKey, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RESOURCEANDSTATUS;
			finderArgs = new Object[] {
					resourcePrimaryKey, status,
					
					start, end, orderByComparator
				};
		}

		List<UserDemande> list = (List<UserDemande>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserDemande userDemande : list) {
				if ((resourcePrimaryKey != userDemande.getResourcePrimaryKey()) ||
						(status != userDemande.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_USERDEMANDE_WHERE);

			query.append(_FINDER_COLUMN_RESOURCEANDSTATUS_RESOURCEPRIMARYKEY_2);

			query.append(_FINDER_COLUMN_RESOURCEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserDemandeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resourcePrimaryKey);

				qPos.add(status);

				if (!pagination) {
					list = (List<UserDemande>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserDemande>(list);
				}
				else {
					list = (List<UserDemande>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user demande in the ordered set where resourcePrimaryKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimaryKey the resource primary key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user demande
	 * @throws com.viapost.stock.NoSuchUserDemandeException if a matching user demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande findByResourceAndStatus_First(long resourcePrimaryKey,
		int status, OrderByComparator orderByComparator)
		throws NoSuchUserDemandeException, SystemException {
		UserDemande userDemande = fetchByResourceAndStatus_First(resourcePrimaryKey,
				status, orderByComparator);

		if (userDemande != null) {
			return userDemande;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("resourcePrimaryKey=");
		msg.append(resourcePrimaryKey);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserDemandeException(msg.toString());
	}

	/**
	 * Returns the first user demande in the ordered set where resourcePrimaryKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimaryKey the resource primary key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user demande, or <code>null</code> if a matching user demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande fetchByResourceAndStatus_First(long resourcePrimaryKey,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<UserDemande> list = findByResourceAndStatus(resourcePrimaryKey,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user demande in the ordered set where resourcePrimaryKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimaryKey the resource primary key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user demande
	 * @throws com.viapost.stock.NoSuchUserDemandeException if a matching user demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande findByResourceAndStatus_Last(long resourcePrimaryKey,
		int status, OrderByComparator orderByComparator)
		throws NoSuchUserDemandeException, SystemException {
		UserDemande userDemande = fetchByResourceAndStatus_Last(resourcePrimaryKey,
				status, orderByComparator);

		if (userDemande != null) {
			return userDemande;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("resourcePrimaryKey=");
		msg.append(resourcePrimaryKey);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserDemandeException(msg.toString());
	}

	/**
	 * Returns the last user demande in the ordered set where resourcePrimaryKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimaryKey the resource primary key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user demande, or <code>null</code> if a matching user demande could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande fetchByResourceAndStatus_Last(long resourcePrimaryKey,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByResourceAndStatus(resourcePrimaryKey, status);

		if (count == 0) {
			return null;
		}

		List<UserDemande> list = findByResourceAndStatus(resourcePrimaryKey,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user demandes before and after the current user demande in the ordered set where resourcePrimaryKey = &#63; and status = &#63;.
	 *
	 * @param userDemandeId the primary key of the current user demande
	 * @param resourcePrimaryKey the resource primary key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user demande
	 * @throws com.viapost.stock.NoSuchUserDemandeException if a user demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande[] findByResourceAndStatus_PrevAndNext(
		long userDemandeId, long resourcePrimaryKey, int status,
		OrderByComparator orderByComparator)
		throws NoSuchUserDemandeException, SystemException {
		UserDemande userDemande = findByPrimaryKey(userDemandeId);

		Session session = null;

		try {
			session = openSession();

			UserDemande[] array = new UserDemandeImpl[3];

			array[0] = getByResourceAndStatus_PrevAndNext(session, userDemande,
					resourcePrimaryKey, status, orderByComparator, true);

			array[1] = userDemande;

			array[2] = getByResourceAndStatus_PrevAndNext(session, userDemande,
					resourcePrimaryKey, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserDemande getByResourceAndStatus_PrevAndNext(Session session,
		UserDemande userDemande, long resourcePrimaryKey, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERDEMANDE_WHERE);

		query.append(_FINDER_COLUMN_RESOURCEANDSTATUS_RESOURCEPRIMARYKEY_2);

		query.append(_FINDER_COLUMN_RESOURCEANDSTATUS_STATUS_2);

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
			query.append(UserDemandeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(resourcePrimaryKey);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userDemande);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserDemande> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user demandes where resourcePrimaryKey = &#63; and status = &#63; from the database.
	 *
	 * @param resourcePrimaryKey the resource primary key
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByResourceAndStatus(long resourcePrimaryKey, int status)
		throws SystemException {
		for (UserDemande userDemande : findByResourceAndStatus(
				resourcePrimaryKey, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userDemande);
		}
	}

	/**
	 * Returns the number of user demandes where resourcePrimaryKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimaryKey the resource primary key
	 * @param status the status
	 * @return the number of matching user demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByResourceAndStatus(long resourcePrimaryKey, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESOURCEANDSTATUS;

		Object[] finderArgs = new Object[] { resourcePrimaryKey, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERDEMANDE_WHERE);

			query.append(_FINDER_COLUMN_RESOURCEANDSTATUS_RESOURCEPRIMARYKEY_2);

			query.append(_FINDER_COLUMN_RESOURCEANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resourcePrimaryKey);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_RESOURCEANDSTATUS_RESOURCEPRIMARYKEY_2 =
		"userDemande.resourcePrimaryKey = ? AND ";
	private static final String _FINDER_COLUMN_RESOURCEANDSTATUS_STATUS_2 = "userDemande.status = ?";

	public UserDemandePersistenceImpl() {
		setModelClass(UserDemande.class);
	}

	/**
	 * Caches the user demande in the entity cache if it is enabled.
	 *
	 * @param userDemande the user demande
	 */
	@Override
	public void cacheResult(UserDemande userDemande) {
		EntityCacheUtil.putResult(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
			UserDemandeImpl.class, userDemande.getPrimaryKey(), userDemande);

		userDemande.resetOriginalValues();
	}

	/**
	 * Caches the user demandes in the entity cache if it is enabled.
	 *
	 * @param userDemandes the user demandes
	 */
	@Override
	public void cacheResult(List<UserDemande> userDemandes) {
		for (UserDemande userDemande : userDemandes) {
			if (EntityCacheUtil.getResult(
						UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
						UserDemandeImpl.class, userDemande.getPrimaryKey()) == null) {
				cacheResult(userDemande);
			}
			else {
				userDemande.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user demandes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserDemandeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserDemandeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user demande.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserDemande userDemande) {
		EntityCacheUtil.removeResult(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
			UserDemandeImpl.class, userDemande.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserDemande> userDemandes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserDemande userDemande : userDemandes) {
			EntityCacheUtil.removeResult(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
				UserDemandeImpl.class, userDemande.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user demande with the primary key. Does not add the user demande to the database.
	 *
	 * @param userDemandeId the primary key for the new user demande
	 * @return the new user demande
	 */
	@Override
	public UserDemande create(long userDemandeId) {
		UserDemande userDemande = new UserDemandeImpl();

		userDemande.setNew(true);
		userDemande.setPrimaryKey(userDemandeId);

		return userDemande;
	}

	/**
	 * Removes the user demande with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userDemandeId the primary key of the user demande
	 * @return the user demande that was removed
	 * @throws com.viapost.stock.NoSuchUserDemandeException if a user demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande remove(long userDemandeId)
		throws NoSuchUserDemandeException, SystemException {
		return remove((Serializable)userDemandeId);
	}

	/**
	 * Removes the user demande with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user demande
	 * @return the user demande that was removed
	 * @throws com.viapost.stock.NoSuchUserDemandeException if a user demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande remove(Serializable primaryKey)
		throws NoSuchUserDemandeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserDemande userDemande = (UserDemande)session.get(UserDemandeImpl.class,
					primaryKey);

			if (userDemande == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserDemandeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userDemande);
		}
		catch (NoSuchUserDemandeException nsee) {
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
	protected UserDemande removeImpl(UserDemande userDemande)
		throws SystemException {
		userDemande = toUnwrappedModel(userDemande);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userDemande)) {
				userDemande = (UserDemande)session.get(UserDemandeImpl.class,
						userDemande.getPrimaryKeyObj());
			}

			if (userDemande != null) {
				session.delete(userDemande);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userDemande != null) {
			clearCache(userDemande);
		}

		return userDemande;
	}

	@Override
	public UserDemande updateImpl(
		com.viapost.stock.model.UserDemande userDemande)
		throws SystemException {
		userDemande = toUnwrappedModel(userDemande);

		boolean isNew = userDemande.isNew();

		UserDemandeModelImpl userDemandeModelImpl = (UserDemandeModelImpl)userDemande;

		Session session = null;

		try {
			session = openSession();

			if (userDemande.isNew()) {
				session.save(userDemande);

				userDemande.setNew(false);
			}
			else {
				session.merge(userDemande);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserDemandeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userDemandeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userDemandeModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { userDemandeModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((userDemandeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userDemandeModelImpl.getOriginalResourcePrimaryKey(),
						userDemandeModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESOURCEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEANDSTATUS,
					args);

				args = new Object[] {
						userDemandeModelImpl.getResourcePrimaryKey(),
						userDemandeModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESOURCEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEANDSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
			UserDemandeImpl.class, userDemande.getPrimaryKey(), userDemande);

		return userDemande;
	}

	protected UserDemande toUnwrappedModel(UserDemande userDemande) {
		if (userDemande instanceof UserDemandeImpl) {
			return userDemande;
		}

		UserDemandeImpl userDemandeImpl = new UserDemandeImpl();

		userDemandeImpl.setNew(userDemande.isNew());
		userDemandeImpl.setPrimaryKey(userDemande.getPrimaryKey());

		userDemandeImpl.setUserDemandeId(userDemande.getUserDemandeId());
		userDemandeImpl.setDemandeId(userDemande.getDemandeId());
		userDemandeImpl.setUserId(userDemande.getUserId());
		userDemandeImpl.setCompanyId(userDemande.getCompanyId());
		userDemandeImpl.setGroupId(userDemande.getGroupId());
		userDemandeImpl.setDate(userDemande.getDate());
		userDemandeImpl.setOrigine(userDemande.getOrigine());
		userDemandeImpl.setArticle(userDemande.getArticle());
		userDemandeImpl.setResourcePrimaryKey(userDemande.getResourcePrimaryKey());
		userDemandeImpl.setTitle(userDemande.getTitle());
		userDemandeImpl.setStatus(userDemande.getStatus());
		userDemandeImpl.setStatusByUserId(userDemande.getStatusByUserId());
		userDemandeImpl.setStatusByUserName(userDemande.getStatusByUserName());
		userDemandeImpl.setStatusByDate(userDemande.getStatusByDate());

		return userDemandeImpl;
	}

	/**
	 * Returns the user demande with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user demande
	 * @return the user demande
	 * @throws com.viapost.stock.NoSuchUserDemandeException if a user demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserDemandeException, SystemException {
		UserDemande userDemande = fetchByPrimaryKey(primaryKey);

		if (userDemande == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserDemandeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userDemande;
	}

	/**
	 * Returns the user demande with the primary key or throws a {@link com.viapost.stock.NoSuchUserDemandeException} if it could not be found.
	 *
	 * @param userDemandeId the primary key of the user demande
	 * @return the user demande
	 * @throws com.viapost.stock.NoSuchUserDemandeException if a user demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande findByPrimaryKey(long userDemandeId)
		throws NoSuchUserDemandeException, SystemException {
		return findByPrimaryKey((Serializable)userDemandeId);
	}

	/**
	 * Returns the user demande with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user demande
	 * @return the user demande, or <code>null</code> if a user demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserDemande userDemande = (UserDemande)EntityCacheUtil.getResult(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
				UserDemandeImpl.class, primaryKey);

		if (userDemande == _nullUserDemande) {
			return null;
		}

		if (userDemande == null) {
			Session session = null;

			try {
				session = openSession();

				userDemande = (UserDemande)session.get(UserDemandeImpl.class,
						primaryKey);

				if (userDemande != null) {
					cacheResult(userDemande);
				}
				else {
					EntityCacheUtil.putResult(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
						UserDemandeImpl.class, primaryKey, _nullUserDemande);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserDemandeModelImpl.ENTITY_CACHE_ENABLED,
					UserDemandeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userDemande;
	}

	/**
	 * Returns the user demande with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userDemandeId the primary key of the user demande
	 * @return the user demande, or <code>null</code> if a user demande with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDemande fetchByPrimaryKey(long userDemandeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)userDemandeId);
	}

	/**
	 * Returns all the user demandes.
	 *
	 * @return the user demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDemande> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user demandes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user demandes
	 * @param end the upper bound of the range of user demandes (not inclusive)
	 * @return the range of user demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDemande> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user demandes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user demandes
	 * @param end the upper bound of the range of user demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user demandes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDemande> findAll(int start, int end,
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

		List<UserDemande> list = (List<UserDemande>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERDEMANDE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERDEMANDE;

				if (pagination) {
					sql = sql.concat(UserDemandeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserDemande>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserDemande>(list);
				}
				else {
					list = (List<UserDemande>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user demandes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserDemande userDemande : findAll()) {
			remove(userDemande);
		}
	}

	/**
	 * Returns the number of user demandes.
	 *
	 * @return the number of user demandes
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

				Query q = session.createQuery(_SQL_COUNT_USERDEMANDE);

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
	 * Initializes the user demande persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viapost.stock.model.UserDemande")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserDemande>> listenersList = new ArrayList<ModelListener<UserDemande>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserDemande>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserDemandeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERDEMANDE = "SELECT userDemande FROM UserDemande userDemande";
	private static final String _SQL_SELECT_USERDEMANDE_WHERE = "SELECT userDemande FROM UserDemande userDemande WHERE ";
	private static final String _SQL_COUNT_USERDEMANDE = "SELECT COUNT(userDemande) FROM UserDemande userDemande";
	private static final String _SQL_COUNT_USERDEMANDE_WHERE = "SELECT COUNT(userDemande) FROM UserDemande userDemande WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userDemande.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserDemande exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserDemande exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserDemandePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"date"
			});
	private static UserDemande _nullUserDemande = new UserDemandeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserDemande> toCacheModel() {
				return _nullUserDemandeCacheModel;
			}
		};

	private static CacheModel<UserDemande> _nullUserDemandeCacheModel = new CacheModel<UserDemande>() {
			@Override
			public UserDemande toEntityModel() {
				return _nullUserDemande;
			}
		};
}
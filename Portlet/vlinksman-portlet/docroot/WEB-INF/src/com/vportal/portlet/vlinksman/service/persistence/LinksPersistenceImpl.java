/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
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

package com.vportal.portlet.vlinksman.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.vportal.portlet.vlinksman.NoSuchLinksException;
import com.vportal.portlet.vlinksman.model.Links;
import com.vportal.portlet.vlinksman.model.impl.LinksImpl;
import com.vportal.portlet.vlinksman.model.impl.LinksModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the links service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LongLH
 * @see LinksPersistence
 * @see LinksUtil
 * @generated
 */
public class LinksPersistenceImpl extends BasePersistenceImpl<Links>
	implements LinksPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LinksUtil} to access the links persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LinksImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LINKGROUPID =
		new FinderPath(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksModelImpl.FINDER_CACHE_ENABLED, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylinkgroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINKGROUPID =
		new FinderPath(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksModelImpl.FINDER_CACHE_ENABLED, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylinkgroupId",
			new String[] { Long.class.getName() },
			LinksModelImpl.LINKGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LINKGROUPID = new FinderPath(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylinkgroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_LG = new FinderPath(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksModelImpl.FINDER_CACHE_ENABLED, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_LG",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_LG = new FinderPath(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksModelImpl.FINDER_CACHE_ENABLED, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_LG",
			new String[] { Long.class.getName(), Long.class.getName() },
			LinksModelImpl.GROUPID_COLUMN_BITMASK |
			LinksModelImpl.LINKGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_LG = new FinderPath(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_LG",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksModelImpl.FINDER_CACHE_ENABLED, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksModelImpl.FINDER_CACHE_ENABLED, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LinksModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksModelImpl.FINDER_CACHE_ENABLED, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksModelImpl.FINDER_CACHE_ENABLED, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the links in the entity cache if it is enabled.
	 *
	 * @param links the links
	 */
	public void cacheResult(Links links) {
		EntityCacheUtil.putResult(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksImpl.class, links.getPrimaryKey(), links);

		links.resetOriginalValues();
	}

	/**
	 * Caches the linkses in the entity cache if it is enabled.
	 *
	 * @param linkses the linkses
	 */
	public void cacheResult(List<Links> linkses) {
		for (Links links : linkses) {
			if (EntityCacheUtil.getResult(LinksModelImpl.ENTITY_CACHE_ENABLED,
						LinksImpl.class, links.getPrimaryKey()) == null) {
				cacheResult(links);
			}
			else {
				links.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all linkses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LinksImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LinksImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the links.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Links links) {
		EntityCacheUtil.removeResult(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksImpl.class, links.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Links> linkses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Links links : linkses) {
			EntityCacheUtil.removeResult(LinksModelImpl.ENTITY_CACHE_ENABLED,
				LinksImpl.class, links.getPrimaryKey());
		}
	}

	/**
	 * Creates a new links with the primary key. Does not add the links to the database.
	 *
	 * @param linkId the primary key for the new links
	 * @return the new links
	 */
	public Links create(long linkId) {
		Links links = new LinksImpl();

		links.setNew(true);
		links.setPrimaryKey(linkId);

		return links;
	}

	/**
	 * Removes the links with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linkId the primary key of the links
	 * @return the links that was removed
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Links remove(long linkId)
		throws NoSuchLinksException, SystemException {
		return remove(Long.valueOf(linkId));
	}

	/**
	 * Removes the links with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the links
	 * @return the links that was removed
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Links remove(Serializable primaryKey)
		throws NoSuchLinksException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Links links = (Links)session.get(LinksImpl.class, primaryKey);

			if (links == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLinksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(links);
		}
		catch (NoSuchLinksException nsee) {
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
	protected Links removeImpl(Links links) throws SystemException {
		links = toUnwrappedModel(links);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, links);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(links);

		return links;
	}

	@Override
	public Links updateImpl(com.vportal.portlet.vlinksman.model.Links links,
		boolean merge) throws SystemException {
		links = toUnwrappedModel(links);

		boolean isNew = links.isNew();

		LinksModelImpl linksModelImpl = (LinksModelImpl)links;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, links, merge);

			links.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LinksModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((linksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINKGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(linksModelImpl.getOriginalLinkgroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LINKGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINKGROUPID,
					args);

				args = new Object[] {
						Long.valueOf(linksModelImpl.getLinkgroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LINKGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINKGROUPID,
					args);
			}

			if ((linksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_LG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(linksModelImpl.getOriginalGroupId()),
						Long.valueOf(linksModelImpl.getOriginalLinkgroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_LG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_LG,
					args);

				args = new Object[] {
						Long.valueOf(linksModelImpl.getGroupId()),
						Long.valueOf(linksModelImpl.getLinkgroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_LG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_LG,
					args);
			}

			if ((linksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(linksModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { Long.valueOf(linksModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(LinksModelImpl.ENTITY_CACHE_ENABLED,
			LinksImpl.class, links.getPrimaryKey(), links);

		return links;
	}

	protected Links toUnwrappedModel(Links links) {
		if (links instanceof LinksImpl) {
			return links;
		}

		LinksImpl linksImpl = new LinksImpl();

		linksImpl.setNew(links.isNew());
		linksImpl.setPrimaryKey(links.getPrimaryKey());

		linksImpl.setLinkId(links.getLinkId());
		linksImpl.setGroupId(links.getGroupId());
		linksImpl.setCompanyId(links.getCompanyId());
		linksImpl.setCreatedDate(links.getCreatedDate());
		linksImpl.setModifiedDate(links.getModifiedDate());
		linksImpl.setLinkgroupId(links.getLinkgroupId());
		linksImpl.setName(links.getName());
		linksImpl.setDescription(links.getDescription());
		linksImpl.setUrl(links.getUrl());
		linksImpl.setPosition(links.getPosition());
		linksImpl.setHasImage(links.isHasImage());
		linksImpl.setIsTargetBlank(links.isIsTargetBlank());
		linksImpl.setImageName(links.getImageName());
		linksImpl.setFolderId(links.getFolderId());

		return linksImpl;
	}

	/**
	 * Returns the links with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the links
	 * @return the links
	 * @throws com.liferay.portal.NoSuchModelException if a links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Links findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the links with the primary key or throws a {@link com.vportal.portlet.vlinksman.NoSuchLinksException} if it could not be found.
	 *
	 * @param linkId the primary key of the links
	 * @return the links
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Links findByPrimaryKey(long linkId)
		throws NoSuchLinksException, SystemException {
		Links links = fetchByPrimaryKey(linkId);

		if (links == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + linkId);
			}

			throw new NoSuchLinksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				linkId);
		}

		return links;
	}

	/**
	 * Returns the links with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the links
	 * @return the links, or <code>null</code> if a links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Links fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the links with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linkId the primary key of the links
	 * @return the links, or <code>null</code> if a links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Links fetchByPrimaryKey(long linkId) throws SystemException {
		Links links = (Links)EntityCacheUtil.getResult(LinksModelImpl.ENTITY_CACHE_ENABLED,
				LinksImpl.class, linkId);

		if (links == _nullLinks) {
			return null;
		}

		if (links == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				links = (Links)session.get(LinksImpl.class, Long.valueOf(linkId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (links != null) {
					cacheResult(links);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LinksModelImpl.ENTITY_CACHE_ENABLED,
						LinksImpl.class, linkId, _nullLinks);
				}

				closeSession(session);
			}
		}

		return links;
	}

	/**
	 * Returns all the linkses where linkgroupId = &#63;.
	 *
	 * @param linkgroupId the linkgroup ID
	 * @return the matching linkses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Links> findBylinkgroupId(long linkgroupId)
		throws SystemException {
		return findBylinkgroupId(linkgroupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the linkses where linkgroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkgroupId the linkgroup ID
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @return the range of matching linkses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Links> findBylinkgroupId(long linkgroupId, int start, int end)
		throws SystemException {
		return findBylinkgroupId(linkgroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the linkses where linkgroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkgroupId the linkgroup ID
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching linkses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Links> findBylinkgroupId(long linkgroupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINKGROUPID;
			finderArgs = new Object[] { linkgroupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LINKGROUPID;
			finderArgs = new Object[] { linkgroupId, start, end, orderByComparator };
		}

		List<Links> list = (List<Links>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_LINKGROUPID_LINKGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LinksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(linkgroupId);

				list = (List<Links>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first links in the ordered set where linkgroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkgroupId the linkgroup ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a matching links could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Links findBylinkgroupId_First(long linkgroupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinksException, SystemException {
		List<Links> list = findBylinkgroupId(linkgroupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("linkgroupId=");
			msg.append(linkgroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinksException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last links in the ordered set where linkgroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkgroupId the linkgroup ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a matching links could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Links findBylinkgroupId_Last(long linkgroupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinksException, SystemException {
		int count = countBylinkgroupId(linkgroupId);

		List<Links> list = findBylinkgroupId(linkgroupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("linkgroupId=");
			msg.append(linkgroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinksException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the linkses before and after the current links in the ordered set where linkgroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkId the primary key of the current links
	 * @param linkgroupId the linkgroup ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next links
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Links[] findBylinkgroupId_PrevAndNext(long linkId, long linkgroupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinksException, SystemException {
		Links links = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			Links[] array = new LinksImpl[3];

			array[0] = getBylinkgroupId_PrevAndNext(session, links,
					linkgroupId, orderByComparator, true);

			array[1] = links;

			array[2] = getBylinkgroupId_PrevAndNext(session, links,
					linkgroupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Links getBylinkgroupId_PrevAndNext(Session session, Links links,
		long linkgroupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINKS_WHERE);

		query.append(_FINDER_COLUMN_LINKGROUPID_LINKGROUPID_2);

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
			query.append(LinksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(linkgroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(links);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Links> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the linkses where groupId = &#63; and linkgroupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param linkgroupId the linkgroup ID
	 * @return the matching linkses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Links> findByG_LG(long groupId, long linkgroupId)
		throws SystemException {
		return findByG_LG(groupId, linkgroupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the linkses where groupId = &#63; and linkgroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param linkgroupId the linkgroup ID
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @return the range of matching linkses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Links> findByG_LG(long groupId, long linkgroupId, int start,
		int end) throws SystemException {
		return findByG_LG(groupId, linkgroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the linkses where groupId = &#63; and linkgroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param linkgroupId the linkgroup ID
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching linkses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Links> findByG_LG(long groupId, long linkgroupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_LG;
			finderArgs = new Object[] { groupId, linkgroupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_LG;
			finderArgs = new Object[] {
					groupId, linkgroupId,
					
					start, end, orderByComparator
				};
		}

		List<Links> list = (List<Links>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_G_LG_GROUPID_2);

			query.append(_FINDER_COLUMN_G_LG_LINKGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LinksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(linkgroupId);

				list = (List<Links>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first links in the ordered set where groupId = &#63; and linkgroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param linkgroupId the linkgroup ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a matching links could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Links findByG_LG_First(long groupId, long linkgroupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinksException, SystemException {
		List<Links> list = findByG_LG(groupId, linkgroupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", linkgroupId=");
			msg.append(linkgroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinksException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last links in the ordered set where groupId = &#63; and linkgroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param linkgroupId the linkgroup ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a matching links could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Links findByG_LG_Last(long groupId, long linkgroupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinksException, SystemException {
		int count = countByG_LG(groupId, linkgroupId);

		List<Links> list = findByG_LG(groupId, linkgroupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", linkgroupId=");
			msg.append(linkgroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinksException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the linkses before and after the current links in the ordered set where groupId = &#63; and linkgroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkId the primary key of the current links
	 * @param groupId the group ID
	 * @param linkgroupId the linkgroup ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next links
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Links[] findByG_LG_PrevAndNext(long linkId, long groupId,
		long linkgroupId, OrderByComparator orderByComparator)
		throws NoSuchLinksException, SystemException {
		Links links = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			Links[] array = new LinksImpl[3];

			array[0] = getByG_LG_PrevAndNext(session, links, groupId,
					linkgroupId, orderByComparator, true);

			array[1] = links;

			array[2] = getByG_LG_PrevAndNext(session, links, groupId,
					linkgroupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Links getByG_LG_PrevAndNext(Session session, Links links,
		long groupId, long linkgroupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINKS_WHERE);

		query.append(_FINDER_COLUMN_G_LG_GROUPID_2);

		query.append(_FINDER_COLUMN_G_LG_LINKGROUPID_2);

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
			query.append(LinksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(linkgroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(links);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Links> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the linkses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching linkses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Links> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the linkses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @return the range of matching linkses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Links> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the linkses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching linkses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Links> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Links> list = (List<Links>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LinksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Links>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first links in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a matching links could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Links findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinksException, SystemException {
		List<Links> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinksException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last links in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a matching links could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Links findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinksException, SystemException {
		int count = countByGroupId(groupId);

		List<Links> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinksException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the linkses before and after the current links in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkId the primary key of the current links
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next links
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Links[] findByGroupId_PrevAndNext(long linkId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinksException, SystemException {
		Links links = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			Links[] array = new LinksImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, links, groupId,
					orderByComparator, true);

			array[1] = links;

			array[2] = getByGroupId_PrevAndNext(session, links, groupId,
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

	protected Links getByGroupId_PrevAndNext(Session session, Links links,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINKS_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(LinksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(links);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Links> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the linkses.
	 *
	 * @return the linkses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Links> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the linkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @return the range of linkses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Links> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the linkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of linkses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Links> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Links> list = (List<Links>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LINKS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LINKS.concat(LinksModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Links>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Links>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the linkses where linkgroupId = &#63; from the database.
	 *
	 * @param linkgroupId the linkgroup ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBylinkgroupId(long linkgroupId) throws SystemException {
		for (Links links : findBylinkgroupId(linkgroupId)) {
			remove(links);
		}
	}

	/**
	 * Removes all the linkses where groupId = &#63; and linkgroupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param linkgroupId the linkgroup ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_LG(long groupId, long linkgroupId)
		throws SystemException {
		for (Links links : findByG_LG(groupId, linkgroupId)) {
			remove(links);
		}
	}

	/**
	 * Removes all the linkses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Links links : findByGroupId(groupId)) {
			remove(links);
		}
	}

	/**
	 * Removes all the linkses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Links links : findAll()) {
			remove(links);
		}
	}

	/**
	 * Returns the number of linkses where linkgroupId = &#63;.
	 *
	 * @param linkgroupId the linkgroup ID
	 * @return the number of matching linkses
	 * @throws SystemException if a system exception occurred
	 */
	public int countBylinkgroupId(long linkgroupId) throws SystemException {
		Object[] finderArgs = new Object[] { linkgroupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LINKGROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_LINKGROUPID_LINKGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(linkgroupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LINKGROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of linkses where groupId = &#63; and linkgroupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param linkgroupId the linkgroup ID
	 * @return the number of matching linkses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_LG(long groupId, long linkgroupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, linkgroupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_LG,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_G_LG_GROUPID_2);

			query.append(_FINDER_COLUMN_G_LG_LINKGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(linkgroupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_LG,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of linkses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching linkses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of linkses.
	 *
	 * @return the number of linkses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LINKS);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the links persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vlinksman.model.Links")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Links>> listenersList = new ArrayList<ModelListener<Links>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Links>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LinksImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LinkGroupPersistence.class)
	protected LinkGroupPersistence linkGroupPersistence;
	@BeanReference(type = LinksPersistence.class)
	protected LinksPersistence linksPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LINKS = "SELECT links FROM Links links";
	private static final String _SQL_SELECT_LINKS_WHERE = "SELECT links FROM Links links WHERE ";
	private static final String _SQL_COUNT_LINKS = "SELECT COUNT(links) FROM Links links";
	private static final String _SQL_COUNT_LINKS_WHERE = "SELECT COUNT(links) FROM Links links WHERE ";
	private static final String _FINDER_COLUMN_LINKGROUPID_LINKGROUPID_2 = "links.linkgroupId = ?";
	private static final String _FINDER_COLUMN_G_LG_GROUPID_2 = "links.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_LG_LINKGROUPID_2 = "links.linkgroupId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "links.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "links.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Links exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Links exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LinksPersistenceImpl.class);
	private static Links _nullLinks = new LinksImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Links> toCacheModel() {
				return _nullLinksCacheModel;
			}
		};

	private static CacheModel<Links> _nullLinksCacheModel = new CacheModel<Links>() {
			public Links toEntityModel() {
				return _nullLinks;
			}
		};
}
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

package com.vportal.portlet.vdoc.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the vdocLogger service. Represents a row in the &quot;vdocLogger&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.vportal.portlet.vdoc.model.impl.vdocLoggerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.vportal.portlet.vdoc.model.impl.vdocLoggerImpl}.
 * </p>
 *
 * @author MrEn
 * @see vdocLogger
 * @see com.vportal.portlet.vdoc.model.impl.vdocLoggerImpl
 * @see com.vportal.portlet.vdoc.model.impl.vdocLoggerModelImpl
 * @generated
 */
public interface vdocLoggerModel extends BaseModel<vdocLogger> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vdoc logger model instance should use the {@link vdocLogger} interface instead.
	 */

	/**
	 * Returns the primary key of this vdoc logger.
	 *
	 * @return the primary key of this vdoc logger
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this vdoc logger.
	 *
	 * @param primaryKey the primary key of this vdoc logger
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the logger ID of this vdoc logger.
	 *
	 * @return the logger ID of this vdoc logger
	 */
	@AutoEscape
	public String getLoggerId();

	/**
	 * Sets the logger ID of this vdoc logger.
	 *
	 * @param loggerId the logger ID of this vdoc logger
	 */
	public void setLoggerId(String loggerId);

	/**
	 * Returns the group ID of this vdoc logger.
	 *
	 * @return the group ID of this vdoc logger
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this vdoc logger.
	 *
	 * @param groupId the group ID of this vdoc logger
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this vdoc logger.
	 *
	 * @return the company ID of this vdoc logger
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this vdoc logger.
	 *
	 * @param companyId the company ID of this vdoc logger
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this vdoc logger.
	 *
	 * @return the user ID of this vdoc logger
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this vdoc logger.
	 *
	 * @param userId the user ID of this vdoc logger
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this vdoc logger.
	 *
	 * @return the user uuid of this vdoc logger
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this vdoc logger.
	 *
	 * @param userUuid the user uuid of this vdoc logger
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the created date of this vdoc logger.
	 *
	 * @return the created date of this vdoc logger
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this vdoc logger.
	 *
	 * @param createdDate the created date of this vdoc logger
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the created by user of this vdoc logger.
	 *
	 * @return the created by user of this vdoc logger
	 */
	public long getCreatedByUser();

	/**
	 * Sets the created by user of this vdoc logger.
	 *
	 * @param createdByUser the created by user of this vdoc logger
	 */
	public void setCreatedByUser(long createdByUser);

	/**
	 * Returns the content of this vdoc logger.
	 *
	 * @return the content of this vdoc logger
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this vdoc logger.
	 *
	 * @param content the content of this vdoc logger
	 */
	public void setContent(String content);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(vdocLogger vdocLogger);

	public int hashCode();

	public CacheModel<vdocLogger> toCacheModel();

	public vdocLogger toEscapedModel();

	public String toString();

	public String toXmlString();
}
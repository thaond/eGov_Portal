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

package com.vportal.portlet.vcalendar.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.vportal.portlet.vcalendar.model.VCal;
import com.vportal.portlet.vcalendar.model.VCalModel;
import com.vportal.portlet.vcalendar.model.VCalSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the VCal service. Represents a row in the &quot;VCal&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.vportal.portlet.vcalendar.model.VCalModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VCalImpl}.
 * </p>
 *
 * @author LongLH
 * @see VCalImpl
 * @see com.vportal.portlet.vcalendar.model.VCal
 * @see com.vportal.portlet.vcalendar.model.VCalModel
 * @generated
 */
@JSON(strict = true)
public class VCalModelImpl extends BaseModelImpl<VCal> implements VCalModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a v cal model instance should use the {@link com.vportal.portlet.vcalendar.model.VCal} interface instead.
	 */
	public static final String TABLE_NAME = "VCal";
	public static final Object[][] TABLE_COLUMNS = {
			{ "calId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "languageId", Types.VARCHAR },
			{ "fileId", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "guest", Types.VARCHAR },
			{ "location", Types.VARCHAR },
			{ "time_", Types.VARCHAR },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "status", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table VCal (calId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,languageId VARCHAR(75) null,fileId LONG,title VARCHAR(550) null,description VARCHAR(550) null,guest VARCHAR(200) null,location VARCHAR(200) null,time_ VARCHAR(75) null,startDate DATE null,endDate DATE null,status LONG)";
	public static final String TABLE_SQL_DROP = "drop table VCal";
	public static final String ORDER_BY_JPQL = " ORDER BY vCal.startDate ASC, vCal.title ASC";
	public static final String ORDER_BY_SQL = " ORDER BY VCal.startDate ASC, VCal.title ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.vportal.portlet.vcalendar.model.VCal"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.vportal.portlet.vcalendar.model.VCal"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.vportal.portlet.vcalendar.model.VCal"),
			true);
	public static long FILEID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long STARTDATE_COLUMN_BITMASK = 4L;
	public static long STATUS_COLUMN_BITMASK = 8L;
	public static long USERID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static VCal toModel(VCalSoap soapModel) {
		VCal model = new VCalImpl();

		model.setCalId(soapModel.getCalId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setLanguageId(soapModel.getLanguageId());
		model.setFileId(soapModel.getFileId());
		model.setTitle(soapModel.getTitle());
		model.setDescription(soapModel.getDescription());
		model.setGuest(soapModel.getGuest());
		model.setLocation(soapModel.getLocation());
		model.setTime(soapModel.getTime());
		model.setStartDate(soapModel.getStartDate());
		model.setEndDate(soapModel.getEndDate());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<VCal> toModels(VCalSoap[] soapModels) {
		List<VCal> models = new ArrayList<VCal>(soapModels.length);

		for (VCalSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.vportal.portlet.vcalendar.model.VCal"));

	public VCalModelImpl() {
	}

	public long getPrimaryKey() {
		return _calId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCalId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_calId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return VCal.class;
	}

	public String getModelClassName() {
		return VCal.class.getName();
	}

	@JSON
	public long getCalId() {
		return _calId;
	}

	public void setCalId(long calId) {
		_calId = calId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public String getLanguageId() {
		if (_languageId == null) {
			return StringPool.BLANK;
		}
		else {
			return _languageId;
		}
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	@JSON
	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_columnBitmask |= FILEID_COLUMN_BITMASK;

		if (!_setOriginalFileId) {
			_setOriginalFileId = true;

			_originalFileId = _fileId;
		}

		_fileId = fileId;
	}

	public long getOriginalFileId() {
		return _originalFileId;
	}

	@JSON
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_columnBitmask = -1L;

		_title = title;
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public String getGuest() {
		if (_guest == null) {
			return StringPool.BLANK;
		}
		else {
			return _guest;
		}
	}

	public void setGuest(String guest) {
		_guest = guest;
	}

	@JSON
	public String getLocation() {
		if (_location == null) {
			return StringPool.BLANK;
		}
		else {
			return _location;
		}
	}

	public void setLocation(String location) {
		_location = location;
	}

	@JSON
	public String getTime() {
		if (_time == null) {
			return StringPool.BLANK;
		}
		else {
			return _time;
		}
	}

	public void setTime(String time) {
		_time = time;
	}

	@JSON
	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_columnBitmask = -1L;

		if (_originalStartDate == null) {
			_originalStartDate = _startDate;
		}

		_startDate = startDate;
	}

	public Date getOriginalStartDate() {
		return _originalStartDate;
	}

	@JSON
	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@JSON
	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public long getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public VCal toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (VCal)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					VCal.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		VCalImpl vCalImpl = new VCalImpl();

		vCalImpl.setCalId(getCalId());
		vCalImpl.setGroupId(getGroupId());
		vCalImpl.setCompanyId(getCompanyId());
		vCalImpl.setUserId(getUserId());
		vCalImpl.setUserName(getUserName());
		vCalImpl.setCreateDate(getCreateDate());
		vCalImpl.setModifiedDate(getModifiedDate());
		vCalImpl.setLanguageId(getLanguageId());
		vCalImpl.setFileId(getFileId());
		vCalImpl.setTitle(getTitle());
		vCalImpl.setDescription(getDescription());
		vCalImpl.setGuest(getGuest());
		vCalImpl.setLocation(getLocation());
		vCalImpl.setTime(getTime());
		vCalImpl.setStartDate(getStartDate());
		vCalImpl.setEndDate(getEndDate());
		vCalImpl.setStatus(getStatus());

		vCalImpl.resetOriginalValues();

		return vCalImpl;
	}

	public int compareTo(VCal vCal) {
		int value = 0;

		value = DateUtil.compareTo(getStartDate(), vCal.getStartDate());

		if (value != 0) {
			return value;
		}

		value = getTitle().toLowerCase().compareTo(vCal.getTitle().toLowerCase());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		VCal vCal = null;

		try {
			vCal = (VCal)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = vCal.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		VCalModelImpl vCalModelImpl = this;

		vCalModelImpl._originalGroupId = vCalModelImpl._groupId;

		vCalModelImpl._setOriginalGroupId = false;

		vCalModelImpl._originalUserId = vCalModelImpl._userId;

		vCalModelImpl._setOriginalUserId = false;

		vCalModelImpl._originalFileId = vCalModelImpl._fileId;

		vCalModelImpl._setOriginalFileId = false;

		vCalModelImpl._originalStartDate = vCalModelImpl._startDate;

		vCalModelImpl._originalStatus = vCalModelImpl._status;

		vCalModelImpl._setOriginalStatus = false;

		vCalModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VCal> toCacheModel() {
		VCalCacheModel vCalCacheModel = new VCalCacheModel();

		vCalCacheModel.calId = getCalId();

		vCalCacheModel.groupId = getGroupId();

		vCalCacheModel.companyId = getCompanyId();

		vCalCacheModel.userId = getUserId();

		vCalCacheModel.userName = getUserName();

		String userName = vCalCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			vCalCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			vCalCacheModel.createDate = createDate.getTime();
		}
		else {
			vCalCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			vCalCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			vCalCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		vCalCacheModel.languageId = getLanguageId();

		String languageId = vCalCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			vCalCacheModel.languageId = null;
		}

		vCalCacheModel.fileId = getFileId();

		vCalCacheModel.title = getTitle();

		String title = vCalCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			vCalCacheModel.title = null;
		}

		vCalCacheModel.description = getDescription();

		String description = vCalCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			vCalCacheModel.description = null;
		}

		vCalCacheModel.guest = getGuest();

		String guest = vCalCacheModel.guest;

		if ((guest != null) && (guest.length() == 0)) {
			vCalCacheModel.guest = null;
		}

		vCalCacheModel.location = getLocation();

		String location = vCalCacheModel.location;

		if ((location != null) && (location.length() == 0)) {
			vCalCacheModel.location = null;
		}

		vCalCacheModel.time = getTime();

		String time = vCalCacheModel.time;

		if ((time != null) && (time.length() == 0)) {
			vCalCacheModel.time = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			vCalCacheModel.startDate = startDate.getTime();
		}
		else {
			vCalCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			vCalCacheModel.endDate = endDate.getTime();
		}
		else {
			vCalCacheModel.endDate = Long.MIN_VALUE;
		}

		vCalCacheModel.status = getStatus();

		return vCalCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{calId=");
		sb.append(getCalId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", fileId=");
		sb.append(getFileId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", guest=");
		sb.append(getGuest());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", time=");
		sb.append(getTime());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vcalendar.model.VCal");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>calId</column-name><column-value><![CDATA[");
		sb.append(getCalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileId</column-name><column-value><![CDATA[");
		sb.append(getFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guest</column-name><column-value><![CDATA[");
		sb.append(getGuest());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>time</column-name><column-value><![CDATA[");
		sb.append(getTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = VCal.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			VCal.class
		};
	private long _calId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _languageId;
	private long _fileId;
	private long _originalFileId;
	private boolean _setOriginalFileId;
	private String _title;
	private String _description;
	private String _guest;
	private String _location;
	private String _time;
	private Date _startDate;
	private Date _originalStartDate;
	private Date _endDate;
	private long _status;
	private long _originalStatus;
	private boolean _setOriginalStatus;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private VCal _escapedModelProxy;
}
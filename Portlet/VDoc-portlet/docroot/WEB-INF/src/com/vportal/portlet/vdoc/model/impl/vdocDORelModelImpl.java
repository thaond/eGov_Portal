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

package com.vportal.portlet.vdoc.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.vportal.portlet.vdoc.model.vdocDORel;
import com.vportal.portlet.vdoc.model.vdocDORelModel;
import com.vportal.portlet.vdoc.model.vdocDORelSoap;
import com.vportal.portlet.vdoc.service.persistence.vdocDORelPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * The base model implementation for the vdocDORel service. Represents a row in the &quot;vdocDORel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.vportal.portlet.vdoc.model.vdocDORelModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vdocDORelImpl}.
 * </p>
 *
 * @author MrEn
 * @see vdocDORelImpl
 * @see com.vportal.portlet.vdoc.model.vdocDORel
 * @see com.vportal.portlet.vdoc.model.vdocDORelModel
 * @generated
 */
@JSON(strict = true)
public class vdocDORelModelImpl extends BaseModelImpl<vdocDORel>
	implements vdocDORelModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vdoc d o rel model instance should use the {@link com.vportal.portlet.vdoc.model.vdocDORel} interface instead.
	 */
	public static final String TABLE_NAME = "vdocDORel";
	public static final Object[][] TABLE_COLUMNS = {
			{ "docId", Types.VARCHAR },
			{ "orgId", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table vdocDORel (docId VARCHAR(500) not null,orgId VARCHAR(500) not null,primary key (docId, orgId))";
	public static final String TABLE_SQL_DROP = "drop table vdocDORel";
	public static final String ORDER_BY_JPQL = " ORDER BY vdocDORel.id.docId DESC, vdocDORel.id.orgId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vdocDORel.docId DESC, vdocDORel.orgId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.vportal.portlet.vdoc.model.vdocDORel"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.vportal.portlet.vdoc.model.vdocDORel"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.vportal.portlet.vdoc.model.vdocDORel"),
			true);
	public static long DOCID_COLUMN_BITMASK = 1L;
	public static long ORGID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static vdocDORel toModel(vdocDORelSoap soapModel) {
		vdocDORel model = new vdocDORelImpl();

		model.setDocId(soapModel.getDocId());
		model.setOrgId(soapModel.getOrgId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<vdocDORel> toModels(vdocDORelSoap[] soapModels) {
		List<vdocDORel> models = new ArrayList<vdocDORel>(soapModels.length);

		for (vdocDORelSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.vportal.portlet.vdoc.model.vdocDORel"));

	public vdocDORelModelImpl() {
	}

	public vdocDORelPK getPrimaryKey() {
		return new vdocDORelPK(_docId, _orgId);
	}

	public void setPrimaryKey(vdocDORelPK primaryKey) {
		setDocId(primaryKey.docId);
		setOrgId(primaryKey.orgId);
	}

	public Serializable getPrimaryKeyObj() {
		return new vdocDORelPK(_docId, _orgId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((vdocDORelPK)primaryKeyObj);
	}

	public Class<?> getModelClass() {
		return vdocDORel.class;
	}

	public String getModelClassName() {
		return vdocDORel.class.getName();
	}

	@JSON
	public String getDocId() {
		if (_docId == null) {
			return StringPool.BLANK;
		}
		else {
			return _docId;
		}
	}

	public void setDocId(String docId) {
		_columnBitmask = -1L;

		if (_originalDocId == null) {
			_originalDocId = _docId;
		}

		_docId = docId;
	}

	public String getOriginalDocId() {
		return GetterUtil.getString(_originalDocId);
	}

	@JSON
	public String getOrgId() {
		if (_orgId == null) {
			return StringPool.BLANK;
		}
		else {
			return _orgId;
		}
	}

	public void setOrgId(String orgId) {
		_columnBitmask = -1L;

		if (_originalOrgId == null) {
			_originalOrgId = _orgId;
		}

		_orgId = orgId;
	}

	public String getOriginalOrgId() {
		return GetterUtil.getString(_originalOrgId);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public vdocDORel toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (vdocDORel)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		vdocDORelImpl vdocDORelImpl = new vdocDORelImpl();

		vdocDORelImpl.setDocId(getDocId());
		vdocDORelImpl.setOrgId(getOrgId());

		vdocDORelImpl.resetOriginalValues();

		return vdocDORelImpl;
	}

	public int compareTo(vdocDORel vdocDORel) {
		int value = 0;

		value = getDocId().compareTo(vdocDORel.getDocId());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getOrgId().compareTo(vdocDORel.getOrgId());

		value = value * -1;

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

		vdocDORel vdocDORel = null;

		try {
			vdocDORel = (vdocDORel)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		vdocDORelPK primaryKey = vdocDORel.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		vdocDORelModelImpl vdocDORelModelImpl = this;

		vdocDORelModelImpl._originalDocId = vdocDORelModelImpl._docId;

		vdocDORelModelImpl._originalOrgId = vdocDORelModelImpl._orgId;

		vdocDORelModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<vdocDORel> toCacheModel() {
		vdocDORelCacheModel vdocDORelCacheModel = new vdocDORelCacheModel();

		vdocDORelCacheModel.docId = getDocId();

		String docId = vdocDORelCacheModel.docId;

		if ((docId != null) && (docId.length() == 0)) {
			vdocDORelCacheModel.docId = null;
		}

		vdocDORelCacheModel.orgId = getOrgId();

		String orgId = vdocDORelCacheModel.orgId;

		if ((orgId != null) && (orgId.length() == 0)) {
			vdocDORelCacheModel.orgId = null;
		}

		return vdocDORelCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{docId=");
		sb.append(getDocId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vdoc.model.vdocDORel");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>docId</column-name><column-value><![CDATA[");
		sb.append(getDocId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = vdocDORel.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			vdocDORel.class
		};
	private String _docId;
	private String _originalDocId;
	private String _orgId;
	private String _originalOrgId;
	private long _columnBitmask;
	private vdocDORel _escapedModelProxy;
}
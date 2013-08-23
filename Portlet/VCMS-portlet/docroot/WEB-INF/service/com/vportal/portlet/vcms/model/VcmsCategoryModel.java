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

package com.vportal.portlet.vcms.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the VcmsCategory service. Represents a row in the &quot;VcmsCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.vportal.portlet.vcms.model.impl.VcmsCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.vportal.portlet.vcms.model.impl.VcmsCategoryImpl}.
 * </p>
 *
 * @author hai
 * @see VcmsCategory
 * @see com.vportal.portlet.vcms.model.impl.VcmsCategoryImpl
 * @see com.vportal.portlet.vcms.model.impl.VcmsCategoryModelImpl
 * @generated
 */
public interface VcmsCategoryModel extends BaseModel<VcmsCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vcms category model instance should use the {@link VcmsCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this vcms category.
	 *
	 * @return the primary key of this vcms category
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this vcms category.
	 *
	 * @param primaryKey the primary key of this vcms category
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the category ID of this vcms category.
	 *
	 * @return the category ID of this vcms category
	 */
	@AutoEscape
	public String getCategoryId();

	/**
	 * Sets the category ID of this vcms category.
	 *
	 * @param categoryId the category ID of this vcms category
	 */
	public void setCategoryId(String categoryId);

	/**
	 * Returns the group ID of this vcms category.
	 *
	 * @return the group ID of this vcms category
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this vcms category.
	 *
	 * @param groupId the group ID of this vcms category
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this vcms category.
	 *
	 * @return the company ID of this vcms category
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this vcms category.
	 *
	 * @param companyId the company ID of this vcms category
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the created date of this vcms category.
	 *
	 * @return the created date of this vcms category
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this vcms category.
	 *
	 * @param createdDate the created date of this vcms category
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the created by user of this vcms category.
	 *
	 * @return the created by user of this vcms category
	 */
	@AutoEscape
	public String getCreatedByUser();

	/**
	 * Sets the created by user of this vcms category.
	 *
	 * @param createdByUser the created by user of this vcms category
	 */
	public void setCreatedByUser(String createdByUser);

	/**
	 * Returns the modified date of this vcms category.
	 *
	 * @return the modified date of this vcms category
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this vcms category.
	 *
	 * @param modifiedDate the modified date of this vcms category
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by user of this vcms category.
	 *
	 * @return the modified by user of this vcms category
	 */
	@AutoEscape
	public String getModifiedByUser();

	/**
	 * Sets the modified by user of this vcms category.
	 *
	 * @param modifiedByUser the modified by user of this vcms category
	 */
	public void setModifiedByUser(String modifiedByUser);

	/**
	 * Returns the portion ID of this vcms category.
	 *
	 * @return the portion ID of this vcms category
	 */
	@AutoEscape
	public String getPortionId();

	/**
	 * Sets the portion ID of this vcms category.
	 *
	 * @param portionId the portion ID of this vcms category
	 */
	public void setPortionId(String portionId);

	/**
	 * Returns the parent ID of this vcms category.
	 *
	 * @return the parent ID of this vcms category
	 */
	@AutoEscape
	public String getParentId();

	/**
	 * Sets the parent ID of this vcms category.
	 *
	 * @param parentId the parent ID of this vcms category
	 */
	public void setParentId(String parentId);

	/**
	 * Returns the name of this vcms category.
	 *
	 * @return the name of this vcms category
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this vcms category.
	 *
	 * @param name the name of this vcms category
	 */
	public void setName(String name);

	/**
	 * Returns the description of this vcms category.
	 *
	 * @return the description of this vcms category
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this vcms category.
	 *
	 * @param description the description of this vcms category
	 */
	public void setDescription(String description);

	/**
	 * Returns the anchored of this vcms category.
	 *
	 * @return the anchored of this vcms category
	 */
	public boolean getAnchored();

	/**
	 * Returns <code>true</code> if this vcms category is anchored.
	 *
	 * @return <code>true</code> if this vcms category is anchored; <code>false</code> otherwise
	 */
	public boolean isAnchored();

	/**
	 * Sets whether this vcms category is anchored.
	 *
	 * @param anchored the anchored of this vcms category
	 */
	public void setAnchored(boolean anchored);

	/**
	 * Returns the href of this vcms category.
	 *
	 * @return the href of this vcms category
	 */
	@AutoEscape
	public String getHref();

	/**
	 * Sets the href of this vcms category.
	 *
	 * @param href the href of this vcms category
	 */
	public void setHref(String href);

	/**
	 * Returns the language of this vcms category.
	 *
	 * @return the language of this vcms category
	 */
	@AutoEscape
	public String getLanguage();

	/**
	 * Sets the language of this vcms category.
	 *
	 * @param language the language of this vcms category
	 */
	public void setLanguage(String language);

	/**
	 * Returns the has image of this vcms category.
	 *
	 * @return the has image of this vcms category
	 */
	public boolean getHasImage();

	/**
	 * Returns <code>true</code> if this vcms category is has image.
	 *
	 * @return <code>true</code> if this vcms category is has image; <code>false</code> otherwise
	 */
	public boolean isHasImage();

	/**
	 * Sets whether this vcms category is has image.
	 *
	 * @param hasImage the has image of this vcms category
	 */
	public void setHasImage(boolean hasImage);

	/**
	 * Returns the image of this vcms category.
	 *
	 * @return the image of this vcms category
	 */
	@AutoEscape
	public String getImage();

	/**
	 * Sets the image of this vcms category.
	 *
	 * @param image the image of this vcms category
	 */
	public void setImage(String image);

	/**
	 * Returns the position of this vcms category.
	 *
	 * @return the position of this vcms category
	 */
	public long getPosition();

	/**
	 * Sets the position of this vcms category.
	 *
	 * @param position the position of this vcms category
	 */
	public void setPosition(long position);

	/**
	 * Returns the user hit of this vcms category.
	 *
	 * @return the user hit of this vcms category
	 */
	public long getUserHit();

	/**
	 * Sets the user hit of this vcms category.
	 *
	 * @param userHit the user hit of this vcms category
	 */
	public void setUserHit(long userHit);

	/**
	 * Returns the rssable of this vcms category.
	 *
	 * @return the rssable of this vcms category
	 */
	public boolean getRssable();

	/**
	 * Returns <code>true</code> if this vcms category is rssable.
	 *
	 * @return <code>true</code> if this vcms category is rssable; <code>false</code> otherwise
	 */
	public boolean isRssable();

	/**
	 * Sets whether this vcms category is rssable.
	 *
	 * @param rssable the rssable of this vcms category
	 */
	public void setRssable(boolean rssable);

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

	public int compareTo(VcmsCategory vcmsCategory);

	public int hashCode();

	public CacheModel<VcmsCategory> toCacheModel();

	public VcmsCategory toEscapedModel();

	public String toString();

	public String toXmlString();
}
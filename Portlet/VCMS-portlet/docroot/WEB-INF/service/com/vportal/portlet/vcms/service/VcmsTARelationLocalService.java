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

package com.vportal.portlet.vcms.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the vcms t a relation local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hai
 * @see VcmsTARelationLocalServiceUtil
 * @see com.vportal.portlet.vcms.service.base.VcmsTARelationLocalServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsTARelationLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VcmsTARelationLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VcmsTARelationLocalServiceUtil} to access the vcms t a relation local service. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsTARelationLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the vcms t a relation to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsTARelation the vcms t a relation
	* @return the vcms t a relation that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsTARelation addVcmsTARelation(
		com.vportal.portlet.vcms.model.VcmsTARelation vcmsTARelation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new vcms t a relation with the primary key. Does not add the vcms t a relation to the database.
	*
	* @param vcmsTARelationPK the primary key for the new vcms t a relation
	* @return the new vcms t a relation
	*/
	public com.vportal.portlet.vcms.model.VcmsTARelation createVcmsTARelation(
		com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK vcmsTARelationPK);

	/**
	* Deletes the vcms t a relation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsTARelationPK the primary key of the vcms t a relation
	* @throws PortalException if a vcms t a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsTARelation(
		com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK vcmsTARelationPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the vcms t a relation from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsTARelation the vcms t a relation
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsTARelation(
		com.vportal.portlet.vcms.model.VcmsTARelation vcmsTARelation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.vportal.portlet.vcms.model.VcmsTARelation fetchVcmsTARelation(
		com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK vcmsTARelationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms t a relation with the primary key.
	*
	* @param vcmsTARelationPK the primary key of the vcms t a relation
	* @return the vcms t a relation
	* @throws PortalException if a vcms t a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.vportal.portlet.vcms.model.VcmsTARelation getVcmsTARelation(
		com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK vcmsTARelationPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms t a relations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms t a relations
	* @param end the upper bound of the range of vcms t a relations (not inclusive)
	* @return the range of vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> getVcmsTARelations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms t a relations.
	*
	* @return the number of vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVcmsTARelationsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the vcms t a relation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsTARelation the vcms t a relation
	* @return the vcms t a relation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsTARelation updateVcmsTARelation(
		com.vportal.portlet.vcms.model.VcmsTARelation vcmsTARelation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the vcms t a relation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsTARelation the vcms t a relation
	* @param merge whether to merge the vcms t a relation with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vcms t a relation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsTARelation updateVcmsTARelation(
		com.vportal.portlet.vcms.model.VcmsTARelation vcmsTARelation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);
}
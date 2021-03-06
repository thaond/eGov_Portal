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

package com.vportal.portlet.vcalendar.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the v cal local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LongLH
 * @see VCalLocalServiceUtil
 * @see com.vportal.portlet.vcalendar.service.base.VCalLocalServiceBaseImpl
 * @see com.vportal.portlet.vcalendar.service.impl.VCalLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VCalLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VCalLocalServiceUtil} to access the v cal local service. Add custom service methods to {@link com.vportal.portlet.vcalendar.service.impl.VCalLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the v cal to the database. Also notifies the appropriate model listeners.
	*
	* @param vCal the v cal
	* @return the v cal that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcalendar.model.VCal addVCal(
		com.vportal.portlet.vcalendar.model.VCal vCal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new v cal with the primary key. Does not add the v cal to the database.
	*
	* @param calId the primary key for the new v cal
	* @return the new v cal
	*/
	public com.vportal.portlet.vcalendar.model.VCal createVCal(long calId);

	/**
	* Deletes the v cal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param calId the primary key of the v cal
	* @throws PortalException if a v cal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVCal(long calId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the v cal from the database. Also notifies the appropriate model listeners.
	*
	* @param vCal the v cal
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVCal(com.vportal.portlet.vcalendar.model.VCal vCal)
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
	public com.vportal.portlet.vcalendar.model.VCal fetchVCal(long calId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v cal with the primary key.
	*
	* @param calId the primary key of the v cal
	* @return the v cal
	* @throws PortalException if a v cal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.vportal.portlet.vcalendar.model.VCal getVCal(long calId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v cals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @return the range of v cals
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vcalendar.model.VCal> getVCals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v cals.
	*
	* @return the number of v cals
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVCalsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the v cal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vCal the v cal
	* @return the v cal that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcalendar.model.VCal updateVCal(
		com.vportal.portlet.vcalendar.model.VCal vCal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the v cal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vCal the v cal
	* @param merge whether to merge the v cal with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the v cal that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcalendar.model.VCal updateVCal(
		com.vportal.portlet.vcalendar.model.VCal vCal, boolean merge)
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

	public com.vportal.portlet.vcalendar.model.VCal addvCal(long groupId,
		long companyId, long userId, java.lang.String userName,
		java.util.Date createDate, java.util.Date modifiedDate,
		java.lang.String languageId, java.lang.String title,
		java.lang.String description, java.util.Date startDate,
		java.util.Date endDate, int status, long fileId,
		java.lang.String guest, java.lang.String location, java.lang.String time)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.vportal.portlet.vcalendar.model.VCal updatevCal(long calId,
		long groupId, long companyId, long userId, java.lang.String userName,
		java.util.Date createDate, java.util.Date modifiedDate,
		java.lang.String languageId, java.lang.String title,
		java.lang.String description, int status, long fileId,
		java.lang.String guest, java.lang.String location, java.lang.String time)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.vportal.portlet.vcalendar.model.VCal deletevCal(long calId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S_G(
		java.util.Date startDate, int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S_G(
		java.util.Date startDate, int status, long groupId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByD_S_G(java.util.Date startDate, int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByU_D_S(
		long userId, int status, java.util.Date startDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByU_D_S(
		long userId, java.util.Date startDate, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByU_D_S(long userId, java.util.Date startDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S(
		java.util.Date startDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S(
		java.util.Date startDate, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByD_S(java.util.Date startDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.vportal.portlet.vcalendar.model.VCal findById(long calId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByUser(
		long calId, java.util.Date startDate, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByUserGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByGroupOrg()
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByF_D_G_T(
		long fileId, java.util.Date startDate, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByF_D_G_U(
		long userId, java.util.Date startDate, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByF(
		long fileId) throws com.liferay.portal.kernel.exception.SystemException;
}
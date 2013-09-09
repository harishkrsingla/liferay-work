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

package com.sample.harish.service.impl;

import com.sample.harish.model.Student;
import com.sample.harish.service.base.StudentLocalServiceBaseImpl;
import com.sample.harish.service.persistence.StudentUtil;

/**
 * The implementation of the student local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sample.harish.service.StudentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author harish.kumar
 * @see com.sample.harish.service.base.StudentLocalServiceBaseImpl
 * @see com.sample.harish.service.StudentLocalServiceUtil
 */
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sample.harish.service.StudentLocalServiceUtil} to access the student local service.
	 */
	public java.util.List<Student> findByCourseLike(
			java.lang.String course)
			throws com.liferay.portal.kernel.exception.SystemException {
			return StudentUtil.findByCourseLike(course);
		}
}
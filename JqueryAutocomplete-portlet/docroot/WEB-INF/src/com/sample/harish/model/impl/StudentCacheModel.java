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

package com.sample.harish.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sample.harish.model.Student;

import java.io.Serializable;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author harish.kumar
 * @see Student
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{studentId=");
		sb.append(studentId);
		sb.append(", studentName=");
		sb.append(studentName);
		sb.append(", course=");
		sb.append(course);
		sb.append("}");

		return sb.toString();
	}

	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setStudentId(studentId);

		if (studentName == null) {
			studentImpl.setStudentName(StringPool.BLANK);
		}
		else {
			studentImpl.setStudentName(studentName);
		}

		if (course == null) {
			studentImpl.setCourse(StringPool.BLANK);
		}
		else {
			studentImpl.setCourse(course);
		}

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	public long studentId;
	public String studentName;
	public String course;
}
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

package com.sample.harish.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sample.harish.service.StudentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author harish.kumar
 */
public class StudentClp extends BaseModelImpl<Student> implements Student {
	public StudentClp() {
	}

	public Class<?> getModelClass() {
		return Student.class;
	}

	public String getModelClassName() {
		return Student.class.getName();
	}

	public long getPrimaryKey() {
		return _studentId;
	}

	public void setPrimaryKey(long primaryKey) {
		setStudentId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_studentId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("studentId", getStudentId());
		attributes.put("studentName", getStudentName());
		attributes.put("course", getCourse());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		String studentName = (String)attributes.get("studentName");

		if (studentName != null) {
			setStudentName(studentName);
		}

		String course = (String)attributes.get("course");

		if (course != null) {
			setCourse(course);
		}
	}

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	public String getStudentName() {
		return _studentName;
	}

	public void setStudentName(String studentName) {
		_studentName = studentName;
	}

	public String getCourse() {
		return _course;
	}

	public void setCourse(String course) {
		_course = course;
	}

	public BaseModel<?> getStudentRemoteModel() {
		return _studentRemoteModel;
	}

	public void setStudentRemoteModel(BaseModel<?> studentRemoteModel) {
		_studentRemoteModel = studentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			StudentLocalServiceUtil.addStudent(this);
		}
		else {
			StudentLocalServiceUtil.updateStudent(this);
		}
	}

	@Override
	public Student toEscapedModel() {
		return (Student)Proxy.newProxyInstance(Student.class.getClassLoader(),
			new Class[] { Student.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StudentClp clone = new StudentClp();

		clone.setStudentId(getStudentId());
		clone.setStudentName(getStudentName());
		clone.setCourse(getCourse());

		return clone;
	}

	public int compareTo(Student student) {
		long primaryKey = student.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		StudentClp student = null;

		try {
			student = (StudentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = student.getPrimaryKey();

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
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{studentId=");
		sb.append(getStudentId());
		sb.append(", studentName=");
		sb.append(getStudentName());
		sb.append(", course=");
		sb.append(getCourse());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.sample.harish.model.Student");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>studentId</column-name><column-value><![CDATA[");
		sb.append(getStudentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studentName</column-name><column-value><![CDATA[");
		sb.append(getStudentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>course</column-name><column-value><![CDATA[");
		sb.append(getCourse());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _studentId;
	private String _studentName;
	private String _course;
	private BaseModel<?> _studentRemoteModel;
}
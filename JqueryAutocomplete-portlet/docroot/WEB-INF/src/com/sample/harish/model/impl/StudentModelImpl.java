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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.sample.harish.model.Student;
import com.sample.harish.model.StudentModel;
import com.sample.harish.model.StudentSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Student service. Represents a row in the &quot;harish_Student&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sample.harish.model.StudentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StudentImpl}.
 * </p>
 *
 * @author harish.kumar
 * @see StudentImpl
 * @see com.sample.harish.model.Student
 * @see com.sample.harish.model.StudentModel
 * @generated
 */
@JSON(strict = true)
public class StudentModelImpl extends BaseModelImpl<Student>
	implements StudentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a student model instance should use the {@link com.sample.harish.model.Student} interface instead.
	 */
	public static final String TABLE_NAME = "harish_Student";
	public static final Object[][] TABLE_COLUMNS = {
			{ "studentId", Types.BIGINT },
			{ "studentName", Types.VARCHAR },
			{ "course", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table harish_Student (studentId LONG not null primary key,studentName VARCHAR(75) null,course VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table harish_Student";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sample.harish.model.Student"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sample.harish.model.Student"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sample.harish.model.Student"),
			true);
	public static long COURSE_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Student toModel(StudentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Student model = new StudentImpl();

		model.setStudentId(soapModel.getStudentId());
		model.setStudentName(soapModel.getStudentName());
		model.setCourse(soapModel.getCourse());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Student> toModels(StudentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Student> models = new ArrayList<Student>(soapModels.length);

		for (StudentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sample.harish.model.Student"));

	public StudentModelImpl() {
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

	public Class<?> getModelClass() {
		return Student.class;
	}

	public String getModelClassName() {
		return Student.class.getName();
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

	@JSON
	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	@JSON
	public String getStudentName() {
		if (_studentName == null) {
			return StringPool.BLANK;
		}
		else {
			return _studentName;
		}
	}

	public void setStudentName(String studentName) {
		_studentName = studentName;
	}

	@JSON
	public String getCourse() {
		if (_course == null) {
			return StringPool.BLANK;
		}
		else {
			return _course;
		}
	}

	public void setCourse(String course) {
		_columnBitmask |= COURSE_COLUMN_BITMASK;

		if (_originalCourse == null) {
			_originalCourse = _course;
		}

		_course = course;
	}

	public String getOriginalCourse() {
		return GetterUtil.getString(_originalCourse);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Student.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Student toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Student)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setStudentId(getStudentId());
		studentImpl.setStudentName(getStudentName());
		studentImpl.setCourse(getCourse());

		studentImpl.resetOriginalValues();

		return studentImpl;
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

		Student student = null;

		try {
			student = (Student)obj;
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
	public void resetOriginalValues() {
		StudentModelImpl studentModelImpl = this;

		studentModelImpl._originalCourse = studentModelImpl._course;

		studentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Student> toCacheModel() {
		StudentCacheModel studentCacheModel = new StudentCacheModel();

		studentCacheModel.studentId = getStudentId();

		studentCacheModel.studentName = getStudentName();

		String studentName = studentCacheModel.studentName;

		if ((studentName != null) && (studentName.length() == 0)) {
			studentCacheModel.studentName = null;
		}

		studentCacheModel.course = getCourse();

		String course = studentCacheModel.course;

		if ((course != null) && (course.length() == 0)) {
			studentCacheModel.course = null;
		}

		return studentCacheModel;
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

	private static ClassLoader _classLoader = Student.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Student.class
		};
	private long _studentId;
	private String _studentName;
	private String _course;
	private String _originalCourse;
	private long _columnBitmask;
	private Student _escapedModelProxy;
}
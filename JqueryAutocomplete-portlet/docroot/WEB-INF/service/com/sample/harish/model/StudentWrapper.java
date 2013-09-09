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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author    harish.kumar
 * @see       Student
 * @generated
 */
public class StudentWrapper implements Student, ModelWrapper<Student> {
	public StudentWrapper(Student student) {
		_student = student;
	}

	public Class<?> getModelClass() {
		return Student.class;
	}

	public String getModelClassName() {
		return Student.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("studentId", getStudentId());
		attributes.put("studentName", getStudentName());
		attributes.put("course", getCourse());

		return attributes;
	}

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

	/**
	* Returns the primary key of this student.
	*
	* @return the primary key of this student
	*/
	public long getPrimaryKey() {
		return _student.getPrimaryKey();
	}

	/**
	* Sets the primary key of this student.
	*
	* @param primaryKey the primary key of this student
	*/
	public void setPrimaryKey(long primaryKey) {
		_student.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the student ID of this student.
	*
	* @return the student ID of this student
	*/
	public long getStudentId() {
		return _student.getStudentId();
	}

	/**
	* Sets the student ID of this student.
	*
	* @param studentId the student ID of this student
	*/
	public void setStudentId(long studentId) {
		_student.setStudentId(studentId);
	}

	/**
	* Returns the student name of this student.
	*
	* @return the student name of this student
	*/
	public java.lang.String getStudentName() {
		return _student.getStudentName();
	}

	/**
	* Sets the student name of this student.
	*
	* @param studentName the student name of this student
	*/
	public void setStudentName(java.lang.String studentName) {
		_student.setStudentName(studentName);
	}

	/**
	* Returns the course of this student.
	*
	* @return the course of this student
	*/
	public java.lang.String getCourse() {
		return _student.getCourse();
	}

	/**
	* Sets the course of this student.
	*
	* @param course the course of this student
	*/
	public void setCourse(java.lang.String course) {
		_student.setCourse(course);
	}

	public boolean isNew() {
		return _student.isNew();
	}

	public void setNew(boolean n) {
		_student.setNew(n);
	}

	public boolean isCachedModel() {
		return _student.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_student.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _student.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _student.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_student.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _student.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_student.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StudentWrapper((Student)_student.clone());
	}

	public int compareTo(com.sample.harish.model.Student student) {
		return _student.compareTo(student);
	}

	@Override
	public int hashCode() {
		return _student.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.sample.harish.model.Student> toCacheModel() {
		return _student.toCacheModel();
	}

	public com.sample.harish.model.Student toEscapedModel() {
		return new StudentWrapper(_student.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _student.toString();
	}

	public java.lang.String toXmlString() {
		return _student.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_student.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Student getWrappedStudent() {
		return _student;
	}

	public Student getWrappedModel() {
		return _student;
	}

	public void resetOriginalValues() {
		_student.resetOriginalValues();
	}

	private Student _student;
}
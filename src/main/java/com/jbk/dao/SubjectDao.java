package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Subject;

public interface SubjectDao {

	public String addSubject(Subject subject);

	public List<Subject> getAllSubject();

	public Subject getSubjectByRollNo(long rollNo);

	public String updateSubject(Subject subject);

	public String deleteSubject(long rollNo);
}

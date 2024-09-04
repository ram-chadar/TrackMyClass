package com.jbk.service;

import java.util.List;

import com.jbk.entity.Subject;

public interface SubjectService {

	public String addSubject(Subject subject);

	public List<Subject> getAllSubject();

	public Subject getSubjectById(long id);

	public String updateSubject(Subject subject);

	public String deleteSubject(long id);

}

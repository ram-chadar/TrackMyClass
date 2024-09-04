package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.SubjectDao;
import com.jbk.entity.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDao dao;

	@Override
	public String addSubject(Subject subject) {
		
		String msg = dao.addSubject(subject);
		
		return msg;
	}

	@Override
	public List<Subject> getAllSubject() {
		List<Subject> allSubject = dao.getAllSubject();
		return allSubject;
	}

	@Override
	public Subject getSubjectById(long id) {
		Subject subject = dao.getSubjectByRollNo(id);
		return subject;
	}

	@Override
	public String updateSubject(Subject subject) {
		String msg = dao.updateSubject(subject);
		return msg;
	}

	@Override
	public String deleteSubject(long rollNo) {
		String msg = dao.deleteSubject(rollNo);
		return msg;
	}

}

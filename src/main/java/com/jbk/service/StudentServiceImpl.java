package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.StudentDao;
import com.jbk.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao dao;

	@Override
	public String addStudent(Student student) {
		
		String msg = dao.addStudent(student);
		
		return msg;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> allStudent = dao.getAllStudent();
		return allStudent;
	}

	@Override
	public Student getStudentByRollNo(long rollNo) {
		Student student = dao.getStudentByRollNo(rollNo);
		return student;
	}

	@Override
	public String updateStudent(Student student) {
		String msg = dao.updateStudent(student);
		return msg;
	}

	@Override
	public String deleteStudent(long rollNo) {
		String msg = dao.deleteStudent(rollNo);
		return msg;
	}

	@Override
	public List<Student> getAllStudentByRoll(List<Long> list) {
		List<Student> studentList=dao.getAllStudentByRoll(list);
		return studentList;
	}

}

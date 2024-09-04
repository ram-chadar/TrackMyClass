package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Subject;
import com.jbk.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectService service;

	@GetMapping("/get-all-subjects")
	public List<Subject> getAllSubject() {
		List<Subject> allSubject = service.getAllSubject();
		return allSubject;
	}

	// localhost:8091/subject/add-subject
	@PostMapping("/add-subject")
	public String addSubject(@RequestBody Subject subject) {

		String msg = service.addSubject(subject);
		return msg;
	}

	@GetMapping("/get-subject-by-id/{id}")
	public Subject getSubjectById(@PathVariable long id) {
		Subject subject = service.getSubjectById(id);
		return subject;

	}

	@DeleteMapping("/delete/subject/{id}")
	public String deleteStudet(@PathVariable long id) {
		String msg = service.deleteSubject(id);
		return msg;
	}

	@PutMapping("/update-subject")
	public String updateSubject(@RequestBody Subject subject) {
		String msg = service.updateSubject(subject);
		return msg;
	}
}

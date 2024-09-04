package com.jbk.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.AttendanceDto;
import com.jbk.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;
	
	@PostMapping("/take-attendance")
	public String takeAttendance(@RequestBody AttendanceDto attendanceDto) {
		String msg = attendanceService.takeAttendance(attendanceDto);
		
		return msg;
		
	}

}

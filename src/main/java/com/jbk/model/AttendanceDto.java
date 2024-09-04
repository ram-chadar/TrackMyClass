package com.jbk.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttendanceDto {

	private String id;
	private List<Long> rollNos;
	private String username;
	private String date;
	private String time;
	private int counts;
	private long subjectId;
	
	
}

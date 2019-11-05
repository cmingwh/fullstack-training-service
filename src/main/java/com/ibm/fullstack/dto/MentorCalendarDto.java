package com.ibm.fullstack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorCalendarDto {
	
	private Long calendarId;
	
	private String userName;
	
	private String startDate;
	
	private String startTime;
	
	private String endTime;
}
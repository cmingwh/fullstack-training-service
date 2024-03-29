package com.ibm.fullstack.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ibm.fullstack.entity.MentorCalendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDto {
	private Long trainingId;
	private String status;
	private Integer progress;
	private Float commissionAmount;
	private Float avgRating = 0.0f;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String endDate;
	@JsonFormat(pattern = "HH:mm:ss")
	private String startTime;
	@JsonFormat(pattern = "HH:mm:ss")
	private String endTime;
	private Float amountReceived;
	private MentorCalendar calendar;
	private Long calendarId;
	private String userName;
	private String mentorName;
	private Long skillId;
	private String skillName;
	private Float fees;
	private String comment;
	private String applyReason;
}

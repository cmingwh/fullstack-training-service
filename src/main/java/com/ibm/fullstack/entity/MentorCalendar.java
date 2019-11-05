package com.ibm.fullstack.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mentor_calendar", schema = "fullstack")
public class MentorCalendar {
	
	@Id
	@GeneratedValue
	@Column(name="calendar_id")
	private Long calendarId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
}
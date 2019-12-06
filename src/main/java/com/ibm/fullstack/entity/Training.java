package com.ibm.fullstack.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "training", schema = "fullstack")
public class Training {

	@Id
	@GeneratedValue
	@Column(name="training_id")
	private Long trainingId;
	
	@Column(name="status")
	private String status = "APPLY";
	
	@Column(name="progress")
	private Integer progress = 0;
	
	@Column(name="fees")
	private Float fees = 0.0f;
	
	@Column(name="commission_amount")
	private Float commissionAmount = 0.0f;
	
	@Column(name="rating")
	private Integer rating = 0;
	
	@Column(name = "amount_received")
	private Float amountReceived = 0.0f;
	
	@ManyToOne
	@JoinColumn(name="calendar_id", insertable=false, updatable=false)
	private MentorCalendar calendar;
	
	@Column(name = "calendar_id")
	private Long calendarId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "mentor_name")
	private String mentorName;

	@Column(name = "skill_id")
	private Long skillId;
	
	@Column(name = "skill_name")
	private String skillName;
	
	@Column(name = "payment_id")
	private Long payment_id;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "apply_reason")
	private String applyReason;
	
}

package com.ibm.fullstack.entity;


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
@Table(name = "training", schema = "fullstack")
public class Training {

	@Id
	@GeneratedValue
	@Column(name="training_id")
	private Long trainingId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="progress")
	private Integer progress = 0;
	
	@Column(name="fees")
	private Float fees = 0.0f;
	
	@Column(name="commission_amount")
	private Float commissionAmount = 0.0f;
	
	@Column(name="rating")
	private Integer rating = 0;
	
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "end_date")
	private String endDate;
	
	@Column(name = "amount_received")
	private Float amountReceived = 0.0f;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "mentor_id")
	private Long mentorId;
	
	@Column(name = "skill_id")
	private Long skillId;
	
	@Column(name = "payment_id")
	private Long payment_id;
	
	
}

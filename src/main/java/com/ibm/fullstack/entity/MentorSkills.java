package com.ibm.fullstack.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mentor_skills", schema = "fullstack")
public class MentorSkills {

	@Column(name="mentor_id")
	private Long mentorId;
	
	@Column(name="skill_id")
	private Long skillId;
	
	@Column(name="level")
	private Integer level;
}

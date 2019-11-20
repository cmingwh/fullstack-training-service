package com.ibm.fullstack.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_user", schema = "fullstack")
public class User {
	
	@GeneratedValue
	@Column(name="user_id")
	private Long userId;
	
	@Id
	@Column(name="user_name")
	private String userName;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="contact_number")
	private String contactNumber;

	@Column(name="linedin_url")
	private String linedinUrl;

	@Column(name="years_of_experience")
	private Float yearsOfExperience;

	@Column(name="timezone")
	private String timezone;
	
	@Column(name="introduction")
	private String introduction;
	
	@Column(name="facilities")
	private String facilities;
	
	@Column(name="examples")
	private String examples;
	
}
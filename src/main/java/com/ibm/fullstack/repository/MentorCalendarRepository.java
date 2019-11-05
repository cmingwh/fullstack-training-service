package com.ibm.fullstack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.fullstack.entity.MentorCalendar;

@Repository
public interface MentorCalendarRepository extends JpaRepository<MentorCalendar, String> {

	List<MentorCalendar> findByUserName(String userName);

	void deleteByCalendarId(Long id);

	MentorCalendar findByCalendarId(Long id);

}
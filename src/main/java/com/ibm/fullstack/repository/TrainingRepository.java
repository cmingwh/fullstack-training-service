package com.ibm.fullstack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.fullstack.entity.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
	
	@Query(value = "select t from Training as t left join MentorCalendar as m on m.calendarId = t.calendarId "
			+ "where t.status in :statuses")
	List<Training> findByStatus(List<String> statuses);


}
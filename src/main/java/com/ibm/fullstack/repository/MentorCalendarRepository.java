package com.ibm.fullstack.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.fullstack.entity.MentorCalendar;

@Repository
public interface MentorCalendarRepository extends JpaRepository<MentorCalendar, String> {

	List<MentorCalendar> findByUserName(String userName);

	void deleteByCalendarId(Long id);

	MentorCalendar findByCalendarId(Long id);

	@Query(value = "select m from MentorCalendar as m inner join MentorSkill as s on m.userName = s.userName "
			+ "left join User as u on m.userName = u.userName "
			+ "where s.skillId = :skillId and m.status = :status and m.endDate <= :endDate and m.startDate >= :startDate")
    List<MentorCalendar> search(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("skillId")Long skillId, @Param("status")String status);

	@Modifying
	@Query(value="update MentorCalendar as m set m.status = :calendarStatusApply where m.calendarId = :calendarId")
	Integer changeStatus(Long calendarId, String calendarStatusApply);
}
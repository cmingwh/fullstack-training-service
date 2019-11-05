package com.ibm.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.fullstack.dto.MentorCalendarDto;
import com.ibm.fullstack.entity.MentorCalendar;
import com.ibm.fullstack.repository.MentorCalendarRepository;
import com.ibm.fullstack.utils.Utils;

@Service("userService")
public class MentorCalendarService {
	@Autowired
    private MentorCalendarRepository calendarRepository;

	public List<MentorCalendarDto> findByUserName(String userName) {
		List<MentorCalendar> list = calendarRepository.findByUserName(userName);
		return Utils.convertTOCalendarDtoList(list);
	}

	public MentorCalendar save(MentorCalendarDto calendarDto) {
		MentorCalendar calendar = Utils.convertTOCalendar(calendarDto);
		return calendarRepository.save(calendar);
	}

	public void delete(Long id) {
		calendarRepository.deleteByCalendarId(id);
	}

	public MentorCalendarDto findByid(Long id) {
		MentorCalendar calendar = calendarRepository.findByCalendarId(id);
		return Utils.convertTOCalendarDto(calendar);
	}
	
}

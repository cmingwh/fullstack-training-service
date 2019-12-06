package com.ibm.fullstack.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.fullstack.dto.MentorCalendarDto;
import com.ibm.fullstack.entity.MentorCalendar;
import com.ibm.fullstack.repository.MentorCalendarRepository;
import com.ibm.fullstack.utils.Constant;
import com.ibm.fullstack.utils.Utils;

@Service("userService")
public class MentorCalendarService {
	@Autowired
    private MentorCalendarRepository calendarRepository;

	public List<MentorCalendarDto> findByUserName(String userName) {
		List<MentorCalendar> list = calendarRepository.findByUserName(userName);
		return Utils.convertTOCalendarDtoList(list);
	}

	public MentorCalendarDto save(MentorCalendarDto calendarDto) {
		MentorCalendar calendar = Utils.convertTOCalendar(calendarDto);
		MentorCalendar newCal = calendarRepository.save(calendar);
		calendarDto.setCalendarId(newCal.getCalendarId());
		return calendarDto;
	}

	@Transactional
	public void delete(Long id) {
		calendarRepository.deleteByCalendarId(id);
	}

	public MentorCalendarDto findByid(Long id) {
		MentorCalendar calendar = calendarRepository.findByCalendarId(id);
		return Utils.convertTOCalendarDto(calendar);
	}

	public List<MentorCalendarDto> search(MentorCalendarDto calendarDto) {
		MentorCalendar calendar = Utils.convertTOCalendar(calendarDto);
		List<MentorCalendar> calendars = calendarRepository.search(calendar.getStartDate(), calendar.getEndDate(), calendarDto.getSkillId(), calendarDto.getStatus());
		Iterator<MentorCalendar> it = calendars.iterator();
		List<MentorCalendarDto> result = new ArrayList<MentorCalendarDto>();
		while(it.hasNext()) {
			MentorCalendar cal = it.next();
			MentorCalendarDto dto = Utils.convertTOCalendarDto(cal);
			dto.setSkillId(calendarDto.getSkillId());
			result.add(dto);
		}
		return result;
	}

	public void changeStatus(Long calendarId, String calendarStatusApply) {
		calendarRepository.changeStatus(calendarId, calendarStatusApply);
	}

	public List<MentorCalendarDto> searchNew(MentorCalendarDto calendarDto) {
		calendarDto.setStatus(Constant.CALENDAR_STATUS_NEW);
		return this.search(calendarDto);
	}

}

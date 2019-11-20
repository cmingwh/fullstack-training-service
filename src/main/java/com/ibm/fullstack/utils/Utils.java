package com.ibm.fullstack.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ibm.fullstack.dto.MentorCalendarDto;
import com.ibm.fullstack.entity.MentorCalendar;

public class Utils {

	
	public static MentorCalendarDto convertTOCalendarDto(MentorCalendar calendar) {
		MentorCalendarDto calendarDto = new MentorCalendarDto();
		calendarDto.setCalendarId(calendar.getCalendarId());
		calendarDto.setUserName(calendar.getUserName());
		calendarDto.setStatus(calendar.getStatus());
		calendarDto.setUser(calendar.getUser());
		
		SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
		calendarDto.setStartDate(yyyyMMdd.format(calendar.getStartDate()));
		
		SimpleDateFormat HHmm = new SimpleDateFormat("HH:mm");
		calendarDto.setStartTime(HHmm.format(calendar.getStartDate()));
		calendarDto.setEndTime(HHmm.format(calendar.getEndDate()));
		return calendarDto;
	}
	
	public static MentorCalendar convertTOCalendar(MentorCalendarDto calendarDto) {
		calendarDto.setStartDate(calendarDto.getStartDate().substring(0, 10));
		MentorCalendar calendar = new MentorCalendar();
		calendar.setCalendarId(calendarDto.getCalendarId());
		calendar.setUserName(calendarDto.getUserName());
		SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			calendar.setStartDate(yyyyMMddHHmmss.parse(calendarDto.getStartDate() + " " + calendarDto.getStartTime()));
			calendar.setEndDate(yyyyMMddHHmmss.parse(calendarDto.getStartDate() + " " + calendarDto.getEndTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return calendar;
	}

	public static List<MentorCalendarDto> convertTOCalendarDtoList(List<MentorCalendar> list) {
		List<MentorCalendarDto> results = new ArrayList<MentorCalendarDto>();
		Iterator<MentorCalendar> it = list.iterator();
		while(it.hasNext()) {
			MentorCalendar calendar = it.next();
			MentorCalendarDto dto = convertTOCalendarDto(calendar);
			results.add(dto);
		}
		return results;
	}
}

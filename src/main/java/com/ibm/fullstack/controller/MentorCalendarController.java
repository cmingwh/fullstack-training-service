package com.ibm.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.fullstack.dto.MentorCalendarDto;
import com.ibm.fullstack.service.MentorCalendarService;

@RestController
@CrossOrigin
@RequestMapping("/calendars")
public class MentorCalendarController {

    @Autowired
    private MentorCalendarService calendarService;

    @GetMapping("/user/{userName}")
    public List<MentorCalendarDto> findByUserName(@PathVariable String userName) {
    	return calendarService.findByUserName(userName);
    }
    
    @GetMapping("/{id}")
    public MentorCalendarDto findByid(@PathVariable Long id) {
    	return calendarService.findByid(id);
    }
    
    @PostMapping(value = "/save")
    public MentorCalendarDto save(@RequestBody MentorCalendarDto calendarDto) {
		return calendarService.save(calendarDto);
    }
    
    @DeleteMapping(value = "/{id}")
    public void save(@PathVariable Long id) {
		calendarService.delete(id);
    }
    
    @PostMapping(value = "/search")
    public List<MentorCalendarDto> search(@RequestBody MentorCalendarDto calendarDto) {
		return calendarService.search(calendarDto);
    }
}
package com.ibm.fullstack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.fullstack.entity.Training;
import com.ibm.fullstack.repository.TrainingRepository;
import com.ibm.fullstack.utils.Constant;

@Service("trainingService")
public class TrainingService {
	@Autowired
    private TrainingRepository trainingRepository;
	
	@Autowired
    private MentorCalendarService calendarService;
	
	public Training save(Training training) {
		trainingRepository.save(training);
		return null;
	}

	@Transactional
	public Training propose(Training training) {
		Long calendarId = training.getCalendarId();
		if(null == calendarId) {
			return null;
		}
		calendarService.changeStatus(calendarId, Constant.CALENDAR_STATUS_APPLY);
		training.setSkillName(getSkillById(training.getSkillId()));
		return this.save(training);
	}

	private String getSkillById(Long skillId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Training> current(String userName) {
		List<String> statuses = new ArrayList<String>();
		statuses.add(Constant.TRAINING_STATUS_APPLY);
		statuses.add(Constant.TRAINING_STATUS_INPROGRESS);
		return trainingRepository.findByStatus(statuses);
	}

	public List<Training> closed(String userName) {
		List<String> statuses = new ArrayList<String>();
		statuses.add(Constant.TRAINING_STATUS_CLOSE);
		statuses.add(Constant.TRAINING_STATUS_REFUSE);
		statuses.add(Constant.TRAINING_STATUS_CANCEL);
		return trainingRepository.findByStatus(statuses);
	}

}

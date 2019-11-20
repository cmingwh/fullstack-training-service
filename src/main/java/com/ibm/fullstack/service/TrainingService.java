package com.ibm.fullstack.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.fullstack.entity.Training;
import com.ibm.fullstack.repository.TrainingRepository;

public class TrainingService {
	@Autowired
    private TrainingRepository trainingRepository;
	
	public Training save(Training training) {
		trainingRepository.save(training);
		return null;
	}

}
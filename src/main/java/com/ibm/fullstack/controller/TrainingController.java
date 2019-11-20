package com.ibm.fullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.fullstack.entity.Training;
import com.ibm.fullstack.service.TrainingService;

@RestController
@CrossOrigin
@RequestMapping("/train")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @PostMapping(value = "/propose")
    public Training propose(@RequestBody Training training) {
		return trainingService.save(training);
    }
    
}
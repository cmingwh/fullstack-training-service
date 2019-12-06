package com.ibm.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		return trainingService.propose(training);
    }
    
    @GetMapping("/current/{userName}")
    public List<Training> current(@PathVariable String userName) {
    	return trainingService.current(userName);
    }
    
    @GetMapping("/closed/{userName}")
    public List<Training> closed(@PathVariable String userName) {
    	return trainingService.closed(userName);
    }
}
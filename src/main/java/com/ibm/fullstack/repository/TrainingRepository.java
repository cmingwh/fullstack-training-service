package com.ibm.fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.fullstack.entity.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {


}
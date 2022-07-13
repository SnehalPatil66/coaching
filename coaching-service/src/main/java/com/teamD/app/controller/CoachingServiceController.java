package com.teamD.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamD.app.model.Coaching;
import com.teamD.app.model.StudentDetails;
import com.teamD.app.repository.CoachingServiceRepository;
import com.teamD.app.repository.StudentDetailsRepository;
import com.teamD.app.service.CoachingService;

@RestController
@RequestMapping("/Coaching")

public class CoachingServiceController {

	@Autowired
	CoachingService coachingService;
	
	@Autowired
	CoachingServiceRepository coachingserviceRepository;
	
	@Autowired
	StudentDetailsRepository studentDetailsRepository;
	
@PostMapping
public ResponseEntity<Coaching> addCoachingDetails(@RequestBody Coaching ca)
{
return new ResponseEntity<>(coachingService.addCoachingDetails(ca), HttpStatus.CREATED);
}


@GetMapping
public ResponseEntity <List<Coaching>> getCoachingDetails()
{
return new ResponseEntity<>(coachingService.getCoachingDetails(), HttpStatus.CREATED);
}


@PutMapping("/Student")
public ResponseEntity <Coaching> registerStudent(@RequestBody Coaching sd)
{
return new ResponseEntity<>(coachingService.registerStudent(sd), HttpStatus.CREATED);
}

/*
@GetMapping("/Coaching/Student")
public ResponseEntity <StudentDetails> getStudentByName(@RequestBody StudentDetails sd)
{
return new ResponseEntity<>(coachingService.getStudentByName(sd), HttpStatus.CREATED);
}


*/
}

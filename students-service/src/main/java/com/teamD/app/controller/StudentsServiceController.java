package com.teamD.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;
import com.teamD.app.model.StudentDetails;
import com.teamD.app.model.Students;
import com.teamD.app.repository.StudentsServiceRepository;
import com.teamD.app.service.StudentsService;

@RestController
@RequestMapping("/Students")

public class StudentsServiceController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	StudentsService studentsService;
	
	@Autowired
	StudentsServiceRepository coachingserviceRepository;
	
	@Autowired
	private EurekaClient discoveryClient;
	

	
	@GetMapping("/{StudentNames}")
	public ResponseEntity<StudentDetails> getStudents(@PathVariable("StudentNames") String StudentNames)
	{
	return new ResponseEntity<>(studentsService.getStudents(StudentNames), HttpStatus.CREATED);
	}

	@PostMapping("/Details")
	public ResponseEntity<Students> putStudentDetails(@RequestBody Students student)
	{
	return new ResponseEntity<>(studentsService.putStudentDetails(student), HttpStatus.CREATED);
	}


	@GetMapping("Details/{StudentNames}")
	public ResponseEntity<Students> getStudentsInformation(@PathVariable("StudentNames") String StudentNames)
	{
	return new ResponseEntity<>(studentsService.getStudentsInformation(StudentNames), HttpStatus.CREATED);
	}

	
}

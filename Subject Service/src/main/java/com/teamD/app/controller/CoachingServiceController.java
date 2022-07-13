package com.teamD.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamD.app.model.Subject;
import com.teamD.app.repository.SubjectRepositoryInterface;
import com.teamD.app.service.SubjectService;

@RestController
@RequestMapping("/Subject")

public class CoachingServiceController {

	@Autowired
	SubjectService subjectService;
	
	@Autowired
	SubjectRepositoryInterface subjectRepositoryInterface;
	
	
	
@PostMapping
public ResponseEntity<Subject> addSubject(@RequestBody Subject subject)
{
return new ResponseEntity<>(subjectService.addSubject(subject), HttpStatus.CREATED);
}

@GetMapping
public ResponseEntity <List<Subject>> getCoachingDetails()
{
return new ResponseEntity<>(subjectService.getSubjectDetails(), HttpStatus.CREATED);
}

@GetMapping("/{SubjectName}")
public ResponseEntity <Subject> registerStudent(@PathVariable("SubjectName") String SubjectName)
{
return new ResponseEntity<>(subjectService.getSubject(SubjectName), HttpStatus.CREATED);
}




}

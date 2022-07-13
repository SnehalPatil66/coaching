package com.teamD.app.service;

import java.util.List;
import java.util.Optional;

import com.teamD.app.model.StudentDetails;
import com.teamD.app.model.Students;

public interface StudentsService {
	//public Students getStudentsById(Integer id);
	
	public StudentDetails getStudents(String studentName);
	
	//public Optional<Students> getId(Integer studentId);
		
	public Students putStudentDetails(Students studentObj);
	
	public Students getStudentsInformation(String studentName);
}

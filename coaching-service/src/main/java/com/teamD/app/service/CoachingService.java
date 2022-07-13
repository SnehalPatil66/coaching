package com.teamD.app.service;

import java.util.List;



import com.teamD.app.model.Coaching;
import com.teamD.app.model.StudentDetails;

public interface CoachingService {
	
public Coaching addCoachingDetails(Coaching ca);



public List<Coaching> getCoachingDetails(); 

public Coaching registerStudent(Coaching sd);	

//public StudentDetails getStudentByName(StudentDetails sd);
	
   
}

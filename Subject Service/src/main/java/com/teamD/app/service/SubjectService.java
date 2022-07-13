package com.teamD.app.service;

import java.util.List;

import com.teamD.app.model.Subject;

public interface SubjectService 
{

	public Subject addSubject(Subject subjectdetail);
		
	public List<Subject> getSubjectDetails();
	
	public Subject getSubject(String subjectName);
	
	
}

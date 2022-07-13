package com.teamD.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamD.app.model.Coaching;
import com.teamD.app.model.StudentDetails;
import com.teamD.app.repository.CoachingServiceRepository;
import com.teamD.app.repository.StudentDetailsRepository;

@Service
public class CoachingServiceImpl implements CoachingService{

	@Autowired
	CoachingServiceRepository coachingServiceRepository;
	
	@Autowired
	StudentDetailsRepository studentDetailsRepository;
	
	
	@Override
	public Coaching addCoachingDetails(Coaching ca) {
		
		Coaching coachingService=new Coaching();
		coachingService.setId(ca.getId());
		coachingService.setCoachingName(ca.getCoachingName());
		
		coachingServiceRepository.save(coachingService);
		return coachingService;
		
	}

	
	 
   @Override
	public List<Coaching> getCoachingDetails() {
	   
		return  coachingServiceRepository.findAll() ;
	}

	@Override
	public Coaching registerStudent(Coaching coachingData) 
	{
		
		List<Coaching> coachingList=new ArrayList<>();
		coachingList=coachingServiceRepository.findAll();
		
		for(Coaching coaching:coachingList)
		{
			if(coachingData.getId()==coaching.getId())
			{
				
				coaching.setCourseList(coachingData.getCourseList());
				
				
				coachingServiceRepository.save(coaching);	
				break;
			}
		}
		
		return coachingData;
	}

	/*
	@Override
	public StudentDetails getStudentByName(StudentDetails sd) {
		String studentName=sd.getStudentName();
		
		List<StudentDetails> studentDetails=new ArrayList<StudentDetails>(); 
		studentDetails=studentDetailsRepository.findAll();
		for( StudentDetails studentDetailsObj:studentDetails)
		{
		if(studentDetailsObj.getStudentName().equals(sd.getStudentName()))
		{
		return studentDetailsObj;
		}
		}
		return null;


	}

		*/
}

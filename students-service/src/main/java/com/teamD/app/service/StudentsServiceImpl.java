package com.teamD.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;
import com.teamD.app.model.Coaching;
import com.teamD.app.model.StudentDetails;
import com.teamD.app.model.Students;
import com.teamD.app.model.Subject;
import com.teamD.app.repository.StudentsServiceRepository;

@Service
public class StudentsServiceImpl implements StudentsService{
	
	@Autowired
	StudentsServiceRepository studentserviceRepository;
	
	

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private EurekaClient discoveryClient;
	
	
	@Override
	public StudentDetails getStudents(String studentName) 
	{
					
			final String uri = "http://COACHING-SERVICE/Coaching";
		 
		    
			ResponseEntity<List<Coaching>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Coaching>>(){});

			List<Coaching> coachingList=new ArrayList<>();
			List<StudentDetails> studentDetailList=new ArrayList<>();
			List<Subject> subjectList =new ArrayList<>();
			double Amount=0.0;
			
			coachingList=response.getBody();
			
			for(Coaching CoachingObj:coachingList)
			{
				studentDetailList=CoachingObj.getCourseList();
			}
			
			StudentDetails tempStudent=new StudentDetails();
			
			for(StudentDetails student:studentDetailList)
			{
				if(student.getStudentName().equals(studentName))
				{
					tempStudent=student;
					break;
					
					
				}
			}
						return tempStudent;
	
	}

	public Students putStudentDetails(Students studentObj)
	{
		return studentserviceRepository.save(studentObj);
	}


	
	public Students getStudentsInformation(String studentName)
	{
		List<Students> studentList=new ArrayList<>();
		
		studentList=studentserviceRepository.findAll();
		
		Students tempStudent=new Students();
		for(Students student:studentList)
		{
			if(student.getStudentName().equals(studentName))
			{
				tempStudent=student;
				break;
			}
		}
		return tempStudent;
	}

	
	
	/*
	@Override
	public Optional<Students> getId(Integer studentId) {
		
				return studentserviceRepository.findById(studentId);
	}


	@Override
	public Students getInvoice() {
		
		return null;
	}
	
    @Override
	public Students subjectSelectedByStudent(Long studentId, String subjectName) {
	
			return null;
		
}

*/
	  
}
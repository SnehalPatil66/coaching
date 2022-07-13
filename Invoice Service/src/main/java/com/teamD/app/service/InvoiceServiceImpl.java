package com.teamD.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;
import com.teamD.app.model.Coaching;
import com.teamD.app.model.Invoice;
import com.teamD.app.model.InvoiceDetails;
import com.teamD.app.model.InvoiceSubject;
import com.teamD.app.model.StudentDetails;
import com.teamD.app.model.Subject;
import com.teamD.app.repository.InvoiceServiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private EurekaClient discoveryClient;
	
	
	@Autowired
	InvoiceServiceRepository invoiceServiceRepository;
	
	@Autowired
	InvoiceServiceRepository invoiceServiceRepository1;
	
	public InvoiceDetails getInvoice(String studentName)
	{
		
		/*
		 * Application instances = discoveryClient.getApplication("employee-service");
		 * 
		 * String host = instances.getInstances().get(0).getHomePageUrl();
		 * 
		 * System.out.println(host);
		 */
		
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
		
		for(StudentDetails student:studentDetailList)
		{
			if(student.getStudentName().equals(studentName))
			{
				subjectList=student.getSubjectList();
				Amount=student.getTotalFees();
				break;
				
				
			}
		}
		List<InvoiceSubject> fullInvoice=new ArrayList<>();
		
		InvoiceDetails invoiceDetails=new InvoiceDetails();
		invoiceDetails.setTotalAmount(Amount);
		for(Subject subject:subjectList)
		{
			InvoiceSubject invoiceObj=new InvoiceSubject();
			invoiceObj.setSubName(subject.getSubjectName());
			fullInvoice.add(invoiceObj);
		}
		
		invoiceDetails.setSubjectName(fullInvoice);
		
		invoiceServiceRepository.save(invoiceDetails);
		return invoiceDetails;
	}


}

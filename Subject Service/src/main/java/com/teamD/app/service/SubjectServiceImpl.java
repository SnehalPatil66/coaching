package com.teamD.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamD.app.model.Subject;
import com.teamD.app.repository.SubjectRepositoryInterface;

@Service
public class SubjectServiceImpl implements SubjectService
{
	@Autowired
	SubjectRepositoryInterface subjectRepositoryInterface;

	@Override
	public Subject addSubject(Subject subjectdetail)
	{
		return subjectRepositoryInterface.save(subjectdetail);
	}

	@Override
	public List<Subject> getSubjectDetails() 
	{
		List<Subject> subjectList=new ArrayList<>();
		
		subjectList=subjectRepositoryInterface.findAll();
		
		return subjectList;
	}

	@Override
	public Subject getSubject(String subjectName)
	{
		
		List<Subject> subjectDetails=new ArrayList<Subject>(); 
		
		subjectDetails=subjectRepositoryInterface.findAll();
		for( Subject subjectDetailsObj:subjectDetails)
		{
		if(subjectDetailsObj.getSubjectName().equals(subjectName))
		{
		return subjectDetailsObj;
		}
		}
		return null;

	}

}

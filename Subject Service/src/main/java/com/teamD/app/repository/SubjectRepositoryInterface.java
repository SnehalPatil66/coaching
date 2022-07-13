package com.teamD.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamD.app.model.Subject;

public interface SubjectRepositoryInterface extends JpaRepository<Subject, Integer>
{

}


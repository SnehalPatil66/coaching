package com.teamD.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamD.app.model.Subject;

@Repository
public interface SubjectDetailsRepository extends JpaRepository<Subject, Integer> {

}

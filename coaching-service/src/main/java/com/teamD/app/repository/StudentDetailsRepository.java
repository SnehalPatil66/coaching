package com.teamD.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.teamD.app.model.Coaching;
import com.teamD.app.model.StudentDetails;

@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Integer> {

}



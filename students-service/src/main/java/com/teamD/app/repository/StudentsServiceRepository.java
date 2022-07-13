package com.teamD.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamD.app.model.Students;


@Repository
public interface StudentsServiceRepository extends JpaRepository<Students, Integer> {

}

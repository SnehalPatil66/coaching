package com.teamD.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamD.app.model.InvoiceDetails;

public interface InvoiceSubjectRepository extends JpaRepository<InvoiceDetails, Integer>{

}

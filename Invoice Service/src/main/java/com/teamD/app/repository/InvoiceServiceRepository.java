package com.teamD.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamD.app.model.Invoice;
import com.teamD.app.model.InvoiceDetails;

@Repository
public interface InvoiceServiceRepository extends JpaRepository<InvoiceDetails, Integer>
 {

}

package com.teamD.app.service;

import java.util.List;

import com.teamD.app.model.Coaching;
import com.teamD.app.model.Invoice;
import com.teamD.app.model.InvoiceDetails;

public interface InvoiceService 
{

	
	//public Invoice getInvoice(String studentName);
	
//	public Invoice addInvoiceData(Invoice invoice);
	
	public InvoiceDetails getInvoice(String studentName);

	
}

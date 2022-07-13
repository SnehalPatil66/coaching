package com.teamD.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;
import com.teamD.app.model.Coaching;
import com.teamD.app.model.Invoice;
import com.teamD.app.repository.InvoiceServiceRepository;
import com.teamD.app.service.InvoiceService;

@RestController
@RequestMapping("/Invoice")
public class InvoiceServiceController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
    InvoiceService invoiceService;
	
	@Autowired
  InvoiceServiceRepository 	invoiceServiceRepository;
	
	@Autowired
	private EurekaClient discoveryClient;
	
@GetMapping("/{studentName}")
public ResponseEntity  getInvoice(@PathVariable("studentName") String studentName)
{
return new ResponseEntity<>(invoiceService.getInvoice(studentName), HttpStatus.CREATED);
}

/*
@GetMapping
public List<Coaching> getAllEmployees(){
	
	/*
	 * Application instances = discoveryClient.getApplication("employee-service");
	 * 
	 * String host = instances.getInstances().get(0).getHomePageUrl();
	 * 
	 * System.out.println(host);
	 */
	/*
	final String uri = "http://COACHING-SERVICE/Coaching";
 
    
	ResponseEntity<List<Coaching>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Coaching>>(){});

	return response.getBody();
}


*/

}

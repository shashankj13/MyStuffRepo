package com.yash.pc.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yash.pc.domain.Customer;

@Path("/RestClass")
public class RestClass {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/ProduceMethod")
	public Customer produceCustomer(){
		Customer customer = new Customer();
		customer.setName("Shashank");
		customer.setCity("INDORE");
		customer.setContact(5212);
		return customer;
	}
	
	@POST
	@Path("/ConsumerMethod")
	@Consumes(MediaType.APPLICATION_JSON)
	public String consumeCustomer(Customer customer){
		System.out.println(customer.toString());
		return "SUCCESS";
	}

}

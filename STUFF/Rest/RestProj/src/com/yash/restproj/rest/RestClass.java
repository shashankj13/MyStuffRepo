package com.yash.restproj.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/RestClass")
public class RestClass {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod(){
		return "HELLO THIS IS REST CALLING";
	}

}

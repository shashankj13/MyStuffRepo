package com.yash.restproj1.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rc")
public class RestClass {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/rm")
	public String restMethod()
	{
		return "HELLO WORLD";
	}

}

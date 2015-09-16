package com.song.api;

import com.song.model.User;
import com.song.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("/ping")
@Component
public class TestApi {
	
	@Autowired
	private IUserService userService;
	
	@GET
	@Path("/")
	public Response pong() {
		return Response.status(200).entity("Pong").build();
	}
	
	@GET
	@Path("/service")
	public Response testSpring() {
		User u = new User("test0@test.com","azerty");
		if(userService.createUser(u))
		  return Response.status(200).entity("True").build();
		else
	      return Response.status(200).entity("False").build();
	
	}
}

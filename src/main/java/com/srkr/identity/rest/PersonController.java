package com.srkr.identity.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srkr.identity.domain.model.Person;
import com.srkr.identity.usecases.CreatePerson;

@Path("/person")
public class PersonController {

	private final Logger log = LogManager.getLogger(PersonController.class);

	@Autowired
	private CreatePerson createPerson;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createResponse(@RequestBody String jsonBody) {
		log.info("Person json : " + jsonBody);
		try {
			createPerson.createPerson(new ObjectMapper().readValue(jsonBody, Person.class));
		} catch (IOException e) {
			Response response = Response.status(Response.Status.FORBIDDEN.getStatusCode()).build();
		}
		Response response = Response.status(Response.Status.CREATED.getStatusCode()).build();
		log.info("Response:" + response);
		return response;

	}

}

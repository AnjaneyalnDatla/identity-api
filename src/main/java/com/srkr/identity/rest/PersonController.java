package com.srkr.identity.rest;

import java.io.IOException;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
import com.srkr.identity.usecases.FindPerson;

import static com.srkr.identity.util.ObjectSerializer.toJsonString;

@Path("/person")
public class PersonController {

	private final Logger log = LogManager.getLogger(PersonController.class);

	@Autowired
	private CreatePerson createPerson;
	
	@Autowired
	private FindPerson findPerson;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createPerson(@RequestBody String jsonBody) {
		log.info("Person json : " + jsonBody);
		try {
			createPerson.createPerson(new ObjectMapper().readValue(jsonBody, Person.class));
		} catch (IOException e) {
			return Response.status(Response.Status.FORBIDDEN.getStatusCode()).build();
		}
		Response response = Response.status(Response.Status.CREATED.getStatusCode()).build();
		log.info("Response:" + response);
		return response;

	}
	
	@GET
	@Path("/{firstName}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAllPersonsByFirstName(@PathParam("firstName") String firstName) {
		log.info("first name : " + firstName);
		List<Person> listOfPersons = null;
		try {
			listOfPersons = findPerson.findAllPersonByFirstName(firstName);
			return Response.status(Response.Status.OK.getStatusCode()).entity(toJsonString(listOfPersons)).build();
		} catch (IOException e) {
			return Response.status(Response.Status.FORBIDDEN.getStatusCode()).build();
		}
	}

	@GET
	@Path("/{lastName}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAllPersonsByLastName(@PathParam("firstName") String lastName) {
		log.info("last name : " + lastName);
		List<Person> listOfPersons = null;
		try {
			listOfPersons = findPerson.findAllPersonByLastName(lastName);
			return Response.status(Response.Status.OK.getStatusCode()).entity(toJsonString(listOfPersons)).build();
		} catch (IOException e) {
			return Response.status(Response.Status.FORBIDDEN.getStatusCode()).build();
		}
	}


}

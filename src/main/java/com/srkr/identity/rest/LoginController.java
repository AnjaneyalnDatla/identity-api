package com.srkr.identity.rest;

import static com.srkr.identity.util.ObjectSerializer.toJsonString;

import java.io.IOException;

import javax.naming.NameNotFoundException;
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
import com.srkr.identity.domain.model.Credentials;
import com.srkr.identity.usecases.FindPerson;

@Path("/validate")
public class LoginController {

	private final Logger log = LogManager.getLogger(LoginController.class);

	@Autowired
	private FindPerson findPerson;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response validateLogin(@RequestBody String jsonBody) {
		log.info("json body:"+ jsonBody);
		Credentials credentials;
		try {
			credentials = findPerson.findPersonByCredentials(new ObjectMapper().readValue(jsonBody, Credentials.class));
			return Response.status(Response.Status.OK.getStatusCode()).entity(toJsonString(credentials)).build();
		} catch (IOException e) {
			return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
		} catch (NameNotFoundException e) {
			return Response.status(Response.Status.UNAUTHORIZED.getStatusCode()).build();
		}
	}
}

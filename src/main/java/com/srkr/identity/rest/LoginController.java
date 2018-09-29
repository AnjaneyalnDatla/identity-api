package com.srkr.identity.rest;

import static com.srkr.identity.util.ObjectSerializer.toJsonString;

import java.io.IOException;

import javax.naming.NameNotFoundException;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.srkr.identity.domain.model.Credentials;
import com.srkr.identity.usecases.FindPerson;

@Path("/validate")
public class LoginController {
	
	private final Logger log = LogManager.getLogger(PersonController.class);
	
	@Autowired
	private FindPerson findPerson;
	
	@GET
	@Path("/{username}/{password}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAllPersonsByFirstName(@PathParam("username") String username,@PathParam("password") String password) {
		log.info("user name : " + username);
		Credentials credentials = null;
		try {
			credentials = findPerson.findPersonByCredentials(new Credentials(username, password, null));
			return Response.status(Response.Status.OK.getStatusCode()).entity(toJsonString(credentials)).build();
		} catch (IOException e) {
			return Response.status(Response.Status.FORBIDDEN.getStatusCode()).build();
		} catch (NameNotFoundException e) {
			return Response.status(Response.Status.UNAUTHORIZED.getStatusCode()).build();
		}
	}

}

package io.swagger.api.impl;

import io.db.AddCustomer;
import io.swagger.api.*;

import io.swagger.model.Customer;

import io.swagger.api.NotFoundException;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.StdErrLog;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T13:02:24.894Z")
public class AddCustomerApiServiceImpl extends AddCustomerApiService {
	@Override
	public Response createCustomer(String body, SecurityContext securityContext) throws NotFoundException {
		// do some magic!
		StdErrLog logger = new StdErrLog();
		logger.setDebugEnabled(true);
		Log.setLog(logger);
		
		logger.info("******************"+body.length(), new Object[]{} );
		if (body != null && body.length() > 0) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPATestDefault");

			JSONParser parser = new JSONParser();
			JSONObject json;
			try {
				json = (JSONObject) parser.parse(body);
				AddCustomer.createDatabase(entityManagerFactory, (String) json.get("firstname"),
						(String) json.get("lastname"), (String) json.get("address"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ApiResponseMessage responseMessage = new ApiResponseMessage(ApiResponseMessage.OK, "Created!");
			responseMessage.setCode(201);
					
			return Response.status(201).entity(responseMessage).build();
		} else {
			ApiResponseMessage responseMessage = new ApiResponseMessage(ApiResponseMessage.ERROR, "Somthing wrong with Customer Data!");
			responseMessage.setCode(415);
					
			return Response.status(415).entity(responseMessage).build();
		}

	}
}

package io.swagger.api.impl;

import io.db.AddCustomer;
import io.db.DBCustomer;
import io.db.ManageCustomer;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Customer;

import java.util.List;
import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T13:02:24.894Z")
public class CustomerApiServiceImpl extends CustomerApiService {
    @Override
    public Response deleteCustomer(String custId, SecurityContext securityContext) throws NotFoundException {
        // this is to delete customer
    	// Configure Jinq for the given JPA database connection
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPATestDefault");
    	ManageCustomer.manageDatabase(entityManagerFactory, new Integer(custId), null, null, null, 0);    	
		
		ApiResponseMessage responseMessage = new ApiResponseMessage(ApiResponseMessage.OK, "Deleted customer ID: "+custId);
		responseMessage.setCode(204);
		return Response.ok().entity(responseMessage).build();
    }
    @Override
    public Response getCustomer(String custId, SecurityContext securityContext) throws NotFoundException {
        // this is to get customer details
    	// Configure Jinq for the given JPA database connection
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPATestDefault");
    	
    	DBCustomer customer = ManageCustomer.getDatabase(entityManagerFactory, (new Integer(custId)).intValue());
    	
    	JSONObject obj = new JSONObject();
        obj.put("customerid", Integer.toString(customer.getCustomerid()));
        obj.put("firstname", customer.getFirstname());
        obj.put("lastname", customer.getLastname());
        obj.put("address", customer.getAddress());
    	
    	ApiResponseMessage responseMessage = new ApiResponseMessage(ApiResponseMessage.OK, obj.toJSONString());
		responseMessage.setCode(200);
	
		return Response.ok().entity(responseMessage).build();
    }
    @Override
    public Response updateCustomer(String custId, String body, SecurityContext securityContext) throws NotFoundException {
        // this is to update customer details
    	// Configure Jinq for the given JPA database connection
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPATestDefault");
    	JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(body);
			ManageCustomer.manageDatabase(entityManagerFactory, new Integer(custId), (String) json.get("firstname"), 
					(String) json.get("lastname"), (String) json.get("address"), 1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
    	
    	ApiResponseMessage responseMessage = new ApiResponseMessage(ApiResponseMessage.OK, "Updated customer ID: "+custId);
		responseMessage.setCode(200);
		return Response.ok().entity(responseMessage).build();
    }
}

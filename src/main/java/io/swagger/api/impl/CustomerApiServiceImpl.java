package io.swagger.api.impl;

import io.db.DBCustomer;
import io.db.ManageCustomer;
import io.swagger.api.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T13:02:24.894Z")
public class CustomerApiServiceImpl extends CustomerApiService {
    @Override
    public Response deleteCustomer(String custId, SecurityContext securityContext) throws NotFoundException {
        // this is to delete customer
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPATestDefault");
    	boolean isDeleted = ManageCustomer.manageDatabase(entityManagerFactory, new Integer(custId), null, null, null, 0);    	
		
    	if (isDeleted) {
			ApiResponseMessage responseMessage = new ApiResponseMessage(ApiResponseMessage.OK, "Deleted customer ID: "+custId);
			responseMessage.setCode(204);
			return Response.status(204).entity(responseMessage).build();
    	} else {
			ApiResponseMessage responseMessage = new ApiResponseMessage(ApiResponseMessage.ERROR, "No customer ID: "+custId+" FOUND to delete!");
			responseMessage.setCode(404);
			return Response.status(404).entity(responseMessage).build();
    	}
    }
    
    @Override
    public Response getCustomer(String custId, SecurityContext securityContext) throws NotFoundException {
        // this is to get customer details
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPATestDefault");
    	
    	DBCustomer customer = ManageCustomer.getDatabase(entityManagerFactory, (new Integer(custId)).intValue());
    	JSONObject obj = new JSONObject();
    	ApiResponseMessage responseMessage = null;
        
    	if (customer != null) {
	    	obj.put("customerid", Integer.toString(customer.getCustomerid()));
	        obj.put("firstname", customer.getFirstname());
	        obj.put("lastname", customer.getLastname());
	        obj.put("address", customer.getAddress());
	        responseMessage = new ApiResponseMessage(ApiResponseMessage.OK, obj.toJSONString());
	        responseMessage.setCode(200);
	        return Response.ok().entity(responseMessage).build();
    	} else {
    		responseMessage = new ApiResponseMessage(ApiResponseMessage.INFO, "Customer ID: "+custId+" Not FOUND!");
	        responseMessage.setCode(404);
    		return Response.status(404).entity(responseMessage).build();
    	}
    	
    }
    
    @Override
    public Response updateCustomer(String custId, String body, SecurityContext securityContext) throws NotFoundException {
        // this is to update customer details
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPATestDefault");
    	
    	if (body != null && body.length() > 0) {
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
    	} else {
    		ApiResponseMessage responseMessage = new ApiResponseMessage(ApiResponseMessage.ERROR, "Somthing wrong with Customer Data!");
			responseMessage.setCode(415);
					
			return Response.status(415).entity(responseMessage).build();
    	}
    }
}

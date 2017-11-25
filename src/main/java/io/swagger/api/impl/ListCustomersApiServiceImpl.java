package io.swagger.api.impl;

import io.db.DBCustomer;
import io.swagger.api.*;
import io.swagger.model.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T13:02:24.894Z")
public class ListCustomersApiServiceImpl extends ListCustomersApiService {
	
    @Override
    public Response listAllCustomers(SecurityContext securityContext) throws NotFoundException {
        // Configure Jinq for the given JPA database connection
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPATestDefault");
    	EntityManager em = entityManagerFactory.createEntityManager();
    	
    	String customers_json = "{ \"Customers\":\n[ ";
    	TypedQuery<DBCustomer> query =
    		      em.createNamedQuery("Customer.findAll", DBCustomer.class);
    	List<DBCustomer> customers = query.getResultList();
    	JSONObject finalobj = new JSONObject();
    	JSONArray list = new JSONArray();
        for (int ix = 0; ix < customers.size()-1; ix++) {
        	JSONObject obj = new JSONObject();
        	obj.put("customerid", Integer.toString(customers.get(ix).getCustomerid()));
            obj.put("firstname", customers.get(ix).getFirstname());
            obj.put("lastname", customers.get(ix).getLastname());
            obj.put("address", customers.get(ix).getAddress());         
            
            list.add(obj);
    	}
        finalobj.put("Customers",list); 
        ApiResponseMessage responseMessage = new ApiResponseMessage(ApiResponseMessage.OK, finalobj.toJSONString().replace("\\\\",""));
		responseMessage.setCode(200);
	
		return Response.ok().entity(responseMessage).build();
     
    }
}

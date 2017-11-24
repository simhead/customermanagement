package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.ListCustomersApiService;
import io.swagger.api.factories.ListCustomersApiServiceFactory;

import io.swagger.annotations.ApiParam;

import io.swagger.model.Customer;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/listCustomers")


@io.swagger.annotations.Api(description = "the listCustomers API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T13:02:24.894Z")
public class ListCustomersApi  {
   private final ListCustomersApiService delegate = ListCustomersApiServiceFactory.getListCustomersApi();

    @GET
    
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List all customers", notes = "", response = Customer.class, tags={ "Customer", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Customer.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = Customer.class) })
    public Response listAllCustomers(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.listAllCustomers(securityContext);
    }
}

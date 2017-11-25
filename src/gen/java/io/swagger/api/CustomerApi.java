package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.CustomerApiService;
import io.swagger.annotations.ApiParam;

import io.swagger.model.Customer;

import java.util.List;
import io.swagger.api.NotFoundException;
import io.swagger.api.factories.CustomerApiServiceFactory;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/customer")


@io.swagger.annotations.Api(description = "the customer API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T13:02:24.894Z")
public class CustomerApi  {
   private final CustomerApiService delegate = CustomerApiServiceFactory.getCustomerApi();

    @DELETE 
    @Path("/{custId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Delete customer by customer ID", notes = "This can only be done by the logged in user.", response = void.class, tags={ "Customer", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Successfully deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid customer ID supplied", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Customer not found", response = void.class) })
    public Response deleteCustomer(@ApiParam(value = "Customer id is required to perform the task",required=true) @PathParam("custId") String custId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteCustomer(custId,securityContext);
    }
    @GET
    @Path("/{custId}")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get customer by customer ID", notes = "", response = Customer.class, tags={ "Customer", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Customer.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid customer ID supplied", response = Customer.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Customer not found", response = Customer.class) })
    public Response getCustomer(@ApiParam(value = "Customer id is required to perform the task",required=true) @PathParam("custId") String custId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getCustomer(custId,securityContext);
    }
    @PUT
    @Path("/{custId}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Update customer by customer ID", notes = "This can only be done by the logged in user.", response = void.class, tags={ "Customer", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Updated successfully", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid customer ID supplied", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Customer not found", response = void.class) })
    public Response updateCustomer(@ApiParam(value = "Customer id is required to perform the task",required=true) @PathParam("custId") String custId
,@ApiParam(value = "" ) String body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateCustomer(custId,body,securityContext);
    }
}

package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.AddCustomerApiService;
import io.swagger.api.factories.AddCustomerApiServiceFactory;

import io.swagger.annotations.ApiParam;


import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/addCustomer")


@io.swagger.annotations.Api(description = "the addCustomer API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T14:51:39.604Z")
public class AddCustomerApi  {
   private final AddCustomerApiService delegate = AddCustomerApiServiceFactory.getAddCustomerApi();

    @POST
    
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Create customer", notes = "Create new customer", response = void.class, tags={ "Customer", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created successfully", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = void.class) })
    public Response createCustomer(@ApiParam(value = "" ) String body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createCustomer(body,securityContext);
    }
}

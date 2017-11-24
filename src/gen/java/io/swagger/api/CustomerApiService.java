package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Customer;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T13:02:24.894Z")
public abstract class CustomerApiService {
    public abstract Response deleteCustomer(String custId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getCustomer(String custId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCustomer(String custId,Customer body,SecurityContext securityContext) throws NotFoundException;
}

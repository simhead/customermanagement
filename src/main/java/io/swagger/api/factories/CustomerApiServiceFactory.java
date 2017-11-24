package io.swagger.api.factories;

import io.swagger.api.CustomerApiService;
import io.swagger.api.impl.CustomerApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T13:02:24.894Z")
public class CustomerApiServiceFactory {
    private final static CustomerApiService service = new CustomerApiServiceImpl();

    public static CustomerApiService getCustomerApi() {
        return service;
    }
}

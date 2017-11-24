package io.swagger.api.factories;

import io.swagger.api.AddCustomerApiService;
import io.swagger.api.impl.AddCustomerApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T13:02:24.894Z")
public class AddCustomerApiServiceFactory {
    private final static AddCustomerApiService service = new AddCustomerApiServiceImpl();

    public static AddCustomerApiService getAddCustomerApi() {
        return service;
    }
}

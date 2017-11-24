package io.swagger.api.factories;

import io.swagger.api.ListCustomersApiService;
import io.swagger.api.impl.ListCustomersApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T13:02:24.894Z")
public class ListCustomersApiServiceFactory {
    private final static ListCustomersApiService service = new ListCustomersApiServiceImpl();

    public static ListCustomersApiService getListCustomersApi() {
        return service;
    }
}

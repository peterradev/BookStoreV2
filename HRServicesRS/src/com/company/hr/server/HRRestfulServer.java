package com.company.hr.server;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

 

public class HRRestfulServer {
	public static void main(String args[]) throws Exception {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(com.company.hr.service.EmployeeResource.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new com.company.hr.service.EmployeeResource()));
        factoryBean.setAddress("http://localhost:8081/");
        Server server = factoryBean.create();

        System.out.println("HR Employee System Restful Server ready...............................");      

    }
}

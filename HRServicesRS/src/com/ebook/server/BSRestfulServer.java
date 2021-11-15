package com.ebook.server;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;


public class BSRestfulServer{
	
	public static void main(String[] args) throws Exception{
		JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
		factoryBean.setResourceClasses(com.ebook.service.ProductResource.class);
		factoryBean.setResourceClasses(com.ebook.service.PartnerResource.class);
		factoryBean.setResourceProvider(new SingletonResourceProvider(new com.ebook.service.ProductResource()));
		factoryBean.setAddress("http://localhost:8081/");
		Server server = factoryBean.create();
		
		System.out.println("BS Product system Restful Server Ready .......");
		
		
	}
	
}
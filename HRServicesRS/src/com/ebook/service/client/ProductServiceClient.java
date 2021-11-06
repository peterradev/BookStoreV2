package com.ebook.service.client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.ebook.service.representation.ProductRequest;

public class ProductServiceClient {

  private ProductServiceClient(){}

  public static void main(String args[]) throws Exception{
    List<Object> providers = new ArrayList<Object>();
    JacksonJsonProvider provider = new JacksonJsonProvider();
    provider.addUntouchable(Response.class);
    providers.add(provider);

    System.out.println("GET METHOD ............................");
    WebClient getClient = WebClient.create("http://localhost:8081/", providers);


    WebClient.getConfig(getClient).getOutInterceptors().add(new LoggingOutInterceptor());
    WebClient.getConfig(getClient).getInInterceptors().add(new LoggingInInterceptor());

    getClient = getClient.accept("application/json").type("application/json").path("/productservice/product/XY1111");

    String getRequestURI = getClient.getCurrentURI().toString();
    System.out.println("Client GET METHOD Request URI: "+ getRequestURI);

    String getRequestHeaders = getClient.getHeaders().toString();
    System.out.println("Client GET METHOD Request Headers: " + getRequestHeaders);

//    String response = getClient.get(String.class);
//    System.out.println("GET METHOD Response: ....." + response);


    // Get method for all products
//    System.out.println("POST METHOD .........................................................");
//    WebClient postClient = WebClient.create("http://localhost:8081", providers);
//    WebClient.getConfig(postClient).getOutInterceptors().add(new LoggingOutInterceptor());
//    WebClient.getConfig(postClient).getInInterceptors().add(new LoggingInInterceptor());

    // change application/xml  to application/json get in json format
//    postClient = postClient.accept("application/xml").type("application/xml").path("/productservice/product");
//
//    String postRequestURI = postClient.getCurrentURI().toString();
//    System.out.println("Client POST METHOD Request URI:  " + postRequestURI);
//    String postRequestHeaders = postClient.getHeaders().toString();
//    System.out.println("Client POST METHOD Request Headers:  " + postRequestHeaders);
//    ProductRequest productRequest = new ProductRequest();
//    productRequest.setPrice(20.20);
//    productRequest.setTitle("Title of Book");
//
//    String responsePost =  postClient.post(productRequest, String.class);
//    System.out.println("POST MEDTHOD Response ........." + responsePost);

    /*****************************************************************************************
    * GET METHOD invoke for all employees
    *****************************************************************************************/
    System.out.println("GET METHOD for all employees..........................................");
    WebClient getAllClient = WebClient.create("http://localhost:8081", providers);
    WebClient.getConfig(getAllClient).getOutInterceptors().add(new LoggingOutInterceptor());
    WebClient.getConfig(getAllClient).getInInterceptors().add(new LoggingInInterceptor());

    // change application/xml  to get in xml format
    getAllClient = getAllClient.accept("application/json").type("application/json").path("/productservice/product");

    String getAllRequestURI = getAllClient.getCurrentURI().toString();
    System.out.println("Client GET METHOD Request URI:  " + getAllRequestURI);
    String getAllRequestHeaders = getAllClient.getHeaders().toString();
    System.out.println("Client GET METHOD Request Headers:  " + getAllRequestHeaders);

    //to see as raw XML/json
    String getAllResponse = getAllClient.get(String.class);
    System.out.println("GET All METHOD Response: ...." + getAllResponse);

    /*****************************************************************************************
    * DELETE METHOD invoke
    *****************************************************************************************/
    System.out.println("DELETE METHOD .........................................................");
    WebClient deleteClient = WebClient.create("http://localhost:8081", providers);
    WebClient.getConfig(deleteClient).getOutInterceptors().add(new LoggingOutInterceptor());
    WebClient.getConfig(deleteClient).getInInterceptors().add(new LoggingInInterceptor());

    // change application/xml  to application/json get in json format
    deleteClient = deleteClient.accept("application/xml").type("application/xml").path("/productservice/product/XY1111");

    String deleteRequestURI = deleteClient.getCurrentURI().toString();
    System.out.println("Client DELETE METHOD Request URI:  " + deleteRequestURI);
    String deleteRequestHeaders = deleteClient.getHeaders().toString();
    System.out.println("Client DELETE METHOD Request Headers:  " + deleteRequestHeaders);

    deleteClient.delete();
    System.out.println("DELETE MEDTHOD Response ......... OK");

    System.exit(0);
  }


}

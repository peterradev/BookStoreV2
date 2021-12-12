package com.ebook.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import com.ebook.service.representation.BookRepresentation;
import com.ebook.service.representation.BookRequest;
import com.ebook.service.workflow.BookActivity;


@CrossOriginResourceSharing(allowAllOrigins = true)


@Path("/books")
public class BookResource implements BookService {

  @GET
  @Produces({MediaType.APPLICATION_JSON})
  @Path("/{id}")
  public BookRepresentation getBook(@PathParam("id") String id){
    BookActivity bookActivity = new BookActivity();
    return bookActivity.getBook(id);
  }

  @POST
  @Produces({MediaType.APPLICATION_JSON})
  @Path("/book")
  public BookRepresentation createBook(BookRequest bookRequest){
    BookActivity bookActivity = new BookActivity();
    return bookActivity.createBook(bookRequest.getTitle(), bookRequest.getIsbn(), bookRequest.getAuthor(), bookRequest.getPrice());
  }

  @DELETE
  @Produces({MediaType.APPLICATION_JSON})
  @Path("/{id}")
  public Response deleteBook(@PathParam("id") String id){
    BookActivity bookActivity = new BookActivity();
    String res = bookActivity.deleteBook(id);
    if(res.equals("OK")){
      return Response.status(Status.OK).build();
    }
    return null;
  }

}

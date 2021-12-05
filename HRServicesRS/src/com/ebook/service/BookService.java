package com.ebook.service;

import java.util.Set;

import com.ebook.service.representation.BookRepresentation;
import com.ebook.service.representation.BookRequest;

public interface BookService {

  public Set<BookRepresentation> getBooks();
  public BookRepresentation getBook(String id);
  public BookRepresentation createBook(BookRequest bookRequest);

}

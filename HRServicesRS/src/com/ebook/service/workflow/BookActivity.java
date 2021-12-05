package com.ebook.service.workflow;

import com.ebook.domain.Link;
import com.ebook.model.item.Book;
import com.ebook.service.representation.BookRepresentation;

public class BookActivity {

  private static BookDAO dao = new BookDAO();

  public BookRepresentation getBook(String id, Sring orderId){
      Book book = dao.getBook(id);

      BookRepresentation bookRepresentation = new BookRepresentation();
      bookRepresentation.setId(book.getId());
      bookRepresentation.setPrice(book.getPrice());
      bookRepresentation.setAuthor(book.getAuthor());
      bookRepresentation.setIsbn(book.getISBN());

      setLinks(bookRepresentation);

      return bookRepresentation;
  }


  private void setLinks(BookRepresentation bookRep) {
    Link buy = new Link("buy", "localhost:8081/books/order?book_id=" + bookRep.getId(), "application/json");
    bookRep.setLinks(buy);
  }

}

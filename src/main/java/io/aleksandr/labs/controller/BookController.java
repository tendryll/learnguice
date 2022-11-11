package io.aleksandr.labs.controller;

import io.aleksandr.labs.model.Book;
import io.aleksandr.labs.service.BookService;

import javax.inject.Inject;
import java.util.List;

public class BookController {
  private final BookService bookService;

  @Inject
  public BookController(final BookService bookService) {
    this.bookService = bookService;
  }

  public void create(final Book book) {
    bookService.create(book);
  }

  public void update(final Book book) {
    bookService.update(book);
  }

  public Book get(final long id) {
    return bookService.get(id);
  }

  public List<Book> find(final String tag) {
    return bookService.find(tag);
  }

  public void delete(final long id) {
    bookService.delete(id);
  }
}

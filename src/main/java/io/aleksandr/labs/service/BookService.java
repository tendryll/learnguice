package io.aleksandr.labs.service;

import io.aleksandr.labs.model.Book;

import java.util.List;

public interface BookService {
  long create(final Book book);

  void update(final Book book);

  Book get(final long id);

  List<Book> find(final String tag);

  void delete(final long id);
}

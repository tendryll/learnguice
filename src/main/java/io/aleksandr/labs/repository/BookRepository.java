package io.aleksandr.labs.repository;

import io.aleksandr.labs.model.Book;

import java.util.List;

public interface BookRepository {
  long create(final Book book);

  Book update(final Book book);

  Book get(final long id);

  List<Book> find(final String tag);

  void delete(final long id);
}

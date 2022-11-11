package io.aleksandr.labs.repository;

import io.aleksandr.labs.model.Book;

import java.util.List;

public interface BookRepository {
  void create(final Book book);

  void update(final Book book);

  Book get(final long id);

  List<Book> find(final String tag);

  void delete(final long id);
}

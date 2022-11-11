package io.aleksandr.labs.repository;

import io.aleksandr.labs.model.Book;

import java.util.List;

public interface BookRepository {
  /**
   * Creates a book and adds it the library.
   *
   * @param book The book details to be saved.
   * @return The book's ID.
   */
  long create(final Book book);

  /**
   * Updates the book by ID.
   *
   * @param book The book details to be updated.
   * @return The updated book if the book to be updated is found, otherwise -1 is returned.
   */
  Book update(final Book book);

  /**
   * Retrieves a book.
   *
   * @param id The ID of the book to be found.
   * @return The retrieved book if found, otherwise null.
   */
  Book get(final long id);

  /**
   * Returns a list of books filtered by tag.
   *
   * @param tag The tag to find books by.
   * @return A list of books.
   */
  List<Book> find(final String tag);

  /**
   * The book to delete by ID.
   *
   * @param id The ID of the book to delete.
   */
  void delete(final long id);
}

package io.aleksandr.labs.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.aleksandr.labs.model.Book;
import io.aleksandr.labs.repository.BookRepository;
import io.aleksandr.labs.service.BookService;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Singleton
public class BookServiceImpl implements BookService {
  private final AtomicLong aLong = new AtomicLong();
  private final BookRepository bookRepository;

  @Inject
  public BookServiceImpl(final BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public long create(final Book book) {
    book.setId(aLong.getAndIncrement());
    return bookRepository.create(book);
  }

  @Override
  public void update(final Book book) {
    bookRepository.update(book);
  }

  @Override
  public Book get(final long id) {
    return bookRepository.get(id);
  }

  @Override
  public List<Book> find(final String tag) {
    final List<Book> books =  bookRepository.find(tag);
    return books;
  }

  @Override
  public void delete(final long id) {
    bookRepository.delete(id);
  }
}

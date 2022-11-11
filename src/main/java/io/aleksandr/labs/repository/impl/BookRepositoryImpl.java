package io.aleksandr.labs.repository.impl;

import io.aleksandr.labs.model.Book;
import io.aleksandr.labs.repository.BookRepository;

import javax.inject.Singleton;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Singleton
public class BookRepositoryImpl implements BookRepository {
  private final Set<Book> library = new HashSet<>();

  @Override
  public long create(final Book book) {
    if (book != null) {
      final Book bk = new Book();

      bk.setId(book.getId());
      bk.setTitle(book.getTitle());
      bk.setDescription(book.getDescription());
      bk.setTags(book.getTags());
      bk.setIsbn10(book.getIsbn10());
      bk.setIsbn13(book.getIsbn13());

      library.add(bk);

      return book.getId();
    }

    return -1;
  }

  @Override
  public Book update(final Book book) {
    Book found = null;

    if (book != null) {
      final Optional<Book> opt = library.stream().filter(bk -> bk.getId() == book.getId()).findFirst();

      if (opt.isPresent()) {
        found = opt.get();
        found.setTitle(book.getTitle());
        found.setDescription(book.getDescription());
        found.setTags(book.getTags());
        found.setIsbn10(book.getIsbn10());
        found.setIsbn13(book.getIsbn13());
      }
    }

    return found;
  }

  @Override
  public Book get(final long id) {
    return library.stream().filter(bk -> bk.getId() == id).findFirst().orElseThrow(IllegalArgumentException::new);
  }

  @Override
  public List<Book> find(final String tag) {
    return library.stream().filter(bk -> bk.getTags().contains(tag)).collect(Collectors.toList());
  }

  @Override
  public void delete(final long id) {
    library.removeIf(bk -> bk.getId() != id);
  }
}

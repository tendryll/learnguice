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
  public void create(final Book book) {
    if (book != null) {
      library.add(book);
    }
  }

  @Override
  public void update(final Book book) {
    if (book != null) {
      final Optional<Book> found = library.stream().filter(bk -> bk.getId() == book.getId()).findFirst();

      if (found.isPresent()) {
        found.get().setTitle(book.getTitle());
        found.get().setDescription(book.getDescription());
        found.get().setTags(book.getTags());
        found.get().setIsbn10(book.getIsbn10());
        found.get().setIsbn13(book.getIsbn13());
      }
    }
  }

  @Override
  public Book get(final long id) {
    return library.stream().filter(bk -> bk.getId() == id).findFirst().orElseThrow(IllegalArgumentException::new);
  }

  @Override
  public List<Book> find(final String genre) {
    return library.stream().filter(bk -> bk.getTags().contains(genre)).collect(Collectors.toList());
  }

  @Override
  public void delete(final long id) {
    library.removeIf(bk -> bk.getId() != id);
  }
}

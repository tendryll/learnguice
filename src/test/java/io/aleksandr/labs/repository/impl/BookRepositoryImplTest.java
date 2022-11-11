package io.aleksandr.labs.repository.impl;

import io.aleksandr.labs.model.Book;
import io.aleksandr.labs.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BookRepositoryImplTest {
  private BookRepository bookRepository;

  @Before
  public void init() {
    bookRepository = new BookRepositoryImpl();
  }

  @Test
  public void create() {
    final String title = "The Book of Kubernetes: A Complete Guide to Container Orchestration";
    final String desc = "Containers ensure that software runs reliably no matter where it’s deployed, and Kubernetes "
        + "lets you manage all of your containers from a single control plane. In this comprehensive tour of the "
        + "open-source platform, each chapter includes a set of example scripts with just enough automation to start "
        + "your container exploration with ease.";
    final String isbn10 = "1718502648";
    final String isbn13 = "978-1718502642";

    final Set<String> tags = new HashSet<>(Arrays.asList("kubernetes", "orchestration"));

    final Book book = new Book();
    book.setTitle(title);
    book.setDescription(desc);
    book.setTags(tags);
    book.setIsbn10(isbn10);
    book.setIsbn13(isbn13);

    final long id = bookRepository.create(book);
    final Book found = bookRepository.get(id);

    assertEquals(title, found.getTitle());
    assertEquals(desc, found.getDescription());
    assertEquals(tags, found.getTags());
    assertEquals(isbn10, found.getIsbn10());
    assertEquals(isbn13, found.getIsbn13());
  }

  @Test
  public void update() {
    final String title = "The Book of Kubernetes: A Complete Guide to Container Orchestration";
    final String desc = "Containers ensure that software runs reliably no matter where it’s deployed, and Kubernetes "
        + "lets you manage all of your containers from a single control plane. In this comprehensive tour of the "
        + "open-source platform, each chapter includes a set of example scripts with just enough automation to start "
        + "your container exploration with ease.";
    final String isbn10 = "1718502648";
    final String isbn13 = "978-1718502642";

    final Set<String> tags = new HashSet<>(Arrays.asList("kubernetes", "orchestration"));

    final Book book = new Book();
    book.setTitle(title);
    book.setDescription(desc);
    book.setTags(tags);
    book.setIsbn10(isbn10);
    book.setIsbn13(isbn13);

    final long id = bookRepository.create(book);
    final Book book2 = bookRepository.get(id);

    book2.setTitle("title");
    book2.setDescription("description");
    book2.setTags(new HashSet<>(Arrays.asList("tags1", "tags2")));
    book2.setIsbn10("isbn10");
    book2.setIsbn13("isbn13");

    final Book updated = bookRepository.update(book2);

    assertEquals("title", updated.getTitle());
    assertEquals("description", updated.getDescription());
    assertEquals(new HashSet<>(Arrays.asList("tags1", "tags2")), updated.getTags());
    assertEquals("isbn10", updated.getIsbn10());
    assertEquals("isbn13", updated.getIsbn13());
  }
}

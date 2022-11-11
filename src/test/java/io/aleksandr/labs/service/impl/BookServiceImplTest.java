package io.aleksandr.labs.service.impl;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.aleksandr.labs.config.AppModule;
import io.aleksandr.labs.controller.BookController;
import io.aleksandr.labs.model.Book;
import io.aleksandr.labs.service.BookService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class BookServiceImplTest {
  private Injector injector;

  @Before
  public void init() {
    injector = Guice.createInjector(new AppModule());
  }

  @Test
  public void find() {
    final Set<String> tags1 = new HashSet<>(Arrays.asList("kubernetes", "orchestration"));
    final Set<String> tags2 = new HashSet<>(Arrays.asList("radical", "candor"));
    final Set<String> tags3 = new HashSet<>(Arrays.asList("reliability", "security", "orchestration"));

    final Book book1 = new Book();
    book1.setTitle("The Book of Kubernetes: A Complete Guide to Container Orchestration");
    book1.setDescription("Containers ensure that software runs reliably no matter where it’s deployed, and Kubernetes "
        + "lets you manage all of your containers from a single control plane. In this comprehensive tour of the "
        + "open-source platform, each chapter includes a set of example scripts with just enough automation to start "
        + "your container exploration with ease.");
    book1.setTags(tags1);
    book1.setIsbn10("1718502648");
    book1.setIsbn13("978-1718502642");

    final Book book2 = new Book();
    book2.setTitle("Radical Candor: Fully Revised & Updated Edition: Be a Kick-Ass Boss Without Losing Your Humanity");
    book2.setDescription(
        "Radical Candor has been embraced around the world by leaders of every stripe at companies of all sizes. "
            + "Now a cultural touchstone, the concept has come to be applied to a wide range of human relationships.");
    book2.setTags(tags2);
    book2.setIsbn10("1529038340");
    book2.setIsbn13("978-1529038347");

    final Book book3 = new Book();
    book3.setTitle("The DevOps Handbook: How to Create World-Class Agility, Reliability, & Security in "
        + "Technology Organizations");
    book3.setDescription("For years, The DevOps Handbook has been the definitive guide for taking the successes laid "
        + "out in the bestselling The Phoenix Project and applying them in any organization. Now, with this fully "
        + "updated and expanded edition, it's time to take DevOps out of the IT department and apply it across the "
        + "full business.");
    book3.setTags(tags3);
    book3.setIsbn10("1950508404");
    book3.setIsbn13("978-1950508402");

    final BookService service = injector.getInstance(BookService.class);
    service.create(book1);
    service.create(book2);
    service.create(book3);

    final List<Book> books = service.find("orchestration");
    assertEquals(2, books.size());
  }
}
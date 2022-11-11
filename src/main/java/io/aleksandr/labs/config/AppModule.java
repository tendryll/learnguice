package io.aleksandr.labs.config;

import com.google.inject.AbstractModule;
import io.aleksandr.labs.repository.BookRepository;
import io.aleksandr.labs.repository.impl.BookRepositoryImpl;
import io.aleksandr.labs.service.BookService;
import io.aleksandr.labs.service.impl.BookServiceImpl;

public class AppModule extends AbstractModule {

  @Override
  public void configure() {
    bind(BookRepository.class).to(BookRepositoryImpl.class);
    bind(BookService.class).to(BookServiceImpl.class);
  }
}

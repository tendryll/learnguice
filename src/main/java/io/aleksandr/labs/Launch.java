package io.aleksandr.labs;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.aleksandr.labs.config.AppModule;

public class Launch {
  public static void main(String[] args) {
    final Injector injector = Guice.createInjector(new AppModule());
  }


}
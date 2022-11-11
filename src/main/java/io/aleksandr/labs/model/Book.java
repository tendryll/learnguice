package io.aleksandr.labs.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Set;

public class Book {
  public static final int INITIAL_ODD_NUMBER = 17;
  public static final int MULTIPLIER_ODD_NUMBER = 37;
  private long id;
  private String title;
  private String description;
  private Set<String> tags;
  private String isbn10;
  private String isbn13;

  public long getId() {
    return id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public Set<String> getTags() {
    return tags;
  }

  public void setTags(final Set<String> tags) {
    this.tags = tags;
  }

  public String getIsbn10() {
    return isbn10;
  }

  public void setIsbn10(final String isbn10) {
    this.isbn10 = isbn10;
  }

  public String getIsbn13() {
    return isbn13;
  }

  public void setIsbn13(final String isbn13) {
    this.isbn13 = isbn13;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Book book = (Book) o;

    return new EqualsBuilder().append(getId(), book.getId())
        .append(getTitle(), book.getTitle()).append(getDescription(), book.getDescription())
        .append(getTags(), book.getTags()).append(getIsbn10(), book.getIsbn10()).append(getIsbn13(), book.getIsbn13())
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(INITIAL_ODD_NUMBER, MULTIPLIER_ODD_NUMBER).append(getId()).append(getTitle())
        .append(getDescription()).append(getTags()).append(getIsbn10()).append(getIsbn13()).toHashCode();
  }
}

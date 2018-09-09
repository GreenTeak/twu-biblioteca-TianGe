package com.twu.biblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Book {
    public Book(Integer id, String name, String author, String publishDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:mm a, EEE M/d/uuuu", Locale.US);
        LocalDateTime ldt = LocalDateTime.parse(publishDate, f);
        ZoneId z = ZoneId.of( "America/Toronto" ) ;
        ZonedDateTime zdt = ldt.atZone(z) ;
        this.publishDate = zdt.toInstant();
        this.isBook=false;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Instant getPublishDate() {
        return publishDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishDate(Instant publishDate) {
        this.publishDate = publishDate;
    }

    public String book_info() {
        return String.format("%s-%s-%s-%s\n", this.id, this.name, this.author, this.publishDate);
    }

    public boolean isBook() {
        return isBook;
    }
    public void setBook(boolean book) {
        isBook = book;
    }
    private Integer id;
    private String name;

    private String author;

    private Instant publishDate;

    private boolean isBook;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return isBook() == book.isBook() &&
                Objects.equals(getId(), book.getId()) &&
                Objects.equals(getName(), book.getName()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getPublishDate(), book.getPublishDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAuthor(), getPublishDate(), isBook());
    }
}

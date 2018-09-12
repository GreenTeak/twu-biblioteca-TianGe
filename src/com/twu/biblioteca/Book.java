package com.twu.biblioteca;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
        this.isBorrowed = false;
    }

    public Integer getId() {
        return id;
    }


    public String book_info() {
        return String.format("%s-%s-%s-%s\n", this.id, this.name, this.author, this.publishDate);
    }

    private Integer id;
    private String name;

    private String author;

    private Instant publishDate;
    public boolean isBorrowed;

}

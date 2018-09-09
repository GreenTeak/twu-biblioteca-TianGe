package com.twu.biblioteca;

import org.junit.Test;

import java.text.ParseException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void should_be_return_book_info() throws ParseException {
        Book book=new Book(1,"Lolita","Kofe","04:30 PM, Sat 5/12/2018");
        assertThat(book.book_info(),is("1-Lolita-Kofe-2018-05-12T20:30:00Z\n"));
    }

}
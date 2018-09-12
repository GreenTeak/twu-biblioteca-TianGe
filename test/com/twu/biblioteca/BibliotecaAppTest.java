package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void should_be_return_book_info(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        assertThat(bibliotecaApp.getBookList().size(),is(5));
    }
    @Test
    public void should_be_return_movies_list(){
        BibliotecaApp bibliotecaApp=new BibliotecaApp();
        assertThat(bibliotecaApp.getMovieList().size(),is(5));
    }


}
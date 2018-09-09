package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BibliotecaAppTest {
    @Test
    public void should_be_return_weclome_to_info(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        assertThat(bibliotecaApp.weclome_info(),is("Weclome to Biblioteca!"));
    }

}
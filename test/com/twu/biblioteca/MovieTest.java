package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void should_be_return_movie_info() {
        Movie movie=new Movie(1,"The Shawshank Redemption","1994","Frank Darabont",8);
        assertThat(movie.getId(),is(1));
    }
}
package com.twu.biblioteca;

public class Movie {
    public Movie(Integer id, String name, String year, String director, Integer rate) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }


    public String movie_info() {
        return String.format("%s-%s-%s-%s-%d\n", this.id, this.name, this.year, this.director,this.rate);
    }

    private Integer id;
    private String name;
    private String year;
    private String director;
    private Integer rate;
}

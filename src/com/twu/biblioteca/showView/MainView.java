package com.twu.biblioteca.showView;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.input.InputSource;
import com.twu.biblioteca.input.ScannerInputSource;

import java.util.List;
import java.util.Scanner;

public interface MainView {
    void printMainView(String appName);
    List<String> getLoginInfo(InputSource inputSource);
    void showMovieListInfo(List<Movie> movieList);
    void showBookListInfo(List<Book> bookList);
    void showPromptMessage(String output);
}

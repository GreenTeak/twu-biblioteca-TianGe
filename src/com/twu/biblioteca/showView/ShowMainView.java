package com.twu.biblioteca.showView;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.input.InputSource;

import java.util.ArrayList;
import java.util.List;

public class ShowMainView implements MainView {

    @Override
    public void printMainView(String appName) {
        System.out.println("--------------" + appName + "------------");
        System.out.println("1.查看书籍列表");
        System.out.println("2.借书");
        System.out.println("3.还书");
        System.out.println("4.电影列表");
        System.out.println("5.观看电影");
        System.out.println("6.显示用户信息");
    }

    @Override
    public List<String> getLoginInfo(InputSource inputSource) {
        List<String> userAccout = new ArrayList<>();
        System.out.println("请输入用户名");
        userAccout.add(inputSource.getInput());
        System.out.println("请输入密码");
        userAccout.add(inputSource.getInput());
        return userAccout;
    }


    @Override
    public void showMovieListInfo(List<Movie> movieList) {
        movieList.stream().forEach(movie -> System.out.println(movie.movie_info()));
    }

    @Override
    public void showBookListInfo(List<Book> bookList) {
        bookList.stream().filter(book -> !book.isBorrowed).forEach(book -> System.out.println(book.book_info()));
    }

    @Override
    public void showPromptMessage(String output) {
        System.out.println(output);
    }
}

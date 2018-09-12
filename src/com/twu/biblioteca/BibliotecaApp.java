package com.twu.biblioteca;

import com.twu.biblioteca.input.InputSource;
import com.twu.biblioteca.input.ScannerInputSource;
import com.twu.biblioteca.showView.ShowMainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BibliotecaApp {

    public static final String INPUT_BOOK_ID = "请输入书id";
    public static final String BOOK_STATUS_INVAILD = "那本书不可用";
    public static final String THANKS_BORROW_BOOK = "谢谢你!";
    public static final String THANKS_RETURN_BOOK = "感谢您退回图书!";
    public static final String BOOK_RETURN_INVALID = "这不是一本可以归还的图书";
    public static final String INPUT_MOVIE_ID = "请输入书电影id";
    public static final String UNVAILD_CHOOSE = "Select a valid option!";
    public static final String WECLOME_APP = "welcome to Biblioteca!";
    public static final String APP_NAME = "Biblioteca";
    public static final String LOGIN_SUCCESS = "login success!";

    private List<Book> bookList = new ArrayList<>();
    private List<Movie> movieList = new ArrayList<>();
    private ShowMainView mainView = new ShowMainView();
    private InputSource inputSource = new ScannerInputSource();
    private List<User> userList = new ArrayList<>();
    private User promptUser;

    public BibliotecaApp() {
        initBookList();
        initMovieList();
        initUserList();
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.showMainView();
    }

    public void showMainView() {
        mainView.showPromptMessage(WECLOME_APP);
        mainView.printMainView(APP_NAME);
        loginApp();
        while (inputSource.hasInput()) {
            String choose = inputSource.getInput();
            if (choose.equals("q")) {
                break;
            }
            selectChioce(choose);
        }
    }

    public void selectChioce(String choose) {
        switch (choose) {
            case "1":
                mainView.showBookListInfo(bookList);
                break;
            case "2":
                borrowBook();
                break;
            case "3":
                returnBook();
                break;
            case "4":
                mainView.showMovieListInfo(this.movieList);
                break;
            case "5":
                watchMovie();
                break;
            case "6":
                showUserInfo();
                break;
            default:
                mainView.showPromptMessage(UNVAILD_CHOOSE);
                break;
        }
    }

    public void showUserInfo(){
        promptUser.showUserInfo();
    }

    public List<User> loginApp(){
        List<String> userLoginInfo = mainView.getLoginInfo(inputSource);
        List<User> collect = userList.stream().filter(user -> user.getAccountNumber().equals(userLoginInfo.get(0)) && user.getPassword().equals(userLoginInfo.get(1)))
                .collect(Collectors.toList());
        mainView.showPromptMessage(LOGIN_SUCCESS);
        promptUser = new User(collect.get(0));
        return collect;
    }

    public void watchMovie() {
        mainView.showPromptMessage(INPUT_MOVIE_ID);
        Integer chooseToWatch = Integer.parseInt(inputSource.getInput());
        movieList.stream().filter(movie -> movie.getId().equals(chooseToWatch))
                .forEach(movie -> mainView.showPromptMessage(movie.movie_info()));
    }

    public void borrowBook() {
        mainView.showPromptMessage(INPUT_BOOK_ID);
        Integer chooseToBorrowId = Integer.parseInt(inputSource.getInput());
        Optional<List<Book>>  borrowBookFromBookList = getBorrowBookFromBookList(chooseToBorrowId);
        if (borrowBookFromBookList.isPresent()) {
            mainView.showPromptMessage(BOOK_STATUS_INVAILD);
            return;
        }
        setBookIsBorrowed(borrowBookFromBookList.get().get(0));
    }

    public void setBookIsBorrowed(Book borrowedBook) {
        setBookStatus(borrowedBook,true);
        mainView.showPromptMessage(THANKS_BORROW_BOOK);
    }

    public Optional<List<Book>> getBorrowBookFromBookList(Integer bookId) {
        Optional<List<Book>> borrowingBook = Optional.of(bookList.stream().filter((book) ->
                !book.isBorrowed && book.getId().equals(bookId)).collect(Collectors.toList()));
        return borrowingBook;
    }

    public void returnBook() {
        mainView.showPromptMessage(INPUT_BOOK_ID);
        Integer chooseToReturnId = Integer.parseInt(inputSource.getInput());
        Optional<List<Book>> returnBook = getReturnBookFromBookList(chooseToReturnId);
        if (returnBook.get().isEmpty()) {
            mainView.showPromptMessage(BOOK_RETURN_INVALID);
            return;
        }
        setBookIsReturn(returnBook.get().get(0));
    }

    public void setBookIsReturn(Book returnBook) {
        setBookStatus(returnBook,false);
        mainView.showPromptMessage(THANKS_RETURN_BOOK);
    }
    public void setBookStatus(Book dealBook,boolean status){
        bookList = bookList.stream().map(book ->{
            if(book.getId().equals(dealBook.getId())){
                book.isBorrowed = status;
            }
            return book;
        }).collect(Collectors.toList());
    }

    public Optional<List<Book>> getReturnBookFromBookList(Integer borrowedBookId) {
        List<Book> collect = bookList.stream().filter(book -> book.isBorrowed && book.getId().equals(borrowedBookId))
                .collect(Collectors.toList());
        Optional<List<Book>> returnBook = Optional.ofNullable(collect);
        return returnBook;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void initBookList() {
        bookList.add(new Book(1, "Lolita", "Kofe", "04:30 PM, Sat 5/12/2018"));
        bookList.add(new Book(2, "A Midsummer Night's Dream", "Shakespeare", "04:30 PM, Sat 5/12/2018"));
        bookList.add(new Book(3, "The Old Man and the Sea", " Hemingway", "04:30 PM, Sat 5/12/2018"));
        bookList.add(new Book(4, "Pickwick Papers", "Charles Dickens", "04:30 PM, Sat 5/12/2018"));
        bookList.add(new Book(5, "The Red and the Black", "Stendhal", "04:30 PM, Sat 5/12/2018"));
    }

    public void initMovieList() {
        movieList.add(new Movie(1, "The Shawshank Redemption", "1994", "Frank Darabont", 9));
        movieList.add(new Movie(2, "Million Dollar Baby", " 2004", "Clint Eastwood", 8));
        movieList.add(new Movie(3, "The chaperone", "2011", "Stephen Herek", 7));
        movieList.add(new Movie(4, "schindler's list", "1993", "Steven Spielberg", 8));
        movieList.add(new Movie(5, "the lord of the rings", "1937", "Tolkien", 8));
    }
    public void initUserList(){
        userList.add(new User(1, "xiaoming", "xiaoming@thoughtworks.com", "138919191911"));
        userList.add(new User(1, "xiaohua", "xiaoming@thoughtworks.com", "138919191911"));
        userList.add(new User(1, "xiaoxia", "xiaoming@thoughtworks.com", "138919191911"));
        userList.add(new User(1, "xiaoliu", "xiaoming@thoughtworks.com", "138919191911"));
        userList.add(new User(1, "xiaowang", "xiaoming@thoughtworks.com", "138919191911"));
    }

}

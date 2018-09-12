package com.twu.biblioteca;

public class UserInfo {
    public UserInfo(Integer id, String name, String email, String telephone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        setAccount(id+'-'+"name",telephone);
    }

    public Integer getId() {
        return id;
    }


    public void setAccount(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public Book getMyBook() {
        return myBook;
    }

    public void setMyBook(Book myBook) {
        this.myBook = myBook;
    }
    private Integer id;

    private String name;

    private String email;

    private String telephone;
    private String accountNumber;

    private String password;

    private Book myBook;
}

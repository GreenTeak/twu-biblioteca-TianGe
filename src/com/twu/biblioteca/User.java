package com.twu.biblioteca;

public class User {
    public User(Integer id, String name, String email, String telephone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        setAccount(  ""+this.id+"-"+name,this.telephone);
    }

    public User(User user) {
        this.id = user.id;
        this.name=user.name;
        this.email=user.email;
        this.telephone=user.telephone;
        this.accountNumber = user.getAccountNumber();
        this.password = user.getPassword();
    }

    public Integer getId() {
        return id;
    }


    public void setAccount(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }


    public void showUserInfo() {
        System.out.println(String.format("%s:%s:%s",this.name,this.email,this.telephone));
    }

    public String getMyBookId() {
        return myBookId;
    }

    public void setMyBookId(String myBookId) {
        this.myBookId = myBookId;
    }

    private String accountNumber;

    private Integer id;

    private String name;

    private String email;

    private String telephone;

    private String password;

    private String myBookId;
}

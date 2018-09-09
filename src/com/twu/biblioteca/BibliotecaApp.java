package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BibliotecaApp {

    private List<Book> bookList=new ArrayList<>();

    public BibliotecaApp() {
        initBookList();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        BibliotecaApp bibliotecaApp=new BibliotecaApp();
        bibliotecaApp.main_view(scanner);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void main_view(Scanner scanner){
        main_view_print();
        while (scanner.hasNext()){
            String choose = scanner.next();
            if(choose.equals("q")){
                break;
            }
            select_chioce(choose);
        }
    }
    public void main_view_print(){
        System.out.println("--------------Biblioteca------------");
        System.out.println("1.查看书籍列表");
        System.out.println("2.借书");
        System.out.println("3.还书");
    }

    public void select_chioce(String choose){
       switch (choose){
           case "1":bookListInfo();break;
           case "2":lentBook();break;
           case "3":backBook();break;
           default:
               System.out.println("Select a valid option!");
               break;
       }
    }
    public void lentBook() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入书id");
        String choose = scanner.next();
        List<Book> books = bookList.stream().filter((book)-> !book.isBook() && book.getId().toString().equals(choose)).collect(Collectors.toList());
        if(books.isEmpty()) {
            System.out.println("那本书不可用");
            return;
        }
        Book isBook =books.get(0);
        for(int i=0;i<bookList.size();i++){
            if(bookList.get(i).getId()==isBook.getId()){
                System.out.println("谢谢你！");
                bookList.get(i).setBook(true);
            }

        }

    }
    public void backBook(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入书id");
        String choose = scanner.next();
        boolean index = false;
        for(int i=0;i<bookList.size();i++){
            if(bookList.get(i).getId()==Integer.parseInt(choose)&&bookList.get(i).isBook()){
                System.out.println("感谢您退回图书！");
                bookList.get(i).setBook(false);
                index=true;
            }
        }
        if(!index){
            System.out.println("这不是一本有效的图书就可以返回");
        }
    }

    public String weclome_info(){
        String weclome ="Weclome to Biblioteca!";
        return weclome;
    }

    public void initBookList(){
        bookList.add(new Book(1,"Lolita","Kofe","04:30 PM, Sat 5/12/2018"));
        bookList.add(new Book(2,"A Midsummer Night's Dream","Shakespeare","04:30 PM, Sat 5/12/2018"));
        bookList.add(new Book(3,"The Old Man and the Sea"," Hemingway","04:30 PM, Sat 5/12/2018"));
        bookList.add(new Book(4,"Pickwick Papers","Charles Dickens","04:30 PM, Sat 5/12/2018"));
        bookList.add(new Book(5,"The Red and the Black","Stendhal","04:30 PM, Sat 5/12/2018"));
    }
    public void bookListInfo(){
        bookList.stream().forEach(book-> {
            if(!book.isBook()) {
                System.out.println(book.book_info());
            }
        });
    }

}

package com.example.baitap;

public class Book {

    int id_book;
    String title;
    int id_author;

    public Book(int id_book, String title, int id_author) {
        this.id_book = id_book;
        this.title = title;
        this.id_author = id_author;
    }
    public Book(){
        this.id_book=0;
        this.title=null;
        this.id_author=0;

    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }


}










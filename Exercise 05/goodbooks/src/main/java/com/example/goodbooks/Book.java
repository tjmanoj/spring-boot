package com.example.goodbooks;

public class Book {
    private int bookId;
    private String bookName;
    private String author;

    public Book(int bookId, String bookName, String author){
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
    }

    //Getters
    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    //Setters
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}

package com.analices.bookstorebackend.model;

public class Book extends LibraryItem{
    private String author;

    public Book() {
        super();
    }

    public Book(int id, String title, String coverUrl, ReadingStatus status, String author) {
        super(id, title, coverUrl, status); //To use the parent class attributes
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getType() {
        return "BOOK";
    }
}

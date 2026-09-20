package com.analices.bookstorebackend.model;

public class Book extends LibraryItem{
    private String author;
    private int isbn;

    public Book() {
        super();
    }

    public Book(int id, String title, String coverUrl, ReadingStatus status, String author, int isbn) {
        super(id, title, coverUrl, status); //To use the parent class attributes
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String getType() {
        return "BOOK";
    }
}

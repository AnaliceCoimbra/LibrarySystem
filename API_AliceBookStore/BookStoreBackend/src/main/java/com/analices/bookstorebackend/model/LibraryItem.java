package com.analices.bookstorebackend.model;

public abstract class LibraryItem implements ReadingManageable {
        private int id;
        private String title;
        private String coverUrl;
        private ReadingStatus status;
        private String genre;
        private int pages;

    public LibraryItem() {
        this.status = ReadingStatus.WANT_TO_READ; // The Standard status when created
    }

    public LibraryItem(int id, String title, String coverUrl, ReadingStatus status, String genre, int pages) {
        this.id = id;
        this.title = title;
        this.coverUrl = coverUrl;
        this.status = status;
        this.genre = genre;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public ReadingStatus getStatus() {
        return status;
    }

    public void setStatus(ReadingStatus status) {
        this.status = status;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public void updateStatus(ReadingStatus newStatus) {
        this.status = newStatus;
    }

    public abstract String getType(); // Identifies if its "BOOK" or "MAGAZINE"
    }

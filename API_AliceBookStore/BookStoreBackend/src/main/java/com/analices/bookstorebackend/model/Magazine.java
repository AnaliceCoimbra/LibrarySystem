package com.analices.bookstorebackend.model;

public class Magazine extends LibraryItem {
    private int edition;

    public Magazine() {
        super();
    }

    public Magazine(int id, String title, String coverUrl, ReadingStatus status, int edition) {
        super(id, title, coverUrl, status); //To use the parent attributes
        this.edition = edition;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String getType() {
        return "MAGAZINE";
    }
}

package librarySystem;

public class Book extends LibraryItem{
    public String author;
    public int isbn;

    public Book(){

    }
    public Book(String author, int isbn){
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public int getIsbn() {
        return isbn;
    }

    @Override
    public void showDetails(){
        System.out.println("Title: " + getTitle()
                + "\nAuthor: " + getAuthor()
                + "\nISBN: " + getIsbn()
        );
    }

}

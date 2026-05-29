package librarySystem;

import java.util.ArrayList;

public class BookShelf {
    public String name;
    public ArrayList<LibraryItem> catalog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookShelf(){
        this.catalog = new ArrayList<>();
    }
    public BookShelf(String name){
        this.name = name;
        this.catalog = new ArrayList<>();
    }

    public void addItem(LibraryItem item){
        catalog.add(item);
    }

    public void showCatalog(){
        System.out.println("Book Store " + getName() + " catalog: ");
        for (LibraryItem book : catalog){
            book.showDetails();
        }
    }


}

import librarySystem.Book;
import librarySystem.BookShelf;
import librarySystem.Magazine;

void main() {
    System.out.println("Starting the day!!");

    //Create books
    Book book1 = new Book("Harper Lee", 47291048);
    book1.setTitle("To Kill a Mockingbird");
    book1.setId(1);
    book1.reserve();

    Book book2 = new Book("F. Scott Fitzgerald", 83019472);
    book2.setTitle("The Great Gatsby");
    book2.setId(2);
    book2.cancelReserve();

    Book book3 = new Book("J.D. Salinger", 19482056);
    book3.setTitle("The Catcher in the Rye");
    book3.setId(3);

    Book book4 = new Book("Jane Austen", 62510394);
    book4.setTitle("Pride and Prejudice");
    book4.setId(4);

    Book book5 = new Book("Aldous Huxley", 30594817);
    book5.setTitle("Brave New World");
    book5.setId(5);
    book5.reserve();

    System.out.println();
    System.out.println();

    //Create a Magazine
    System.out.println("We have a magazine here! ");
    Magazine mag1 = new Magazine(2);
    mag1.showDetails();

    System.out.println();
    System.out.println();

    //Create the Book Shelf
    BookShelf bookStore = new BookShelf("Alice's Book Store");
    bookStore.addItem(book1);
    bookStore.addItem(book2);
    bookStore.addItem(book3);
    bookStore.addItem(book4);
    bookStore.addItem(book5);
    bookStore.showCatalog();



}
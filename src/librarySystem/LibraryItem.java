package librarySystem;

public abstract class LibraryItem implements Reservable{
    private String title;
    private int id;
    private boolean reserved;

    public LibraryItem(){

    };

    public LibraryItem(String title, int id, boolean reserved){
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public void reserve(){
        this.reserved = true;
        System.out.println("We reserved the book " + getTitle() + " for you.");
    }

    @Override
    public void cancelReserve(){
        this.reserved = false;
        System.out.println("Canceling the book reservation for " + getTitle() + ".");
    }

    public abstract void showDetails();
}

package librarySystem;

public class Magazine extends LibraryItem {
    public int edition;

    public Magazine(){

    }
    public Magazine(int edition){
        this.edition = edition;
    }
    public int getEdition(){
        return edition;
    }

    @Override
    public void showDetails(){
        System.out.println("Magazine edition: " + getEdition());
    }

}

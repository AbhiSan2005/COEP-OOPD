import java.util.HashSet;

public class Library {
    private HashSet<Book> books; //This is not right. We should have count of each book also (or maybe just use IDs)
    private HashSet<Book> issued;

    public void Library() {
        books = new HashSet<>();
        issued = new HashSet<>();
    }
    
    public void issue(Book toBeIssued) {
        if (books.contains(toBeIssued)) {
            books.remove(toBeIssued);
            issued.add(toBeIssued);
        }
        else if (issued.contains(toBeIssued)) {
            System.out.println("Sorry, This book has be issued out\n");
        }
        else System.out.println("Could not find the book requested\n");
    }

    public void Return (Book toBeReturned) {
        if (issued.contains(toBeReturned)) {
            issued.remove(toBeReturned);
            books.add(toBeReturned);
        }
        else System.out.println("Not been issued by this library\n");
    }
    
    public double getPercentage() {
        return (issued.size() / books.size()) * 100;
    }

    public static void main(String[] args) {
        Library A = new Library();
        Library B = new Library();

        //Will complete rest later
    }
}
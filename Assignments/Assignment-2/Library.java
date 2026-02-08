import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Book> issued;

    public Library(ArrayList<Book> books) {
        this.books = books;
        issued = new ArrayList<>();
    }
    
    public void issue(Book toBeIssued) {
        if (books.contains(toBeIssued)) {
            books.remove(toBeIssued);
            issued.add(toBeIssued);
        }
        else if (issued.contains(toBeIssued)) {
            System.out.println("Already issued!\n");
        }
        else System.out.println("Not found!\n");
    }

    public void Return(Book toBeReturned) {
        if (issued.contains(toBeReturned)) {
            issued.remove(toBeReturned);
            books.add(toBeReturned);
        }
        else System.out.println("Not issued!\n");
    }
    
    public double getPercentage() {
        int totalBooks = books.size() + issued.size();
        if (totalBooks == 0) return 0.0;
        return ((double)issued.size() / totalBooks) * 100;
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public void displayBooks() {
        System.out.println("Available Books:\n");
        for (int i = 0; i < books.size(); i++) {
            books.get(i).displayBook();
        }
        
        System.out.println("\nIssued Books:\n");
        for (int i = 0; i < issued.size(); i++) {
            issued.get(i).displayBook();
        }
        
        System.out.println("\nIssued %: " + String.format("%.2f", getPercentage()) + "%");
    }
    
    public Book getBookByID(int id, boolean fromIssued) {
        ArrayList<Book> list = fromIssued ? issued : books;
        for (Book b : list) {
            if (b.getID() == id) {
                return b;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        ArrayList<Book> booksA = new ArrayList<>();
        booksA.add(new Book("Harry Potter and the Philosopher's Stone", 450.00, 1));
        booksA.add(new Book("Harry Potter and the Chamber of Secrets", 475.00, 1));
        booksA.add(new Book("The Lord of the Rings", 899.00, 3));
        booksA.add(new Book("1984", 299.00, 2));
        booksA.add(new Book("To Kill a Mockingbird", 350.00, 1));
        
        ArrayList<Book> booksB = new ArrayList<>();
        booksB.add(new Book("The Great Gatsby", 250.00, 2));
        booksB.add(new Book("Pride and Prejudice", 300.00, 1));
        booksB.add(new Book("The Catcher in the Rye", 325.00, 1));
        booksB.add(new Book("Animal Farm", 200.00, 1));
        booksB.add(new Book("Brave New World", 275.00, 2));
        
        Library A = new Library(booksA);
        Library B = new Library(booksB);
        Library currentLibrary = A;

        boolean Continue = true;
        while (Continue) {
            System.out.println("Current Library: " + (currentLibrary == A ? "A" : "B"));
            System.out.println("1. Add book  2. Issue  3. Return  4. Display  5. Change library  6. Exit");
            int choice = in.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = in.nextLine();
                    System.out.print("Price: ");
                    double price = in.nextDouble();
                    System.out.print("Edition: ");
                    int edition = in.nextInt();
                    currentLibrary.addBook(new Book(title, price, edition));
                    break;
                    
                case 2:
                    System.out.print("Book ID to issue: ");
                    int issueID = in.nextInt();
                    Book toIssue = currentLibrary.getBookByID(issueID, false);
                    if (toIssue != null) currentLibrary.issue(toIssue);
                    else System.out.println("Invalid!\n");
                    break;
                    
                case 3:
                    System.out.print("Book ID to return: ");
                    int returnID = in.nextInt();
                    Book toReturn = currentLibrary.getBookByID(returnID, true);
                    if (toReturn != null) currentLibrary.Return(toReturn);
                    else System.out.println("Invalid!\n");
                    break;
                    
                case 4:
                    currentLibrary.displayBooks();
                    break;
                    
                case 5:
                    System.out.print("1. Library A  2. Library B\nChoice: ");
                    int libraryChoice = in.nextInt();
                    if (libraryChoice == 1) currentLibrary = A;
                    else if (libraryChoice == 2) currentLibrary = B;
                    else System.out.println("Invalid!\n");
                    break;
                    
                case 6:
                    Continue = false;
                    break;
                    
                default:
                    System.out.println("Invalid choice!\n");
                    break;
            }
        }
        in.close();
    }
}
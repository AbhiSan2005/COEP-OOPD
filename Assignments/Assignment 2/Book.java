public class Book {
    private static int nextID = 1; //Needed for copies of same books
    private int ID;
    private String title;
    private double price;
    private int edition;
    
    Book(String title, double price) {
        this(title, price, 1);
    }
    
    Book(String title, double price, int edition) {
        this.title = title;
        this.price = price;
        this.edition = edition;
        this.ID = advanceID();
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getEdition() {
        return edition;
    }
    
    public int getID() {
        return ID;
    }

    public static int advanceID() {
        return nextID++;
    }
    
    public void displayBook() {
        System.out.println(ID + ". " + title + " | Edition:" + edition + " | $" + price);
    }
}
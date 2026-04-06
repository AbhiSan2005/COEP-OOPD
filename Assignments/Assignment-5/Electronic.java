public class Electronic implements StoreItem, Comparable<Electronic> {
    private String name;
    private double price;
    private String brand;
    private int warrantyYears;

    public Electronic(String name, double price, String brand, int warrantyYears) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.warrantyYears = warrantyYears;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Electronics: " + name + " Brand: " + brand + " Price: Rs." + price + " Warranty: " + warrantyYears);
    }

    @Override
    public int compareTo(Electronic other) {
        return Double.compare(this.price, other.price);
    }
}
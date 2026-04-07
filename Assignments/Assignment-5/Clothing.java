public class Clothing implements StoreItem, Comparable<Clothing> {
    private String name;
    private double price;
    private String size;

    public Clothing(String name, double price, String size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void displayInfo() {
        System.out.println("Clothing: " + name + " Price: Rs." + price + " Size: " + size);
    }

    @Override
    public int compareTo(Clothing other) {
        return Double.compare(this.price, other.price);
    }
}
public class Grocery implements StoreItem, Comparable<Grocery> {
    private String name;
    private double price;
    private double weight;

    public Grocery(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
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
        System.out.println("Grocery: " + name + " Price:" + price + " Weight: " + weight);
    }

    @Override
    public int compareTo(Grocery other) {
        return Double.compare(this.price, other.price);
    }
}
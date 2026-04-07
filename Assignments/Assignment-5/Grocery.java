public class Grocery implements StoreItem, Comparable<Grocery> {
    private String name;
    private double price;
    private double weight;

    public Grocery(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
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
        System.out.println("Grocery: " + name + " Price:" + price + " Weight: " + weight);
    }

    @Override
    public int compareTo(Grocery other) {
        return Double.compare(this.price, other.price);
    }
}
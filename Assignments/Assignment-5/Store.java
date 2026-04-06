public class Store {
    public static void main(String[] args) {
        Inventory<Electronic> electronicsInventory = new Inventory<>("Electronics");
        Inventory<Grocery> groceryInventory = new Inventory<>("Groceries");
        Inventory<Clothing> clothingInventory = new Inventory<>("Clothing");

        electronicsInventory.addItem(new Electronic("Laptop", 55000.0, "Dell", 2));
        electronicsInventory.addItem(new Electronic("Headphones", 2500.0, "Sony", 1));
        groceryInventory.addItem(new Grocery("Rice", 500.0, 10.0));
        groceryInventory.addItem(new Grocery("Milk", 60.0, 1.0));
        clothingInventory.addItem(new Clothing("T-Shirt", 800.0, "L"));
        clothingInventory.addItem(new Clothing("Jeans", 1500.0, "32"));

        electronicsInventory.displayAll();
        groceryInventory.displayAll();
        clothingInventory.displayAll();
        System.out.println();

        Electronic cheapestElec = Inventory.findCheapest(electronicsInventory.getItems());
        System.out.println("Cheapest Electronic: " + cheapestElec.getName() + cheapestElec.getPrice());
        System.out.println();

        Inventory.printSummary(electronicsInventory);
        Inventory.printSummary(clothingInventory);
        System.out.println();
    }
}
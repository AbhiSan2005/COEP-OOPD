import java.util.ArrayList;
import java.util.List;

public class Inventory<T extends StoreItem & Comparable<T>> {
    private List<T> items;
    private String categoryName;

    public Inventory(String categoryName) {
        this.categoryName = categoryName;
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
        else {
            System.out.println("Invalid index");
        }
    }

    public List<T> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void displayAll() {
        System.out.println("Category: " + categoryName);
        for (T item : items) {
            System.out.print("  "); 
            item.displayInfo();
        }
    }

    public static <T extends Comparable<T>> T findCheapest(List<T> items) {
        if (items == null || items.isEmpty()) return null;
        T cheapest = items.get(0);
        for (T item : items) {
            if (item.compareTo(cheapest) < 0) cheapest = item;
        }
        return cheapest;
    }

    public static void printSummary(Inventory<?> inv) {
        System.out.println("Inventory: " + inv.getCategoryName() + " Total items: " + inv.getCount());
    }
}
public class Manual extends Vehicle {
    public Manual(String brand, double maxSpeed, int wheels, boolean isOn) {
        super(brand, "None", maxSpeed, wheels, isOn);
    }

    @Override
    public void displayInfo() {
        System.out.println("Gears: Manual\n");
        super.displayInfo();
    }
}
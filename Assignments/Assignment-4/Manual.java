public class Manual extends Vehicle {
    //Is it supposed to be electric?
    public Manual(String brand, double maxSpeed, int wheels, boolean isOn) {
        super(brand, "None", maxSpeed, wheels, isOn);
    }

    @Override
    public void displayInfo() {
        System.out.println("Gear-Type: Manual\n");
        super.displayInfo();
    }
}
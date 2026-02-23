public class Automatic extends Vehicle {
    protected double mileage;
    
    public Automatic(String brand, String fuel, double maxSpeed, double mileage, int wheels, boolean isOn) {
        super(brand, fuel, maxSpeed, wheels, isOn);
        this.mileage = mileage;
    }

    @Override
    public void displayInfo() {
        System.out.println("Gear-Type: Automatic\n");
        super.displayInfo();
        System.out.println("Mileage: " + mileage);
    }
}
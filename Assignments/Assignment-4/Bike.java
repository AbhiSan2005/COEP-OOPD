public class Bike extends Automatic{
    public Bike(String brand, String fuel, double maxSpeed, double mileage, boolean isOn) {
        super(brand, fuel, maxSpeed, mileage, 2, isOn);
    }

    public void ride() {
        if (this.isOn) {
            System.out.println("Ride On!");
        }
        else {
            System.out.println("Switch the Bike On!");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Type: Bike\n");
        super.displayInfo();
    }
}

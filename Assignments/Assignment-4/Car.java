public class Car extends Automatic{
    public Car(String brand, String fuel, double maxSpeed, double mileage, boolean isOn) {
        super(brand, fuel, maxSpeed, mileage, 4, isOn);
    }

    public void honk() {
        System.out.println("Po!");
    }

    @Override
    public void displayInfo() {
        System.out.println("Type: Car\n");
        super.displayInfo();
    }
}

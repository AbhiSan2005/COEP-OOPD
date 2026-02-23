public class Car extends Automatic{
    public Car(String brand, String fuel, double maxSpeed, double mileage, boolean isOn) {
        super(brand, fuel, maxSpeed, mileage, 4, isOn);
    }

    public void honk() {
        System.out.println("Po!");
    }

    public void honk(String msg) {
        System.out.println(msg + '\n');
    }

    @Override
    public void displayInfo() {
        System.out.println("Type: Car\n");
        super.displayInfo();
    }
}

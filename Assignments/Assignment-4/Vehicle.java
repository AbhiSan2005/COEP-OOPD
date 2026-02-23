public abstract class Vehicle {
    protected String brand;
    protected String fuel;
    protected double maxSpeed;
    protected int wheels;
    protected boolean isOn;

    public Vehicle(String brand, String fuel, double maxSpeed, int wheels, boolean isOn) {
        this.brand = brand;
        this.fuel = fuel;
        this.maxSpeed = maxSpeed;
        this.wheels = wheels;
        this.isOn = isOn;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand + "\nFuel: " + fuel + "\nMax Speed: " + maxSpeed + "\nWheels: " + wheels + "\nIs On?: " + isOn);
    }

    public void start() {
        if (!this.isOn) this.isOn = true;
        else System.out.println("Already On");
    }

    public void start(String msg) {
        start();
        System.out.println(msg + '\n');
    }

    public void stop() {
        if (this.isOn) this.isOn = false;
        else System.out.println("Already Off");
    }
}
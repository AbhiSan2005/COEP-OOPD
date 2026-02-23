public class Test {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("Toyota", "Petrol", 180, 15, false),
            new Bike("Yamaha", "Petrol", 120, 40, false),
            new Manual("Trek", 30, 2, false)
        };

        for (Vehicle v : vehicles) {
            v.displayInfo();
            v.start();
            v.stop();
        }

        Car car = new Car("Honda", "Petrol", 160, 14, false);
        car.start();
        car.start("Vroom!");
        car.honk();
        car.honk("BEEP!");

        Bike bike = new Bike("Royal Enfield", "Petrol", 140, 35, false);
        bike.start();
        bike.ride();
        bike.stop();
        bike.ride();
    }
}
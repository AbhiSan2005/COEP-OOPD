public class Manager extends Employee {
    private double bonus;

    public void setBonus(double b) {
        bonus = b;
    }

    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day); //Must be the first line in constructor of a subclass
        bonus = 0;
    }

    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        // super.equals checked that this and otherObject belong to the same class
        Manager other = (Manager) otherObject;
        return bonus == other.bonus;
    }

    //Remember declaring a method as final prevents it from being inherited in a subclass
}
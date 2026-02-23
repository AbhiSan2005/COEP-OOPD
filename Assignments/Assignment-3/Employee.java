public class Employee {
    private static int nextID = 1;
    private int ID;
    private int rating;
    private double salary;
    private double bonus;
    private double bonusAmount;
    private String name;

    public Employee(String name) {
        this(name, 10000, 0, 1);
    }

    public Employee(String name, double salary) {
        this(name, salary, 0, 1);
    }

    public Employee(String name, double salary, double bonus) {
        this(name, salary, bonus, 1);
    }

    public Employee(String name, double salary, double bonus, int rating) {
        this.ID = advanceID();
        this.name = name;
        this.salary = salary;
        this.rating = rating;
        this.bonus = bonus;
        this.bonusAmount = bonus * rating;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
        setBonusAmount(bonus * rating);
    }

    private void setBonusAmount(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    // Depending on the rating given to the employee, the bonus is calculated as bonus amount * rating
    public void setRating(int rating) {
        setBonusAmount(bonus * rating);
        this.rating = rating;
    }

    public int getID() {
        return this.ID;
    }

    public void display() {
        System.out.println(ID + ": " + name + " | Base Salary: " + salary + " | Bonus: " + bonus + " | Rating: " + rating + " |Total Salary: " + (salary+bonusAmount));
    }

    private static int advanceID() {
        return nextID++;
    }
}
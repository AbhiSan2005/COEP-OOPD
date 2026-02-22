public class Employee {
    private int ID;
    private int rating;
    private double salary;
    private double bonus;
    private double bonusAmount;
    private String name;

    Employee(int id, String name) {
        this(id, name, 10000, 0, 1);
    }

    Employee(int id, String name, double salary) {
        this(id, name, salary, 0, 1);
    }

    Employee(int id, String name, double salary, double bonus) {
        this(id, name, salary, bonus, 1);
    }

    Employee(int id, String name, double salary, double bonus, int rating) {
        this.ID = id;
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

    public void setBonusAmount(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    // Depending on the rating given to the employee, the bonus is calculated as bonus amount * rating
    public void setRating(int rating) {
        setBonusAmount(bonus * rating);
        this.rating = rating;
    }

    public int getID() {
        return ID;
    }

    public void display() {
        System.out.println(ID + ": " + name + " | Base Salary: " + salary + " | Bonus: " + bonus + " | Rating: " + rating + " |Total Salary: " + (salary+bonusAmount));
    }
}
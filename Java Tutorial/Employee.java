import java.time.LocalDate;
import java.util.Random;

class Employee {
    //Static variable - belongs to the class and is shared amongst the instances
    private static int nextId = 1;

    //Explicit initialisation of field
    private int id = advanceId();
    
    // instance fields
    private String name;
    private double salary;
    private LocalDate hireDay;

    // object initialization block - will run on every instance creation (not considered good practice)
    {
        id = nextId;
        nextId++;
    }

    //Static Initialisation block to initialise static variables (not recommended)
    private static Random generator = new Random();
    // static initialization block
    static
    { 
        nextId = generator.nextInt(10000);
    }
    
    // constructor
    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    public Employee(String n, double s)
    {
        name = n;
        salary = s;
    }

    public Employee()
    {
        name = "";
        salary = 0;
    }

    //A constructor can call another using this keyword
    /*
    public Employee(double s) {
        this("Employee #" + nextId, s);
        nextId++;
    }
    */
  
    // a method
    public final String getName() { //A Final Method can never be overriden
        return name;
    }
    
    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    //Very very imp lesson
    /*
    public Date getHireDay() {
        return hireDay;
    }
    is bad practice because Date has a setter method! Which means objects of Date class are mutable! This could violate encapsultion

    Do this instead:
    public Date getHireDay() {
        return (Date) hireDay.clone();
    }
    */

    //Note the use of keyword this is follwoed by . and not ->
    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    //Static Method - does not use implicit parameters (this). Can use static fields tho as shown
    //Call these using Employee.advanceId() and not Abhiraj.advanceId() (meaningless)
    public static int advanceId() {
        int r = nextId; // obtain next available id
        nextId++;
        return r;
    }

    //If java Employee is run, then this will execute else this wont be executed
    public static void main(String[] args) // unit test
    {
        var e = new Employee("Romeo", 50000, 2003, 3, 31);
        e.raiseSalary(10);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}
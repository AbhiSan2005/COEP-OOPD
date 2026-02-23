import java.util.ArrayList;
import java.util.Scanner;

public class Office {
    private ArrayList<Employee> employees;
    
    Office(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    
    public void displayEmployees() {
        for (Employee e : employees) {
            e.display();
        }
    }

    public Employee getEmployeeById(int id) {
        for (Employee e : employees) {
            if (e.getID() == id) {
                return e;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        //Set employees here
        employees.add(new Employee("John", 50000, 1000, 3));
        employees.add(new Employee("Sarah", 60000, 1500, 4));
        employees.add(new Employee("Mike", 45000));
        
        Office office = new Office(employees);

        Scanner in = new Scanner(System.in);
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Choices:\n1.Display 2.Change Employee Bonus/Rating 3.Add Employees 4.Quit");
            int choice = in.nextInt();

            switch (choice) {
                case 1 -> office.displayEmployees();
                case 2 -> {
                    office.displayEmployees();
                    System.out.println("Enter ID of Employees:");
                    int employeeID = in.nextInt();
                    
                    Employee currentEmployee = office.getEmployeeById(employeeID);
                    if (currentEmployee == null) {
                        System.out.println("Employee not found!");
                        break;
                    }
                    currentEmployee.display();
                    
                    boolean changeContinue = true;
                    while (changeContinue) {
                        System.out.println("Choices:\n1.Change Bonus 2. Change Rating 3.Done");
                        int change = in.nextInt();
                        if (change == 1) {
                            System.out.println("Enter amount:");
                            double bonus = in.nextDouble();
                            currentEmployee.setBonus(bonus);
                        }
                        else if (change == 2) {
                            System.out.println("Enter rating(1-5):");
                            int rating = in.nextInt();
                            if (rating > 5 || rating < 1) {
                                System.out.println("Enter number between 1 and 5");
                                continue;
                            }
                            currentEmployee.setRating(rating);
                        }
                        else if (change == 3) {
                            changeContinue = false;
                            break;
                        }
                        else {
                            System.out.println("Choose either 1, 2, or 3");
                        }
                        currentEmployee.display();
                    }
                    office.displayEmployees();
                }
                case 3 -> {
                    in.nextLine();
                    System.out.println("Enter Name:");
                    String name = in.nextLine();
                    
                    System.out.println("Enter Salary:");
                    double salary = in.nextDouble();
                    
                    employees.add(new Employee(name, salary));
                    office.displayEmployees();
                }
                case 4 -> continueLoop = false;
                default -> {
                    System.out.println("Invalid Choice\nExiting as default");
                    break;
                }
            }
        }
        in.close();
    }
}
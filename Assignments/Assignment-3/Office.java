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
        employees.add(new Employee(1, "John", 50000, 1000, 3));
        employees.add(new Employee(2, "Sarah", 60000, 1500, 4));
        employees.add(new Employee(3, "Mike", 45000));
        
        Office office = new Office(employees);

        Scanner in = new Scanner(System.in);
        boolean Continue = true;
        while (Continue) {
            System.out.println("Choices:\n1.Display 2.Change Employee Bonus/Rating 3.Add Employees 4.Quit");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    office.displayEmployees();
                    break;
                case 2:
                    office.displayEmployees();
                    System.out.println("Enter ID of Employees:");
                    int employeeID = in.nextInt();
                    
                    Employee currentEmployee = office.getEmployeeById(employeeID);
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
                        }
                        else {
                            System.out.println("Choose either 1, 2, or 3");
                        }
                        currentEmployee.display();
                    }
                    office.displayEmployees();
                    break;
                case 3:
                    System.out.println("Enter ID:");
                    int id = in.nextInt();
                    if (office.getEmployeeById(id) != null) System.out.println("Employee already exists");
                   
                    System.out.println("Enter Name:");
                    String name = in.nextLine();
                    
                    System.out.println("Enter Salary:");
                    double salary = in.nextDouble();
                    
                    employees.add(new Employee(id, name, salary));
                    office.displayEmployees();
                    break;
                case 4:
                    Continue = false;
                    break;
                default:
                    break;
            }
        }
        in.close();
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    private ArrayList<Employees> employees;

    public Company(ArrayList<Employees> employees) {
        this.employees = employees;
    }

    public void displayEmployees() {
        for (Employees e : employees) {
            e.display();
        }
    }

    public Employees getEmployeeById(int id) throws EmployeeNotFoundException {
        for (Employees e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new EmployeeNotFoundException("No employee found with given ID ");
    }

    public static void main(String[] args) {
        ArrayList<Employees> initialEmployees = new ArrayList<>();
        initialEmployees.add(new Employees("Rahul", 5, 10, 7));
        initialEmployees.add(new Employees("Sneha", 2, 5, 4));
        initialEmployees.add(new Employees("Amit", 0, 12, 10));

        Company system = new Company(initialEmployees);
        Scanner in = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.println("1. Apply for Leave (Employee) \n2. Process Leave (Manager) \n3. View All Employees \n4. Exit");
            System.out.print("Choice: ");
            
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    system.displayEmployees();
                    System.out.print("Employee ID: ");
                    int id = in.nextInt();
                    
                    try {
                        Employees emp = system.getEmployeeById(id); 
                        System.out.print("Leave Type(Casual/Earned/Sick): "); 
                        
                        String type = in.next();
                        System.out.print("Number of Days: ");
                        
                        int days = in.nextInt();
                        emp.applyLeave(type, days);
                    } catch (EmployeeNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (InsufficientLeaveException e) {
                        System.out.println(e.getMessage()); 
                    } catch (Exception e) {
                        System.out.println("An unexpected error occurred: " + e.getMessage());
                    } finally {
                        System.out.println("Processed");
                    }
                }
                case 2 -> {
                    system.displayEmployees();
                    System.out.print("Employee ID to process: ");
                    int id = in.nextInt();
                    
                    try {
                        Employees emp = system.getEmployeeById(id);
                        if (emp.hasPendingRequest) {
                            System.out.print("Approve request for " + emp.reqDays + " " + emp.reqType + " leaves? (true/false): ");
                            boolean approve = in.nextBoolean();
                            emp.processLeave(approve);
                        } else {
                            System.out.println("No pending requests for this employee.");
                        }
                        
                    } catch (EmployeeNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 3 -> system.displayEmployees();
                case 4 -> {
                    continueLoop = false;
                }
                default -> System.out.println("Invalid choice");
            }
        }
        in.close();
    }
}
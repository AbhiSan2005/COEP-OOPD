import java.util.ArrayList;
import java.util.Scanner;

public class LeaveManagement {
    private ArrayList<Employees> employees;

    public LeaveManagement(ArrayList<Employees> employees) {
        this.employees = employees;
    }

    public void displayEmployees() {
        for (Employees e : employees) {
            e.display();
        }
    }

    public Employees getEmployeeById(int id) {
        for (Employees e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Employees> initialEmployees = new ArrayList<>();
        initialEmployees.add(new Employees("Rahul", 5, 10, 7));
        initialEmployees.add(new Employees("Sneha", 2, 5, 4));
        initialEmployees.add(new Employees("Amit", 0, 12, 10));

        LeaveManagement system = new LeaveManagement(initialEmployees);
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
                    Employees emp = system.getEmployeeById(id);
                    
                    if (emp != null) {
                        System.out.print("Leave Type(Casual/Earned/Sick): ");
                        String type = in.next();
                        System.out.print("Number of Days: ");
                        int days = in.nextInt();

                        try {
                            emp.applyLeave(type, days);
                        } catch (InsufficientLeaveException e) {
                            System.out.println(e.getMessage()); 
                        } catch (Exception e) {
                            System.out.println("An unexpected error occurred: " + e.getMessage());
                        } finally {
                            System.out.println("Processed");
                        }
                    }
                    else {
                        System.out.println("Employee not found");
                    }
                }
                case 2 -> {
                    system.displayEmployees();
                    System.out.print("Employee ID to process: ");
                    int id = in.nextInt();
                    Employees emp = system.getEmployeeById(id);

                    if (emp != null && emp.hasPendingRequest) {
                        System.out.print("Approve request for " + emp.reqDays + " " + emp.reqType + " leaves? (true/false): ");
                        boolean approve = in.nextBoolean();
                        emp.processLeave(approve);
                    }
                    else if (emp != null) {
                        System.out.println("No pending requests for this employee");
                    }
                    else {
                        System.out.println("Employee not found");
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
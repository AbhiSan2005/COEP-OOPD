import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    final int check = 1;
    final int deposit = 2;
    final int withdraw = 4;
    final int transfer = 8;
    ArrayList<User> users = new ArrayList<>();
    
    public double check(User user) {
        if ((user.getUserType().getType() & check) == check) {
            return user.getBalance();
        }
        else {
            System.out.println("Sorry, you can't check your balance!\n");
        }
        return -1;
    }
    
    public void deposit(User user, double amount) {
        double currentBalance = user.getBalance();
        if ((user.getUserType().getType() & deposit) == deposit) {
            user.setBalance(currentBalance + amount);
        }
        else {
            System.out.println("Sorry, you can't deposit!\n");
        }
    }
    
    public double withdraw(User user, double amount) {
        double currentBalance = user.getBalance();
        if ((user.getUserType().getType() & withdraw) == withdraw) {
            if (amount > currentBalance) {
                System.out.println("Current Balance Insufficient\n");
                System.out.println("Would you like to withdraw whatever is left?\n");
                System.out.println("Yes: 1\nNo: 0\n");
                Scanner in = new Scanner(System.in);
                int bool = in.nextInt();
                in.close();
                if (bool == 1) {
                    double remaining = currentBalance;
                    user.setBalance(0);
                    return remaining;
                }
                else if (bool == 0) {
                    return 0;
                }
                else {
                    System.out.println("Invalid input\n");
                    return -1;
                }
            }
            else {
                user.setBalance(currentBalance - amount);
                return amount;
            }
        }
        else {
            System.out.println("Sorry, you can't withdraw!\n");
        }
        return -1;
    }
    
    public void transfer(User from, User to, double amount) {
        if ((from.getUserType().getType() & transfer) == transfer && (to.getUserType().getType() & transfer) == transfer) {
            double toBeTaken = withdraw(from, amount);
            if (toBeTaken > 0) {
                deposit(to, toBeTaken);
            }
        }
        else if ((from.getUserType().getType() & transfer) != transfer) {
            System.out.println("First User doesn't have the transfer privilege\n");
        }
        else if ((to.getUserType().getType() & transfer) != transfer) {
            System.out.println("Second User doesn't have the transfer privilege\n");
        }
    }

    public User registerUser(Type type, double amount) {
        User newUser = new User(type, amount);
        users.add(newUser);
        System.out.println("Your ID:");
        System.out.println(newUser.getID());
        return newUser;
    }

    public User findUserByID(int id) {
        for (User user : users) {
            if (user.getID() == id) {
                return user;
            }
        }
        System.out.println("No User with Given ID");
        return null;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner in = new Scanner(System.in);
        
        boolean continueRegisters = true;
        while (continueRegisters) {
            System.out.println("Enter User Type:");
            System.out.println("Premium: 15\nRegular: 7\nBasic: 3");
            int userTypeCode = in.nextInt();
            Type userType;
            if (userTypeCode == 15) userType = Type.PREMIUM;
            else if (userTypeCode == 7) userType = Type.REGULAR;
            else userType = Type.BASIC;
            
            System.out.println("Enter Initial Balance:");
            double balance = in.nextDouble();
            atm.registerUser(userType, balance);
            
            System.out.println("Register another user?\nYes: 1\nNo: 0\n");
            int cont = in.nextInt();
            if (cont == 0) {
                continueRegisters = false;
            }
        }
        
        boolean continueOperations = true;
        while (continueOperations) {
            System.out.println("Enter your UserID:\n");
            int userID = in.nextInt();
            User currentUser = atm.findUserByID(userID);
            if (currentUser == null) {
                continue;
            }
            
            System.out.println("1: Check Balance\n2: Deposit\n4: Withdraw\n8: Transfer\n0: Exit");
            int operation = in.nextInt();
            
            if (operation == 0) {
                continueOperations = false;
            }
            else if (operation == 1) {
                double balance = atm.check(currentUser);
                if (balance >= 0) {
                    System.out.println(balance);
                }
            }
            else if (operation == 2) {
                System.out.println("Enter amount:");
                double amount = in.nextDouble();
                atm.deposit(currentUser, amount);
            }
            else if (operation == 4) {
                System.out.println("Enter amount:");
                double amount = in.nextDouble();
                double withdrawn = atm.withdraw(currentUser, amount);
            }
            else if (operation == 8) {
                System.out.println("Enter the UserID receiving:");
                int toID = in.nextInt();
                User toUser = atm.findUserByID(toID);
                
                if (toUser == null) {
                    System.out.println("User not found!");
                } else {
                    System.out.println("Enter amount:");
                    double amount = in.nextDouble();
                    atm.transfer(currentUser, toUser, amount);
                }
            }
            else {
                System.out.println("Please Enter the given numbers!");
            }
        }
        in.close();
    }
}
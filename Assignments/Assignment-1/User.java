public class User {
    private static int nextID = 1;
    private int ID;
    private Type type; 
    private double money;

    User(Type type) {
        this(type, 0);
    }

    User(Type type, double balance) {
        this.type = type;
        this.money = balance;
        this.ID = advanceID();
    }

    public Type getUserType() {
        return type;
    }

    public double getBalance() {
        return money;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            balance = 0;
            System.out.println("Balance cannot be less than zero. Resetting to zero");
        }
        this.money = balance;
    }

    public int getID() {
        return ID;
    }

    private static int advanceID() {
        return nextID++;
    }
}
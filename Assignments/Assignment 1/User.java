enum Type {
    PREMIUM(15), REGULAR(7), BASIC(3);
    private int type;

    private Type(int type) { 
        this.type = type;
    }
    
    public int getType() { 
        return type;
    }
}

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
        this.money = balance;
    }

    public int getID() {
        return ID;
    }

    public static int advanceID() {
        return nextID++;
    }
}
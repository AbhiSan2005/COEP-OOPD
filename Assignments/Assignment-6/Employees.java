public class Employees {
    private static int nextID = 1;
    private int id;
    private String name;
    private int casualLeaves;
    private int earnedLeaves;
    private int sickLeaves;
    public boolean hasPendingRequest;
    public String reqType;
    public int reqDays;

    public Employees(String name, int casualLeaves, int earnedLeaves, int sickLeaves) {
        this.id = advanceID();
        this.name = name;
        this.casualLeaves = casualLeaves;
        this.earnedLeaves = earnedLeaves;
        this.sickLeaves = sickLeaves;
        this.reqType = "";
    }

    private static int advanceID() {
        return nextID++;
    }

    public int getId() {
        return this.id;
    }

    public int getTotalLeaves() {
        return casualLeaves + earnedLeaves + sickLeaves;
    }

    public void applyLeave(String type, int days) throws InsufficientLeaveException {
        assert days > 0 : "Must be greater than zero";

        if (type.equalsIgnoreCase("Casual")) {
            if (days > casualLeaves) {
                throw new InsufficientLeaveException("Not enough casual leaves left");
            }
        }
        else if (type.equalsIgnoreCase("Earned")) {
            if (days > earnedLeaves) {
                throw new InsufficientLeaveException("Not enough earned leaves left");
            }
        }
        else if (type.equalsIgnoreCase("Sick")) {
            if (days > sickLeaves) {
                throw new InsufficientLeaveException("Not enough sick leaves left");
            }
        }
        else {
            throw new IllegalArgumentException("Invalid leave type");
        }

        this.reqType = type;
        this.reqDays = days;
        this.hasPendingRequest = true;
        System.out.println("Done");
    }

    public void processLeave(boolean isApproved) {
        if (!hasPendingRequest) {
            System.out.println("No pending requests");
            return;
        }

        if (isApproved) {
            if (reqType.equalsIgnoreCase("Casual")) {
                casualLeaves -= reqDays;
            }
            else if (reqType.equalsIgnoreCase("Earned")) {
                earnedLeaves -= reqDays;
            }
            else if (reqType.equalsIgnoreCase("Sick")) {
                sickLeaves -= reqDays;
            }
            System.out.println("Approved " + reqDays + " " + reqType + " leave(s) for " + name);
        }
        else {
            System.out.println("Rejected request for leave of " + name);
        }

        hasPendingRequest = false;
        reqType = "";
        reqDays = 0;
    }

    public void display() {
        System.out.println("ID: " + id + " Name: " + name + " Casual: " + casualLeaves + " Earned: " + earnedLeaves + " Sick: " + sickLeaves + " Total: " + getTotalLeaves());
        if (hasPendingRequest) {
            System.out.println(" Pending Request: " + reqDays + " " + reqType + " leaves");
        }
    }
}
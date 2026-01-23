public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        var staff = new Employee[3];
        //This is legal : Manager boss = (Manager) staff[0];
        staff[0] = boss; //This variable is polymorphic
        boss.setBonus(5000);
        System.out.println(boss.getName());
        //NOTE: You cant use staff[0].setBonus(5000), why?
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
        for (Employee e : staff)
            System.out.println(e.getName() + " " + e.getSalary()); //Boss is a manager and JVM selects the correct getSalary automatically (dynamic binding)
    }
}
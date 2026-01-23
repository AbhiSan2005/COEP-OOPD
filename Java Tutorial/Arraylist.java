import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> staff = new ArrayList<>();
        // var staff = new ArrayList<Employee>(); Dont use diamond syntax with
        staff.add(23); //Same as staff.add(Integer.valueOf(23)), also known as Autoboxing
        staff.add(0, 22); 
        staff.set(0, 12);
        staff.remove(1);
        System.out.println(staff.get(0)); //staff.get().intValue() Unboxing

        //ALWAYS KEEP IN MIND: WRAPPER CLASSES ARE IMMUTABLE
        Integer example1 = Integer.valueOf(69);
        Integer b = 1000;

        Integer n = 1;
        Double x = 2.0;
        System.out.println(true ? n : x); // prints 1.0

        // Dont use new Integer(1000) - might get depricated soon
        // Warning: always use equals when comparing wrapper objects
        // Integer a = 1000;
        // Integer b = 1000;
        // if (a == b) This might work or might not work
        
        //Convenient way to get both flexibilty and access
        Scanner sc = new Scanner(System.in);
        var list = new ArrayList<Integer>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        var a = new int[list.size()];
        list.toArray(a);
    }
}
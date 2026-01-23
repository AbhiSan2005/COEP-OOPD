import java.io.Console;
import java.util.*; //For input scanner and console

enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    private Size(String abbreviation) { 
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation() { 
        return abbreviation;
    }
    private String abbreviation;
}

public class Welcome
{
    public static void main(String[] args)
    {
        String greeting = "Welcome to Core Java!";
        //Check out other string methods
        System.out.println(greeting.equals("args"));
        System.out.println(greeting.charAt(0));
        System.out.println(greeting.length());
        System.out.println(greeting);
        
        //C style
        int x = -5;
        x += 3.5;
        System.out.printf("%d", x);
        
        
        for (int i = 0; i < greeting.length(); i++)
            System.out.print("=");
        System.out.println();


        //For reading input
        Scanner in = new Scanner(System.in);
        
        //For reading passwords
        Console cons = System.console();
        String username = cons.readLine("User name: ");
        char[] passwd = cons.readPassword("Password: ");
        
        // get first input
        System.out.print("What is your name? ");
        String name = in.nextLine();

        // get second input
        System.out.print("How old are you? ");
        int age = in.nextInt();
        
        // display output on console
        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));

        //Check out enum in Java
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE)
            System.out.println("Good job--you paid attention to the _.");
    }
}

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String rubbish = sc.nextLine();
        System.out.println(n);
        System.out.println(rubbish);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // Scanner is a java package for reading inputs
        // and System.in is java's way of getting the 
        // local machine's keyboard input
        Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = input.nextLine();
        System.out.println(name);
    
    }
}
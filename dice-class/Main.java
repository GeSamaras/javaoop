import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dice die = new Dice(6);

        int roll1 = die.roll();
        int roll2 = die.roll();
        int sum = roll1 + roll2;
        System.out.print("You rolled: " + roll1 + " and " + roll2);
        System.out.println(". The sum is: " + sum);

        System.out.println("The die is: " + die);
        System.out.println("The die is: " + die.getValue());

        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            die.roll();
            System.out.println("Dice rolled: " + die + " (" + die.getValue() + ")");

            System.out.println("Roll once more [Yn] ");
            input = scanner.nextLine();
        } while (input == "y" || input == "");
    }
}

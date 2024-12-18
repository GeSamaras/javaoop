import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu () {
        // "this." is used so all references only point
        // to the "private scanner" declared in this class  
        this.scanner = new Scanner(System.in); // scanner will look for System.in
        // needed so the stream of inputs made by the user is read
    }

    public void run() {
        do { 
            printMenu();
            
            // declare type and call getChoice() as long as run() is active
            String choice;
            choice = getChoice();
            System.out.println("Your choice is: " + choice);

            if (choice.equals("3")) {
                System.out.println("Number 3 selected");                
            }
            if (choice.equals("2")) {
                System.out.println("Number 2 selected");
            }
            if (choice.equals("1")) {
                System.out.println("Number 1 selected");
                RockPaperScissor game = new RockPaperScissor();
                game.play();
            }
            if (choice.equals("q")) {
                break;
            }            
        } while (true);
    }

    public void printMenu() {
        String menu = """
                 -----------------
                | 1) Menu choice 1
                | 2) Menu choice 2
                | 3) Menu choice 3
                | m) Print menu
                | qQ) Quit
                -----------------

                """;
        System.out.println(menu);
    }

    public String getChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextLine();
    }
}


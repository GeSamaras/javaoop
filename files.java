
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("Hello");
        lines.add("Itsa me mawrio");

        Path path = Paths.get("text.txt");

        try {

            // Files package reads files in the local system
            // path = where to store the file
            // lines = what will be stored
            // CREATE = makes this new file 
            Files.write(path, lines, StandardOpenOption.CREATE);


            // readAllLines goes to the "path" and returns
            // the values, in this case in a list of strings
            var readLines = Files.readAllLines(path);

            for (String line : readLines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
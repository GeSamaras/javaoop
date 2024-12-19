/**
 * Show how a path can be constructed to point out a file resources.
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadBufferedMain {
    
    public static void main(String[] args) {
        List<String> rows = new ArrayList<>();
        Path path = Paths.get("data", "file.txt");
        System.out.println(path);

        // Read file content
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                rows.add(line);
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        
        // Write file content
        Path path1 = Paths.get("data", "file_backup_again.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path1)) {
            for (String row: rows) {
                writer.write(row, 0, row.length());
                writer.write("\n", 0, 1);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        System.out.println("---\nWrote a backup file as: " + path1);
    }
}


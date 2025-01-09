package se.choccy;

import java.io.Console;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // Set the console encoding to UTF-8
        System.setProperty("file.encoding", StandardCharsets.UTF_8.name());
        Console console = System.console();
        if (console != null) {
            console.printf("Console encoding: %s%n", console.charset());
        }

        Menu menu = new Menu();
        menu.run();
    }
}

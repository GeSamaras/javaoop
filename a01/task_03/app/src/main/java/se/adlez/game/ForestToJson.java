package se.adlez.game;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;


public class ForestToJson {
    public static String toJson(Forest forest) {
        Gson gson = new Gson();
        return gson.toJson(forest);
    }

    public static void saveAsJson(Forest forest, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(toJson(forest));
            System.out.println("Saved JSON data to '" + fileName + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
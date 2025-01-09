package se.choccy.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ForestToFile {
    public static void save(Forest forest, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(forest);
            System.out.println("Saved serialized forest to file '" + fileName + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Forest load(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Forest forest = (Forest) ois.readObject();
            System.out.println("Loaded serialized forest from file '" + fileName + "'.");
            return forest;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
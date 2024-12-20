/**
 * Show how a path can be constructed to point out a file resources.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializeMain {
    
    public static void main(String[] args) 
        throws FileNotFoundException, IOException
    {
        Path path = Paths.get("data", "serialize.data");
        Person mik = new Person("Mikael", "Roos", 42);

        // Serialize and write to file
        try (
            FileOutputStream file = new FileOutputStream(path.toString());
            ObjectOutputStream out = new ObjectOutputStream(file);
        ) {  
            // Method for serialization of object into a file
            out.writeObject(mik);
            System.out.println("Object has been serialized in " + path);
        } catch (IOException ex) {
            System.out.println("IOException is caught " + ex);
        }

        // Deserialization
        Person doe = new Person();
        try (
            FileInputStream file = new FileInputStream(path.toString());
            ObjectInputStream in = new ObjectInputStream(file);
        ) {
            // Method for deserialization of object from file
            doe = (Person) in.readObject();
            System.out.println("Object has been deserialized ");
            System.out.println(doe);
        } catch(IOException ex) {
            System.out.println("IOException is caught " + ex);
        } catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}


class Person implements Serializable {
    public String firstName;
    public String lastName;
    public int age;

    Person () {

    }

    Person (String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " (" + age + ")";
    }
}

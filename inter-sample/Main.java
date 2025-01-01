/* Interfaces serve as small lego blocks in which,
 * if a class wants to use that interface, they
 * must build off of those blocks
*/

// Define an interface
interface Animal {
    void eat(); // abstract method
}

/* The purpose of interfaces is to standardize what,
 * and how other classes should be behave/build.
 * Interfaces are used so multiple classes can
 * inherite functionalities, even if they're not
 * related. 
*/






/* Abstract classes are used as a "foundation" for
 * other classes to utilize methods they share with
 * each other.
 * Abstract classes have "abstract methods" which
 * that their inheriting classes must implement,
 * and they have "concrete methods", that all classes
 * have access to. 
*/


// Define an abstract class
abstract class Mammal implements Animal {
    // Concrete method
    void breathe() {
        System.out.println("Breathing...");
    }

    // Abstract method
    abstract void makeSound();
}

/* So, the abstract class "Mammal" has access to
 * "eat()" from the "Animal" interface. And then
 * classes inheriting from "Mammal" will not only
 * have access to those abstract methods, but also
 * the interface made by "Animal"
*/


// Define a concrete class that extends the abstract class and implements the interface
class Dog extends Mammal {
    // Implement the interface's method
    public void eat() {
        System.out.println("Dog eats food.");
    }

    // Provide implementation for the abstract class's method
    void makeSound() {
        System.out.println("Dog barks.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Mammal myDog = new Dog(); // Polymorphism
        myDog.eat();              // Interface method
        myDog.breathe();          // Concrete method from abstract class
        myDog.makeSound();        // Abstract class method implementation
    }
}

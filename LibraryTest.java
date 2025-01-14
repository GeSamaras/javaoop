import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Author {
    private String name;
    public Author(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class Book {
    private String title;
    private int year;
    private DateTimeFormatter date;
    private String borrowerName;
    private Author author;

    public Book(String title, int year, Author author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }
    public void loanBook(Borrower borrower) {
        
    }
    public void returnBook() {

    }
    public String getTitle() {
        return title;
    }
}

class Borrower {
    private String name;
    private ArrayList<Book> books;
    public Borrower (String name) {
        this.name = name;
        books = new ArrayList<>();
    }
    public void addBook(Book book){

    }
    public void removeBook(Book book){

    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Borrower> borrowers = new ArrayList<>();
    public Book findBook(String title) {
        for (Book book: books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    public void borrowBook(Book books){

    }
}

abstract class Vehicle {
    private String name;
    private int speed;
    abstract public void move();
}

class Car extends Vehicle implements Repairable {
    private String fuelType;

    public void refuel() {

    }

    public void move() {

    }

    public void repair() {
        System.out.println("car repaired");
    }
}

interface Repairable {
    public void repair();
}
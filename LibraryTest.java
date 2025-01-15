import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

class Author {
    String name;

    // class constructor, which initializes the Author's name
    // whenever the Author object is called
    public Author(String name) {
        this.name = name;
    }

    // getter for when the name is needed somewhere in an object
    public String getAuthor() {
        return name;
    }
}

class Book {
    // all variables
    String title;
    int year;

    // new instances of objects to be used in Book
    Author author;
    Borrower currentBorrower;
    Date borrowDate;


    // constructor that points title, year and author to this class
    public Book (String title, int year, Author author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    // getters for title and author in case those need to be called
    public String getTitle(String title) {
        return this.title;
    }

    public String getAuthor(String author) {
        return author;
    }

    
    // instanciates Borrower and Date in the parameter of this method
    // if the object Borrower doesn't exist, then it becomes the new
    // borrower, and the date is added
    public void borrowBook(Borrower borrower, Date date) {
        if (this.currentBorrower == null) {
            this.currentBorrower = borrower;
            this.borrowDate = date;
        } else { System.out.println("already borrowed");}
    }
}

class Borrower {
    String name;
    // starts a new List which takes Books borrowed by this user
    List<Book> borrowedBooks;
 

    // constructor
    public Borrower(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void borrowedBooks(Book books, Date date) {
        if (borrowedBooks.contains(books)) {
            System.out.println("Already in list");
        } else {
            books.borrowBook(this, date);
            borrowedBooks.add(books);
        }
    }
}


class Library {
    List<Book> books;

    public Library() {
        this.books = new ArrayList<>();    
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(String title) {
        for(Book book: books) {
            if (book.getTitle(title).equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
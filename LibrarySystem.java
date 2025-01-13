import java.util.ArrayList;
import java.util.List;

class Author {
    private String name;
    private String getString() {
        return name;
    }

}

class Library {
    private List<Book> books = new ArrayList<>();
    private List<Borrower> borrowers = new ArrayList<>();
    Book book = new Book();

    public Book findBook(String title) {
        for (Book book: books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
    return null;
    }

    public void borrowBook(Book book) {

    }

}

class Book {
    private String title;
    private int year;
    private Author name;
    private boolean bookBorrowed = false;

    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public Author getAuthor() {
        return name;
    }
}

class Borrower {
    private String name;

}
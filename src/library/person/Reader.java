package library.person;

import library.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {
    private final int id;
    private final List<Book> borrowedBooks = new ArrayList<>(); // Composition: Reader "has a" list of borrowed books

    public Reader(String surname, String name, int id) {
        super(surname, name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return super.toString() + " (ID: " + id + ")";
    }
}

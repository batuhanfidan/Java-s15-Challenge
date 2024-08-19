package library.person;


import library.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person{
    private List<Book> books;

    public Author(String surname, String name, Book books) {
        super(surname, name);
        this.books = new ArrayList<>();
        this.books.add(books);
    }

    public void whoYouAre(String name, String surname) {
        System.out.println(name + surname);
    }

    public void newBook(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return "books=" + books +
                '}';
    }
}

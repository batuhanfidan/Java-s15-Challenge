package library;

import library.book.Book;
import library.person.Reader;

import java.util.*;

public class Library {
    private Map<String, List<Book>> books = new HashMap<>(); // Book name as the key, list of books as the value
    private Map<Integer, Reader> readers = new HashMap<>();
    private Set<Book> borrowedBooks = new HashSet<>();

    public void addBook(Book book) {
        books.computeIfAbsent(book.getBookName(), k -> new ArrayList<>())
                .add(book);
        System.out.println("Book added successfully: " + book.getBookName() + " (ID: " + book.getBookId() + ")");
    }

    public void removeBook(int bookId) {
        for (List<Book> bookCopies : books.values()) {
            Iterator<Book> iterator = bookCopies.iterator();
            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.getBookId() == bookId) {
                    iterator.remove();
                    if (bookCopies.isEmpty()) {
                        books.values().remove(bookCopies);
                    }
                    System.out.println("Book removed successfully: " + book.getBookName() + " (ID: " + book.getBookId() + ")");
                    return;
                }
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public void updateBook(int bookId, String newName, String newAuthor, double newPrice, String newEdition, String newCategory) {
        for (List<Book> bookCopies : books.values()) {
            for (Book book : bookCopies) {
                if (book.getBookId() == bookId) {
                    book.setBookName(newName);
                    book.setAuthor(newAuthor);
                    book.setPrice(newPrice);
                    book.setEdition(newEdition);
                    book.setCategory(newCategory);
                    System.out.println("Book updated successfully: " + book.getBookName());
                    return;
                }
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public Book selectBookById(int bookId) {
        for (List<Book> bookCopies : books.values()) {
            for (Book book : bookCopies) {
                if (book.getBookId() == bookId) {
                    return book;
                }
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
        return null;
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.println("Listing all books:");
        books.values().stream()
                .flatMap(List::stream)
                .forEach(book -> System.out.println("ID: " + book.getBookId() +
                        ", Name: " + book.getBookName() +
                        ", Author: " + book.getAuthor() +
                        ", Price: " + book.getPrice() +
                        ", Status: " + (book.isStatus() ? "Available" : "Not Available")));
    }

    public void listBooksByCategory(String category) {
        System.out.println("Listing books in category '" + category + "':");

        books.values().stream()
                .flatMap(List::stream)
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .forEach(book -> System.out.println("ID: " + book.getBookId() +
                        ", Name: " + book.getBookName() +
                        ", Author: " + book.getAuthor()));
    }


    public void authorBooks(String authorName) {
        System.out.println("Listing books by author '" + authorName + "':");

        books.values().stream()
                .flatMap(List::stream)
                .filter(book -> authorName.equalsIgnoreCase(book.getAuthor()))
                .forEach(book -> System.out.println("ID: " + book.getBookId() +
                        ", Name: " + book.getBookName()));
    }


    public Map<Integer, Reader> getReaders() {
        return readers;
    }

    public void addReader(Reader reader) {
        if (!readers.containsKey(reader.getId())) {
            readers.put(reader.getId(), reader);
            System.out.println("Reader added successfully.");
        } else {
            System.out.println("Reader with ID " + reader.getId() + " already exists.");
        }
    }

    public void borrowBook(Reader reader, String bookName) {
        if (reader.getBorrowedBooks().size() >= 5) {
            System.out.println("Book limit reached! Reader can't borrow more than 5 books.");
            return;
        }

        List<Book> bookCopies = books.get(bookName);
        if (bookCopies != null) {
            for (Book book : bookCopies) {
                if (book.isStatus() && !borrowedBooks.contains(book)) {
                    borrowedBooks.add(book);
                    book.setStatus(false);
                    reader.getBorrowedBooks().add(book);
                    System.out.println(reader.getName() + " borrowed " + book.getBookName());
                    issueInvoice(reader, book);
                    return;
                }
            }
            System.out.println("No available copies of the book: " + bookName);
        } else {
            System.out.println("The book is not available in the library. The person who borrow the book is" + reader);
        }
    }

    public void returnBook(Reader reader, String bookName, int bookId) {
        List<Book> bookCopies = books.get(bookName);
        if (bookCopies != null) {
            for (Book book : bookCopies) {
                if (book.getBookId() == bookId && borrowedBooks.contains(book)) {
                    borrowedBooks.remove(book);
                    book.setStatus(true);
                    reader.getBorrowedBooks().remove(book);
                    System.out.println(reader.getName() + " returned " + book.getBookName());
                    returnInvoice(reader, book);
                    return;
                }
            }
            System.out.println("This book was not borrowed or doesn't exist.");
        }
    }




    public void issueInvoice(Reader reader, Book book) {
        System.out.println("Invoice generated for " + reader.getName() + " for borrowing book: " + book.getBookName() + " for $" + book.getPrice());
    }

    public void returnInvoice(Reader reader, Book book) {
        System.out.println("Invoice generated for " + reader.getName() + " for returning book: " + book.getBookName() + " and refund of $" + book.getPrice());
    }
}

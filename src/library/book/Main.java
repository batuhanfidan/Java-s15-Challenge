package library;

import library.book.*;
import library.person.Reader;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Creating some Book objects
        Book book1 = new Journals(1, "Journal of AI Research", "John Doe", 50.0, true, "1st Edition", "Research", Type.GAME);
        Book book2 = new Magazine(2, "AI Monthly", "John Doe", 20.0, true, "2nd Edition", "Technology");
        Book book3 = new StudyBook(3, "Data Structures and Algorithms", "Alice Brown", 40.0, true, "3rd Edition", "Computer Science", Study.GEOMETRY);
        Book book4 = new StudyBook(4, "Data Structures and Algorithms", "Alice Brown", 40.0, true, "3rd Edition", "Computer Science", Study.GEOMETRY);

        // Adding books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        // Listing all books
        System.out.println("\nListing all books in the library:");
        library.listBooks();

        // Updating a book
        System.out.println("\nUpdating a book:");
        library.updateBook(2, "AI Weekly", "Jane Doe", 30.0, "3rd Edition", "AI");

        // Listing all books after update
        System.out.println("\nListing all books after update:");
        library.listBooks();

        // Creating a Reader and adding to the library
        Reader reader1 = new Reader("Doe", "John", 101);
        library.addReader(reader1);

        // Reader borrowing a book
        System.out.println("\nReader attempting to borrow a book:");
        library.borrowBook(reader1, "Journal of AI Research");

        // Reader reaching borrow limit
        for (int i = 0; i < 5; i++) {
            library.borrowBook(reader1, "Data Structures and Algorithms");
        }

        // Listing all books after borrowing
        System.out.println("\nListing all books after borrowing:");
        library.listBooks();

        // Returning a book
        System.out.println("\nReader attempting to return a book:");
        library.returnBook(reader1, "Journal of AI Research", 1);

        // Listing all books after returning
        System.out.println("\nListing all books after returning:");
        library.listBooks();

        // Searching for books by author
        System.out.println("\nListing books by author 'Alice Brown':");
        library.authorBooks("Alice Brown");

        // Searching for books by category
        System.out.println("\nListing books in 'Computer Science' category:");
        library.listBooksByCategory("Computer Science");

        // Removing a book from the library
        System.out.println("\nRemoving a book from the library:");
        library.removeBook(4);  // Removing a book by its ID

        // Listing all books after removal
        System.out.println("\nListing all books after removal:");
        library.listBooks();

        // Searching for books by a non-existent author
        System.out.println("\nListing books by author :");
        library.authorBooks("Alice Brown");

        // Searching for books in a non-existent category
        System.out.println("\nListing books in:");
        library.listBooksByCategory("Research");
    }
}

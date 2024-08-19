package library.book;

public class Magazine extends Book{

    private Type type;

    public Magazine(int bookId, String bookName, String author, double price, boolean status, String edition, String category) {
        super(bookId, bookName, author, price, status, edition, category);
    }

    @Override
    public void displayDetails() {

    }
}

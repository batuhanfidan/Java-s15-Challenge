package library.book;

public class Journals extends Book{

    private Type type;

    public Journals(int bookId, String bookName, String author, double price, boolean status, String edition, String category, Type type) {
        super(bookId, bookName, author, price, status, edition, category);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void displayDetails() {
        System.out.println(getBookId() + getBookName() + getAuthor() + getPrice());
    }

}

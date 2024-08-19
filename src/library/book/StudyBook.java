package library.book;

public class StudyBook extends Book{

    private Study Study;

    public StudyBook(int bookId, String bookName, String author, double price, boolean status, String edition, String category, library.book.Study study) {
        super(bookId, bookName, author, price, status, edition, category);
        Study = study;
    }

    @Override
    public void displayDetails() {

    }
}

package library.person;

import library.Library;

public class Librarian extends Person {
    private String password;

    public Librarian(String surname, String name, String password) {
        super(surname, name);
        this.password = password;
    }

    public void verifyMember(int readerId, Library library) {
        if (library.getReaders().containsKey(readerId)) {
            System.out.println("Member is registered in the library.");
        } else {
            System.out.println("The person is not registered in the library.");
        }
    }
}

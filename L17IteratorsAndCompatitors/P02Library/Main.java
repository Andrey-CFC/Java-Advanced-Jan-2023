package L17IteratorsAndCompatitors.P02Library;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 2002);
        Book bookThree = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        Library library = new Library(bookOne, bookTwo, bookThree);

        Iterator<Book> iterator = library.iterator();
        //начин 1
        for (Book book : library) {

            System.out.println(book.getTitle());
        }
        //начин 2
        while (iterator.hasNext()) {
            Book current = iterator.next();

            System.out.println(current.getTitle());
        }
        //начин 3
        library.forEach(book-> System.out.println(book.getTitle()));
    }
}

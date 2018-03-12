import db.DBAuthor;
import db.DBBook;
import models.Author;
import models.Book;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        DBAuthor.deleteAll();
        DBBook.deleteAll();

        Author author1 = new Author("John", "Niven");
        DBAuthor.saveAuthor(author1);

        Author author2 = new Author("Douglas", "Adams");
        DBAuthor.saveAuthor(author2);

        Book book1 = new Book("Kill Your Friends", author1);
        DBBook.saveBook(book1);

        Book book2 = new Book("The Hitchhiker's Guide to the Galaxy", author2);
        DBBook.saveBook(book2);

        book2.setTitle("The Hitchhiker's Guide to Eating Galaxies");
        DBBook.updateBook(book2);

        author1.setFirstName("J");
        DBAuthor.updateAuthor(author1);

        List<Book> books = DBBook.getBooks();

        List<Author> authors = DBAuthor.getAuthors();

    }

}

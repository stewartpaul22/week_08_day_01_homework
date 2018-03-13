import db.DBHelper;
import models.Author;
import models.Book;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        DBHelper.deleteAll("Author");
        DBHelper.deleteAll("Book");

        Author author1 = new Author("John", "Niven");
        DBHelper.save(author1);

        Author author2 = new Author("Douglas", "Adams");
        DBHelper.save(author2);

        Book book1 = new Book("Kill Your Friends", author1);
        DBHelper.save(book1);

        Book book2 = new Book("The Hitchhiker's Guide to the Galaxy", author2);
        DBHelper.save(book2);

        Book book3 = new Book("The Second Coming", author1);
        DBHelper.save(book3);

        book2.setTitle("The Hitchhiker's Guide to Eating Galaxies");
        DBHelper.update(book2);

        author1.setFirstName("J");
        DBHelper.update(author1);

        DBHelper.delete(book3);

        List<Book> books = DBHelper.getAll("Book");

        List<Author> authors = DBHelper.getAll("Author");

        List<Book> booksByAuthor1 = DBHelper.getBooks(author1.getId());

        List<Book> booksByAuthor2 = DBHelper.getBooks(author2.getId());

        Book foundBook = DBHelper.find(book1.getId(), "Book");

        Author foundAuthor = DBHelper.find(author1.getId(), "Author");

    }

}

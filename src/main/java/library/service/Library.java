package library.service;
import java.util.List;
import library.models.Book;

public interface Library {
    public Book getBook(int id);
    public void addBook(Book book);
    public List<Book> getAllBooks();
    public boolean editBook(int id, Book book);
    public boolean deleteBook(int id);
}

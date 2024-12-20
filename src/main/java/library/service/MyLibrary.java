package library.service;

import library.models.Book;

import java.util.List;


public class MyLibrary implements Library {

    @Override
    public Book getBook(int id) {
        for (Book book : getAllBooks()) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    @Override
    public void addBook(Book book) {
        int newBookId = generateNewBookId();
        book.setId(newBookId);
        MockGlobalStorage.addBook(book);
    }

    private int generateNewBookId() {
        List<Book> myBooks = getAllBooks();
        if (myBooks.isEmpty()) {
            return 1;
        }
        Book lastBook = myBooks.get(myBooks.size() - 1);
        return lastBook.getId() + 1;
    }

    @Override
    public List<Book> getAllBooks() {
        return MockGlobalStorage.getBooks();
    }

    @Override
    public boolean editBook(int id, Book book) {
        Book choosenBook = getBook(id);
        if (choosenBook == null) {
            return false;
        }
        boolean isDeleted = deleteBook(choosenBook.getId());
        if (isDeleted) {
            addBook(book);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
        Book book = getBook(id);
        if (book != null) {
            MockGlobalStorage.removeBook(book);
            return true;
        }
        return false;
    }
}
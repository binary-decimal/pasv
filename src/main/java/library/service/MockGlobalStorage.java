package library.service;

import library.models.Book;

import java.util.ArrayList;


class MockGlobalStorage {
    private static final ArrayList<Book> books = new ArrayList<>();

    static ArrayList<Book> getBooks() {
        return books;
    }

    static void addBook(Book book) {
        books.add(book);
    }

    static void removeBook(Book book) {
        books.remove(book);
    }
}


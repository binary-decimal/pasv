package library.models;

import library.enums.Genre;

public class Book {
    private int id;
    private String title;
    private String author;
    private int editionYear;
    private Genre genre;

    public Book(String title, String author, int editionYear, Genre genre) {
        this.title = title;
        this.author = author;
        this.editionYear = editionYear;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getEditionYear() {
        return editionYear;
    }

    public void setEditionYear(int editionYear) {
        this.editionYear = editionYear;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        System.out.println();
        String bookTemplate = "\"%s\", author: %s, \n genre: %s, year: %s, id: %s";
        return String.format(bookTemplate, title, author, genre, editionYear, id);
    }
}

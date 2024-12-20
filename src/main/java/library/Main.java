package library;

import library.enums.Genre;
import library.service.MyLibrary;
import library.models.Book;

import java.util.Scanner;

public class Main {
    // A flag to control the recursion.
    private static boolean continueSession = true;
    private static final Scanner userInput = new Scanner(System.in);
    private static final MyLibrary myLibrary = new MyLibrary();

    public static void main(String[] args) {

        // Adding initial books to the library
        myLibrary.addBook(new Book("Clean Code", "Bob", 2000, Genre.FANTASY));
        myLibrary.addBook(new Book("Dirty Code", "Jay", 500, Genre.COMEDY));

        // Start user interaction
        greet();
    }

    private static void greet() {
        while (continueSession) {
            String greeting = "\n Please choose your option: 1 See all books, 2 Delete book, 3 Add book, 4 Edit book, 5 Exit";
            System.out.println(greeting);
            String userChoice = userInput.nextLine();
            selectOption(userChoice);
        }
    }

    private static void selectOption(String option) {
        switch (option) {
            case "1" -> showAllBooks();
            case "2" -> letUserToDeleteBook();
            case "3" -> letUserToAddBook();
            case "4" -> letUserToModifyBook();
            case "5" -> {
                System.out.println("Exiting. Goodbye!");
                userInput.close();
                continueSession = false;
            }
            default -> {
                System.out.println("Sorry this option doesn't exist");
            }
        }
    }

    public static void showAllBooks() {
        for (Book book : myLibrary.getAllBooks()) {
            System.out.println(book);
        }
    }

    public static void letUserToDeleteBook() {
        int bookId = promptUserForBookId("Enter the ID of the book to delete:");

        boolean isDeleted = myLibrary.deleteBook(bookId);
        if (!isDeleted) {
            System.out.println("This id doesn't exist");
        }
        displayUpdatedBookList();
    }

    public static void letUserToModifyBook() {
        int bookId = promptUserForBookId("Enter the ID of the book to modify:");

        Book newDetails = getBookDetailsFromUser();

        boolean isEdited = myLibrary.editBook(bookId, newDetails);
        if (isEdited) {
            System.out.println("Thanks, here is the updated list:");
            showAllBooks();
        } else {
            System.out.println("This book doesn't exist.");
            letUserToModifyBook();
        }
    }

    public static void letUserToAddBook() {
        System.out.println("Please provide details for the new book:");
        Book newBook = getBookDetailsFromUser();

        myLibrary.addBook(newBook);
        System.out.println("Book added successfully.");
        displayUpdatedBookList();
    }

    private static int promptUserForBookId(String promptMessage) {
        System.out.println(promptMessage);
        showAllBooks();
        return getValidIntegerInput();
    }

    private static void displayUpdatedBookList() {
        System.out.println("Here is the updated book list:");
        showAllBooks();
    }

    private static Book getBookDetailsFromUser() {
        System.out.println("Please add the title:");
        String title = userInput.nextLine();

        System.out.println("Please add the author:");
        String author = userInput.nextLine();

        Genre genre = letUserChooseGenre();

        System.out.println("Please add the edition year:");
        int year = getValidIntegerInput();

        return new Book(title, author, year, genre);
    }

    public static Genre letUserChooseGenre() {
        System.out.println("Please choose a genre from the following list:");
        Genre.printAllGenres();

        int genreChoice = getValidIntegerInput();
        Genre selectedGenre = Genre.chooseGenreByNumber(genreChoice);

        if (selectedGenre == null) {
            System.out.println("Invalid genre choice. Please try again.");
            // Recursive call in case of invalid genre
            return letUserChooseGenre();
        }
        return selectedGenre;
    }

    private static int getValidIntegerInput() {
        while (!userInput.hasNextInt()) {
            System.out.println("That's not a valid number. Please enter a number:");
            userInput.next();
        }
        int validInput = userInput.nextInt();
        // Scanner fix: Consume the remaining newline character after the number
        userInput.nextLine();
        return validInput;
    }
}

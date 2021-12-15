package by.overone.hometask31.controller;

import by.overone.hometask31.entity.Book;
import by.overone.hometask31.exception.BookNotFoundException;
import by.overone.hometask31.service.IBookService;
import by.overone.hometask31.service.impl.BookService;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class BookController {

    private static final IBookService bookService = new BookService();

    public void mainMenu() {
        boolean flag = true;

        while (flag) {
            System.out.println("Select one of the following option:");
            System.out.println("1. Get all books");
            System.out.println("2. Get book by ...");
            System.out.println("3. Add book");
            System.out.println("4. Exit");

            int numberOfSelectedOption = selectNumber(1, 4);
            switch (numberOfSelectedOption) {
                case 1:
                    readAll();
                    break;
                case 2:
                    readBy();
                    break;
                case 3:
                    addBook();
                    break;
                case 4:
                    System.out.println("Bye-bye my dear friend");
                    flag = false;
                    break;
                default:
                    System.err.println("Something went wrong ..");
            }
        }
    }

    public void readAll() {
        List<Book> books = bookService.readAll();
        viewBooks(books);
        boolean flag = true;
        while (flag) {
            System.out.println("Select actions on books:");
            System.out.println("1. Update book");
            System.out.println("2. Delete book");
            System.out.println("3. Return to main menu");
            Scanner scanner = new Scanner(System.in);

            int selectNumber = selectNumber(1, 3);
            switch (selectNumber) {
                case 1:
                    System.out.println("Select updated book by ID: ");
                    int idFromUpdate = scanner.nextInt();
                    for (Book book : books) {
                        if (idFromUpdate == book.getId()) {
                            updateBook(book);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Select deleted book by ID: ");
                    int idFromDelete = scanner.nextInt();
                    deleteBook(idFromDelete);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    flag = false;
                    System.err.println("Something went wrong ..");
            }
        }
    }

    public void readBy() {
        System.out.println("Select a menu option");
        System.out.println("1. Read all books by author");
        System.out.println("2. Read a book by ID");
        System.out.println("3. Return to main menu");

        int selectNumber = selectNumber(1, 3);
        switch (selectNumber) {
            case 1:
                readByAuthor();
                break;
            case 2:
                readByID();
                break;
            case 3:
                break;
            default:
                System.err.println("Something went wrong ..");
        }
    }

    public void readByAuthor() {
        System.out.println("Enter author: ");
        String authorName = new Scanner(System.in).nextLine();
        List<Book> books = null;
        try {
            books = bookService.readByAuthor(authorName);
        } catch (BookNotFoundException e) {
            System.err.println(e.getMessage());
        }
        viewBooks(books);
    }

    public void readByID() {
        System.out.println("Enter ID of book: ");
        Scanner scanner = new Scanner(System.in);

        int idOfBook = -1;
        boolean flagNegativeNumber = true;
        do {
            if (!flagNegativeNumber) {
                System.out.println("Enter a number more than 0");
            }
            while (!scanner.hasNextInt()) {
                System.out.println("Enter a number ID of book!");
                scanner.nextLine();
            }
            idOfBook = scanner.nextInt();
            flagNegativeNumber = false;
        } while (idOfBook <= 0);
        Book book = bookService.readByID(idOfBook);
        if (book != null) {
            System.out.println("Requested book by ID is : " + book);
        } else {
            System.out.println("Requested book is not returned");
        }
    }

    public void updateBook(Book book) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the field to edit");
        System.out.print("Are you want to edit title? (Y/N)");
        char choice = scanner.nextLine().toUpperCase(Locale.ROOT).charAt(0);
        System.out.print("Enter new value: ");
        if (choice == 'Y') {
            book.setTitle(scanner.nextLine());
        }

        System.out.print("Are you want to edit author? (Y/N)");
        choice = scanner.nextLine().toUpperCase(Locale.ROOT).charAt(0);
        System.out.print("Enter new value: ");
        if (choice == 'Y') {
            book.setAuthor(scanner.nextLine());
        }

        System.out.print("Are you want to edit quantity? (Y/N)");
        choice = scanner.nextLine().toUpperCase(Locale.ROOT).charAt(0);
        System.out.print("Enter new value: ");
        if (choice == 'Y') {
            long quantity = 0;
            do {
                quantity = scanner.nextLong();
                if (quantity <= 0) {
                    System.out.println("Enter count more than 0");
                }
            } while (quantity <= 0);
            book.setQuantity(quantity);
        }
        if (bookService.updateBook(book)) {
            System.out.println("The book has been updated");
        } else {
            System.out.println("The book hasn`t been updated");
        }
    }

    public void deleteBook(int intId) {
        if (bookService.deleteBook(intId)) {
            System.out.println("The book with ID " + intId + " successful deleted");
        } else {
            System.err.println("The book with ID " + intId + " is not deleted");
        }
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        long id = 1;
        System.out.println("Please enter title: ");
        String title = scanner.nextLine();
        System.out.println("Please enter author: ");
        String author = scanner.nextLine();
        System.out.println("Please enter quantity: ");

        long quantity = -1;
        do {
            while (!scanner.hasNextLong()) {
                System.out.println("Enter number!");
            }
            quantity = scanner.nextLong();
            if (quantity < 0 ) {
                System.out.println("Enter correct quantity");
            }
        } while (quantity < 0);


        Book addedBook = bookService.addBook(new Book(id, title, author, quantity));
        if (addedBook.getId() != -1) {
            System.out.println("You will create the book: " + addedBook);
        } else {
            System.err.println("The book not added");
        }
    }

    private void viewBooks(List<Book> books) {
        if (books != null) {
            int counter = 1;
            for (Book book : books) {
                System.out.println(counter + ". " + book);
                counter++;
            }
        }
    }

    private int selectNumber(int initialInt, int finiteNumber) {
        Scanner scanner = new Scanner(System.in);

        int intOption = -1;
        boolean flagEnteredNumber = false;
        do {
            if (flagEnteredNumber) {
                System.out.println("Enter a number between " + initialInt + " and " + finiteNumber);
            }
            while (!scanner.hasNextInt()) {
                System.out.println("Enter a number");
                scanner.nextLine();
            }
            intOption = scanner.nextInt();
            flagEnteredNumber = true;
        } while (intOption < initialInt || intOption > finiteNumber);
        return intOption;
    }
}

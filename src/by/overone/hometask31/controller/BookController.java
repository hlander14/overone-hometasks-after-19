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
            System.out.println("Select one of the following option:\n");
            System.out.println("1. Get all books");
            System.out.println("2. Get book by author");
            System.out.println("3. Add book");
            System.out.println("4. Exit");
            int result = new Scanner(System.in).nextInt();
            switch (result) {
                case 1:
                    readAll();
                    break;
                case 2:
                    readByAuthor();
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
            System.out.println("Select one of the following book:");
            System.out.println("1. Update book");
            System.out.println("2. Delete book");
            System.out.println("3. Exit table editing mode");
            Scanner scanner = new Scanner(System.in);
            int bookId = scanner.nextInt();
            switch (bookId) {
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

    public void updateBook(Book book) {
        Book bookToEdit = book;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the field to edit");
        System.out.print("Are you want to edit title? (Y/N)");
        char choice = scanner.nextLine().toUpperCase(Locale.ROOT).charAt(0);
        System.out.print("Enter new value: ");
        if (choice == 'Y') {
            bookToEdit.setTitle(scanner.nextLine());
        }

        System.out.print("Are you want to edit author? (Y/N)");
        choice = scanner.nextLine().toUpperCase(Locale.ROOT).charAt(0);
        System.out.print("Enter new value: ");
        if (choice == 'Y') {
            bookToEdit.setAuthor(scanner.nextLine());
        }

        System.out.print("Are you want to edit author? (Y/N)");
        choice = scanner.nextLine().toUpperCase(Locale.ROOT).charAt(0);
        System.out.print("Enter new value: ");
        if (choice == 'Y') {
            bookToEdit.setQuantity(scanner.nextLong());
        }
        bookService.updateBook(bookToEdit);
    }

    public void deleteBook(int intId) {
        bookService.deleteBook(intId);
    }

    public void addBook() {
        List<Book> books = bookService.readAll();
        long maxId = 0;
        for (Book book : books) {
            if (maxId < book.getId()) {
                maxId = book.getId();
            }
        }

        Scanner scanner = new Scanner(System.in);
        Long id = maxId + 1;
        System.out.println("Next entry will be with id: " + id);
        System.out.println("Please enter title: ");
        String title = scanner.nextLine();
        System.out.println("Please enter author: ");
        String author = scanner.nextLine();
        System.out.println("Please enter quantity: ");
        Long quantity = scanner.nextLong();

        Book book = new Book(id, title, author, quantity);
        if (!bookService.addBook(book)) {
            System.err.println("The book not added");
        }
    }

    public void readByAuthor() {
        System.out.println("Write author: ");
        String authorName = new Scanner(System.in).nextLine();
        List<Book> books = null;
        try {
            books = bookService.readByAuthor(authorName);
        } catch (BookNotFoundException e) {
            System.err.println(e.getMessage());
        }
        viewBooks(books);
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
}

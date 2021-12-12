package by.overone.lesson31.controller;

import by.overone.lesson31.entity.Book;
import by.overone.lesson31.exception.BookNotFoundException;
import by.overone.lesson31.service.IBookService;
import by.overone.lesson31.service.impl.BookService;

import java.util.List;
import java.util.Scanner;

public class BookController {

    private static final IBookService bookService = new BookService();

    public void mainMenu() {
        boolean flag = true;

        while (flag) {
            System.out.println("Select one of the following option:\n");
            System.out.println("1. Get all books");
            System.out.println("2. Get book by author");
            System.out.println("3. Add book"); // TODO
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
        System.out.println("Select one of the following book:");
        int bookId = new Scanner(System.in).nextInt();
        System.out.println("1. Update book");
        System.out.println("2. Delete book");
        System.out.println("3. Exit");
        boolean flag = true;
        while (flag) {
            switch (bookId) {
                case 1:
                    updateBook(bookId);
                    break;
                case 2:
                    deleteBook(bookId);
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

    public void updateBook(int bookId) {
        // TODO
    }

    public void deleteBook(int bookId) {
        // TODO
    }

    public void addBook() {
        // TODO
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

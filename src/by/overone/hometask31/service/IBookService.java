package by.overone.hometask31.service;

import by.overone.hometask31.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> readAll();

    List<Book> readByAuthor(String authorName);

    Book readByID(int idOfBook);

    Book addBook(Book book);

    boolean deleteBook(int idFromDelete);

    boolean updateBook(Book bookToUpdate);
}

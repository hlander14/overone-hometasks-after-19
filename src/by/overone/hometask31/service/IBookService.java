package by.overone.hometask31.service;

import by.overone.hometask31.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> readAll();

    List<Book> readByAuthor(String authorName);

    boolean addBook(Book book);

    void deleteBook(int idFromDelete);

    void updateBook(Book bookToUpdate);
}

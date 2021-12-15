package by.overone.hometask31.repository;

import by.overone.hometask31.entity.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> readAll();

    List<Book> readByAuthor(String authorName);

    Book readByID(int idOfBook);

    int addBook(Book book);

    boolean deleteBook(int idFromDelete);

    boolean updateBook(Book bookToUpdate);
}

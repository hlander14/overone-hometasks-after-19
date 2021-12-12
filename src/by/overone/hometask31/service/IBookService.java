package by.overone.lesson31.service;

import by.overone.lesson31.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> readAll();

    List<Book> readByAuthor(String authorName);
}

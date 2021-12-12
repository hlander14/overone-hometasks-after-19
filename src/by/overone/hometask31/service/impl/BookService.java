package by.overone.hometask31.service.impl;

import by.overone.hometask31.entity.Book;
import by.overone.hometask31.exception.BookNotFoundException;
import by.overone.hometask31.repository.IBookRepository;
import by.overone.hometask31.repository.impl.BookRepository;
import by.overone.hometask31.service.IBookService;

import java.util.List;

public class BookService implements IBookService {

    private static final IBookRepository bookRepository = new BookRepository();

    @Override
    public List<Book> readAll() {
        return bookRepository.readAll();
    }

    @Override
    public List<Book> readByAuthor(String authorName) {
        List<Book> books = bookRepository.readByAuthor(authorName);
        if (books.size() == 0) {
            throw new BookNotFoundException("Invalid author");
        }
        return books;
    }

    @Override
    public boolean addBook(Book book) {
        return bookRepository.addBook(book);
    }

    @Override
    public void deleteBook(int idFromDelete) {
        bookRepository.deleteBook(idFromDelete);
    }

    @Override
    public void updateBook(Book bookToUpdate) {
        bookRepository.updateBook(bookToUpdate);
    }
}

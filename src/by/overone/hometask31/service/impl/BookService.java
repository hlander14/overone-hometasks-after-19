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
    public Book readByID(int idOfBook) {
        return bookRepository.readByID(idOfBook);
    }

    @Override
    public Book addBook(Book book) {
        int returnedID;
        Book bookById = null;
        if ((returnedID = bookRepository.addBook(book)) != -1) {
            bookById = bookRepository.readByID(returnedID);
            if (bookById != null) {
                return bookById;
            }
        }
        return new Book(-1L, "", "", 0L);
    }

    @Override
    public boolean deleteBook(int idFromDelete) {
        return bookRepository.deleteBook(idFromDelete);
    }

    @Override
    public boolean updateBook(Book bookToUpdate) {
        return bookRepository.updateBook(bookToUpdate);
    }
}

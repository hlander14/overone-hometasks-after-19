package by.overone.hometask31.repository.impl;

import by.overone.hometask31.entity.Book;
import by.overone.hometask31.repository.IBookRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    String driverSQL = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/book_schema";
    String username = "user";
    String password = "123";

    @Override
    public List<Book> readAll() {
        List<Book> books = new ArrayList<>();
        try {
            Class.forName(driverSQL);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM book_schema.books");
            while (resultSet.next()) {
                Long bookId = Long.valueOf(resultSet.getString(1));
                String title = resultSet.getString(2);
                String author = resultSet.getString(3);
                Long quantity = Long.valueOf(resultSet.getString(4));
                books.add(new Book(bookId, title, author, quantity));
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> readByAuthor(String authorName) {
        List<Book> books = new ArrayList<>();
        try {
            Class.forName(driverSQL);
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM book_schema.books WHERE author = ?");
            preparedStatement.setString(1, authorName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long bookId = Long.valueOf(resultSet.getString(1));
                String title = resultSet.getString(2);
                String author = resultSet.getString(3);
                Long quantity = Long.valueOf(resultSet.getString(4));
                books.add(new Book(bookId, title, author, quantity));
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public boolean addBook(Book bookToAdd) {
        try {
            Class.forName(driverSQL);
            Connection connection = DriverManager.getConnection(url, username, password);

            String sqlString = "INSERT INTO book_schema.books (id, title, author, quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sqlString);
            preparedStatement.setInt(1, bookToAdd.getId().intValue());
            preparedStatement.setString(2, bookToAdd.getTitle());
            preparedStatement.setString(3, bookToAdd.getAuthor());
            preparedStatement.setInt(4, bookToAdd.getQuantity().intValue());
            preparedStatement.execute();
            connection.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteBook(int idFromDelete) {
        try {
            Class.forName(driverSQL);
            Connection connection = DriverManager.getConnection(url, username, password);

            String sqlString = "DELETE FROM book_schema.books WHERE id=?";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sqlString);
            preparedStatement.setInt(1, idFromDelete);
            preparedStatement.execute();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBook(Book bookToUpdate) {
        try {
            Class.forName(driverSQL);
            Connection connection = DriverManager.getConnection(url, username, password);

            String sqlString = "UPDATE book_schema.books SET title = ?, author = ?, quantity = ? WHERE id = ?";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sqlString);
            preparedStatement.setString(1, bookToUpdate.getTitle());
            preparedStatement.setString(2, bookToUpdate.getAuthor());
            preparedStatement.setInt(3, bookToUpdate.getQuantity().intValue());
            preparedStatement.setInt(4, bookToUpdate.getId().intValue());
            preparedStatement.execute();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

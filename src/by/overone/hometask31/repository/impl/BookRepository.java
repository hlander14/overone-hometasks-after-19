package by.overone.hometask31.repository.impl;

import by.overone.hometask31.entity.Book;
import by.overone.hometask31.repository.IBookRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    public static final String DRIVER_SQL = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/book_schema";
    public static final String USERNAME = "user";
    public static final String PASSWORD = "123";

    @Override
    public List<Book> readAll() {
        Connection connection = null;
        List<Book> books = new ArrayList<>();
        try {
            Class.forName(DRIVER_SQL);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM book_schema.books");
            while (resultSet.next()) {
                Long bookId = Long.valueOf(resultSet.getString(1));
                String title = resultSet.getString(2);
                String author = resultSet.getString(3);
                Long quantity = Long.valueOf(resultSet.getString(4));
                books.add(new Book(bookId, title, author, quantity));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public List<Book> readByAuthor(String authorName) {
        Connection connection = null;
        List<Book> books = new ArrayList<>();
        try {
            Class.forName(DRIVER_SQL);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public Book readByID(int idOfBook) {
        Connection connection = null;
        Book bookByID = null;
        try {
            Class.forName(DRIVER_SQL);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM book_schema.books WHERE id = ?");
            preparedStatement.setInt(1, idOfBook);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long bookId = Long.valueOf(resultSet.getString(1));
                String title = resultSet.getString(2);
                String author = resultSet.getString(3);
                Long quantity = Long.valueOf(resultSet.getString(4));
                bookByID = new Book(bookId, title, author, quantity);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookByID;
    }

    @Override
    public int addBook(Book bookToAdd) {
        Connection connection = null;
        try {
            Class.forName(DRIVER_SQL);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sqlString = "INSERT INTO book_schema.books (title, author, quantity) VALUES (?, ?, ?)";
            String[] columnNames = new String[] { "id" };
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sqlString, columnNames);
            preparedStatement.setString(1, bookToAdd.getTitle());
            preparedStatement.setString(2, bookToAdd.getAuthor());
            preparedStatement.setInt(3, bookToAdd.getQuantity().intValue());

            if (preparedStatement.executeUpdate() > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if ( generatedKeys.next() ) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public boolean deleteBook(int idFromDelete) {
        Connection connection = null;
        boolean flagCorrectEnd = false;
        try {
            Class.forName(DRIVER_SQL);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sqlString = "DELETE FROM book_schema.books WHERE id=?";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sqlString);
            preparedStatement.setInt(1, idFromDelete);
            flagCorrectEnd = preparedStatement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flagCorrectEnd;
    }

    @Override
    public boolean updateBook(Book bookToUpdate) {
        Connection connection = null;
        boolean flagCorrectEnd = false;
        try {
            Class.forName(DRIVER_SQL);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sqlString = "UPDATE book_schema.books SET title = ?, author = ?, quantity = ? WHERE id = ?";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sqlString);
            preparedStatement.setString(1, bookToUpdate.getTitle());
            preparedStatement.setString(2, bookToUpdate.getAuthor());
            preparedStatement.setInt(3, bookToUpdate.getQuantity().intValue());
            preparedStatement.setInt(4, bookToUpdate.getId().intValue());
            preparedStatement.execute();
            flagCorrectEnd = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flagCorrectEnd;
    }
}

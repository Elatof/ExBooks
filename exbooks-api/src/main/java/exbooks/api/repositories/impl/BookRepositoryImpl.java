package exbooks.api.repositories.impl;


import exbooks.api.ConnectionManager;
import exbooks.api.entities.BookEntity;
import exbooks.api.repositories.BookRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private static final String SELECT_ALL = "SELECT * FROM public.book";

    private static final String CREATE =
            "INSERT INTO public.book (\"name\",\"genre\",\"description\",\"author\",\"year\")\n" +
                    "VALUES(?,?,?,?,?) RETURNING id;";


    @Override
    public List<BookEntity> selectAll() throws SQLException {
        List<BookEntity> entities = new ArrayList<>();
        try (
                Connection connection = ConnectionManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL)
        ) {
            while (resultSet.next()) {
                entities.add(parseResultSet(resultSet));
            }
        } catch (SQLException e) {//не тре
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public BookEntity findById(Integer id) throws SQLException {  //TODO
        return null;
    }

    @Override
    public BookEntity insert(BookEntity entity) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection(); PreparedStatement statement = connection.prepareStatement(CREATE)) {
            setPreparedStatementData(statement, entity);
            try (ResultSet generatedKeys = statement.executeQuery()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                }
            }
        }

        return entity;
    }

    @Override
    public int update(BookEntity entity) throws SQLException {  //TODO
        return 0;
    }

    @Override
    public int delete(BookEntity entity) throws SQLException {  //TODO
        return 0;
    }

    private BookEntity parseResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String genre = resultSet.getString("genre");
        String description = resultSet.getString("description");
        String author = resultSet.getString("author");
        LocalDate year =  resultSet.getDate("year").toLocalDate();
        return new BookEntity(id, name, genre, description, author, year);
    }

    private void setPreparedStatementData(PreparedStatement statement, BookEntity entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getGenre());
        statement.setString(3, entity.getDescription());
        statement.setString(4, entity.getAuthor());
        statement.setDate(5, Date.valueOf(entity.getYear()));
}

}
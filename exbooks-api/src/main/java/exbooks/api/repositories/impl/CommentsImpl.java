package exbooks.api.repositories.impl;

import exbooks.api.ConnectionManager;
import exbooks.api.entities.Comment;
import exbooks.api.repositories.CommentsRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentsImpl implements CommentsRepository {

    @Override
    public int update(int idBook, int idComment)throws SQLException {
        Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             int resultSet = statement.executeUpdate("UPDATE public.comment SET  accept=false WHERE book_id=21 and id=3;");

        return resultSet;
    }

    @Override
    public List<Comment> get(int id) throws SQLException {
        List<Comment> comments=new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT  c.id, u.email, c.comment, c.announce_timestamp,c.accept FROM public.comment  c JOIN public.user u ON  c.user_id=u.id WHERE c.book_id="+id);
             )
        { while (resultSet.next()) {
            comments.add(parseResultSet(resultSet));
        }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
    private Comment parseResultSet(ResultSet resultSet) throws SQLException {
        Comment com = new Comment();

        com.setId(resultSet.getInt("id"));
        com.setUser(resultSet.getString("email"));
        com.setComment(resultSet.getString("comment"));
        com.setTimestamp((resultSet.getString("announce_timestamp")));
        if(resultSet.getBoolean("accept"))
            com.setAccept("+");
        else com.setAccept("-");
        return com;
    }

}

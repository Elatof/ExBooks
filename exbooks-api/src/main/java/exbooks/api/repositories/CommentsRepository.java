package exbooks.api.repositories;

import exbooks.api.entities.Comment;
import exbooks.api.models.CommentAdd;

import java.util.List;

public interface CommentsRepository {
    boolean check (int idComment)throws ClassNotFoundException, Exception;
    CommentAdd insert (CommentAdd comment) throws ClassNotFoundException, Exception;
    List<Comment> get (int id) throws ClassNotFoundException, Exception;
    int update ( int idComment) throws ClassNotFoundException, Exception;
    int updateBook (int idComment) throws ClassNotFoundException, Exception;
}

package exbooks.api.repositories;

import exbooks.api.entities.Comment;

import java.util.List;

public interface CommentsRepository {
    List<Comment> get (int id) throws ClassNotFoundException, Exception;
}
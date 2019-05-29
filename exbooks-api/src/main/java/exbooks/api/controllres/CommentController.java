package exbooks.api.controllres;

import exbooks.api.entities.Comment;
import exbooks.api.entities.Details;
import exbooks.api.models.*;
import exbooks.api.repositories.impl.CommentsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CommentController {
    @Autowired
    CommentsImpl CommentsRepository;

    @PostMapping("/api/comment/{idBook}/register")
    public CommentRegResponse register(@RequestBody CommentRegRequest regRequest, @PathVariable int idBook) throws Exception {
        System.out.println("228"+idBook);
        CommentAdd newComment=new CommentAdd();
    newComment.setBook_id(idBook);
    newComment.setUser_id(24);
    newComment.setAccept(false);
    LocalDateTime now = LocalDateTime.now();
    newComment.setAnnounce_timestamp(now);
    newComment.setComment(regRequest.getComment());
    CommentAdd insertedComment= CommentsRepository.insert(newComment);


    CommentRegResponse regResponse = new CommentRegResponse();
    regResponse.setId(insertedComment.getId());
        return regResponse;
    }
    @GetMapping(value = "/api/books/Comments/{idBook}/comment")
    public ResponseEntity<List<Comment>> comment(@PathVariable int idBook) throws SQLException {
        System.out.println("idbook="+idBook);
       // int a = CommentsRepository.update(21,3);
        List<Comment> comments = CommentsRepository.get(idBook);
        if(comments.isEmpty()){
            comments.add(NoComment());
        }

        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    public Comment NoComment(){

        Comment not=new Comment();
        not.setId(666);
        not.setUser("No comments");
        not.setAccept("----");
        not.setComment("----");
        not.setTimestamp("----");
        return not;
    }
}

package exbooks.api.controllres;

import exbooks.api.entities.Comment;
import exbooks.api.entities.Details;
import exbooks.api.repositories.impl.CommentsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CommentController {
    @Autowired
    CommentsImpl CommentsRepository;


    @GetMapping(value = "/api/books/Comments/{idBook}/comment")
    public ResponseEntity<List<Comment>> comment(@PathVariable int idBook) throws SQLException {
        System.out.println("idbook="+idBook);
        List<Comment> comments= CommentsRepository.get(idBook);
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
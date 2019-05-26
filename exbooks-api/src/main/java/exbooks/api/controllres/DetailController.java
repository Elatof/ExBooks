package exbooks.api.controllres;

import exbooks.api.entities.BookEntity;
import exbooks.api.entities.Details;
import exbooks.api.repositories.impl.DetailRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;

@RestController
@CrossOrigin
public class DetailController {
    @Autowired
    DetailRepositoryImpl detailRepository;

    @GetMapping(value = "/api/books/{Id}/details")
    public ResponseEntity<Details> details(@PathVariable int Id) throws SQLException {
        Details det;
        System.out.println("id="+Id);

        det=detailRepository.getBook(Id);

        System.out.println(det.toString());
        return new ResponseEntity<>(det, HttpStatus.OK);
    }
}

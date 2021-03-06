package exbooks.api.controllres;

import exbooks.api.entities.AnnounceBoardEntity;
import exbooks.api.entities.BookEntity;
import exbooks.api.models.AnnounceAddRequest;
import exbooks.api.models.AnnounceAddResponse;
import exbooks.api.models.AnnounceDataResponse;
import exbooks.api.repositories.impl.AnnounceBoardRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
public class ListController {
    @Autowired
    AnnounceBoardRepositoryImpl announceBoardRepository;



    @GetMapping(value = "/api/announce")
    public ResponseEntity<List<AnnounceDataResponse>> getAllUsers() throws SQLException {
        List<AnnounceDataResponse> announceBoardEntities = announceBoardRepository.selectAll2();
        return new ResponseEntity<>(announceBoardEntities, HttpStatus.OK);
    }

}
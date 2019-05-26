package exbooks.api.controllres;


import exbooks.api.entities.AnnounceBoardEntity;
import exbooks.api.entities.BookEntity;
import exbooks.api.models.BookRegRequest;
import exbooks.api.models.BookRegResponse;
import exbooks.api.repositories.BookRepository;
import exbooks.api.repositories.impl.AnnounceBoardRepositoryImpl;
import exbooks.api.repositories.impl.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@CrossOrigin
public class BookController {

    private final BookRepository bookRepository;
    @Autowired
    AnnounceBoardRepositoryImpl announceBoardRepository;
    public BookController() {
        this.bookRepository = new BookRepositoryImpl();
    }
    @PostMapping("/api/book/register")
    public BookRegResponse register(@RequestBody BookRegRequest regRequest) throws Exception {
        BookEntity newBook= new BookEntity();
        newBook.setName(regRequest.getName());
        newBook.setAuthor(regRequest.getAuthor());
        newBook.setGenre(regRequest.getGenre());
        newBook.setYear(regRequest.getYear());
        newBook.setDescription(regRequest.getDescription());


        BookEntity insertedBook=this.bookRepository.insert(newBook);
        BookRegResponse regResponse= new BookRegResponse();
        regResponse.setBookId(insertedBook.getId());
        //ListController a =new ListController();
        add_to_board(insertedBook);


        return regResponse;
    }
    public AnnounceBoardEntity add_to_board(BookEntity entity)throws Exception{
        AnnounceBoardEntity new_book= new AnnounceBoardEntity();
        new_book.setUserId(23);
        new_book.setBookId(entity.getId());
        LocalDateTime now = LocalDateTime.now();
        new_book.setAnnounceTimestamp(now);
        AnnounceBoardEntity inserted_element=this.announceBoardRepository.insert(new_book);
        return new_book;
    }
}

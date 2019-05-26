package exbooks.api.repositories;

import exbooks.api.entities.BookEntity;
import exbooks.api.entities.Details;

public interface DetailRepository {
     Details getBook (int id) throws ClassNotFoundException, Exception;
}

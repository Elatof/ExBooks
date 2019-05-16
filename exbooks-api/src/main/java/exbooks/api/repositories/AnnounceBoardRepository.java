
package exbooks.api.repositories;



import exbooks.api.entities.AnnounceBoardEntity;
import exbooks.api.models.AnnounceDataResponse;

import java.sql.SQLException;
import java.util.List;

public interface AnnounceBoardRepository extends GeneralRepository<AnnounceBoardEntity,Integer>{

    List<AnnounceDataResponse> selectAll2() throws SQLException;
}
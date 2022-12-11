package mm.com.mingalarcinema.movieticketing.database.repo;

import mm.com.mingalarcinema.movieticketing.database.model.Theatre;
import mm.com.mingalarcinema.movieticketing.payload.response.TheatreShort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface TheatreRepo extends JpaRepository<Theatre, String> {

    @Query(value = "SELECT a from Theatre a where a.theatreId in :idList")
    List<Theatre> getTheatres(Set<String> idList);

    @Query(value = "select t.theatreId as id, t.theatreName as name from Theatre t where t.theatreId in :idList")
    List<TheatreShort> getTheatreShortList(List<String> idList);
}

package mm.com.mingalarcinema.movieticketing.database.repo;

import mm.com.mingalarcinema.movieticketing.database.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, String> {

    @Query(value = "select * from ob_movie where movie_type = 'NOW_SHOWING' order by movie_priority", nativeQuery = true)
    List<Movie> getNowShowingMovies();
}

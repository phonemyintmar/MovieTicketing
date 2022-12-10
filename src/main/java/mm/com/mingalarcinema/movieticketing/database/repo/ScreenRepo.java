package mm.com.mingalarcinema.movieticketing.database.repo;

import mm.com.mingalarcinema.movieticketing.database.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepo extends JpaRepository<Screen, String> {

    List<Screen> getScreensByMovieId(String movieId);
}

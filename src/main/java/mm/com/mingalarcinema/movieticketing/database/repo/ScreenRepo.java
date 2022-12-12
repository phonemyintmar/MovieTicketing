package mm.com.mingalarcinema.movieticketing.database.repo;

import mm.com.mingalarcinema.movieticketing.database.model.Screen;
import mm.com.mingalarcinema.movieticketing.payload.response.ScreenAndThreatreName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ScreenRepo extends JpaRepository<Screen, String> {

    @Query(value = "select os.screen_name || ' | ' || ot.theatre_name || CHR(10) || ot.address from ob_screen os, ob_theatre ot " +
            "where os.screen_id = :s and os.theatre_id = ot.theatre_id", nativeQuery = true)
    Optional<String> getScreenName(String s);
}

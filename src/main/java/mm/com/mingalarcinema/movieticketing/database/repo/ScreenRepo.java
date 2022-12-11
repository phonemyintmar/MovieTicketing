package mm.com.mingalarcinema.movieticketing.database.repo;

import mm.com.mingalarcinema.movieticketing.database.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ScreenRepo extends JpaRepository<Screen, String> {

}

package mm.com.mingalarcinema.movieticketing.database.repo;

import mm.com.mingalarcinema.movieticketing.database.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookingRepo extends JpaRepository<Booking, String> {

    @Query(value = "select screen_id from ob_booking where show_id = :showId", nativeQuery = true)
    Optional<String> getscreenId(String showId);
}

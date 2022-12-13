package mm.com.mingalarcinema.movieticketing.database.repo;

import mm.com.mingalarcinema.movieticketing.database.model.Show;
import mm.com.mingalarcinema.movieticketing.payload.response.ShowsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShowRepo extends JpaRepository<Show, String> {

    @Query(value = "select os.show_time as showTime, " +
            " os.show_date as showDate, " +
            " os.is3d as is3d, " +
            " os.total_available_seats as totalAvailableSeats, " +
            " os.total_taken_seats as totalTakenSeats, " +
            " ot.theatre_name as theatreName " +
            " from ob_show os, ob_theatre ot " +
            " where os.movie_id = :movieId " +
            " and os.theatre_id = ot.theatre_id " +
            " order by ot.theatre_popularity desc", nativeQuery = true)
    List<ShowsResponse> getShowsByMovieId(String movieId);

    @Query(value = "select screen_id from ob_show where show_id = :showId", nativeQuery = true)
    Optional<String> getscreenId(String showId);

    @Query(value = "select show_key from ob_show where show_id = :showId", nativeQuery = true)
    Optional<String> getShowKey(String showId);
}

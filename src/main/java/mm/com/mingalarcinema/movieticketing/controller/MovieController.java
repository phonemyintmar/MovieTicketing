package mm.com.mingalarcinema.movieticketing.controller;

import mm.com.mingalarcinema.movieticketing.database.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/movie")
public class MovieController {

    @GetMapping("")
    public ResponseEntity<?> getMovies() {
        Movie movie = new Movie();
        return ResponseEntity.ok(movie);
    }
}

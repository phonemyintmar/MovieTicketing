package mm.com.mingalarcinema.movieticketing.controller;

import mm.com.mingalarcinema.movieticketing.database.model.Movie;
import mm.com.mingalarcinema.movieticketing.database.repo.MovieRepo;
import mm.com.mingalarcinema.movieticketing.database.repo.TheatreRepo;
import mm.com.mingalarcinema.movieticketing.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    private final MovieRepo movieRepo;

    private final TheatreRepo theatreRepo;

    public MovieController(MovieService movieService, MovieRepo movieRepo, TheatreRepo theatreRepo) {
        this.movieService = movieService;
        this.movieRepo = movieRepo;
        this.theatreRepo = theatreRepo;
    }

    @GetMapping("")
    public ResponseEntity<?> getMovies() {
        List<Movie> movieList = movieRepo.findAll();
        if (movieList.isEmpty()) return ResponseEntity.badRequest().body("ma shi wo ");
        return ResponseEntity.ok(movieList);
    }

    @GetMapping("test")
    public ResponseEntity<?> testingMethod() {
        Set<String> set = new HashSet<>();
        set.add("ab");
        set.add("ef");

        return ResponseEntity.ok(theatreRepo.getTheatres(set));
    }
}

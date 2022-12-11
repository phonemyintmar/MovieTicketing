package mm.com.mingalarcinema.movieticketing.service.implementations;

import lombok.extern.slf4j.Slf4j;
import mm.com.mingalarcinema.movieticketing.database.model.Movie;
import mm.com.mingalarcinema.movieticketing.database.repo.MovieRepo;
import mm.com.mingalarcinema.movieticketing.payload.response.BaseResponse;
import mm.com.mingalarcinema.movieticketing.payload.response.ResponseCode;
import mm.com.mingalarcinema.movieticketing.payload.response.ResponseFactory;
import mm.com.mingalarcinema.movieticketing.service.IMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MovieService implements IMovieService {
    private final MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public ResponseEntity<BaseResponse> getNowShowingMovies() {
        List<Movie> movieList = movieRepo.getNowShowingMovies();
        return ResponseFactory.onSuccess(ResponseCode.SUCCESS, movieList);
    }

    @Override
    public ResponseEntity<BaseResponse> getMovieDetail(String movieId) {
        Optional<Movie> movie = movieRepo.findById(movieId);
        return movie.map(value -> ResponseFactory.onSuccess(ResponseCode.SUCCESS, value)).orElseGet(() -> ResponseFactory.onErrorWithMessage(ResponseCode.INVALID_REQUEST, "Cannot find the movie"));
    }
}

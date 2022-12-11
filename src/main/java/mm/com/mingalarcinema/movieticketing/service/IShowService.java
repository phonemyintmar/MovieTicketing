package mm.com.mingalarcinema.movieticketing.service;

import mm.com.mingalarcinema.movieticketing.payload.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface IShowService {
    ResponseEntity<BaseResponse> getShowsByMovieId(String movieId);

    ResponseEntity<BaseResponse> getShowDetails(String showId);
}

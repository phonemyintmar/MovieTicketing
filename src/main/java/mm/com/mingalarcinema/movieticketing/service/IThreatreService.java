package mm.com.mingalarcinema.movieticketing.service;

import mm.com.mingalarcinema.movieticketing.payload.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface IThreatreService {
    ResponseEntity<BaseResponse> getTheatreListForMovie(String movieId);
}

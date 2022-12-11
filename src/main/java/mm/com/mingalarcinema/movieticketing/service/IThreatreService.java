package mm.com.mingalarcinema.movieticketing.service;

import mm.com.mingalarcinema.movieticketing.payload.request.TheatreIdList;
import mm.com.mingalarcinema.movieticketing.payload.response.BaseResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IThreatreService {
    ResponseEntity<BaseResponse> getTheatreListForMovie(String movieId);

    ResponseEntity<BaseResponse> getTheatreShortList(TheatreIdList idList);


}

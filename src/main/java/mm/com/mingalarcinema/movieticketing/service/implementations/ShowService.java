package mm.com.mingalarcinema.movieticketing.service.implementations;

import lombok.extern.slf4j.Slf4j;
import mm.com.mingalarcinema.movieticketing.database.repo.ShowRepo;
import mm.com.mingalarcinema.movieticketing.payload.response.BaseResponse;
import mm.com.mingalarcinema.movieticketing.payload.response.ResponseCode;
import mm.com.mingalarcinema.movieticketing.payload.response.ResponseFactory;
import mm.com.mingalarcinema.movieticketing.payload.response.ShowsResponse;
import mm.com.mingalarcinema.movieticketing.service.IShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShowService implements IShowService {
    private final ShowRepo showRepo;

    public ShowService(ShowRepo showRepo) {
        this.showRepo = showRepo;
    }


    @Override
    public ResponseEntity<BaseResponse> getShowsByMovieId(String movieId) {
        List<ShowsResponse> showsResponseList = showRepo.getShowsByMovieId(movieId);
        return ResponseFactory.onSuccess(ResponseCode.SUCCESS, showsResponseList);

    }

    @Override
    public ResponseEntity<BaseResponse> getShowDetails(String showId) {

        return null;
    }
}

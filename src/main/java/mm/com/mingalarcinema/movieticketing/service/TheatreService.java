package mm.com.mingalarcinema.movieticketing.service;

import lombok.extern.slf4j.Slf4j;
import mm.com.mingalarcinema.movieticketing.database.model.Screen;
import mm.com.mingalarcinema.movieticketing.database.model.Theatre;
import mm.com.mingalarcinema.movieticketing.database.repo.ScreenRepo;
import mm.com.mingalarcinema.movieticketing.database.repo.TheatreRepo;
import mm.com.mingalarcinema.movieticketing.payload.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class TheatreService implements IThreatreService {
    private final TheatreRepo theatreRepo;

    private final ScreenRepo screenRepo;

    public TheatreService(TheatreRepo theatreRepo, ScreenRepo screenRepo) {
        this.theatreRepo = theatreRepo;
        this.screenRepo = screenRepo;
    }

    @Override
    public ResponseEntity<BaseResponse> getTheatreListForMovie(String movieId) {
        List<Screen> screenList = screenRepo.getScreensByMovieId(movieId);
        Set<String> theatreIdList = new HashSet<>();
        for (Screen screen : screenList) {
            theatreIdList.add(screen.getTheatreId());
        }
        List<Theatre> theatreList = theatreRepo.getTheatres(theatreIdList);
        return null;
    }


}

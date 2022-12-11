package mm.com.mingalarcinema.movieticketing.controller;

import mm.com.mingalarcinema.movieticketing.database.model.Screen;
import mm.com.mingalarcinema.movieticketing.database.repo.ScreenRepo;
import mm.com.mingalarcinema.movieticketing.payload.response.ResponseCode;
import mm.com.mingalarcinema.movieticketing.payload.response.ResponseFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/screen")
public class ScreenController {
    private final ScreenRepo screenRepo;

    public ScreenController(ScreenRepo screenRepo) {
        this.screenRepo = screenRepo;
    }

    @GetMapping("{movieId}")
    public ResponseEntity<?> getScreens(@PathVariable String movieId) {
//        List<Screen> screenList = screenRepo.getScreensByMovieId(movieId);
        return ResponseFactory.onSuccess(ResponseCode.SUCCESS, null);
    }
}

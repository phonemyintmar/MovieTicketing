package mm.com.mingalarcinema.movieticketing.controller;

import mm.com.mingalarcinema.movieticketing.database.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/screen")
public class ScreenController {

    @GetMapping("{movieId}")
    public ResponseEntity<?> getScreens(@PathVariable String movieId) {
        List<String> a = new ArrayList<>();

        return ResponseEntity.ok(movieId);
    }
}

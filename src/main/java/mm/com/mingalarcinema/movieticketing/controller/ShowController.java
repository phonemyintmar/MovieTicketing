package mm.com.mingalarcinema.movieticketing.controller;

import mm.com.mingalarcinema.movieticketing.payload.response.BaseResponse;
import mm.com.mingalarcinema.movieticketing.service.IShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("show")
public class ShowController {
    private final IShowService showService;

    public ShowController(IShowService showService) {
        this.showService = showService;
    }

    @GetMapping("{movieId}")
    public ResponseEntity<BaseResponse> getShowsByMovieId(@PathVariable String movieId) {
        return showService.getShowsByMovieId(movieId);
    }

    @PostMapping("{showId}")
    public ResponseEntity<BaseResponse> getShowDetails(@PathVariable String showId){
        return showService.getShowDetails(showId);
    }
}

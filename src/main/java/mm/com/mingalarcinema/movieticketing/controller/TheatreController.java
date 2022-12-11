package mm.com.mingalarcinema.movieticketing.controller;

import mm.com.mingalarcinema.movieticketing.payload.request.TheatreIdList;
import mm.com.mingalarcinema.movieticketing.payload.response.BaseResponse;
import mm.com.mingalarcinema.movieticketing.service.IThreatreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TheatreController {

    private final IThreatreService threatreService;

    public TheatreController(IThreatreService threatreService) {
        this.threatreService = threatreService;
    }

    public ResponseEntity<BaseResponse> getTheatreForMovie() {
        return null;
    }

    @PostMapping("theatrelist")
    public ResponseEntity<BaseResponse> getTheatreList(@RequestBody TheatreIdList idList) {
        return threatreService.getTheatreShortList(idList);
    }
}

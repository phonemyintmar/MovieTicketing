package mm.com.mingalarcinema.movieticketing.service.implementations;

import lombok.extern.slf4j.Slf4j;
import mm.com.mingalarcinema.movieticketing.database.model.Screen;
import mm.com.mingalarcinema.movieticketing.database.model.Show;
import mm.com.mingalarcinema.movieticketing.database.repo.ScreenRepo;
import mm.com.mingalarcinema.movieticketing.database.repo.ShowRepo;
import mm.com.mingalarcinema.movieticketing.payload.response.*;
import mm.com.mingalarcinema.movieticketing.service.IShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ShowService implements IShowService {
    private final ScreenRepo screenRepo;

    private final ShowRepo showRepo;

    public ShowService(ScreenRepo screenRepo, ShowRepo showRepo) {
        this.screenRepo = screenRepo;
        this.showRepo = showRepo;
    }


    @Override
    public ResponseEntity<BaseResponse> getShowsByMovieId(String movieId) {
        List<ShowsResponse> showsResponseList = showRepo.getShowsByMovieId(movieId);
        return ResponseFactory.onSuccess(ResponseCode.SUCCESS, showsResponseList);

    }

    @Override
    public ResponseEntity<BaseResponse> getShowDetails(String showId) {
        Optional<Show> showOptional = showRepo.findById(showId);
        if (!showOptional.isPresent()) return ResponseFactory
                .onErrorWithMessage(ResponseCode.INVALID_REQUEST, "The show with provided ID cannot be found");
        Show show = showOptional.get();
        ShowDetail showDetail = new ShowDetail();
        SeatPlan seatPlan = new SeatPlan();
        List<SeatPlan> seatPlans = new ArrayList<>();
        SeatDetail seatDetail = new SeatDetail();
        List<SeatDetail> seatDetails = new ArrayList<>();
        Optional<Screen> screenOptional = screenRepo.findById(show.getScreenId());


        if (show.getCoupleSeatsPrice() != null) {
            seatPlan.setSeatType("Couple Seats");
            seatPlan.setSeatTypePrice(show.getCoupleSeatsPrice());
            seatPlans.add(seatPlan);
            for (String seatNo : screenOptional.get().getCoupleSeats().split(",")) {
                seatDetail.setSeatNo(seatNo);
                seatDetail.setSeatPrice(show.getCoupleSeatsPrice());
                seatDetail.setSeatType("Couple Seats");
                seatDetail.setSeatStatus("Available");
                seatDetails.add(seatDetail);
            }
        }
        if (show.getNormalSeatsPrice() != null) {
            seatPlan.setSeatType("Normal Seats");
            seatPlan.setSeatTypePrice(show.getNormalSeatsPrice());
            seatPlans.add(seatPlan);
            for (String seatNo : screenOptional.get().getNormalSeats().split(",")) {
                seatDetail.setSeatNo(seatNo);
                seatDetail.setSeatPrice(show.getNormalSeatsPrice());
                seatDetail.setSeatType("Normal Seats");
                seatDetail.setSeatStatus("Available");
                seatDetails.add(seatDetail);
            }
        }
        if (show.getStandardSeatsPrice() != null) {
            seatPlan.setSeatType("Standard Seats");
            seatPlan.setSeatTypePrice(show.getStandardSeatsPrice());
            seatPlans.add(seatPlan);
            for (String seatNo : screenOptional.get().getStandardSeats().split(",")) {
                seatDetail.setSeatNo(seatNo);
                seatDetail.setSeatPrice(show.getStandardSeatsPrice());
                seatDetail.setSeatType("Standard Seats");
                seatDetail.setSeatStatus("Available");
                seatDetails.add(seatDetail);
            }
        }
        if (show.getPremiumSeatsPrice() != null) {
            seatPlan.setSeatType("Premium Seats");
            seatPlan.setSeatTypePrice(show.getPremiumSeatsPrice());
            seatPlans.add(seatPlan);
            for (String seatNo : screenOptional.get().getPremiumSeats().split(",")) {
                seatDetail.setSeatNo(seatNo);
                seatDetail.setSeatPrice(show.getPremiumSeatsPrice());
                seatDetail.setSeatType("Premium Seats");
                seatDetail.setSeatStatus("Available");
                seatDetails.add(seatDetail);
            }
        }


        seatDetails = seatDetails.stream().peek(seat -> {
            if (Arrays.asList(show.getOccupiedSeats().split(",")).contains(seat.getSeatNo())) {
                seat.setSeatStatus("Occupied");
            }
        }).collect(Collectors.toList());

        //peek loh ya tl loh ngo loh a pw ka hr ko peek pee out ka hr ko map htr tr
        //peek nae so return sayr m lo wo but peek has some problems pyan read kyi
        seatDetails = seatDetails.stream().map(seat -> {
            if (Arrays.asList(show.getWalkInOnlySeats().split(",")).contains(seat.getSeatNo())) {
                seat.setSeatStatus("For Walk-ins");
            }
            return seat;
        }).collect(Collectors.toList());

        showDetail.setSeatDetail(seatDetails);
        showDetail.setSeatPlan(seatPlans);
        showDetail.setShowId(showId);
        showDetail.setShowDate(show.getShowDate());
        showDetail.setShowTime(show.getShowTime());

        return ResponseFactory.onSuccessWithMessage(ResponseCode.SUCCESS, "Seat plan for the show " + showId, showDetail);
    }
}

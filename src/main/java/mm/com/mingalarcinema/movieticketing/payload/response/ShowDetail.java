package mm.com.mingalarcinema.movieticketing.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ShowDetail {
    private String showId;

    private LocalDate showDate;

    private String showTime;

    private List<SeatPlan> seatPlan;

    private List<SeatDetail> seatDetail;

}

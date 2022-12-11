package mm.com.mingalarcinema.movieticketing.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShowDetail {
    private List<SeatPlan> seatPlan;

    private List<SeatDetail> seatDetail;

}

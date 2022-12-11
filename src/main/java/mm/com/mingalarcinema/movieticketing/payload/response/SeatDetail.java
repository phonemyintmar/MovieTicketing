package mm.com.mingalarcinema.movieticketing.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatDetail {
    private String seatNo;

    //enum?
    private String seatType;

    private String seatPrice;

    private String seatStatus;
}

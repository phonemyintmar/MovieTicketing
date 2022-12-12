package mm.com.mingalarcinema.movieticketing.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class BookingResponse {

    private String bookingId;

    private String screenAndTheatreName;

    private String showTime;

    private LocalDate showDate;

    private String seatNumbers;

    private Double totalCost;

    private String userName;

    private String qrString;

    private LocalDateTime bookedDate;
}

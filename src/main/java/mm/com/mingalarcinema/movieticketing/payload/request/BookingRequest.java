package mm.com.mingalarcinema.movieticketing.payload.request;

import lombok.Getter;
import lombok.Setter;
import mm.com.mingalarcinema.movieticketing.database.model.BookedSeat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class BookingRequest {

    private BookedSeat[] seats;

    private String showId;

    private String movieId;

    private String movieName;

    private Double totalCost;

    private LocalDate showDate;

    private String showTime;

    private String userName;

    //analytics// nout pine mha pop
//    private Boolean isGuest;

    //may b enum;
    private String paymentType;

    private LocalDateTime requestAt;
}

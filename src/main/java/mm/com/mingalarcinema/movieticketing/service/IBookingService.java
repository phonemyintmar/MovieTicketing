package mm.com.mingalarcinema.movieticketing.service;

import mm.com.mingalarcinema.movieticketing.payload.request.BookingRequest;
import mm.com.mingalarcinema.movieticketing.payload.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface IBookingService {

    ResponseEntity<BaseResponse> book(BookingRequest request);
}

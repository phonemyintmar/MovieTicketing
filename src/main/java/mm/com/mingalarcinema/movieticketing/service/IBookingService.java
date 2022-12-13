package mm.com.mingalarcinema.movieticketing.service;

import mm.com.mingalarcinema.movieticketing.payload.request.BookingRequest;
import mm.com.mingalarcinema.movieticketing.payload.response.BaseResponse;
import org.springframework.http.ResponseEntity;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface IBookingService {

    ResponseEntity<BaseResponse> book(BookingRequest request) throws Exception;
}

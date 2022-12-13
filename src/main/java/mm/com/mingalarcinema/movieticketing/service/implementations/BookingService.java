package mm.com.mingalarcinema.movieticketing.service.implementations;

import lombok.extern.slf4j.Slf4j;
import mm.com.mingalarcinema.movieticketing.database.model.BookedSeat;
import mm.com.mingalarcinema.movieticketing.database.model.Booking;
import mm.com.mingalarcinema.movieticketing.database.model.BookingStatus;
import mm.com.mingalarcinema.movieticketing.database.repo.BookingRepo;
import mm.com.mingalarcinema.movieticketing.database.repo.ScreenRepo;
import mm.com.mingalarcinema.movieticketing.database.repo.ShowRepo;
import mm.com.mingalarcinema.movieticketing.payload.request.BookingRequest;
import mm.com.mingalarcinema.movieticketing.payload.response.*;
import mm.com.mingalarcinema.movieticketing.service.IBookingService;
import mm.com.mingalarcinema.movieticketing.util.EncryptionUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class BookingService implements IBookingService {
    private final ShowRepo showRepo;

    private final BookingRepo bookingRepo;

    private final ScreenRepo screenRepo;

    public BookingService(ShowRepo showRepo, BookingRepo bookingRepo, ScreenRepo screenRepo) {
        this.showRepo = showRepo;
        this.bookingRepo = bookingRepo;
        this.screenRepo = screenRepo;
    }

    @Override
    public ResponseEntity<BaseResponse> book(BookingRequest request) throws Exception {
        //booking over work flow ka pyan kyi ya mhr because payment br nyr ma htae ya thay loh
        //and payment a twet log file twy ll htote ya ml

        Booking booking = new Booking();
        booking.setBookingId(UUID.randomUUID().toString());
        // dr pyan kyi
        booking.setBookingStatus(BookingStatus.DONE);
        booking.setMovieId(request.getMovieId());
        booking.setShowId(request.getShowId());
        booking.setMovieName(request.getMovieName());
        booking.setUserName(request.getUserName());
        booking.setTotalCost(request.getTotalCost());
        booking.setPaymentType(request.getPaymentType());

        String seatNumbers = "";
        for (BookedSeat seat : request.getSeats()) {
            seatNumbers = seatNumbers + seat.getSeatNo() + "\n";
        }
        booking.setSeatNumbers(seatNumbers);


        Optional<String> screenIdOptional = showRepo.getscreenId(request.getShowId());
        if (!screenIdOptional.isPresent())
            return ResponseFactory.onErrorWithMessage(ResponseCode.SOMETHING_WENT_WRONG, "cannot find the screen");

        String screenAndTheatreName = "";
        Optional<String> screenAndTheatreNameOptional = screenRepo.getScreenName(screenIdOptional.get());
        if (!screenAndTheatreNameOptional.isPresent()) {
            log.error("There was an error at fetching screen and theatre name please check.");
        }
        screenAndTheatreName = screenAndTheatreNameOptional.get();
        booking.setScreenAndTheatreName(screenAndTheatreName);
        bookingRepo.save(booking);

        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(booking.getBookingId());
        bookingResponse.setScreenAndTheatreName(booking.getScreenAndTheatreName());
        bookingResponse.setShowTime(bookingResponse.getShowTime());
        bookingResponse.setShowDate(bookingResponse.getShowDate());
        bookingResponse.setTotalCost(booking.getTotalCost());
        bookingResponse.setUserName(booking.getUserName());
        bookingResponse.setBookedDate(LocalDateTime.now());


        String algorithm = "AES/CBC/PKCS5Padding";
        Optional<String> showKeyOptional = showRepo.getShowKey(request.getShowId());
        if (!showKeyOptional.isPresent())
            return ResponseFactory.onErrorWithMessage(ResponseCode.SOMETHING_WENT_WRONG, "cannot get show key");

        String qrValue = "User name = " + booking.getUserName() + "\n" +
                "Total cost = " + booking.getTotalCost() + "\n" +
                "Booking status = " + booking.getBookingStatus() + "\n" +
                "Theatre name = " + booking.getScreenAndTheatreName() + "\n" +
                "Show time = " + booking.getShowTime();

        String qrString = EncryptionUtil.encrypt(algorithm, qrValue, EncryptionUtil.getKeyFromPassword(showKeyOptional.get(), "JCGV128"), EncryptionUtil.generateIv());

        String finalQrString = booking.getBookingId() + "|" + qrString;
        bookingResponse.setQrString(finalQrString);

        return ResponseFactory.onSuccess(ResponseCode.SUCCESS, null);
    }
}

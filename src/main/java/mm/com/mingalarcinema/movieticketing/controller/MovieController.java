package mm.com.mingalarcinema.movieticketing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import mm.com.mingalarcinema.movieticketing.database.model.Movie;
import mm.com.mingalarcinema.movieticketing.database.repo.MovieRepo;
import mm.com.mingalarcinema.movieticketing.database.repo.TheatreRepo;
import mm.com.mingalarcinema.movieticketing.payload.response.SeatDetail;
import mm.com.mingalarcinema.movieticketing.service.implementations.MovieService;
import mm.com.mingalarcinema.movieticketing.util.EncryptionUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.*;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    private final MovieRepo movieRepo;

    private final TheatreRepo theatreRepo;

    public MovieController(MovieService movieService, MovieRepo movieRepo, TheatreRepo theatreRepo) {
        this.movieService = movieService;
        this.movieRepo = movieRepo;
        this.theatreRepo = theatreRepo;
    }

    @GetMapping("")
    public ResponseEntity<?> getMovies() {
        return movieService.getNowShowingMovies();
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<?> getMovieDetail(@PathVariable String movieId) {
        return movieService.getMovieDetail(movieId);
    }

    @GetMapping("test/{input}")
    public ResponseEntity<?> testingMethod(@PathVariable String input) throws Exception {
        SecretKey secretKey = EncryptionUtil.getKeyFromPassword("password", "abcd");
        IvParameterSpec ivParameterSpec = EncryptionUtil.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";

        Random rn = new Random();
        int number = rn.nextInt(10) + 5;
        String generatedString = RandomStringUtils.randomAlphanumeric(number);

        SeatDetail detail = new SeatDetail();

        String cipherText = EncryptionUtil.encrypt(algorithm, input, secretKey, ivParameterSpec);
        System.out.println(cipherText);
        String plainText = EncryptionUtil.decrypt(algorithm, cipherText, secretKey, ivParameterSpec);


        return ResponseEntity.ok(plainText);
    }

    public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }


}

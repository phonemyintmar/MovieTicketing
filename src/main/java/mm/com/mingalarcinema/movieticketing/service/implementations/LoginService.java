package mm.com.mingalarcinema.movieticketing.service.implementations;

import lombok.extern.slf4j.Slf4j;
import mm.com.mingalarcinema.movieticketing.controller.LoginRequest;
import mm.com.mingalarcinema.movieticketing.database.model.User;
import mm.com.mingalarcinema.movieticketing.database.repo.UserRepo;
import mm.com.mingalarcinema.movieticketing.payload.response.ResponseCode;
import mm.com.mingalarcinema.movieticketing.payload.response.ResponseFactory;
import mm.com.mingalarcinema.movieticketing.service.ILoginService;
import mm.com.mingalarcinema.movieticketing.util.JwtTokenUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Slf4j
@Service
public class LoginService implements ILoginService {
    private final UserRepo userRepo;

    private final JwtTokenUtil jwtUtil;

    public LoginService(UserRepo userRepo, JwtTokenUtil jwtUtil) {
        this.userRepo = userRepo;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public ResponseEntity<?> onLogin(LoginRequest request) {

        // we will use an authentication service here
        Optional<User> userOptional = userRepo.findUserByUserNameAndPassword(request.getUsername(), request.getPassword());
        if (!userOptional.isPresent())
            return ResponseFactory.onError(ResponseCode.WRONG_CREDENTIALS);


        // user ka bl mhr so bl role br nyr config loh ya dl
        // claims htl mhr thwr htae yone pl authentication service takhu use pee ae ka pyan tae data ko d mhr pass loh ya;
        String jwtToken = jwtUtil.generateToken(userOptional.get());
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("token", jwtToken);
        return ResponseFactory.onSuccessWithMessage(ResponseCode.SUCCESS, "Successfully logged in", responseMap);
    }
}

package mm.com.mingalarcinema.movieticketing.service;

import mm.com.mingalarcinema.movieticketing.controller.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface ILoginService {

    ResponseEntity<?> onLogin(LoginRequest request);
}

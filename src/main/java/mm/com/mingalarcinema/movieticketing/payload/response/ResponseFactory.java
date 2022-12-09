package mm.com.mingalarcinema.movieticketing.payload.response;

import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ResponseFactory {
    public static ResponseEntity<BaseResponse> onSuccessWithMessage(ResponseCode code, String message, Object result) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResult(result);
        baseResponse.setCode(code.getCode());
        baseResponse.setMessage(message);
        baseResponse.setRespondedAt(LocalDateTime.now());
        return ResponseEntity.ok(baseResponse);
    }

    public static ResponseEntity<BaseResponse> onSuccess(ResponseCode code, Object result) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResult(result);
        baseResponse.setCode(code.getCode());
        baseResponse.setMessage(code.getMessage());
        baseResponse.setRespondedAt(LocalDateTime.now());
        return ResponseEntity.ok(baseResponse);
    }

    public static ResponseEntity<BaseResponse> onErrorWithMessage(ResponseCode code, String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResult(null);
        baseResponse.setCode(code.getCode());
        baseResponse.setMessage(message);
        baseResponse.setRespondedAt(LocalDateTime.now());
        return ResponseEntity.ok(baseResponse);
    }

    public static ResponseEntity<BaseResponse> onError(ResponseCode code) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResult(null);
        baseResponse.setCode(code.getCode());
        baseResponse.setMessage(code.getMessage());
        baseResponse.setRespondedAt(LocalDateTime.now());
        return ResponseEntity.ok(baseResponse);
    }
}

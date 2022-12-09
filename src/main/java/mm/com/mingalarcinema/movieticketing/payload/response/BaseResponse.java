package mm.com.mingalarcinema.movieticketing.payload.response;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class BaseResponse {
    private String message;
    private String code;
    private Object result;
    private LocalDateTime respondedAt;
}

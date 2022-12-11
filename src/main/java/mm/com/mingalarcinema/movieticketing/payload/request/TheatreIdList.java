package mm.com.mingalarcinema.movieticketing.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TheatreIdList {
    private List<String> idList;
}

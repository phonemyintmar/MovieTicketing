package mm.com.mingalarcinema.movieticketing.database.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UnbookableSeats {
    private String reason;
    private List<String> seats;
}

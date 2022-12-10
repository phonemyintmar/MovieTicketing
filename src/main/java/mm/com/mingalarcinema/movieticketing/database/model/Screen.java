package mm.com.mingalarcinema.movieticketing.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "ob_screen")
@Getter
@Setter
public class Screen {
    @Id
    private String screenId;

    private String movieId;

    private String theatreId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String screenHour;

    private String bannerUrl;

//    private Double prices;
}

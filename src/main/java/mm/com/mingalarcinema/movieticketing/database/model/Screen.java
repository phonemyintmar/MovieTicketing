package mm.com.mingalarcinema.movieticketing.database.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String theatreId;

    private String coupleSeats;

    private String normalSeats;

    private String standardSeats;

    private String premiumSeats;

    private String bannerUrl;

    private Boolean is3d;

    private String theatreAddress;

    @JsonIgnore
    private Integer totalSeatNumbers;
}

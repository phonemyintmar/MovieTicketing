package mm.com.mingalarcinema.movieticketing.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ob_movie")
@Setter
@Getter
public class Movie {

    @Id
    private Long movieId;

    private String movieName;

    private String bannerUrl;

    private String description;

    private String movieType;

    private LocalDateTime updatedDate;
}

package mm.com.mingalarcinema.movieticketing.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ob_movie")
@Setter
@Getter
public class Movie {

    @Id
    private String movieId;

    private String movieName;

    private String cast;

    private String genre;

    private String bannerUrl;

    private String trailerUrl;

    private String description;

    @Enumerated(EnumType.STRING)
    private MovieType movieType;

    private int moviePriority;

    private LocalDateTime updatedDate;
}

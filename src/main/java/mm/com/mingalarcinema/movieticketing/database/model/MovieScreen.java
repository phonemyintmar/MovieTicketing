package mm.com.mingalarcinema.movieticketing.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "ob_movie_screen")
public class MovieScreen {
    @Id
    private String tesIdthissctuallyneedscompoundid;

    private String movieId;

}

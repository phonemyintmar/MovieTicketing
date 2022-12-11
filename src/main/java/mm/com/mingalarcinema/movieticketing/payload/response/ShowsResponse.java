package mm.com.mingalarcinema.movieticketing.payload.response;

public interface ShowsResponse {
    String getShowTime();

    String getShowDate();

    String getIs3d();

    String getTotalAvailableSeats();

    String getTotalTakenSeats();

    String getTheatreName();

}

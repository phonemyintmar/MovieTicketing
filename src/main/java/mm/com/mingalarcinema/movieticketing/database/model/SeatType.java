package mm.com.mingalarcinema.movieticketing.database.model;

public enum SeatType {
    Couple_Seat("Couple Seats", 10000d),
    Normal_Seat("Normal Seats",1000d),
    Standard_Seat("Standard Seats",3000d),
    Premium_Seat("Premium Seats",7000d);


    final String name;

    final Double basePrice;

    SeatType(String name, Double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public final String getName() {
        return name;
    }
}

package mm.com.mingalarcinema.movieticketing.payload.response;

public enum ResponseCode {
    //success codes *starts with zero
    SUCCESS("000", "Action is successful"),

    //error codes *starts with one
    INVALID_REQUEST("100", "Invalid Request"),
    SOMETHING_WENT_WRONG("199", "Something went wrong!");

    private final String code;
    private final String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

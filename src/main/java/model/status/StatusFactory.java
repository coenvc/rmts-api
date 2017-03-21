package model.status;

public class StatusFactory {

    public Status build (StatusCode statusCode) {
        switch (statusCode) {
            case ACTIVE:
                return new Status("active");
            case NON_ACTIVE:
                return new Status("non-active");
            case ENDED:
                return new Status("ended");
            case DENIED:
                return new Status("denied");
                default:
                    throw new IllegalArgumentException("Status code does not exist.");
        }
    }
}


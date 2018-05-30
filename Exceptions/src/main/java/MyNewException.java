import java.util.logging.Logger;

public class MyNewException extends Exception {

    final  Logger logger = Logger.getLogger(MyNewException.class.toString());

    public MyNewException() {
    }

    public MyNewException(String message) {
        super(message);
    }

    public MyNewException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyNewException(Throwable cause) {
        super(cause);
    }

    public String customExceptionMessage() {
        logger.info("The application Failed.");
        return "The application failed.";
    }
}

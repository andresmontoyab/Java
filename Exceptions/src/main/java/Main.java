import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        try {
            throw new MyNewException();
        } catch (MyNewException e) {
            e.customExceptionMessage();
        }

    }
}

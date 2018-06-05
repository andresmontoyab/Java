package LambdaSectionChallenge;

public class Main {
    public static void main(String[] args) {

        // First Challenge

        Runnable runnable = () -> {
            String myString = "Lets split this up into an array";
            String[] parts = myString.split(" ");
            for (String string : parts) {
                System.out.println(string);
            }
        };

        // Challenge Number Two

        
    }
}

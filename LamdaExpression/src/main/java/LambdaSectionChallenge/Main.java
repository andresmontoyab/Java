package LambdaSectionChallenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

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
        Function<String, String> lambda = (String source) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i< source.length(); i ++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // CHallenge three and five
        String challengeTwo = everySecondChar( lambda, "1234567890");
        System.out.println(challengeTwo);

        // Challenge six
        Supplier<String> iLoveJava = () -> "I Love Java!";

        // Challenge seve
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        //Challenge Nine and ten
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob");

        topNames2015.stream()
                .map(names -> names.substring(0,1).toUpperCase() + names.substring(1, names.length()))
                .sorted()
                .forEach(System.out::println);

        // Challenge Twelve

        long namesTimeA = topNames2015.stream()
                .map(names -> names.substring(0,1).toUpperCase() + names.substring(1, names.length()))
                .filter(names -> names.startsWith("A"))
                .sorted()
                .count();

        System.out.println(namesTimeA);


        topNames2015.stream()
                .map(names -> names.substring(0,1).toUpperCase() + names.substring(1, names.length()))
                .peek(System.out::println)
                .sorted()
        ;


    }

    // CHallenge four
    public static String everySecondChar(Function<String, String> operation , String source){
        return operation.apply(source);
    }
}

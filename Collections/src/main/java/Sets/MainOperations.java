package Sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainOperations {

    public static void main(String[] args) {

        Set<Integer> square = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 0; i < 100 ; i++) {
            square.add( i * i);
            cubes.add( i * i *i );
        }

        System.out.println("There are " + square.size() + " squares and " + cubes.size() + " cubes");

        Set<Integer> union = new HashSet<>(square);
        union.addAll(cubes);

        Set<Integer> intersection = new HashSet<>(square);
        intersection.retainAll(cubes);

        Set<String> words = new HashSet<>();
        String sentences = " one day in the year of the fox";
        String[] arrayWords = sentences.split(" ");
        words.addAll(Arrays.asList(arrayWords));


        HashSet<String> nature = new HashSet<>();
        HashSet<String> divine = new HashSet<>();

        String natureString = "thee all unknown art nature but to is ";
        String divineString = "err human forgive divine to is ";

        String[] natureArray = natureString.split(" ");
        String[] divineArray = divineString.split(" ");

        nature.addAll(Arrays.asList(natureArray));
        divine.addAll(Arrays.asList(divineArray));

        System.out.println("Nature divine");

        HashSet<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);

        for(String string : diff1) {
            System.out.println(string);
        }

        System.out.println("Divine - Nature");
        HashSet<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);

        for(String string : diff2) {
            System.out.println(string);
        }

        // symetric difference

        HashSet<String> unionSymetric = new HashSet<>(nature);
        unionSymetric.addAll(divine);

        HashSet<String> intersectionSymetric = new HashSet(nature);
        intersectionSymetric.retainAll(divine);

        unionSymetric.removeAll(intersectionSymetric);

        System.out.println("Symetric");

        for (String string : unionSymetric) {
            System.out.print(string + " ");
        }

    }
}

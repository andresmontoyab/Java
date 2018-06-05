package map;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> languagues = new HashMap<String, String>();
        languagues.put("Java", "A compiled high level, object oriented, platform independient language.");
        languagues.put("Python", "an interpreted, objected oriented, high level programming languague with dynamic semantic");
        languagues.put("Algol", "Algorithmic languague");
        languagues.put("BASIC", "Beginner all purposes symbolic Instruction code");
        languagues.put("Lisp", "There in Lies madness");

        System.out.println(languagues.get("BASIC"));

        if(languagues.containsKey("Java")){
            System.out.println("Dont add");
            // dont add
        } else {
            System.out.printf("Add");
            // add
        }

        languagues.remove("Lisp");

        for (String key : languagues.keySet()) {
            System.out.println(key + " : " + languagues.get(key));
        }

        System.out.println("Testing mutable data in maps");

        Person andres = new Person("Andres", 123456);
        Person carlos = new Person("Carlos", 4568);
        Person sandra = new Person("Sandra", 716);
        Person simon = new Person("Simon", 48913);
        Person juan = new Person("Juan", 41864531);

        Map<Integer, Person> personas = new HashMap<Integer, Person>();
        personas.put(andres.getNumberId(), andres);
        personas.put(carlos.getNumberId(), carlos);
        personas.put(sandra.getNumberId(), sandra);
        personas.put(simon.getNumberId(), simon);
        personas.put(juan.getNumberId(), juan);

        Map<Integer, Person> newPersonas = new HashMap<Integer, Person>(personas);
        newPersonas.put(andres.getNumberId(), juan);

        andres.setName("Andruuuuu");
        carlos.setName("Carliiin");

        for (Integer intKey : newPersonas.keySet()) {
            System.out.println("This is come new personas " + newPersonas.get(intKey).getName());
            System.out.println("This is come personas " + personas.get(intKey).getName());
        }


        System.out.println("Testing Strings in Map");

        Map<String, String> chekingStrings = new HashMap<String, String>();
        String testString = "Hey there";
        String instanceString = new String("Instancing");

        chekingStrings.put("1", testString);
        chekingStrings.put("2", instanceString);


        System.out.println(chekingStrings.get("1"));
        System.out.println(chekingStrings.get("2"));

        testString = "Not here";


        System.out.println(chekingStrings.get("1"));
        System.out.println(chekingStrings.get("2"));
    }
}

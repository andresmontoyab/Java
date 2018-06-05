package LinkedHashMap;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, City> cities = new TreeMap<String, City>();

        City medellin = new City("Medellin", 3000000);
        City newMedellin = new City("Medellin", 4000000);
        City bogota = new City("Bogota", 7000000);
        City cartagena = new City("Cartagena", 500000);
        City pasto = new City("Pasto", 1000000);

        cities.put(medellin.getName(), medellin);
        cities.put(bogota.getName(), bogota);
        cities.put(cartagena.getName(), cartagena);
        cities.put(pasto.getName(), pasto);
        cities.put(newMedellin.getName(), newMedellin);



        printCities(cities);


    }

    public static void printCities(Map<String, City> cities) {
        for (String city : cities.keySet()) {
            System.out.println(cities.get(city).toString());
        }
    }
}

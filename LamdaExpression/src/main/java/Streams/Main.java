package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBigNumber = Arrays.asList(
                "N40",
                "B12",
                "N36",
                "G50", "G60", "G57", "g52",
                "I26", "I17");

        List<String> gNumber  = new ArrayList<>();

        someBigNumber.forEach(number -> {
            if(number.toUpperCase().startsWith("G")){
                gNumber.add(number.toUpperCase());
//                System.out.println(number.to);
            }
        });

        gNumber.sort((String s1, String s2) -> s1.compareTo(s2));
        gNumber.forEach(s -> System.out.println(s));


        // stream

        // map

        List<String> arrayString = Arrays.asList(
                "DD50", "DD45", "DD30");

        arrayString.stream()
                .map( number -> number.substring(2, number.length()))
                .sorted()
                .forEach(System.out::println);


        Stream<String> streamString = Stream.of("15","16","18","19");

        Stream<String> streamFromArray = Arrays.asList(
                "DD50", "DD45", "DD30").stream();

        /// Flat map

        Employee andres = new Employee("Andres " , 22);
        Employee poncho = new Employee("Poncheras ", 29);
        Employee sebas = new  Employee("GambaNeitor ", 25);
        Employee mauro = new  Employee("Maurisinho ", 33);
        Employee vanesa = new Employee("Vanesa ", 23);
        Employee oscar = new  Employee("Ututuisnho", 32);

        Department hr = new Department("Human Resources");
        hr.addEmployee(andres);
        hr.addEmployee(poncho);
        hr.addEmployee(sebas);
        hr.addEmployee(mauro);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(vanesa);
        accounting.addEmployee(oscar);

        List<Department> departments = new ArrayList<>();
        departments.add(accounting);
        departments.add(hr);

        departments.stream()
            .flatMap( department -> department.getEmployees().stream())
            .forEach(System.out::println);

        // Collect method
        List<String> sortedGNumber = someBigNumber
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);


        sortedGNumber.forEach(s -> System.out.println(s));

        Map<Integer, List<Employee>> groupByAge = departments.stream()
                .flatMap( department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        groupByAge.keySet().forEach(s -> System.out.println(groupByAge.get(s)));


        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        Stream.of("ABC", "AV", "SDAF", "SDF","IOP")
                .filter( s -> {
                    System.out.println(s);
                    return s.length() == 3;
                }).count();

    }




}

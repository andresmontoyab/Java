package javaFunctionalPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Employee andres = new Employee("Andres", 22);
        Employee poncho = new Employee("Poncheras ", 29);
        Employee sebas = new Employee("GambaNeitor", 25);
        Employee mauro = new Employee("Maurisinho", 33);
        Employee vanesa = new Employee("Vanesa", 23);
        Employee oscar = new Employee("Ututuisnho", 32);

        List<Employee> employees = new ArrayList<>();
        employees.add(andres);
        employees.add(poncho);
        employees.add(sebas);
        employees.add(mauro);
        employees.add(vanesa);
        employees.add(oscar);

        printEmployeesByAge(employees, "Employes over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employes young 30", employee -> employee.getAge() <= 30);
        printEmployeesByAge(employees, "Employes young 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        Random random = new Random();
        Supplier<Integer> randomValues = () -> random.nextInt(200);

        for (int i = 0; i < 10; i++){
            System.out.println(randomValues.get());
        }

        Function<Employee,String> getFirstLetter = (Employee employee) -> {
            return employee.getName().substring(0,1);
        };

        Function<String, String> addAge = (String letter) -> {
            return letter.concat("!" + letter + "~" );
        };

        Function chaining = getFirstLetter.andThen(addAge).andThen(addAge);

        System.out.println(chaining.apply(employees.get(0)));

        employees.forEach(employee -> System.out.println(getFirstLetter(getFirstLetter, employee)));

        BiFunction<Employee, String, String> concatingName = (Employee employee, String word) -> {
            return employee.getName() + "~" + word;
        };

        System.out.println(concatingName.apply(employees.get(0), "BiFunction"));

        IntUnaryOperator intBy5 = i -> i +5;
        System.out.println(intBy5.applyAsInt(5));
    }

    public static String getFirstLetter(Function<Employee, String> function, Employee employee) {
        return function.apply(employee);
    }

    public static void printEmployeesByAge(List<Employee> employees,
                                           String ageText,
                                           Predicate<Employee> ageCondition){
        System.out.println(ageText);
        System.out.println("============");
        for (Employee employee : employees) {
            if(ageCondition.test(employee)) {
                System.out.println(employee.toString());
            }
        }
    }
}

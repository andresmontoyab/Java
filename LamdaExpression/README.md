# Lambda Expression

Lambda Expression are composed by:

	1. Argument List

	2. Arrow

	3. Body

Lambda Expression can only be used with interfaces that only contains one method, that interfaces are known as functional interfaces.

	new Thread(() ->  System.out.println("Im in the runnable")).start();

The Runnable interfaces is a functional interfaces.

## Create our Lambda.

	1. Create a Interface with one method.	

	public interface MathAverage {
 	   int calculateAverage(int a, int b);
	}

	2. Use the interface.

    public void usingInterface(MathAverage ma) {
        ma.calculateAverage(10, 11);
    }

    3. Use the method and define the lambda.

      	usingInterface((firstValue, secondValue) -> {
            System.out.println("Im in the implementation of the method");
            return (firstValue + secondValue)/2;
        });

    	or just

    	usingInterface((firstValue, secondValue) -> (firstValue + secondValue)/2);		

	We can also save our lambda and send it later

	MathAverage ma = (firstValue, secondValue) -> (firstValue + secondValue)/2;
	usingInterface(ma);

## ForEach Interface 

     listInteger.forEach(integer -> {
            System.out.println(integer);
        }); 

## Predicate Interface.

First we define a method with a Predicate parameter.

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

We call this method using lambdas function.

  		printEmployeesByAge(employees, "Employes over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employes young 30", employee -> employee.getAge() <= 30);    

        or 

        printEmployeesByAge(employees, "Employes young 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

## SupplierInterface

Is a interface that does not receive arguments but return information.

 		Random random = new Random();
        Supplier<Integer> randomValues = () -> random.nextInt(200);

        for (int i = 0; i < 10; i++){
            System.out.println(randomValues.get());
        }

We can use it with the method get. We can also pass it like a parameter.

## Using Variables in Lambda Expression

Every variable that a lamda expression must to use has to be effectively final for the same reason that local variables have to be declared final if we want to use them within an anonymous classes code,  

Lambda expressions (as well as anonymous classes) in Java can only access to the final (or effectively fina(when we dont define a variable final but never change the value of the variable.)) variables of the enclosing scope.

¿Why the variable muys be final or effectively final?

	1. n pure functional languages, this is the only thing that should be allowed, keeping the referential transparency property.

¿ What is referential transparency Property ?

	1. Referential transparency, a term commonly used in functional programming, means that given a function and an input value, you will always receive the same output. That is to say there is no external state used in the function. 


# Functions 

The interface function is composed for two parameters, the first one the parametro with will pass to the function and the second is the return of the funcion.

		 Function<Employee,String> getFirstLetter = (Employee employee) -> {
		            return employee.getName().substring(0,1);
		        };

In the above code we have, return type of the function is a String and the parameter to operate is a Employee.

		   public static String getFirstLetterMethod(Function<Employee, String> function, Employee employee) {
		        return function.apply(employee);
		    }

We can use this function like parameter in a method, if we want the result of the function use the method apply.

		 employees.forEach(employee -> System.out.println(getFirstLetterMethod(getFirstLetter, employee)));

## BiFucntion

The BiFunction Receive three parameters, the first and second one are used for the operation of the function, the third one is the return type.

BiFunction<Employee, String, String> concatingName = (Employee employee, String word) -> {
            return employee.getName() + "~" + word;
        };

        System.out.println(concatingName.apply(employees.get(0), "BiFunction"));		 

## Unary Function.

Are function with the same parameter type for input and output. 

## Chaining Functions

If we want to chaining function we must understand that the output argument to the first function is the input argument for the second option.

 		Function<Employee,String> getFirstLetter = (Employee employee) -> {
            return employee.getName().substring(0,1);
        };

        Function<String, String> addAge = (String letter) -> {
            return letter.concat("!" + letter + "~" );
        }; 

        Function chaining = getFirstLetter.andThen(addAge).andThen(addAge);

        System.out.println(chaining.apply(employees.get(0)));		 

# Streams !!

Streams are sequence of computation or a set of computation steps that are chain together. A stream is a sequence of zero or n intermediate operations and a terminal operation.

For create a Stream we use collection as the source.

1. Creating a Stream

		Stream<String> streamString = Stream.of("15","16","18","19");

2. Creating a Stream from array

      Stream<String> streamFromArray = Arrays.asList("DD50", "DD45", "DD30").stream();

## Terminal operation

Are operations that return a void or non-stream result, this operations force to end the chain of the stream.

## Intermediate Operations

Are operations that return a Stream, this operations dont force to the end the chain of the stream.

## Lazy Evaluation

Stream operations are lazy evaluated its mean nothing happens until there's a terminal operation. 

     	Stream.of("ABC", "AV", "SDAF", "SDF","IOP")
                .filter( s -> {
                    System.out.println(s);
                    return s.length() == 3;
                });

In the code above we have a stream with a filter, the method filter is a intermediate operation. All stream required a terminal operation if a stream does not have a terminal operation the stream dont realize any operation, in the code above nothing is print because there's no terminal operation.

        Stream.of("ABC", "AV", "SDAF", "SDF","IOP")
                .filter( s -> {
                    System.out.println(s);
                    return s.length() == 3;
                }).count();

But if we added a terminal operation the print of each value will be execute.                

## Map

In streams the map methods maps each source element to the function result.

1. Define our source

 			List<String> arrayString = Arrays.asList(
                "DD50", "DD45", "DD30");

2. Create and operate with the streams

		        arrayString.stream()			// Create the strean with base of the Stings --> Stream<String>
	                .map( number -> number.substring(2, number.length()))	// return 50, 45, 30 in a Stream<String>
	                .map(Integer::parseInt)									// return 50, 45, 30 in Stream<Integer>
	                .forEach(System.out::println);							// print 50,45,30


## Filter

In a set of information the filter method applies a predicate and only the information or data that satisfy the predicate will persist.

				arrayString.stream()			// Create the strean with base of the Stings --> Stream<String>			
	                .map( number -> number.substring(2, number.length()))	// return 50, 45, 30 in a Stream<String>
	                .map(Integer::parseInt)									// return 50, 45, 30 in Stream<Integer>
	                .filter(number -> number > 40)							// return 45,50 in Stream<Integer>
	                .forEach(System.out::println);							// print 50,45

## FlatMap 

The flatMap is usefull when we have to deal with nested collection or nested list, in this case we have a entry of type List<String> and have n outputs of type String.

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


## Collect

After we deal with Stream we can store the information using the method collect.

	     List<String> someBigNumber = Arrays.asList(
	                "N40",
	                "B12",
	                "N36",
	                "G50", "G60", "G57", "g52",
	                "I26", "I17");

		List<String> sortedGNumber = someBigNumber
		                .stream()
		                .map(String::toUpperCase)
		                .filter(s -> s.startsWith("G"))
		                .sorted()
		                .collect(Collectors.toList());

or in Arraylist

        List<String> sortedGNumber = someBigNumber
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);		                

        sortedGNumber.forEach(s -> System.out.println(s));

Maps


        Map<Integer, List<Employee>> groupByAge = departments.stream()
                .flatMap( department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        groupByAge.keySet().forEach(s -> System.out.println(groupByAge.get(s)));		        

## Reduce Function


        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);		                

## Sorted

Is a way to sort the information in a Stream, this sort method use a comparator.

	    List<String> arrayString = Arrays.asList(
                "DD50", "DD45", "DD30");

        arrayString.stream()
                .map( number -> number.substring(2, number.length()))	// return 50,45,30 
                .sorted()					// will sort the information in lower to higher order
                .forEach(System.out::println);		// print 30,45,50


## ForEach

Is a terminal operation and applies any operation over the informarion but does not return information.

                 
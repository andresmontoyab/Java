# Static and Final Statement

## Static Statement

	1. State field are also known as a class variable , is associated with the class rather than a particular instance of it.

	2. Only one copy of the variable on memory.

	3. All this instances of the class share that one class variable.

	4. Static methods does not need a instanciate to be used.

	5. In a static context cant be use it method or variables no statics.

	6. But in a non-static context can be use variables or methods static

	7. Static methods (in fact all methods) as well as static variables are stored in the PermGen section of the heap, since they are part of the reflection data

Main Class 

		public class Main {
			public static int multiplier = 7;

		    public static void main(String[] args) {

		        StaticTest firstInstance = new StaticTest("First Instance");
		        System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstances());

		        StaticTest secondInstance  = new StaticTest("Second Instance");
		        System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());

		        int answer = multiply(6);
		        System.out.println("The answer is " + answer);

		    }

		    public static int multiply (int number) {
		        return multiplier * number;
		    }
		}

StaticTest Class

		public class StaticTest {

		    private static int numInstances = 0;
		    private String name;

		    public StaticTest(String name) {
		        this.name = name;
		        this.numInstances ++;
		    }

		    public static int getNumInstances() {
		        return numInstances;
		    }

		    public String getName() {
		        return name;
		    }
		}


With the code above we can saw that, each time that new StaticTest("") its call increment by 1 the variable numInstances, with this we can conclude that the variable numInstances is shared by all the instances;

We can call the method StaticTest.getNumInstances() without using a instance, that is because this method is static.

If our method multiply wont be static we cant call it in our public static void main method.

## Final Statement

Another usefull keyword in java used generally to define constant values is final (but strictly final variables are not constant because they can be modifed but only once).

		private final int instanceNumber = 1; // the variable always have the value of 1.

Or

		public class SomeClass {

	    private final int instanceNumber;

	    public SomeClass(int numberInstance) {
	        instanceNumber = numberInstance;
	    }		  

As we can saw above the final variables can only be modified one time.

If we try to change the value of a final variable when a initial value its given, the compiler will show us a error.

Following the good practices, constant variable names should be in upper case

## Final Methods

In certain situation we create methods and dont want that this method can be overriden, if we want to avoid that situation we must declare this method like final, and this way any of this child class can overriden the method.


		public class Password {

		    private static final int KEY = 786146456;
		    private final int encryptedPassword;

		    public Password(int password) {
		        this.encryptedPassword = encrypDecryp(password);
		    }


		    public int encrypDecryp(int password) {
		        return password ^ KEY;
		    }

		    public final void storePassword() {
		        System.out.println("Saving password as " + this.encryptedPassword);
		    }
		}

As we saw above the method storePassword was marked with final, that means any 	subclassing can override this method	

## Final Classes

Some classes however, should not (and in certain cases can not) be designed to take subclassing into account in a good way. In these cases it makes sense to mark the class as final, even though it limits OOP.

A final class is simply a class that can't be extended.

The final class can extend another non-final class.


		public final class Password {

		    private static final int KEY = 786146456;
		    private final int encryptedPassword;

		    public Password(int password) {
		        this.encryptedPassword = encrypDecryp(password);
		    }
		}

As we saw above the class Password was marked with the final keyword, that means, this class cant be inherited.

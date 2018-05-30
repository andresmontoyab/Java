# Interfaces , Inner Class and Abstract Class

## Interfaces

The interfaces in java are a component that only give the signature of a method.

		public interface ISaveable {
		    ArrayList<String> write();
		    void read(ArrayList<String> savedValues);
		}

Also the interfaces are abstract and we can made our interface a litle bit much flexible, que can replace ArrayList<String> by List, as we saw ArrayList<> extends from List<> and witouth "<>" our interfaces is saying that the List of return can be of any type.

		public interface ISaveable {
		    List write();
		    void read(List savedValues);
		}		

In this way our interface is more flexible and abstract.

As we can see the implementation of the methods write and read isn't in the interface, this must be implement for each class that use this interface.

There are obvious advantages to the interfaces, we guaranteeing what's a contract to confirm that if a class is implementing this interface, it has to implement that code, it's a way to make sure that those particular methods are overwritten

		public class Player implements ISaveable{
			    public List<String> write() {
		        List<String> values = new ArrayList<String>();
		        values.add(0, this.name);
		        values.add(1, "" + this.hitPoints);
		        values.add(2, "" + this.strenght);
		        values.add(3, this.weapon);

		        return values;
		    }

		    public void read(List<String> savedValues) {
		        if (savedValues != null && savedValues.size() > 0 ) {
		            this.name = savedValues.get(0);
		            this.hitPoints = Integer.parseInt(savedValues.get(1));
		            this.strenght = Integer.parseInt(savedValues.get(2));
		            this.weapon = savedValues.get(3);
		        }
		    }
		}

¿Why are usefull the interfaces? --> With the use of the interface we can say that each class the use it, will have a common behaviour, in other words each class that use the interface ISaveable must have to implement write and read.

Another usefull fact about interface is that let us a kind of multi inherence, because we can use diferrent interfaces in a same class. 

We cant instantiate the interface, like:

		ISaveable newISaveable = new ISaveable()

We must instantiate the class that implement the interface

		ISaveable newPlayer = new Player();		

## List<>

		1. List<String> values = new ArrayList<String>();

		2. List<String> valuesLinked = new LinkedList<String>();

## Inner Class

Is a tool provided by java to nested clases.

		public class GearBox {
		    private ArrayList<Gear> gears;
		    private int maxGear;
		    private int currentGear = 0;

		    public GearBox(int maxGear) {
		        this.maxGear = maxGear;
		        this.gears = new ArrayList<Gear>();
		        Gear neutral = new Gear(0, 0.0);
		        this.gears.add(neutral);
		    }

		    public class Gear {
		        private int gearNumber;
		        private double ratio;

		        public Gear(int gearNumber, double ratio) {
		            this.gearNumber = gearNumber;
		            this.ratio = ratio;
		        }

		        public double driveSpeed(int revs) {
		            return revs * (this.ratio);
		        }
		    }
		}

As you can see in the example above, we have a outer class call GearBox and inside of this one another class called Gear.

If I one instantiate the inner class class, i must use the outer class.

       
	        GearBox mcLaren = new GearBox(6);
	        GearBox.Gear first = mcLaren.new Gear(1, 12.3);
	        System.out.println(first.driveSpeed(1000));

## Abstract Class

 Abstraction is when you define the required funcionality for something without actually implementing the data house, in onther words we are focusing on what needs to be done , not on the how it's be done, son interface as you saw are purely abstract and dont specify any actual aspect of the implementation.	        

 We can't instantiate a class that is abstract, we must instantiate	the class that extends this abstract class.

When we create a abstract methods inside of a abstract class, this methods only have the signature like in the interfaces, and the sub class that extends this abstract class must implement these methods.

		public abstract class Animal {

		    private String name;

		    public Animal(String name) {
		        this.name = name;
		    }

		    public abstract void eat();
		    public abstract void breathe();

		    public String getName() {
		        return name;
		    }
		}

As we can saw in the code above, not all methods in a abstract class can be abstract, for example getName() isn't a abstract method.		

## Interface Vs Abstract Class

		1. Abstract class are very similar to interfaces, you cant instantiate and they may contain a mix of methods declared with or without the implementation.

		2. all methods over the interface are automatically public, whereas the methods of the abstract class can have any visibility(private, protected...).

		3. An abstract class can extend only one parent class but it can implement multiple interfaces.

		4. When a abstract class is subclass, the subclass usually provides de implementation for all the abstract methods in its parents class, If it does not , then the subclass must also be declared abstract.

## When use Abstract Class

		1. You want to share code among several closely related classes.		

		2. you want to declare non static or non final fields (for example name, age), this enables you to define methods that can access and modify like getName or setName.

		3. When you have a requirement for your base class to provide a default implementation of certain methods but other methods should be open to being overriden by child classes.

		4. Provide a common definition of a base classes thath multiples deverides classes can share.

## Interfaces

		1. Is only de declaration of methods of an class, its not the implementation.

		2. we define what kind of operation an object can perform. these operations are defined by the class that implements the interface.

		3. The interfaces form a contract between the class and the outside world, and this contract is enforced at build time by the compiler.		

		4. All methods in a interfaces are automatically public and abstract.

		5. An interface can extends another interface.

		6. Interfaces are more flexible and can deal with a lot more stress on the design of your program than the implementation.

		7. the interfaces primary purposes is the abstraction, decoupling the "what" from the "how"-

		8. In java 9 interfaces can also contain private methods(usefull when two methods in a interface share the same code.)

		9. You can use a interfaces when, you expect that unrelated classes will implement your interface, for example, the interface comparable or cloneable are implemented by many unrelated classes.

		10. You want to specify the behavior of specific data, but you're not concerned about who implements its behavior.

		11. You want to separete differente behavior.
		3. An Abstract class can have member variables that are inherited, something that cant be done a interface. A interface can have variable but they are all public static final variables, essentailly are gonna a constant value that never change with the static scope, they have to be static because non static variables require a instance and you can't instantiate an interface.

		2. Interfaces also cannot have constructor but abstract class can.

		

		4. Abstract classes can have defined methods(methods with implementation), whereas all methods in the interface are abstracts. 


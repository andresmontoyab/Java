# Collections



							Collections                    MAP
				__________________|_______________          |
				|          |           |       	 |       SortedMap
			   Set        List       Queue      Deque
			    |
			SortedSet

## Methods Collections

1. Binary Search

Is the fastest way to make a search in a sorted list, works by cheking the element in the midpoint of the list.

	1.To implement the binary search, first we must order our structure. 

	2. We must implement comparable interface and the method compareTo().

	3. Call the function.

	 Seat requestedSeat = new Seat(seatNumber);
	 int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
	 if (foundSeat >= 0) {
	 	// found the specific object	
	 } else {
	 	// cant found the object
	 }	

2. Copy List

In the next example will copy a list using the concept shallow copy, first we have a ArrayList<Seat> call seats in the class theatre, with this object we can create a copy.

		List<Seat> seatCopy = new ArrayList<Seat>(theatre.seats);

In the new object seatCopy will be all the elements of the theatre.seats, but this elements are no Independent, if I modified a element in one list, the other will be modified to, that means that the objects inside the two list are the sames references to the objects inside . 	

3. reverse

Its a method that belong to collection and let reverse a list.
 
		Collections.reverse(seatCopy);

The result will a list with the same values but, this values will be in a reverse order.		

4. shuffle

Its a method that belong to collection and let a random order in a list.
 
		Collections.shuffle(seatCopy);

The result will a list with the same values but, this values will be in a random order.	

5. min and max	

Seatch for the max and min value inside a list.

	    Seat minSeat = Collections.min(seatCopy);
        Seat maxSeat = Collections.max(seatCopy);

# Comparable and Comparator Interfaces

## Comparable

If we want to use the interface comparable we need to follow the next steps.

	1. implement the interface comparable.

	2. Override the method compareTo().

	3. The method compareTo() works this way, the method should return a number less than zero if the object should sort less than the object that is being compared to, and it should return a number greater than zero if we should sort right than the object that's being compared to, and  if the two objects are equals will return 0.

Example

Object implement comparable and method compareTo()

		public class Seat implements Comparable<Seat>{ 
		
		    public int compareTo(Seat seat) {
  		    return  this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
    		}
		}	

Main

Create ArrayList with base to another array

		 List<Seat> reverseSeat = new ArrayList<Seat>(theatre.getSeats());	

Use Collections Methods 

		Collections.sort(reverseSeat);
       
If we dont define the comparable and try to use Collections.sort the program will fail because the way that reverse works is comparing each value with the method compareTo().

## Comparator

The comparator interface defines a single method called compare, unlike comparable the objects to be sorted dont have to implement comparator, instead a object of type comparator can be created with a compare method that can sort the objects that we're interest in. More that one comparator can be created and it allows for object to be sorted in different ways 

Define Comparator.

		public class Theatre {
		 static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
		        public int compare(Seat seat1, Seat seat2) {
		            if (seat1.getPrice() < seat2.getPrice()) {
		                return -1;
		            } else if (seat1.getPrice() > seat2.getPrice()) {
		                return 1;
		            } else
		             return 0;
		        }
		    };
		}

Create a List and sort with help of the comparetor

		 List<Seat> pricesSeat = new ArrayList<Seat>(theatre.getSeats());		    
		        Collections.sort(pricesSeat, Theatre.PRICE_ORDER);		    

# Map

A java map can not contain duplicate Keys and each key can only map to a single value, and each key only map to a single value.

## Using HashMap

For the structures HashMap and HashSet is so import the methods equals and hashCode, because with two methods is based all the structure. We must to ensure the next points.

	1. We must try for the two structores the key(for maps) or de value (set) must be immutable.

	2. For te HashMap we must ensure the key can not have duplicates, and for the Set that the value can noth ave duplicate, for this we must override our equals method.

	3. We must ensure that for a value always return the same HashCode.

	4. We must ensure if a.equals(b) is true then a.hasCode() and b.hasCode() must be equals.

A HashMap is a data structure that implements the interface Map, this structure is also based in the methods hashCode() and equals(), this two methods have the next task, the first one get a key like parameter and return a int called HashValue, and the equals can compare if two object are equals.

after we get a 

			Map<String, String> languagues = new HashMap<String, String>();

Add a element

			languagues.put("Java", "A compiled high level, object oriented, platform independient language.");			

Retrieve element

			languagues.get("Java");		

Remember that in maps we cant repeat information with the same Key, if we add the follow line		

			languagues.put("Java", "A new Definition.");			

The program will override the content with the key Java.

If we want to check a Key has a value we can use the method contains.
  
	        if(languagues.containsKey("Java")){
	            System.out.println("Dont add");
	            // dont add
	        } else {
	            System.out.printf("Add");
	            // add
	        }

Way of iterate a Map. 

   for (String key : languagues.keySet()) {
            System.out.println(key + " : " + languagues.get(key));
        }			

Remember that a Set is a Map without the value field, so when we say languagues.keySet(), this will return all the Keys and in the loop we retrieve all the information that we need.

Remove a elemento with the Key.

 			languagues.remove("Lisp");

For the remove of the object 		

When we store a object in a map new HashMap<Integer, Object>(), the object value is a reference to the object in memory.

## LinkedHashMap

The Link Hash Map is similar to HashMap but with the difference that can mantain de order of added in the structure, if you remember the HashMap is chaotic ordered, but LinkedHashMap no.

 		Map<String, City> cities = new LinkedHashMap<String, City>();

        City medellin = new City("Medellin", 3000000);
        City bogota = new City("Bogota", 7000000);
        City cartagena = new City("Cartagena", 500000);
        City pasto = new City("Pasto", 1000000);

        cities.put(medellin.getName(), medellin);
        cities.put(bogota.getName(), bogota);
        cities.put(cartagena.getName(), cartagena);
        cities.put(pasto.getName(), pasto);

        printCities(cities);

The code Above will return each city in the order that were added to the map.

## TreeMap

The Tree Map is other implementation of the Map, but this implementation does not use the Hashing, It uses a data structure called Red-Black tree. 

As the name itself suggests, working of TreeMap is based on tree data structure. Each node in tree will have three references i.e. its parent, right and left element.

The left element will always be logically less than parent element.

The right element will always be logically greater than OR equal to parent element

The logical comparison of Objects is done by natural order i.e. those object who implement Comparable interface and override compareTo(Object obj) method.

Internally the difference between HashMap and LinkedHashMap is in the second one we add two more nodes called after and before, and are pointing to the after element of the Map and to the before element.        

# Set

A set has no defined ordering number, set can not contain duplicates, if you want to be sure that you dont have any duplicate value in your collection your better option is using a set rather than a list.

Order of elements in a set is implementation dependent. HashSet elements are ordered on hash code of elements. TreeSet elements are ordered according to supplied Comparator (If no Comparator is supplied, elements will be placed in ascending order) and LinkedHashSet maintains insertion order.

The best performance implementation of set is the HashSet class and that uses Hash to store the items.

Random access of elements is not possible.

## HashSet

 HashSet gives constant time performance for insertion, removal and retrieval operations. It allows only one null element.

 HashSet doesn’t maintain any order. The order of the elements will be largely unpredictable. And it also doesn’t guarantee that order will remain constant over time.

## Bulk Operations

Bulk operations are particarly well suited to Sets, when applied, they perform standar set algebraic operations, suppose square and cubes are sets:

     Set<Integer> square = new HashSet<>();
     Set<Integer> cubes = new HashSet<>();

	1. square.containsAll(cubes) --> returns true if cubes is a subset of square.

		 if (union.containsAll(cubes)) {
		 	// cubes is a subset of square.
		 }

	2. square.addAll(cubes) 	  --> Transform square into the union of square and cubes.

	        Set<Integer> union = new HashSet<>(square);
	        union.addAll(cubes);

	3. square.retainAll(cubes)	  --> Transform square into the intersection of square and cubes.

	        Set<Integer> intersection = new HashSet<>(square);
        	intersection.retainAll(cubes);

	4. square.removeAll(cubes)   --> Transform square in the set difference of square and cubes, also know like asymetric differences, and that means all the informacion that is cubes but no is squares.

		 	HashSet<String> nature = new HashSet<>();
	        HashSet<String> divine = new HashSet<>();

	        String natureString = "thee all unknown art nature but to is ";
	        String divineString = "err human forgive divine to is ";

	        String[] natureArray = natureString.split(" ");
	        String[] divineArray = divineString.split(" ");

	        nature.addAll(Arrays.asList(natureArray));
	        divine.addAll(Arrays.asList(divineArray));

	        HashSet<String> diff1 = new HashSet<>(nature);
	        diff1.removeAll(divine);

	5. Symetric difference is elements that appear in one set , or the other but no in both, that is the same that a union of the two set minus the intersection.

	  	HashSet<String> unionSymetric = new HashSet<>(nature);
        unionSymetric.addAll(divine);

        HashSet<String> intersectionSymetric = new HashSet(nature);
        intersectionSymetric.retainAll(divine);

        unionSymetric.removeAll(intersectionSymetric);

Another way to create a set, with a list.

        Set<String> words = new HashSet<>();
        String sentences = " one day in the year of the fox";
        String[] arrayWords = sentences.split(" ");
        words.addAll(Arrays.asList(arrayWords));



1. List<> --> Interface

2. LinkedList<> --> Implements List<> interface

3. ArrayList<>  --> Implements List<> interface

4. Vector  		--> Implements List<> interface

4. Sets         --> Interface

7. HashSet 		--> Implements Sets Interface.

5. Maps         --> Maps

6. HashMap		--> Implements Maps Interface

6. Trees.

6. Queus


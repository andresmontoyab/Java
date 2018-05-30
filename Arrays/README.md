# Array & ArrayList & & AutoBOxing & LinkedList

## Array

Until this moment we only saw a variables like int, String, boolean, but what happends if we need a amount of String, like  List of names? For this reason arise the Array

We can define a List of int

		1. int[] arrayInt = new int[number] --> Number is the size of the array.

		2. int[] arrayInt = {5, 6, 7, 8};

Is important to say that in all arrays the first index position is 0, for example if we want to list the values of the example 2 in console we can do the next.

        System.out.println(arrayInt[0]); // 5
        System.out.println(arrayInt[1]); // 6
        System.out.println(arrayInt[2]); // 7
        System.out.println(arrayInt[3]); // 8

If we want to assign new values we can do it:

		1 arrayInt[0] = 7; // now the value of the position 0 in the array is 7

We also can define a array of String or any kind of object

		String[] strings = {"Carlos", "Andres", "Sofia", "Sara"};

or

 		Object[] objects = new Object[5];
        objects[0] = "Hi There";
        objects[1] = true;
        objects[2] = 4l;
        objects[3] = new Integer(3);

        System.out.println(objects[0].toString());
        System.out.println(objects[1].toString());
        System.out.println(objects[2].toString());
        System.out.println(objects[3].toString());        

A important fact to say is, in the array structure all the information are contiguous in memory, for this reason is easy to know what will be the next value.       

But this kinds of array have a problem , let say that we have a array with 5 position, but after a time we need storage another field, so i need other position in my array, but i can just add a new position, for this i need to recreate another array with more spaces and copy all the information. 

## ArrayList

For the above problem arise the ArrayList Object, this object has the same function of the array, but the JVM deals with the size of the array, if the array needs more space so, the JVM will create another array with more size and copy all the information there.

Define ArrayList

		ArrayList<Integer> arrayInt = new ArrayList<Integer>();

Add Item ArrayList

		arrayInt.add(3);
        arrayInt.add(15);
        arrayInt.add(28);

Search Value ArrayList.

	
        arrayInt.get(0); // 3
        arrayInt.get(1); // 15
        arrayInt.get(2); // 28

## Unboxing.

A important point to understand is that, for the creation of our ArrayList, we must use a Object, its mean ArrayList<Object>, we cant create ArrayList<primitive_type>, like ArrayList<int> or ArrayList<boolean>, but if we want to create a ArrayList<int> we can use a strategy call unboxing, this means wrap up a primitive type to a object, a example of this is int -> Integer, where int is a primitive type and Integer is a Object that represent a int.


## LinkedList

Another Kind of List<> is the LinkedList<>, this kinds of list solve the problem of recreate new arrays if a ArrayList doesnt have more space, this kind of list does not need contiguous values, when we add a value with linkedList this value will be storage in any avaialble space, the most of time are not contiguous spaces.

Define LinkedList

		LinkedList<Integer> intergers = new LinkedList<Integer>();

Add Values.


        intergers.add(8);
        intergers.add(6);
        intergers.add(80);
        intergers.add(85);		

To try to show the memory behavior lets say that:

		intergers.add(8); --> Will be storage in the memory spot 100
		intergers.add(6); --> Will be storage in the memory spot 140
		intergers.add(80); --> Will be storage in the memory spot 132
		intergers.add(85); --> Will be storage in the memory spot 180

LinkedList internally create a node that will contains the next information.

		1. The first memory space
		2. the value of this node
		3. The address of the next node
		Ex: 100 , 8 , 140 --> This means, the position of the node is 100, in this node the value is 8, and then next node is in the position 140.

In the final node of the list the field "the address of then next node" will be null.

## Iterators.

The iterators are the way in which we can explore a LinkedList.

## Iterator in one direction.

This kind of iterator only can move forward to the List.

		1. Iterator<Integer> i = intergers.iterator();

		2. i.hasNext() // Return true if exist a next value or a next node.

		2. i.next()    // Move to the next node in the List.

Usually this three step are used together.

		Iterator<Integer> i = intergers.iterator();		// Create Iterator
		while (i.hasNext()) { 							// Check if exist a next node.
			i.next();									// Move forward.
		}

## Iterator in two directions

This kind of iterador can move forward and backward. This iterator have a special behavior, you can image the iterator is a object that can comunicate the nodes, for this reason the iterator is in between two nodes.

		1. ListIterator<Integer> listIterator = intergers.listIterator();	// Create ListIterator or iterator in two directions	

		2. listIterator.hasNext();											// Check if exist a next node

        3. listIterator.hasPrevious();										// Check if exist a previous node
        
        4. listIterator.next();												// Move forward
        
        5. listIterator.previous();											// Move backward.

As I said above the iterator is between two nodes, and can move to the next or to the previous.

li --> ListIterator
n1 --> Node One
n2 --> Node Two
n3 --> Node Three     

		li n1 n2 n3 // If we say li.next the iterator will take the information of n1 and after that will be between n1 and n2, 
					// If we say li.previous will happen an error because there's nothing before li

		n1 li n2 n3 // If we say li.next the iterator will take the information of n2 and after that will be between n2 and n3.
					// If we say li.previous the iterator will take the information of n1 and after that will be before n1(the initial position)

	   n1 n2 l1 n3  // If we say li.next the iterator will take the information of n3 and after that will be between n3 and n4.
					// If we say li.previous the iterator will take the information of n2 and after that will be between n2 and n3.


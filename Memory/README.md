## Memory In Java

## Basics and Load Static

Whenever you trigger a java command, it divides allocated memory into two parts – Stack and Heap. Stack is used only for execution purpose. Heap is used for storage purpose. consider the following program and we will see how it uses stack and heap memory through diagram.

First java command enters the stack memory for execution. First it checks whether the class A is loaded in heap memory or not. If it is not loaded, loading operation of class A starts.

Randomly one object is created in the heap memory. It is also called Class Memory.  After object creation, all static members are loaded into class memory.


## Non-static

Non-Static variables and Non-Static methods are non-static components of a class. These are also called instance components of a class. Non-static components are stored inside the object memory. Each object will have their own copy of non-static components. But,  static components are common to all objects of that class.

 First it loads class A into heap memory. Randomly some memory is allocated to A. All static members are loaded into this class memory.

 When we instanciate a new object, the first thing is the JVM create this object in the Heap with all the features, and in the stack the JVM will save the reference of the new object create and his direction in the heap.
 
## Garbage Colector

You all know that an object is created in the memory using new operator. Constructor is used to initialize the properties of that object. When an object is no more required, it must be removed from the memory so that that memory can be reused for other objects. Removing unwanted objects or abandoned objects from the memory is called garbage collection (GC).


Whenever you run a java program, JVM creates three threads. 1) main thread   2) Thread Scheduler   3) Garbage Collector Thread. In these three threads, main thread is a user thread and remaining two are daemon threads which run in background.

The task of main thread is to execute the main() method. The task of thread scheduler is to schedule the threads. The task of garbage collector thread is to sweep out abandoned objects from the heap memory. Abandoned objects or dead objects are those objects which does not have live references. Garbage collector thread before sweeping out an abandoned object, it calls finalize() method of that object. After finalize() method is executed, object is destroyed from the memory. That means clean up operations which you have kept in the finalize() method are executed before an object is destroyed from the memory.

## Types of references In Java

Depending upon how objects are garbage collected, references to those objects in java are grouped into 4 types. They are,

## String Inmutables.

n Java, strings are special. Java gives some special attention to string types that no other types enjoy such attention. For example, to create the string objects you need not to use ‘new‘ keyword. Where as to create other type of objects you have to use ‘new’ keyword. Like this, strings enjoy some special attention by the java. This attention is worth the while, because the strings are used almost everywhere while developing any kind of applications.

We all know that JVM divides the allocated memory to a Java program into two parts. one is Stack and another one is heap. Stack is used for execution purpose and heap is used for storage purpose. In that heap memory, JVM allocates some memory specially meant for string literals. This part of the heap memory is called String Constant Pool.

Whenever you create a string object using string literal, that object is stored in the string constant pool and whenever you create a string object using new keyword, such object is stored in the heap memory.

One more interesting thing about String Constant Pool is that, pool space is allocated to an object depending upon it’s content. There will be no two objects in the pool having the same content.

“When you create a string object using string literal, JVM first checks the content of to be created object. If there exist an object in the pool with the same content, then it returns the reference of that object. It doesn’t create new object. If the content is different from the existing objects then only it creates new object.”


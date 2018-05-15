# Concurrency in Java

## Thread

The thread are thw way to implement concurrency in java.

Implemente a Thread

			public class MyRunnable implements Runnable {

			    @Override
			    public void run() {
			        System.out.println(ANSI_CYAN + "Hello from my runnable implementation of run()");
			    }
			}

		   Thread myRunnableThread = new Thread(new MyRunnable());
        	myRunnableThread.start();

or


	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                //action
	            }
	        }).start();        	

## Thread Methods

	1. start(): Begin a declared thread in another execution thread.

	2. run() : Begin a declared thread in the same execution thread where is called.
	
	3. join() : wait that a thread finish the execution.

	4. wait() : the thread wait until be notified. 

	5. notifyAll(): Notify to all the thread to continue the execution.    

## Jave Executor.

The java executor is a tool that provide a better management of the threads in java.

			ExecutorService executorService  = Executors.newFixedThreadPool(3);

The executor deals suitable with execution of the certain amount of threads, in the above code are three threads.

	  		executorService.execute(threadOne);
	        executorService.execute(threadTwo);
	        executorService.execute(ThreadThree);

The executor will start each of these threads.

			executorService.shutdown();	   

We must to use shutdown, to cut the execution of the program.			

If you want to see a example with executor, you can find it in this repository in the package producer_consumer.

## Future Actions.

In some times we need the thread answer, for this reason we need a future answer and we have to wait the thread.

		    Future<String> future = executorService.submit(new Callable<String>() { // Future son utilizados para esperar la respuesta de un thread
		            @Override
		            public String call() throws Exception {
		                System.out.println(ThreadColor.ANSI_RESET + " Im being pritned for the callable clase");
		                return "This is the callable result";
		            }
		        }); 	

As we can see we defined a future varaible thtat will wait the answer for the thread.

 			try {
	            System.out.println(future.get());       // future.get() block until the resource is available
	        } catch (ExecutionException e) {
	            System.out.println("Something went wrong");
	        } catch (InterruptedException e) {
	            System.out.println("Thread running the task was interupted.");
	        }

After the Future variable we have to wait for the answer for this, we use the future.get() function this will block until the resource is available.


## Concurrency Problems

When we used threads can happend some kinds of problems, for example if with two differents thread i want to update the same varaible, in the same moment, maybe the result of the variable will be wrong, for this reason exist a concept called "thread safe", in which we try to implement different strategies to control the threads.

## Thread Safe

For the Thread Safe we can use tools like the statement "synchronized", locks or the package concurrency.atomic.

## Synchronized.

The statement synchronized only let one thread execute the code that was "synchronized"

		    public synchronized String read() {
		        while(empty) {
		            try {
		                wait();     // El hilo esperará hasta ser notificado
		            } catch (InterruptedException e){
		            }
		        }
		        empty = true;
		        notifyAll();        // Notifica a todos los hilos para que continuen con su ejecucion.
		        return message;
		    }

As we can see in the above code we have a synchronized method, that means that only one thread at time can use this method, if another thread want to use it, this thread have to wait. Is important to say that synchronized doest work in the way first come first serve, the JVM allocate any thread.

			try {
                System.out.println(color + "Adding...." + num);
                synchronized (buffer) {
                    buffer.add(num);
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println(color + "ProducerSynchronized was interrupted.");
            }

In the above code we alse can see that we can only synchronized a part of the code(no all method), this is usefull because you only have to worry for the thread safe in particual sections.

## Locks.

The locks are tool provide for java to achieve the task of thread safe, for the use of lock we have to instante a new object of the class ReentrantLock and if use suitable the function lock() and unlock().

			ReentrantLock reentrantLock = new ReentrantLock(); 

This lock will control each thread, if any thread has lock the thread, all the other thread have to wait until the lock be realeased.

		 		reentrantLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    reentrantLock.unlock();
                }

As we can see firstable we use the function lock() under the lock, after that we do the operation that we need (the update or read) and at the end we realeased the lock().

Its important use always the lock management inside in a try-finally block, because we need ALWAYS released the lock if we do not do it, we could causea deadlock.

## Use tryLock()

Java provide us a function called tryLock(), this function say if the lock is available return true, if not return false, with this function we can realize another task meanwhile we wait for the lock.

				if (reentrantLock.tryLock()){ // lock the lock.
					try {
							// do the actions
						} catch () {
							// Excepcion 	
							} finally {
								reentrantLock.unlock();	
							}
				} else {
					// doing another task.
				}

## Fair locks

The fair lock are used to try to solve a problem called startvation, as we said early the locks or synchronized strategies doesnt work with the idea of first come first serve, for this reason if we have five threads, maybe in some situations one of this threads will never execute, and that is startvation.

			private static ReentrantLock lock = new ReentrantLock(true);

We have to instiate a ReentrantLock with the parameter "true", this true say that this lock will be fair.

			threadFair1.setPriority(10);
			threadFair2.setPriority(8);
			threadFair3.setPriority(6);
			threadFair4.setPriority(4);
			threadFair5.setPriority(2);		

Allocate priority to each thread.

			 lock.lock();
               try {
                    // execute critical section of code
                } finally {
                   lock.unlock();
               }

Use the try-finally block with lock.

The fair locks have a drawback, this implementation reduce the performance of the application, because the JVM has to control the fair allocation. 

## Concurrent atomic package.

Is a tool provide for jave that help to make different object more "safe thread", but even we use this tool in some situation we have to use too locks or synchronized.

A example of concurrent.atomic package is the ArrayBlockingQueue, a object that let the use of Queus in a better way for the concurrency, this object will be atomic.    		

## DeadLocks

A deadlock occurs when 2 or more threads and blocked on locks and every thread that's blocked is holding a lock that another block thread want.

For example, thread ones is holding a lock 1 and waiting to acquire lock 2 but, thread 2 is holding block 2 and is waiting to acquire lock 1., because all the thread are block they will never release the locks ther're holding and so none of the waiting threads will actually ever run .

A way to solve this kind of problem is holding the locks in the same order in each thread. Thread 1 first want the lock 1 and Thread 2 too, in this way we can solve some cases of deadlocks.

## Starvation 

Due the synchronization block aren't first come first served, sometimes a thread never win the lock, for this reasson this thread never is executed, and that is know like starvation.

A way to solve the starvation is using fair locks, but this kind of lock reduce the performance of the program.

## LiveLocks

Is similar to Deadlock but instead of the threads been blocked they're actually constantly active and usually waiting for all the other threads to complete their task, now since all the threads are waiting for other to complete none of them can actually progress.

## Slipped Condition

This is a specific type of race condition or also know as (aka) thread interference 

It can occur when a thread can be suspended between reading a condition and acting on it.
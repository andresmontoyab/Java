## Custom Exceptions

When we are programming almost all the time we have to face different situation called Error, this errors are situation that we dont expect in our program and make it crash it, for this reason we have to handle this error with something call exceptions, by default java has its own exceptions, but in some moments its more efficient and maintainable when we define custom Exceptions.


Handle Exception with try/catch block and Throw the custom Exception.

		 try {
            throw new MyNewException();
         } catch (MyNewException e) {
            e.customExceptionMessage();
        }

Custom Exception.


		public class MyNewException extends Exception {

		    final  Logger logger = Logger.getLogger(MyNewException.class.toString());

		    public MyNewException() {
		    }

		    public MyNewException(String message) {
		        super(message);
		    }

		    public MyNewException(String message, Throwable cause) {
		        super(message, cause);
		    }

		    public MyNewException(Throwable cause) {
		        super(cause);
		    }

		    public String customExceptionMessage() {
		        logger.info("The application Failed.");
		        return "The application failed.";
		    }
		}        


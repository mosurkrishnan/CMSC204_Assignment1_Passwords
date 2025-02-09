
public class LengthException extends Exception {

	

	
	/**
	 * Default constructor 
	 * 1.	Length of password is less than 6 characters (class LengthException)
			Message – The password must be at least 6 characters long

	 */
		public LengthException(){	
			super("The password must be at least 6 characters long");
		}
	
}

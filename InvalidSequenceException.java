
public class InvalidSequenceException extends Exception {
	/**
	 * constructor
	 * 6.	Password contains more than 2 of the same character in sequence (class InvalidSequenceException) 
			Message – The password cannot contain more than two of the same character in sequence.

	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}

}

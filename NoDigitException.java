
public class NoDigitException extends Exception {
	/**
	 * Default constructor
	 * 4.	Password doesn’t contain a numeric character (class NoDigitException)
			Message – The password must contain at least one digit

	 */
	public NoDigitException() {
		super("The password must contain at least one digit");
		}

}

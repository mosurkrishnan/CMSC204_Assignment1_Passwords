
public class NoUpperAlphaException extends Exception {
	/**
	 * Basic default constructor
	 * 2.	Password doesn’t contain an uppercase alpha character (class NoUpperAlphaException)
			Message – The password must contain at least one uppercase alphabetic character

	 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}

}

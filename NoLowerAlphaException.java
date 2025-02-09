
public class NoLowerAlphaException extends Exception {

	/**
	 * basic default construtcir
	 * 3.	Password doesn’t contain a lowercase alpha character (class NoLowerAlphaException)
			Message – The password must contain at least one lowercase alphabetic character

	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}

}

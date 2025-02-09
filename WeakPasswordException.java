
public class WeakPasswordException extends Exception {
	/**
	 * default constructor
	 * 7.	Password contains 6 to 9 characters which are otherwise valid (class WeakPasswordException)
			Message – The password is OK but weak - it contains fewer than 10 characters.

	 */
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}

}

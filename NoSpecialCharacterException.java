
public class NoSpecialCharacterException extends Exception {
	/**
	 * Basic constructor
	 * 5.	Password doesn’t contain a special character (class NoSpecialCharacterException)
		Message – The password must contain at least one special character 

	 */
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}


}

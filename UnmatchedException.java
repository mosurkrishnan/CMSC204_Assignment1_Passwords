
public class UnmatchedException extends Exception {

	/**
	 * constructor
	 * ?? how is this linked to GUI ? =- ASK
	 * 8.	For GUI – check if Password and re-typed Password are identical (class UnmatchedException) 
			Message – The passwords do not match
			Throw this exception from the GUI, not the utility class.

	 */
	public UnmatchedException() {
		super("The passwords do not match");
	}
}

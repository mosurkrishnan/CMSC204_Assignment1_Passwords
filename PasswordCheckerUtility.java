import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Chandra Krishnan
 * CMSC204 Assignment 1 Passwords
 * an application that will check for valid passwords.  The following rules must be followed to create a valid password.
	1.	At least 6 characters long
	2.	10 or more characters is a strong password, between 6 and 9 characters is a weak (but acceptable) password.
	3.	At least 1 numeric character
	4.	At least 1 uppercase alphabetic character
	5.	At least 1 lowercase alphabetic character
	6.	At least 1 special character
	7.	No more than 2 of the same character in a sequence

 */
public class PasswordCheckerUtility {
	
	/**
	 * isValidLength
	 * Checks the password length requirement - The password must be at least 6 characters long
	@param password - password string to be checked for length
	@return true if meets minimum length requirement
	@throws LengthException - thrown if does not meet minimum length requirement
	 */
	public static boolean isValidLength(String password) throws LengthException {
		//System.out.println("1st method");
	    if (password.length() < 6) {
	    	throw new LengthException();
	    } else {
	      return true;
	    }
	  }
	/**
	 * hasDigit
	 * Checks the password Digit requirement - Password must contain atleast 1 "digit" or numeric character
	@param password - password string to be checked for Digit requirement
	@return true if meets Digit requirement
	@throw NoDigitException - thrown if does not meet Digit requirement
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
	    for (int i = 0; i < password.length(); i++) {
	        if (Character.isDigit(password.charAt(i))) {
	            return true; 
	            // if 1st digit is found then returns true
	            // assumption - once a digit is found - no need for further iteration
	        }
	    }
	    throw new NoDigitException(); // Throw exception if no digit is found
	}
	/**
	 * Checks the password lowercase requirement - Password must contain at least one lowercase alpha character
	 * 3.	Password doesn’t contain a lowercase alpha character (class NoLowerAlphaException)
	Message – The password must contain at least one lowercase alphabetic character

	@param password - password string to be checked for lowercase requirement
	@return true if meets lowercase requirement
	@throws NoLowerAlphaException - thrown if does not meet lowercase requirement
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
	    for (int i = 0; i < password.length(); i++) {
	    	// for loop checks each alphabet
	        if (Character.isLowerCase(password.charAt(i))) {
	            return true; 
	            // Return true when a lowercase letter is found
	            // assumption - once a lowercase is found - no need for further iteration
	        }
	    }
	    throw new NoLowerAlphaException(); // Throw exception if no lowercase letter is found
	}
	
	/**
	 * hasUpperAlpha
	 * Checks the password alpha character requirement - Password must contain an uppercase alpha character
	@param password - password string to be checked for alpha character requirement
	@returns true if meet alpha character requirement
	@throws NoUpperAlphaException - thrown if does not meet alpha character requirement
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
	    for (int i = 0; i < password.length(); i++) {
	    	// for loop checks each alphabet for uppercase
	        if (Character.isUpperCase(password.charAt(i))) {
	            return true; 
	            // Return true when a uppercase letter is found
	            // assumption - once a uppercase is found - no need for further iteration
	        }
	    }
	    throw new NoUpperAlphaException(); // Throw exception if no uppercase letter is found
	}
	/**
	 * hasSpecialChar
	 * Checks the password SpecialCharacter requirement - Password must contain a Special Character
	 * To check for a special symbol, use the “regular expression” construct.  
	 * Check the whole password, not just an individual character, using the following :
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(str);
		return (!matcher.matches());

	@param password - password string to be checked for SpecialCharacter requirement
	@return true if meets SpecialCharacter requirement
	@throws NoSpecialCharacterException - thrown if does not meet SpecialCharacter requirement
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		String reg="[a-zA-Z0-9]*";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(password);
		
		if(matcher.matches()) { // if it "matches" then only letters and numbers are present(no special characters)
								// so throw exception
			throw new NoSpecialCharacterException();
		}		
		else {					// if this reaches "else" - means the password contains a special character
			return true;
		}
	}
	/**
	 * isWeakPassword
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	@param password - string to be checked if weak password
	@return false if the password is valid and the length of password is NOT between 6 and 9 (inclusive).
	@throws WeakPasswordException - if length of password is between 6 and 9 (inclusive), 
	ALTHOUGH the password may be VALID.
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
	    // Check if the password length is between 6 and 9 (inclusive)
	    if (password.length() >= 6 && password.length() <= 9) {
	        throw new WeakPasswordException();
	        // will throw exception if >= 6 and <+ 9
	    } else {
	    
	    return false; }// practically an else statement. False means it's not a weak password 
	}
	/**
	 * isValidSequence (labeled in Javadoc as NoSameCharInSequence)
	 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	Parameters:
	@param password - password string to be checked for Sequence requirement
	Returns:
	@return false if does NOT meet Sequence requirement
	Throws:
	@throws InvalidSequenceException - thrown if meets Sequence requirement
	 */
	public static boolean isValidSequence(String password) throws InvalidSequenceException {        
		int count = 1; // Counter for repeats

	    for (int i = 1; i < password.length(); i++) {
	        if (password.charAt(i) == password.charAt(i - 1)) { 
	            count++; // Increasin count if character repeats
	            if (count > 2) { 
	                throw new InvalidSequenceException();
	            }
	        } else {
	            count = 1; // Resetting counter when different character is there
	        }
	    }
	    return true; // If no invalid sequence - return true
	}
	
	/**
	 * isValidPassword
	 * This method will check the validity of one password and return true if the password is valid and 
	 * throw one or more exceptions if invalid.  (Refer to java doc for the list of the exceptions thrown)
	 * Return true if valid password (follows all the following rules), returns false if an invalid password 
	 * 1. At least 6 characters long - 
	 * 2. At least 1 numeric character- 
	 * 3. At least 1 uppercase alphabetic character - 
	 * 4. At least 1 lowercase alphabetic character - 
	 * 5. At least 1 special character - 
	 * 6. No more than 2 of the same character in a sequence - Hello@123 – OK AAAbb@123 – not OK Aaabb@123 – OK
		@param - password - string to be checked for validity
		@return true if valid password (follows all rules from above), false if an invalid password
		
		@throws LengthException - thrown if length is less than 6 characters
		@throws NoUpperAlphaException - thrown if no uppercase alphabetic
		@throws  NoLowerAlphaException - thrown if no lowercase alphabetic
		@throws NoDigitException - thrown if no digit
		@throws NoSpecialCharacterException - thrown if does not meet SpecialCharacter requirement
		@throws InvalidSequenceException - thrown if more than 2 of same character.
	 */
	
	public static boolean isValidPassword(String password) throws 
									LengthException, NoUpperAlphaException, NoLowerAlphaException, 
									NoDigitException, NoSpecialCharacterException, InvalidSequenceException, 
									WeakPasswordException {
									// not sure weakPasswordException is needed here. 
		return isValidLength(password) && hasUpperAlpha(password)
		        && hasLowerAlpha(password) && hasDigit(password)
		        && hasSpecialChar(password) && isValidSequence(password);
		  }
	
	/**
	 * getInvalidPasswords
	 * This method will accept an ArrayList of passwords as the parameter and return an ArrayList 
	 * with the status of any invalid passwords (weak passwords are not considered invalid)
	 * The ArrayList of invalid passwords will be of the following format:
		<password><blank><message of exception thrown>

		Parameters:
		@param passwords - list of passwords
		Returns:
		@return ArrayList of invalid passwords in the correct format (not weak)
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 * @throws WeakPasswordException 
	 */
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
        ArrayList<String> invalidPasswords = new ArrayList<>();
        // creating a new array list of invalid passwords
        
        for (int i = 0; i < passwords.size(); i++) {
        	
        	String word = passwords.get(i);
            try {
            	
                isValidPassword(passwords.get(i)); // will throw exception if invalid
            } catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | 
 		           NoDigitException | NoSpecialCharacterException | InvalidSequenceException ex) { 
                invalidPasswords.add(passwords.get(i) + " -> " + ex.getMessage());
            }
            catch (WeakPasswordException e) { // weak password is still acceptable. do not add it to a invalid password list  
            }
        }  
        return invalidPasswords;
    }
	
	/**
	 * comparePasswords
	 * Compare equality of two passwords
		@param password - password string to be checked for
		@param passwordConfirm - passwordConfirm string to be checked against password for
		@throws UnmatchedException - thrown if not same (case sensitive)
		
		public static void comparePasswords​(java.lang.String password, java.lang.String passwordConfirm) 
											throws UnmatchedException
	 */
	public static void comparePasswords​(String password, String passwordConfirm) 
			throws UnmatchedException{
		if (!password.equals(passwordConfirm)) {
			// if password IS NOT EQUAL TO passwordConfirm 
			throw new UnmatchedException();
		}
	        
	}
	/**
	 * comparePasswordsWithReturn
	 * Checks the password length requirement - The password must be at least 6 characters long
		@param password - password string to be checked for length
		@return true if meets minimum length requirement
		@throws LengthException - thrown if does not meet minimum length requirement
		public static boolean comparePasswordsWithReturn​(String password, String passwordConfirm)
	 */
	public static boolean comparePasswordsWithReturn​(String password, String passwordConfirm) 
			throws LengthException {
			// throws LengthException is not part of javadoc
		if (password.length() < 6) {
			// is password is < 6 characters !
	        throw new LengthException();
	    }
	    return password.equals(passwordConfirm);
	    // returns true if equal
	}
	
}


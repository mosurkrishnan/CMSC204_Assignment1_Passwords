import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DriverAsSurrogateForJunitTesting {

	public static void main(String[] args) throws UnmatchedException {
		List<String> initialValues = Arrays.asList("334455BB#", "george2ZZZ#", 
				"4Sale#", "bertha22","august30","a2cDe", "ApplesxxYYzz#", "aa11bb", "pilotProject",
				"myPassword", "myPassword2", "AAAbb@123");
        ArrayList<String> arrayList = new ArrayList<>(initialValues);
        String  s1 = "Password123", s2 = "Thisw1llPas$@123", s3 = "David"; 
        String s4 = "NoNumber$!", s5 = "ValidTrue@123", s6 = "weakpassword", s7 = "CMSC204";
        String s8 = "abcd"; // for compareWithReturn
	        // "Password123"    // No special character - INVALID
	       	// "Thisw1llPas$@123"       // invalid sequence 2 LL's
	        // "David"            // Too short - INVALID
	        // "NoNumber$!"    // No digit - INVALID
	        // "ValidTrue@123"      // Valid
	        // "weakpassword"  // No digit, no special char, no upper alpha - INVALID
	       	// "CMSC204"   // No lowerAplha, no special char, weak password - INVALID
			
		System.out.println(" ****** checking isValid Length*********\n");
		System.out.println("String is - " + s3);
				try{ 
					if (PasswordCheckerUtility.isValidLength(s3)) {
	                    System.out.println(s3 + " is valid length.");}
					}
				catch (LengthException e)
					{System.out.println(s1 + " is not valid length.");
					}
		System.out.println("isValid Length - works\n" );
//**********************************************************************			
		System.out.println(" ****** checking hasDigit*********\n");
		System.out.println("String is - " + s4);
				try{
					if (PasswordCheckerUtility.hasDigit(s4)) {
	                    System.out.println(s4 + " has digit.");}
					}
				catch (NoDigitException e)
					{System.out.println(s4 + " has no digits.");
					}
		System.out.println("isValid Length - works\n" );
//**********************************************************************					
		System.out.println(" ****** checking hasLowerAlpha*********\n");
		System.out.println("String is - " + s7);
				try{
					if (PasswordCheckerUtility.hasLowerAlpha(s7)) {
			            System.out.println(s7 + " has lower alpha.");}
					}
				catch (NoLowerAlphaException e)
					{System.out.println(s7 + " has no lowerAlpha.");
					}
		System.out.println("hasLowerAlpha - works\n" );

				//**********************************************************************					
				System.out.println(" ****** checking hasUpperAlpha*********\n");
				System.out.println("String is - " + s6);
						try{
							if (PasswordCheckerUtility.hasUpperAlpha(s6)) {
					            System.out.println(s2 + " has upper alpha.");}
							}
						catch (NoUpperAlphaException e)
							{System.out.println(s6 + " has NO UpperAlpha.");
							}
				System.out.println("hasUpperAlpha - works\n" );
				//**********************************************************************					
				System.out.println(" ****** checking hasSpecialChar*********\n");
				System.out.println("String is - " + s7);
						try{
							if (PasswordCheckerUtility.hasSpecialChar(s7)) {
					            System.out.println(s7 + " is valid.");}
							}
						catch (NoSpecialCharacterException e)
							{System.out.println(s7 + " has no SpecialChar.");
							}
				System.out.println("hasSpecialChar - works - VERIFY THIS\n" );
				//**********************************************************************				
				System.out.println(" ****** checking isWeakPassword*********\n");
				System.out.println("String is - " + s7);
						try{
							if (PasswordCheckerUtility.isWeakPassword(s7)) {
					            System.out.println(s3 + " is strong password.");}
							}
						catch (WeakPasswordException e)
							{System.out.println(s7 + "  isWeakPassword.");
							}
				System.out.println("isWeakPassword - works \n" );
				//**********************************************************************		
				System.out.println(" ****** checking isValidSequence*********\n");
				System.out.println("String is - " + s2 + " 2L's");
						try{
							if (PasswordCheckerUtility.isValidSequence(s2)) {
					            System.out.println(s2 + " is valid.");}
							}
						catch (InvalidSequenceException e)
							{System.out.println(s2 + " NOT ValidSequence.");
							}
				System.out.println("isValidSequence - works \n" );
				//**********************************************************************		
				System.out.println(" ****** checking isValidPassword*********\n");
				System.out.println("String is - " + s5 );
						try{
							if (PasswordCheckerUtility.isValidPassword(s5)) {
					            System.out.println(s5 + " is valid password.");}
							}
						catch (InvalidSequenceException | LengthException | NoDigitException | NoLowerAlphaException | 
								NoUpperAlphaException | NoSpecialCharacterException | 
								WeakPasswordException e)
							{System.out.println(s5 + " NOT Valid password.");
							}
				System.out.println("isValidSequence - works \n" );
				//**********************************************************************			
				System.out.println(" ****** checking comparePasswords​*********\n");
				System.out.println("Strings are - " + s4 +  " " + s3);
						try{
							PasswordCheckerUtility.comparePasswords​(s4, s3); 
						    System.out.println(s4 + s3 + " is equal.");}
						catch(UnmatchedException e) {System.out.println(s4 + s3 + " not equal");
						    };			    
				System.out.println("comparePasswords - works \n" );
				//*******************************************************		
				System.out.println(" ****** checking comparePasswordsWithReturn​*********\n");
				System.out.println("Strings are - " + s3 +  " " + s4);
				try{
					PasswordCheckerUtility.comparePasswordsWithReturn​(s3, s4); 
				    System.out.println(s4 + " is > 6 characters.");}
				catch(LengthException e) {System.out.println(s3 + " less than 6 characters");
				    };			    		    
				System.out.println("comparePasswordsWithReturn - works \n" );
				//*******************************************************
				System.out.println(" ****** checking hasSpecialChar​*********\n");
				System.out.println("Strings are - " + s6);
				try{
					if (PasswordCheckerUtility.hasSpecialChar(s6)) {
			            System.out.println(s6 + " has Special Chars.");}
					}
				catch (NoSpecialCharacterException e)
					{System.out.println(s6 + " NO Special Chars.");
					}
				System.out.println("isValidSequence - works \n" );
				//*******************************************************    
				System.out.println(" ****** checking invalidPasswords ArrayList*********\n");
//				List<String> initialValues = Arrays.asList("Password123", "Thisw1llPas$@123", 
//						"David", "NoNumber$!","ValidTrue@123","weakpassword", "CMSC$904" );
//				ArrayList<String> arrayList = new ArrayList<>(initialValues);
				        
				        // Print invalid passwords
				        System.out.println("Invalid Passwords:");
				      // Get invalid passwords
				        ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(arrayList);
				        for (int i = 0; i < invalidPasswords.size(); i++) 
				        {
				        	System.out.println(invalidPasswords.get(i));
				        }	
				 //******************************************************
				        System.out.println(" \n****** Does isValidLength Throw LengthException*********\n");
						System.out.println("String is - " + s3);
								try{ 
									PasswordCheckerUtility.isValidLength(s3) ;
									}
								catch (LengthException e)
									{System.out.println(s1 + " Password Validation Error " + e.getMessage());
									}
						System.out.println("Throws LengthException message - works\n" );
				

	}
}



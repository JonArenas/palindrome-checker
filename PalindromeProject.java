import java.util.Random;

//By: Brooke Williamson and Jonathan Arenas
public class PalindromeProject
{
    public static void main(String[] args) {
		
        int TOTAL_ELEMENTS = 10;                                                   //Sets 'TOTAL_ELEMENTS' as the value given
        int randomNumber;
        char randomChar;
		//char character = 'a';                                                      //Sets 'character' as the value given

        char[] charArray = new char[TOTAL_ELEMENTS];                               //Declares 'charArray' with 'TOTAL_ELEMENTS' elements

        StringBuilder stringBuilder = new StringBuilder();                         //Creates a method for adding char values into a forward String
		Random random = new Random();
		
        for (int i = 0; i < charArray.length; i++) {                               //Populates 'charArray' with alphanumeric characters
            randomNumber = random.nextInt(26 + 10);                          
            
            if (randomNumber < 26) {
                randomChar = (char) ('a' + randomNumber);
            } else {
                randomChar = (char) ('0' + (randomNumber - 26));
            }
			charArray[i] = randomChar;
            //charArray[i] = character;                                              //Sets current array element as the provided character
            stringBuilder.append(charArray[i]);                                    //Adds the character to 'stringBuilder' each loop iteration
        }

        String string = stringBuilder.toString();                                 //Sets 'string' as all 'charArray' chars combined into a String

        System.out.println("String: " + string);                                                           //Prints 'string'
        System.out.println("Is the String a Palindrome? " + isPalindrome(string));                             //Checks if 'string' is a palindrome
    }

    public static boolean isPalindrome(String stringChecker) {               //Method to check if a string is a palindrome
        
		long startTime = System.nanoTime(); 
        stringChecker = stringChecker.toLowerCase();                         //Converts the string to all lowercase characters
        
        int left = 0;                                                        //Pointer for the start of the string
        int right = stringChecker.length() - 1;                              //Pointer for the end of the string

        while (left < right) {                                               //Loop through the string until the pointers meet or cross
            if (stringChecker.charAt(left) != stringChecker.charAt(right)) { //Check if the characters at the left and right pointers are different
				System.out.println("Time Taken: " + (System.nanoTime() - startTime) + " nanoseconds");
				return false;                                                //If characters are different, the string is not a palindrome
            }
            left++;                                                          //Move the left pointer towards the right
            right--;                                                         //Move the right pointer towards the left
        }
        System.out.println("Time Taken: " + (System.nanoTime() - startTime) + " nanoseconds");
		return true;                                                         //If all characters match, the string is a palindrome
    }
}
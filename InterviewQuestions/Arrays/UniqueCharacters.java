/* 
 *Implement an algorithm to determine if a string 
 *has all unique characters. What if you cannot 
 *use additional data structures?
 *Assume capitalize characters are different
 */
import java.util.*; 

public class UniqueCharacters {

  public static void  main(String[] args) {
    String test = "angelica";
    String test2 = "Tuan";
    testMethods(test);
    testMethods(test2);
  }

  static void testMethods(String testString) {
    System.out.println("Test hasUniqueCharacters method");
    if (hasUniqueCharacters(testString)) {
      System.out.println("string " + testString + " has unique characters");
    } else {
      System.out.println("string " + testString + " doesn't have unique characters");
    }
    System.out.println("Test hasUniqueCharactersTwo method");
    if (hasUniqueCharactersTwo(testString)) {
      System.out.println("string " + testString + " has unique characters");
    } else {
      System.out.println("string " + testString + " doesn't have unique characters\n");
    }
  }


  // Using extra data-structures
  // Time O(n)
  // Space O(n)
  public static boolean hasUniqueCharacters(String input) {
    if(input == null){
      return false;
    } 
    if(input.length() < 2) {
      return true;
    }
    Set<Character> charsFound = new HashSet<Character>();
    for(int i = 0; i < input.length() ; i++){
      char curr = input.charAt(i);
      if(charsFound.contains(curr)) {
        return false;
      }
      charsFound.add(curr);
    }
    return true;
  }

  // Not additional data-structures
  // Time O(n^2)
  // Space O(1)
  public static boolean hasUniqueCharactersTwo(String input) {
    if(input == null){
      return false;
    }
    int stringLength = input.length();
    if(stringLength < 2) {
      return true;
    }
    char currChar;
    for(int i = 0; i < stringLength; i++){
      currChar = input.charAt(i);
      for(int j = i+1; j < stringLength; j++){
        if(currChar == input.charAt(j)){
          return false;
        }
      }
    }
    return true;
  }
}
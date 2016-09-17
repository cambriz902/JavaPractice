/* Implement a method to perform basic string compression 
 * using the counts of repeated characters. For example, 
 * the string aabcccccaaa would become a2b1c5a3. If the 
 * "compressed" string would not become smaller than the 
 * original string, your method should return the original string.
 */

public class StringCompression{

  public static void main(String[] args){
    String test = "aabcccccaaa";
    String testTwo = "aa";

    System.out.println(test);
    System.out.println(compress(test));
    System.out.println(testTwo);
    System.out.println(compress(testTwo));
  }

  public static String compress(String input){
    if(input == null || input.length()< 3){
      return input;
    }
    char prevChar = input.charAt(0);
    int currCount = 1;
    String compressedString = "";
    char currChar;
    for(int i = 1; i < input.length(); i++){
      currChar = input.charAt(i);
      if(prevChar == currChar) {
        currCount++;
      } else {
        compressedString = compressedString + prevChar + currCount;
        currCount = 1;
        prevChar = currChar;
      }
    }
    compressedString = compressedString + prevChar + currCount;
    if(compressedString.length() < input.length()) {
      return compressedString;
    }
    return input;
  }
}
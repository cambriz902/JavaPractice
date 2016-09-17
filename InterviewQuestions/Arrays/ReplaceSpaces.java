/* Write a method to replace all spaces in a string 
 * with '%20'. You may assume that the string has
 * sufficient space at the end of the string to hold 
 * the additional characters, and that you are given
 * the "true" length of the string. (Note: if imple-menting 
 * in Java, please use a character array so that you 
 * can perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith 
 * Output: "Mr%20Dohn%20Smith"
 */

import java.util.*;

public class ReplaceSpaces{ 

  public static void main(String[] args){
    String[] test = {"M", "r", " ", "J", "o", "h", "n", " ", "S", "m", "i", "t", "h", " ", " ", " ", " "};
    System.out.println(Arrays.toString(replaceSpaces(test)));
  }
  
  // Time O(n)
  // Space O(1)
  public static String[] replaceSpaces(String[] array) {
    if (array == null) {
      return array;
    }
    int trueIndex = array.length - 1;
    boolean firstCharFound = false;
    for(int i = array.length - 1; i >= 0; i--){
      String currChar = array[i];
      if(!firstCharFound && currChar != " ") {
        firstCharFound = true;
      }
      if(firstCharFound) {
        if(currChar == " "){
          array[trueIndex] = "0";
          trueIndex--;
          array[trueIndex] = "2";
          trueIndex--;
          array[trueIndex] ="%";
        } else {
          array[trueIndex] = currChar;
        }
        trueIndex--;
      }
    }
    return array;
  } 
}

/*Given two strings, write a method to decide 
 *if one is a permutation of the other.
 */

import java.util.*;

public class StringPermutation {

  public static void main(String[] args){
    String testOne = "yolo";
    String testTwo = "looy";
    String testThree = "loya";

    testStrings(testOne, testTwo);
    testStrings(testOne, testThree);
  }

  public static void testStrings(String testOne, String testTwo){
    if(arePermutations(testOne, testTwo)){
      System.out.println(testOne + " is a permutation of " + testTwo);
    } else {
      System.out.println(testOne + " isn't a permutation of " + testTwo); 
    }
  }

  // Time O(n)
  // Space O(n)
  public static boolean arePermutations(String stringOne, String stringTwo){
    if(stringOne == null || stringTwo == null) {
      return false;
    }
    if(stringOne.length() != stringTwo.length()){
      return false;
    }
    HashMap<Character, Integer> charactersFound = new HashMap<Character, Integer>();
    int charCount;
    for(int i = 0; i < stringOne.length(); i++){
      char currChar = stringOne.charAt(i);
      if(charactersFound.containsKey(currChar)){
        charCount = charactersFound.get(currChar);
        charactersFound.replace(currChar, charCount + 1);
      } else {
        charactersFound.put(currChar, 1);
      }
    }
    for(int j = 0; j < stringTwo.length(); j++){
      char currChar = stringTwo.charAt(j);
      if(!charactersFound.containsKey(currChar)){
        return false;
      }
      charCount = charactersFound.get(currChar);
      charCount = charCount - 1;
      if(charCount == 0){
        charactersFound.remove(currChar);
      } else {
        charactersFound.replace(currChar, charCount);
      }
    }
    return true;
  }
}
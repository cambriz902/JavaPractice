package Algorithm;

import java.util.HashSet;

public class LinkedListAlgoOne {
	/*
	 *Implement an algorithm to determine if a string has all unique characters. What
	 *if you cannot use additional data structures?
	 */

	
	//find if string contains Unique characters using hashset
	//Run Time = O(n) where n is the length of our input string 
	//because we have to check all the character to see if the string is unique
	//Space = O(n) where n is the length of our input string 
	//because we have to save all the previous characters we have checked in the string
	public boolean hasUniqueChars(String input){
		if(input == null || input.length() > 26){
			return false;
		}
		if(input.length() < 2){
		return true;
		}
		HashSet<Character> charSet = new HashSet<Character>();
		for(int i = 0; i < input.length(); i++){
			if(charSet.contains(input.charAt(i))){
				return false;
			}
			charSet.add(input.charAt(i));
		}
		return true;
	}
}

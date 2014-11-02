package Algorithm;

public class ReplaceSpaces{
	
	/*Write a method to replace all spaces in a string with'%20'. You may assume that
	 *the string has sufficient space at the end of the string to hold the additional
	 *characters, and that you are given the "true" length of the string. (Note: if implementing
	 *in Java, please use a character array so that you can perform this operation
	 *in place.)
	 *EXAMPLE
 	 *Input: "Mr John Smith"
	 *Output: "Mr%20Dohn%20Smith"
	 */

	public static String replaceSpaces(String inputString){
		if(inputString == null || inputString.length() == 0){
			return inputString;
		}
		String newString = "";
		for(int i = 0; i < inputString.length(); i++){
			if(inputString.charAt(i) == ' '){
				newString += "%20";
			} else {
				newString += inputString.charAt(i);
			}
		}
		return newString;
	}

}
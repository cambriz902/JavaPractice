package Algorithm;

public class IsRotation{
	
	/*Assume you have a method isSubstring which checks if one word is a
	 *substring of another. Given two strings, s1 and s2, write code to check if s2 is
	 *a rotation of s1 using only one call to isSubstring (e.g.,"waterbottle"is a rotation
	 *of "erbottlewat").
	 */

	public static boolean isRotation(String stringOne, String stringTwo){
		if(stringOne.length() == stringTwo.length()){
			return isSubstring(stringTwo+stringTwo, stringOne);
		}
		return false;
	}

	private static boolean isSubstring(String stringOne, String subString){
		if(stringOne == null || subString == null){
			return false;
		}
		if(stringOne.length() < subString.length()){
			return false;
		};
		int startIndex = 0;
		int firstCharacter = 0;
		boolean isSubstring  = false;
		boolean newStartIndex = false;
		for(int i = 0; i < stringOne.length();i++){
			if(startIndex == subString.length()){
				return true;
			}
			if( (stringOne.length() - i)  < (subString.length() - startIndex) ){
				return false;
			}
			if(stringOne.charAt(i) == subString.charAt(startIndex)){
				if(startIndex == 0){
					isSubstring = true;
					firstCharacter = i + 1;
				} else if (isSubstring && !newStartIndex){
					firstCharacter = i;
					newStartIndex = true;
				}
				startIndex++;
			} else if (isSubstring ){
				isSubstring = false;
				i = firstCharacter;
				newStartIndex = false;
				startIndex = 0;
			}
		}
		if(startIndex == subString.length()){
			return true;
		}
		return false;
	}
}

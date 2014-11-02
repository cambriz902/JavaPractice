package Algorithm;

public class CompressString{
	/*Implement a method to perform basic string compression using the counts
	 *of repeated characters. For example, the string aabcccccaaa would become
	 *a2blc5a3. If the "compressed" string would not become smaller than the original
	 *string, your method should return the original string.
	 */

	public static String compressString(String inputString){
		if(inputString == null || inputString.length() < 3){
			return inputString;
		}
		String newString = "";
		char currChar;
		char lastChar = '1';
		Integer repeated = 1;
		for(int i = 1; i < inputString.length();i++){
			lastChar = inputString.charAt(i -1);
			currChar = inputString.charAt(i);
			if(lastChar == currChar){
				repeated++;
			} else {
				newString += lastChar + repeated.toString();
				repeated = 1;
			}
			lastChar = currChar;
		}
		if(repeated != 1){
			newString += lastChar + repeated.toString();
		} else {
			newString += lastChar + '1';
		}

		if(newString.length() < inputString.length()){
			return newString;
		}
		return inputString;
	}
}

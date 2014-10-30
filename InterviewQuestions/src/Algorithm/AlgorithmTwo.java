package Algorithm;

import java.util.HashMap;

public class AlgorithmTwo{
	
	/*Given two strings, write a method to decide if one is a permutation of the other.*/
	public static boolean isPermutation(String stringOne, String stringTwo){
		if(stringOne == null || stringTwo == null){
			return false;
		}
		if(stringOne.length() != stringTwo.length()){
			return false;
		}
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		Integer objValue;
		for(int i = 0; i < stringOne.length();i++){
			if(map.containsKey(stringOne.charAt(i))){
				map.put(stringOne.charAt(i),(int)map.get(stringOne.charAt(i))+1);
			} else {
				map.put(stringOne.charAt(i), 1);
			}
		}
		for(int i = 0; i < stringTwo.length();i++){
			if(map.containsKey(stringTwo.charAt(i))){
				objValue = map.get(stringTwo.charAt(i));
				if ( objValue < 2){
					map.remove(stringTwo.charAt(i));
				} else {
					map.put(stringTwo.charAt(i), (int)map.get(stringTwo.charAt(i))-1);
				}
			} else {
				return false;
			}
		}
		return true;
	}
}

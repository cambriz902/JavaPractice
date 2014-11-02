package Algorithm;
import DataStructures.*;

public class AddListNumbers {
	/*You have two numbers represented by a linked list, where each node contains a
	 *single digit. The digits are stored in reverse order, such that the Ts digit is at the
	 *head of the list. Write a function that adds the two numbers and returns the sum
	 *as a linked list.
	 *EXAMPLE
	 *Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
	 *Output: 2 -> 1 -> 9.That is, 912.
 	 *FOLLOW UP
	 *Suppose the digits are stored in forward order. Repeat the above problem.
	 *EXAMPLE
 	 *Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
	 *Output: 9 -> 1 -> 2.That is, 912.
	 */

	public static LinkedList sumLists(LinkedList ListOne, LinkedList ListTwo){
		if(ListOne == null || ListTwo == null){
			return null;
		}
		int ListOneNumber = getNumberFromList(ListOne);
		System.out.println(ListOneNumber);
		int ListTwoNumber = getNumberFromList(ListTwo);
		int sum = ListOneNumber + ListTwoNumber;
		LinkedList List = getListFromNumber(sum);
		return List;
	}

	public static int getNumberFromList(LinkedList List){
		if(List == null){
			return -1; //When number is negative there is an error
		}
		int number = 0;
		int numberLocation = 10;
		for (int i = 0; i < List.getLength(); i++){
			number += List.getValueAtIndex(i) * (Math.pow(numberLocation,i));
		}
		return number;
	}

	public static LinkedList getListFromNumber(int number){
		if( number < 0){
			return null;
		}
		LinkedList List = new LinkedList();
		while(number > 0){
			List.insertBack(number%10);
			number = number/10;
		}
		return List;
	}
}

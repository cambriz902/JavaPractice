import java.util.HashMap;

import DataStructures.*;
import Algorithm.*;
public class Test{

	public static void main(String[] args){
		testLinkedList();
		testSecretSantaGenerator();
	}

	//test methods for LinkedList class
	public static void  testLinkedList(){
		LinkedList ListOne = new LinkedList();
		LinkedList ListTwo = new LinkedList();
		int[] testArray = {1,2,3,4,5};
		for(int i = 0; i < testArray.length;i++){
			ListOne.insertFront(testArray[i]);
			ListTwo.insertBack(testArray[i]);
		}
		ListOne.printList(); //print 5,4,3,2,1
		ListTwo.printList(); //print 1,2,3,4,5
		System.out.println(ListOne.getLength()); //print 5
		ListOne.deleteFirst(); //delete head
		ListOne.printList(); //print 4,3,2,1
		ListOne.deleteLast();  //delete tail
		ListOne.printList(); //print 4,3,2
		ListOne.deleteIndex(1); //delete element at index 1(second from head)
		ListOne.printList(); //print 4,2
		System.out.println(ListOne.getLength()); //print 2
	}
	
	public static void testSecretSantaGenerator(){
		String[] people = {"Pikachu","Charmender","Mew","Zaptos","Entei","Eve","Lapras"};
		HashMap<String,String> pairing = SecretSantaGenerator.matcher(people);
		SecretSantaGenerator.printHashMap(pairing);
		
	}
}
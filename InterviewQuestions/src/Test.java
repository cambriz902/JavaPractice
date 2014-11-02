import java.util.HashMap;

import DataStructures.*;
import Algorithm.*;
public class Test{

	public static void main(String[] args){
		//testLinkedList();
		//testSecretSantaGenerator();
		//testIsPermutation();
		//testReplaceSpaces();
		//testCompressString();
		//testRotateMatrix();
		//testExpandZeros();
		//testIsRotation();
		//testDeleteDuplicates();
		//testGetElementKDistanceFromTail();
		//testDeleteElementInMiddleOfList();
		//testPartitionList();
		testAddListNumbers();
		
		//test random code
		/*long[] inputArray =  {1,2,3,4,5,6,7,8,9};
		double arrayLength = inputArray.length;
		arrayLength = (double) Math.pow(arrayLength,.5);
		System.out.println("length = " + inputArray.length + " square of length = " + arrayLength);
		*/
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
	
	public static void testIsPermutation(){
		
		String stringOne = "abccd";
		String stringTwo = "cadcb";
		String stringThree ="abdcacc";
		if(AlgorithmTwo.isPermutation(stringOne, stringTwo)){
			System.out.println(stringOne + " is a permutation of " + stringTwo);
		}
		if(!AlgorithmTwo.isPermutation(stringOne, stringThree)){
			System.out.println(stringOne + " is not a permutation of " + stringThree);
		}
	}
	
	public static void testReplaceSpaces(){
		String inputString = "Mr John Smith";
		String newString = ReplaceSpaces.replaceSpaces(inputString);
		System.out.println(inputString); // prints Mr John Smith
		System.out.println(newString); // prints Mr%20John%20Smith
	}
	
	public static void testCompressString(){
		String stringOne = "aabcccccaaa";
		String stringTwo = "aabbccdddz";
		System.out.println(CompressString.compressString(stringOne)); // prints a2b1c5a3
		System.out.println(CompressString.compressString(stringTwo)); // prints aabbccdddz because new compress String is same length
	}
	
	public static void testRotateMatrix(){
		long[] inputArray =  {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		long[][] matrix = RotateMatrix.createMatrix(inputArray); //Returns an NxN matrix
		RotateMatrix.printMatrix(matrix); // print matrix
		System.out.println("***************************");
		RotateMatrix.printMatrix(RotateMatrix.ninetyDegrees(matrix)); //Return a new matrix rotated by ninety degrees and print it
		System.out.println("***************************");
		RotateMatrix.ninetyDegreesInPlace(matrix);// Rotate matrix in place
		RotateMatrix.printMatrix(matrix);// print matrix rotated ninety degrees
	}
	
	public static void testExpandZeros(){
		int[] inputArrayOne =  {0,2,3,4,5,6,7,8,9,10,11,12,13,14,0,16,17,18,19,20,21,22,23,24,25};
		int[] inputArrayTwo = {1,2,3,0,4,5,6,7,8,0,9,10};
		int[][] matrixOne = ExpandZeros.createMatrix(inputArrayOne,5,5); //create matrix
		int[][] matrixTwo = ExpandZeros.createMatrix(inputArrayTwo, 3, 4);
		ExpandZeros.printMatrix(matrixOne,5,5); // print matrixOne
		System.out.println("***************************");
		ExpandZeros.expandZeros(matrixOne, 5,5); // expand zeros matrixOne
		ExpandZeros.printMatrix(matrixOne,5,5); //print matrixOne
		System.out.println("***************************");
		ExpandZeros.printMatrix(matrixTwo, 3, 4); // print matrixTwo
		System.out.println("***************************");
		ExpandZeros.expandZeros(matrixTwo, 3, 4); //expand Zeros matrixTwo
		ExpandZeros.printMatrix(matrixTwo, 3, 4); // print matrixTwo
	}
	
	public static void testIsRotation(){
		String stringOne = "waterbottle";
		String stringTwo = "erbottlewat";
		String stringThree = "ottlewatwat"; //should break algorithm
		String stringFour = "erbottleawa";
		//all if statements should pass and print
		if(IsRotation.isRotation(stringOne, stringTwo)){
			System.out.println(stringTwo + " is a rotation of " + stringOne);
		}
		if(!IsRotation.isRotation(stringOne, stringThree)){
			System.out.println(stringThree + " is not a rotation of " + stringOne);
		}
		if(!IsRotation.isRotation(stringOne, stringFour)){
			System.out.println(stringFour + " is not a rotation of " + stringOne);
		}
	}
	
	public static void testDeleteDuplicates(){
		LinkedList List = new LinkedList();
		int[] testData = {1,2,3,5,1,26,7,2,1};
		for(int i = 0; i < testData.length;i++){
			List.insertBack(testData[i]);
		}
		List.printList(); // prints the list 1,2,3,5,1,26,7,2,1
		List.deleteDuplicates(); // Deletes duplicates 1,2,1
		List.printList(); // print new list 1,2,3,5,26,7
	}
	
	public static void testGetElementKDistanceFromTail(){
		LinkedList List = new LinkedList();
		int[] testData = {1,2,3,4,5,6,7};
		for(int i = 0; i < testData.length;i++){
			List.insertBack(testData[i]);
		}
		int k = 3;
		List.printList(); // prints the list 1,2,3,4,5,6,7
		System.out.println(List.getElementKDistanceFromTail(k)); // Get element 3 distance from tail (4)
	}
	
	public static void testDeleteElementInMiddleOfList(){
		LinkedList List = new LinkedList();
		int[] testData = {1,2,3,4,5,6,7};
		for(int i = 0; i < testData.length;i++){
			List.insertBack(testData[i]);
		}
		int index = 3;
		List.printList(); // prints the list 1,2,3,4,5,6,7
		List.deleteElementAtIndex(index); // delete element at index 3
		List.printList(); // print the list 1,2,3,5,6,7
	}
	
	public static void testPartitionList(){
		LinkedList List = new LinkedList();
		int[] testData = {14,21,32,4,5,6,7,6,10,1,2,15};
		for(int i = 0; i < testData.length;i++){
			List.insertBack(testData[i]);
		}
		int partition = 6;
		List.printList(); // prints the list 14,21,32,4,5,6,7,10,1,2,15
		List.partitionListWithValue(partition); // partition list around 6
		List.printList(); // print the list 4,5,1,2,21,6,7,6,10,32,14,15
	}
	
	public static void testAddListNumbers(){
		int numberOne = 617;
		int numberTwo = 295;
		LinkedList ListOne = AddListNumbers.getListFromNumber(617);
		ListOne.printList(); // print 7,1,6
		LinkedList ListTwo = AddListNumbers.getListFromNumber(295);
		ListTwo.printList(); // print 2,9,5
		LinkedList ListSum = AddListNumbers.sumLists(ListOne, ListTwo);
		ListSum.printList(); // print 2,1,9
		System.out.println("sum of " + numberOne + " + " + numberTwo + " = " + AddListNumbers.getNumberFromList(ListSum)); // print 912
	}
}





























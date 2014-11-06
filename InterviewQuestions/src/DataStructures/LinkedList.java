package DataStructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

//LinkedList
public class LinkedList{
	private Node head;
	private Node curr;
	private Node tail;
	private int length;
	private boolean loops;

	public class Node{
		Node next;
		Node prev;
		int data;

		public Node(){}

		public Node(int data){
			this.next = null;
			this.prev = null;
			this.data = data;
		}
	}

	public LinkedList(){
		this.head = null;
		this.curr = null;
		this.tail = null;
		this.length = 0;
		this.loops = false;
	}

	public LinkedList(int[] input){
		this.head = null;
		this.curr = null;
		this.tail = null;
		this.length = 0;
		this.loops = false;
		for(int i = 0; i < input.length;i++){
			insertBack(input[i]);
		}
	}
	
	public boolean isEmpty(){
		if (head == null){
			return true;
		}
		return false;
	}

	public void insertFront(int data){
		Node temp = new Node(data);
		if( isEmpty() ){
			head = temp;
			curr = temp;
			tail = temp;
		} else {
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
		length++;
	}

	public void insertBack(int data){
		Node temp = new Node(data);
		if( isEmpty() ){
			head = temp;
			tail = temp;
			curr = temp;
		} else {
			temp.prev = tail;
			tail.next = temp;
			tail = temp;
		}
		length++;
	}

	//index starts from 0 to length-1
	public void insertAtIndex(int index, int data) {
		if(index >= length){
			return;
		}
		Node temp = new Node(data);
		curr = head;
		while(index > 1){
			curr = curr.next;
			index--;
		}
		temp.prev = curr;
		temp.next = curr.next;
		curr.next = temp;
		curr = temp.next;
		curr.prev = temp;
	}

	public int getValueAtIndex(int index){
		if(index >= length){
			return 0;
		}
		curr = head;
		while (index > 0){
			curr = curr.next;
			index--;
		}
		return curr.data;
	}

	public void printList(){
		if (isEmpty()){
			return;
		}
		curr = head;
		while (curr.next != null){
			System.out.print(curr.data +",");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}

	//Delete first element
	public void deleteFirst(){
		if( isEmpty()){
			return;
		}
		if( length == 1){
			head = null;
			tail = null;
			curr = null;
		} else {
			curr = head.next;
			head.next = null;
			curr.prev = null;
			head = curr;
		}
		length--;
	}

	//Delete last Element
	public void deleteLast(){
		if( isEmpty()){
			return;
		}
		if(length == 1){
			head = null;
			tail = null;
			curr = null;
		} else {
			curr = tail.prev;
			curr.next = null;
			tail.prev = null;
			tail = curr;
		}
		length--;
	}

	public void deleteIndex(int index){
		if(index >= length){
			return;
		}
		if(index == 0) {
			deleteFirst();
		} else if (index == length - 1){
			deleteLast();
		} else {
			curr = head;
			while( index > 1){
				curr = curr.next;
				index--;
			}
			curr.next = curr.next.next;
			curr = curr.next;
			curr.prev = curr.prev.prev;
			length--;
		}
	}
	
	//Write code to remove duplicates from an unsorted linked list.
	public void deleteDuplicates(){
		if( isEmpty()){
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		curr = head;
		int index = 0;
		while(curr != null){
			if(set.contains(curr.data)){
				curr =  curr.next;
				deleteIndex(index);
			} else {
				set.add(curr.data);
				curr = curr.next;
				index++;
			}
		}

	}
	
	//Implement an algorithm to find the kth to last element of a singly linked list.
	public int getElementKDistanceFromTail(int k){
		if(length <= k){
			return -1; // if data cant be negative this is an error
		}
		if(k ==0 ){
			return tail.data;
		}
		int counter = k;
		Node temp = head;
		curr = head;
		while(counter > 0){
			curr = curr.next;
			counter--;
		}
		while(curr.next != null){
			curr = curr.next;
			temp = temp.next;
		}
		return temp.data;
	}
	
	/*Implement an algorithm to delete a node in the middle of a singly linked list,
	 *given only access to that node.
	 */
	public void deleteElementAtIndex(int index){
		if(index >= length-1 || index == 0){
			return;
		}

		curr = head; 
		//point to node we want to delete
		while(index > 0){
			curr = curr.next;
			index--;
		}
		Node temp = curr.next;
		curr.data = temp.data;
		curr.next = curr.next.next;
		temp = temp.next;
		temp.prev = curr;
	}
	
	/*Write code to partition a linked list around a value x, such that all nodes less than
	 *x come before all nodes greater than or equal to x.
	 */
	public void partitionListWithValue(int partition){
		if( isEmpty() ){
			return;
		}
		curr = head;
		Node temp = head.next;
		while(temp != null){
			if(curr.data >= partition){
				if(temp.data <partition){
					int holdData = temp.data;
					temp.data = curr.data;
					curr.data = holdData;
				}
				temp = temp.next;
			} else {
				curr = curr.next;
				if(curr == temp){
					temp = temp.next;
				}
			}
		}
	}
	
	/*Given a circular linked list, implement an algorithm which returns the node at
	 *the beginning of the loop.
	 *DEFINITION
	 *Circular linked list: A (corrupt) linked list in which a node's next pointer points
	 *to an earlier node, so as to make a loop in the linked list.
	 *EXAMPLE
	 *Input: A - > B - > C - > D - > E - > C [the same C as earlier]
	 *Output: C
	 */
	public int getFirstElementInLoop(){
		if(isEmpty()){
			return -1;
		}
		curr = head;
		Node fastPointer = head;
		boolean start = false;
		while(curr != fastPointer || !start){
			curr = curr.next;
			fastPointer = fastPointer.next.next;
			if(!start){
				start = true;
			}
		}
		curr = head;;
		while(curr != fastPointer){
			curr = curr.next;
			fastPointer = fastPointer.next;
		}
		return fastPointer.data;
	}
	
	public void loopAtIndex(int index){
		if (length <= index){
			return;
		}
		curr = head;
		while(index > 0){
			curr = curr.next;
			index--;
		}
		tail.next = curr;
		loops = true;
	}
	
	public boolean doesLoop(){
		return loops;
	}
	
	//Implement a function to check if a linked list is a palindrome.
	public boolean isPalindrome(){
		if(isEmpty()){
			return false;
		}
		if(length == 1){
			return true;
		}
		Node slowPointer = head;
		Node fastPointer = head;
		Node prevSlowPointer = head;
		Node nextHalf;
		Node mid = null;
		Boolean isPalindrome = true;
		while(fastPointer != null && fastPointer.next != null){
		prevSlowPointer = slowPointer;
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		if(fastPointer != null){
			mid = slowPointer;
			slowPointer = slowPointer.next;
		}
		nextHalf = slowPointer;
		prevSlowPointer.next = null;
		reverseSecondHalf(nextHalf);
		isPalindrome = compareListHalves(nextHalf);
		if(mid != null){
			prevSlowPointer.next = mid;
			mid.next = nextHalf;
		} else {
			prevSlowPointer.next = nextHalf;
		}
		return isPalindrome;
	}

	public boolean compareListHalves(Node mid){
		while( mid != null){
			curr = head;
			Node temp = mid;
			if(temp.data != curr.data){
				return false;
			}
			temp = temp.next;
			curr = curr.next;
		}
		return true;
	}
	
	public void reverseSecondHalf(Node midNode){
		if(midNode == null){
			return;
		}
		Node next = null;
		curr = midNode;
		Node prev = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		midNode = prev;
	}
	
	public int getLength(){
		if(isEmpty()){
			return 0; //can throw an exception
		}
		return length;
	}
}
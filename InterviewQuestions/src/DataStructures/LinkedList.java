package DataStructures;

//LinkedList
public class LinkedList{
	private Node head;
	private Node curr;
	private Node tail;
	private int length;

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
	
	public int getLength(){
		if(isEmpty()){
			return 0; //can throw an exception
		}
		return length;
	}
}
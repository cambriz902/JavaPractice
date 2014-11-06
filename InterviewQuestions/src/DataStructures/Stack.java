package DataStructures;

public class Stack{
	Node top;
	Node min;
	Node curr;
	Node buttom;
	int items;
	
	public class Node{
		Node up;
		Node lastMin;
		Node down;
		int data;
		
		public Node(){}
		
		public Node(int data){
			this.up = null;
			this.down = null;
			this.lastMin = null;
			this.data = data;
		}
		
	}
	
	public Stack(){
		this.top = null;
		this.min = null;
		this.curr = null;
		this.buttom = null;
		this.items = 0;
	}
	
	public Stack(int[] input){
		if(input == null){
			return;
		}
		for(int i = 0; i < input.length;i++){
			push(input[i]);
		}
	}
	
	public void push(int data){
		Node newNode = new Node(data);
		if(isEmpty()){
			top = newNode;
			buttom = newNode;
			min = newNode;
		} else {
			if(newNode.data < min.data){
				newNode.lastMin = min;
				min = newNode;
			}
			top.up = newNode;
			newNode.down = top;
			top = newNode;
		}
		items++;
	}
	
	public int pop(){
		if(isEmpty()){
			return -1; //negative means error
		}
		int data = top.data;
		if(items == 1){
			buttom = null;
			top = null;
			min = null;
		} else {
			if(top.data == min.data){
				min = top.lastMin;
			}
			top = top.down;
			top.up = null;
		}
		items--;
		return data;
	}
	
	public int peek(){
		if(isEmpty()){
			return -1;//negative means error;
		}
		return top.data;
	}

	public int getMin(){
		if(isEmpty()){
			return -1;
		}
		return min.data;
	}
	public boolean isEmpty(){
		if(items == 0){
			return true;
		}
		return false;
	}
	
	public int items(){
		return items;
	}
	
	public void printStack(){
		if(isEmpty()){
			return;
		}
		curr = top;
		while (curr.down != null){
			System.out.print(curr.data + ",");
			curr = curr.down;
		}
		System.out.println(curr.data);
	}
}


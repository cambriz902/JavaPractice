package DataStructures;

import java.util.ArrayList;

public class SetOfStacks{
	ArrayList<StackNode> Stacks;
	ArrayList<StackNode> StacksTop;
	StackNode top;
	int currStack;
	int items;
	int maxStackSize;

	class StackNode{
		StackNode up;
		StackNode down;
		int data;

		public StackNode(int data){
			this.up = null;
			this.down = null;
			this.data = data;
		}
	}

	public SetOfStacks(int stackSize){
		this.Stacks = new ArrayList<StackNode>();
		this.StacksTop = new ArrayList<StackNode>();
		this.top = null;
		this.currStack = 0;
		this.items = 0;
		this.maxStackSize = stackSize;
	}

	public void push(int data){
		StackNode newNode = new StackNode(data);
		if(items%maxStackSize == 0 && !isEmpty()){
			StacksTop.add(currStack,top);
			currStack++;
			Stacks.add(currStack, newNode);
		} else {
			if(isEmpty()){
				top = newNode;
				Stacks.add(currStack,newNode);
			} else {
				top.up = newNode;
				newNode.down = top;
			}
		}
		items++;
		top = newNode;
	}

	public int pop(){
		if( isEmpty() ){
			return -1;
		}
		int data;
		if(items%maxStackSize == 1){
			data = top.data;
			Stacks.remove(currStack);
			if(items != 1){
				currStack--;
				top = StacksTop.get(currStack);
			}
		} else {
			data = top.data;
			top = top.down;
		}
		items--;
		return data;
	}

	public int peek(){
		if(isEmpty()){
			return -1;
		}
		return top.data;
	}
	
	public int stacks(){
		if (isEmpty()){
			return -1;
		}
		return currStack+1;
	}
	
	public int items(){
		if(isEmpty()){
			return -1;
		}
		return items;
	}
	
	public boolean isEmpty(){
		if(items == 0){
			return true;
		}
		return false;
	}
}
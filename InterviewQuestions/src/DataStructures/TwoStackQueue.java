package DataStructures;

public class TwoStackQueue{
	boolean pushLast;
	StackArray pushStack;
	StackArray popStack;
	int items;

	public TwoStackQueue(int stackSize){
		this.pushLast = true; 
		this.pushStack = new StackArray(stackSize);
		this.popStack = new StackArray(stackSize);
		this.items = 0;
	}

	public void push(int data){
		if(!pushLast){
			swapToPushStack();
		}
		pushStack.push(data);
		items++;
		pushLast = true;
	}

	public int pop(){
		if(isEmpty()){
			return -1;
		}
		if(pushLast){
			swapToPopStack();
		}
		pushLast = false;
		items--;
		return popStack.pop();
	}

	public void swapToPushStack(){
		if(popStack.items == 0){
			return;
		}
		while( popStack.items > 0){
			pushStack.push(popStack.pop());
		}
	}

	public void swapToPopStack(){
		if(pushStack.items == 0){
			return;
		}
		while(pushStack.items > 0){
			popStack.push(pushStack.pop());
		}
	}
	
	public int items(){
		return items;
	}
	public boolean isEmpty(){
		if(items == 0){
			return true;
		}
		return false;
	}
}
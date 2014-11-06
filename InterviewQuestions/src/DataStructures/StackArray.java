package DataStructures;

public class StackArray {
	int[] array;
	int top;
	int curr;
	int buttom;
	int items;

	public StackArray(int size){
		this.array = new int[size];
		this.top = 0;
		this.curr = 0;
		this.buttom = 0;
		this.items = 0;
	}

	public void push(int data){
		if(isEmpty()){
			array[top] = data;
		} else {
			top++;
			array[top] = data;
		}
		items++;
	}

	public int peek(){
		if(isEmpty()){
			return -1;
		}
		return array[top];
	}

	public int pop(){
		if(isEmpty()){
			return -1;
		}
		int data = array[top];
		if(items != 1){
			top--;
		}
		items--;
		return data;
	}

	public void printStack(){
		if(isEmpty()){
			return;
		}
		for(curr = items -1; curr > 0; curr--){
			System.out.print(array[curr] + ",");
		}
		System.out.println(array[curr]);
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

}

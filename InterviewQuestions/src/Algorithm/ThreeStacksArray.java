package Algorithm;

public class ThreeStacksArray{
	int stackSize;
	StackNode stacks[];
	int items;
	int stackOneItems;
	int stackTwoItems;
	int stackThreeItems;
	int stackOneTop;
	int stackTwoTop;
	int stackThreeTop;
	int nextFreeSpace;

	class StackNode{
		int lastIndex;
		int data;

		public StackNode(int data){
			this.lastIndex = 0;
			this.data = data; 
		}
	}

	//Constructor that takes in the size of stack array
	public ThreeStacksArray(int size){
		this.stackSize = size;
		this.stacks = new StackNode[stackSize];
		this.items = 0;
		this.stackOneItems = 0;
		this.stackTwoItems = 0;
		this.stackThreeItems = 0;
		this.stackOneTop = -1;
		this.stackTwoTop = -1;
		this.stackThreeTop = -1;
		this.nextFreeSpace = 0;
	}


	public boolean pushStackOne(int data){
		if(isFull()){
			return false;
		}
		StackNode newNode = new StackNode(data);
		newNode.lastIndex = stackOneTop;
		stacks[nextFreeSpace] = newNode;
		nextFreeSpace++;
		items++;
		stackOneItems++;
		return true;
	}

	public int popStackOne(){
		if(stackOneItems == 0){
			return -1;
		}
		int data = stacks[stackOneTop].data;
		stackOneTop = stacks[stackOneTop].lastIndex;
		nextFreeSpace--;
		stackOneItems--;
		items--;
		return data;
	}

	public boolean pushStackTwo(int data){
		if(isFull()){
			return false;
		}
		StackNode newNode = new StackNode(data);
		newNode.lastIndex = stackTwoTop;
		stacks[nextFreeSpace] = newNode;
		nextFreeSpace++;
		items++;
		stackTwoItems++;
		return true;
	}

	public int popStackTwo(){
		if(stackTwoItems == 0){
			return -1;
		}
		int data = stacks[stackTwoTop].data;
		stackTwoTop = stacks[stackTwoTop].lastIndex;
		nextFreeSpace--;
		stackTwoItems--;
		items--;
		return data;
	}

	public boolean pushStackThree(int data){
		if(isFull()){
			return false;
		}
		StackNode newNode = new StackNode(data);
		newNode.lastIndex = stackThreeTop;
		stacks[nextFreeSpace] = newNode;
		nextFreeSpace++;
		items++;
		stackThreeItems++;
		return true;
	}

	public int popStackThree(){
		if(stackThreeItems == 0){
			return -1;
		}
		int data = stacks[stackThreeTop].data;
		stackOneTop = stacks[stackThreeTop].lastIndex;
		nextFreeSpace--;
		stackThreeItems--;
		items--;
		return data;
	}

	public boolean isFull(){
		if(stackSize == items){
			return true;
		}
		return false;
	}
}

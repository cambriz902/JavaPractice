package DataStructures;

public class MinHeap{
	int items;
	int nextIndex;
	int[] heap;
	int heapSize;

	public MinHeap(int size){
		if(size < 1){
			return;
		}
		this.items = 0;
		this.nextIndex = 1;
		this.heapSize = size+1;
		this.heap = new int[heapSize];
	}

	public void insert(int data){
		if(nextIndex > heapSize){
			doubleTableSize();
		}
		int parent;
		if(nextIndex %2 == 0){
			parent = nextIndex / 2;
		} else {
			parent = (nextIndex - 1) / 2;
		}
		heap[nextIndex] = data;
		while(parent >= 1){
			if(heap[parent] <= heap[nextIndex]){
				break;
			}
			int temp = heap[parent];
			heap[parent] = heap[nextIndex];
			heap[nextIndex] = temp;
		}
		nextIndex++;
		items++;
	}

	public void doubleTableSize(){
		int[] newHeap = new int[heapSize*2];
		for(int i = 1; i <= heapSize;i++){
			newHeap[i] = heap[i];
		}
		heap = newHeap;
	}

	public int getMin(){
		if( isEmpty() ){
			return -1;
		}
		return heap[1];
	}
	public int removeMin(){
		if( isEmpty() ){
			return -1;
		}
		int data = heap[1];
		nextIndex = nextIndex - 1;
		heap[1] = heap[nextIndex];
		balanceMinHeap();
		items--;
		return data;
	}

	public void balanceMinHeap(){
		if(nextIndex == 0){
			return;
		}
		int parent = 1;
		int leftChild = parent*2;
		int rightChild = parent*2 + 1;
		int temp;
		while(parent < nextIndex && leftChild < nextIndex && rightChild < nextIndex){
			if(heap[parent] > heap[leftChild]){
				temp = heap[parent];
				heap[parent] = heap[leftChild];
				heap[leftChild]= temp;
				parent = leftChild;
				leftChild = parent*2;
				rightChild = parent*2 +1;
			} else if ( heap[parent] > heap[rightChild]){
				temp = heap[parent];
				heap[parent] = heap[rightChild];
				heap[rightChild] = temp;
				parent = rightChild;
				leftChild = parent*2;
				rightChild = parent*2+1;
			} else {
				break;
			}
		}
	}
	public void printHeap(){
		if( isEmpty() ){
			return;
		}
		for(int i = 1; i < items; i++){
			System.out.print(heap[i] + ",");
		}
		System.out.println(heap[items]);
	}

	public boolean isEmpty(){
		if(items == 0){
			return true;
		}
		return false;
	}
}

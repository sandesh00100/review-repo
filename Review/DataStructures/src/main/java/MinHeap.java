import java.util.Arrays;

/**
 * 					3
 * 				  /   \
 * 				 4     8
 * 			   /  \   / \
 * 			  9    7 10  9
 *          / \   / 
 *         15 20 13
 * Can be stored as [3,4,8,9,7,10,9,15,20,13]
 * We're using an array because there is a specific way that nodes are added to the heap.
 * From left to right and it's always a complete binary tree (every thing is filled except maybe the last row which is filled from left to right)
 * @author Sandesh
 *
 * Heapsort
 * Heap Construction uses <= 2N compares and exchanges
 * Heapsort uses<= 2NlogN compares and exchange
 *
 *
 * Mergesort: takes linear extra space
 * quicksort: qudratic time worst case senario
 * heapsort: inplace NlogN worst case
 *
 * Heap sort is optimal for both time and space
 * but
 * 	the inner loop takes longer than quicksorts
 * 	makes poor use of cache memory
 * 	not stable
 */
public class MinHeap {
	private int capacity = 3;
	private int size = 0;

	int[] items = new int[capacity];

	public MinHeap(int[] a) {
		// Heapify
		this.size = a.length;
		ensureExtraCapicity();
		for (int i=0; i < this.size; i++){
			items[i] = a[i];
		}

		for(int i = (size-1)/2; i >= 0; i--){
			heapifyDown(i);
		}

	}

	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	};

	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	};

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	};

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	};

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	};

	private boolean hasParent(int index) {
		return getParentIndex(index) >= size;
	};
	
	
	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	
	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	
	private int parent(int index) {
		return items[getParentIndex(index)];
	}
	
	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	/**
	 * If it's full then double the capacity of the array. Basically how an array list operates.
	 */
	private void ensureExtraCapicity() {
		while(size >= capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	/**
	 * Look at the top of the tree
	 * @return root of the tree
	 */
	public int peek() {
		if (size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	/**
	 * Take out the top of the tree and replace it with the last element
	 * @return top of the tree
	 */
	public int poll() {
		if (size == 0) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		items[size] = item;
		heapifyDown(0);
		return item;
	}
	
	private void heapifyDown(int index) {
		// If it doesn't have a left child then it wont have a right with how it's ordered
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			// If the smaller child is already greater than the current node then exit
			if (items[smallerChildIndex] > items[index]) {
				break;
			} else {
				swap(smallerChildIndex,index);
			}
			
			index = smallerChildIndex;
		}
	}
	
	public void add(int item) {
		ensureExtraCapicity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	/**
	 * Make sure 
	 */
	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > items[index]) {
			int parentIndex = getParentIndex(index);
			swap(index, parentIndex);
			index = parentIndex;
		}
	}

	public int[] sort() {
		while(size>0){
			poll();
		}
		return this.items;
	}
	
}

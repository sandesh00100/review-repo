import java.util.EmptyStackException;

public class Stack<T> {
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	// Top -> .. -> .. -> Bottom
	private StackNode<T> top;
	
	/**
	 *  From: Top -> Next -> ... -> Bottom
	 *  To: Next -> ... -> Bottom
	 * @return Top of the stack
	 */
	public T pop() {
		// Stack is empty throw exception
		if (top == null) throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}
	
	/**
	 * From: OldTop -> Next -> ... -> Bottom
	 * To: newItem -> OldTop -> Next -> ... -> Bottom
	 * @param newItem
	 */
	public void push(T newItem) {
		StackNode<T> newNode = new StackNode<T>(newItem);
		newNode.next = top;
		top = newNode;
	}
	
	/**
	 * 
	 * @return Top of the stack
	 */
	public T peek() {
		if (top == null) throw new EmptyStackException();
		return top.data;
	}
	
	/**
	 * Checks if stack is empty
	 * @return
	 */
	public boolean isEmpty() {
		return top == null;
	}
}
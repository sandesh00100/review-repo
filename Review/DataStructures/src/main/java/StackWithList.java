import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Every operation takes constant time in the worst case
 * Uses extra time and space to deal with links
 * @param <T>
 */
public class StackWithList<T> implements Stack<T>, Iterable<T>{
	
	// Top -> .. -> .. -> Bottom
	private LinkedListNode<T> top;
	
	/**
	 *  From: Top -> Next -> ... -> Bottom
	 *  To: Next -> ... -> Bottom
	 * @return Top of the stack
	 */
	@Override
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
	@Override
	public void push(T newItem) {
		LinkedListNode<T> newNode = new LinkedListNode<T>(newItem);
		newNode.next = top;
		top = newNode;
	}
	
	/**
	 * 
	 * @return Top of the stack
	 */
	@Override
	public T peek() {
		if (top == null) throw new EmptyStackException();
		return top.data;
	}
	
	/**
	 * Checks if stack is empty
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator<>(top);
	}
}

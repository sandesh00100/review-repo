import java.util.*;
import java.util.function.Consumer;

/**
 * First in first out data structure
 * TODO: Create a priority queue
 * @author Sandesh
 *
 */
public class QueueWithList<T> implements Queue<T>, Iterable<T>{
	@Override
	public Iterator<T> iterator(){
		return new ListIterator(first);
	}
	
	private LinkedListNode<T> first;
	private LinkedListNode<T> last;
	
	/**
	 *  From:	First -> ... -> Last
	 *  To:		First -> ... -> Last -> newItem
	 * @param newItem
	 */
	@Override
	public void enqueue(T newItem) {
		LinkedListNode<T> newNode = new LinkedListNode<T>(newItem);
		if (last != null) {
			last.next = newNode;
		}
		last = newNode;
		if (first == null) {
			first = last;
		}
	}
	
	/**
	 * From:	First -> next -> ... -> Last
	 * To:		next -> ... -> last
	 * Also called dequeue
	 * @return the element after the first node
	 */
	@Override
	public T dequeue() {
		if (first == null) throw new NoSuchElementException();
		T data = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		}
		return data;
	}
	
	/**
	 * 
	 * @return First element
	 */
	@Override
	public T peek() {
		if (first == null) throw new NoSuchElementException();
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}

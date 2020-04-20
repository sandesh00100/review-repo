import java.util.NoSuchElementException;

/**
 * First in first out data structure
 * TODO: Create a priority queue
 * @author Sandesh
 *
 */
public class QueueWithList<T> implements Queue<T>{
	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	/**
	 *  From:	First -> ... -> Last
	 *  To:		First -> ... -> Last -> newItem
	 * @param newItem
	 */
	@Override
	public void enqueue(T newItem) {
		QueueNode<T> newNode = new QueueNode<T>(newItem);
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

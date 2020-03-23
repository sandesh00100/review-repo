/*
 * TODO: impplement runner technique
 */
public class LinkedListNode<T> {
	LinkedListNode<T> next = null;
	T data;

	public LinkedListNode(T d) {
		this.data = d;
	}

	public void appendToTail(T d) {
		LinkedListNode<T> end = new LinkedListNode<T>(d);
		LinkedListNode<T> n = this;
		
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	public LinkedListNode<T> deleteNode(LinkedListNode<T> head, T d) {
		LinkedListNode<T> currentNode = head;
		
		if (currentNode.next.data == d) {
			return currentNode;
		}
		
		while (currentNode.next != null) {
			if (currentNode.next.data == d) {
				currentNode.next = currentNode.next.next;
				return head;
			}
			currentNode = currentNode.next;
		}
		
		return head;
		
	}
	
	
}

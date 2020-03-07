package dataStructures;

/*
 * TODO: impplement runner technique
 */
public class LinkedListNode {
	LinkedListNode next = null;
	int data;

	public LinkedListNode(int d) {
		this.data = d;
	}

	public void appendToTail(int d) {
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	public LinkedListNode deleteNode(LinkedListNode head, int d) {
		LinkedListNode currentNode = head;
		
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

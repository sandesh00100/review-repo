import java.util.Iterator;

public class ListIterator<T> implements Iterator<T> {
    private LinkedListNode<T> currentNode;
    public ListIterator(LinkedListNode node) {
        currentNode = node;
    }
    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public T next() {
        T item = currentNode.data;
        currentNode = currentNode.next;
        return item;
    }
}

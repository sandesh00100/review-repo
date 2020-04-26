import java.util.Iterator;

public class QueueWithArray<T> implements Queue<T>, Iterable<T>{
    private T[] queue;
    private int headIndex;
    private int tailIndex;
    private int size;
    private final int START_CAPACITY = 10;

    public QueueWithArray() {
        queue = (T[]) new Object[START_CAPACITY];
        size = 0;
        headIndex = 0;
        tailIndex = 0;
    }

    @Override
    public void enqueue(T item) {
        queue[tailIndex] = item;
        tailIndex += 1;
        size += 1;
        if (tailIndex == queue.length) {
            if (size <= queue.length/2) {
                reStructure();
            } else {
                resize(2*queue.length);
            }
        }
    }

    //TODO: Implement some sort of resizing for dequeue
    @Override
    public T dequeue() {
        T itemToReturn = null;
        if (headIndex>0) {
            itemToReturn = queue[headIndex];
            headIndex += 1;
            size-=1;
        }
        return itemToReturn;
    }

    @Override
    public T peek() {
        return queue[headIndex];
    }

    private void resize(int newCapacity){
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i=0; i<queue.length; i++){
            newArray[i] = queue[i];
        }
        queue = newArray;
    }

    private void reStructure(){
        for (int i=headIndex; i<tailIndex; i++){
            queue[i-headIndex] = queue[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(queue);
    }
}

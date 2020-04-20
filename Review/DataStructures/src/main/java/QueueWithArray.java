public class QueueWithArray<T> implements Queue<T>{
    private T[] queue;
    private int headIndex;
    private int tailIndex;
    private int size;
    private final int START_CAPACITY = 10;

    public QueueWithArray() {
        queue = (T[]) new Object[START_CAPACITY];
        headIndex = 0;
        tailIndex = 0;
    }

    @Override
    public void enqueue(T item) {
        queue[tailIndex] = item;
        tailIndex += 1;
        size += 1;
    }

    @Override
    public T dequeue() {
        T itemToReturn = null;
        T itemToReturn = null;
        if (headIndex>0){
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

    private void resize(){

    }+
}

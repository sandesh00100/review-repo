import java.util.Iterator;

/**
 * Less wasted space than the linked list implementation
 *
 * Performance  best    worst   amortized
 * Initalize    1       1       1
 * Push         1       N       1
 * Pop          1       N       1
 * Size         1       1       1
 * @param <T>
 */
public class StackWithArray<T> implements Stack<T>, Iterable<T>{
    private T[] stack;
    private int nextHeadIndex = 0;
    private final int START_CAPACITY = 10;
    // Capacity should be removed
    public StackWithArray(){
        stack = (T[]) new Object[START_CAPACITY];
    }

    @Override
    // Amortized insertions should be about with with dynamically increasing size should be 3N
    public void push(T item) {
        if(nextHeadIndex == stack.length) {
            resize(2 * stack.length);
        }
        stack[nextHeadIndex] = item;
        nextHeadIndex += 1;
    }

    @Override
    // When the capacity gets to 1/4 of the size of the stack we want to decrease this by half
    // The reason we don't do it when it gets to 1/2 full is because if you're at the 1/2 mark alternating push pop operations can cause thrashing and inefficient copies
    public T pop() {
        nextHeadIndex -= 1;
        if (nextHeadIndex >0 && nextHeadIndex == stack.length/4) {
            resize(stack.length/2);
        }
        return stack[nextHeadIndex];
    }

    @Override
    public boolean isEmpty() {
        return nextHeadIndex == 0;
    }

    @Override
    public T peek() {
        return stack[nextHeadIndex -1];
    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i=0; i<nextHeadIndex; i++){
            copy[i]=stack[i];
        }
        stack=copy;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(stack);
    }
}

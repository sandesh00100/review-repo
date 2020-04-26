import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int currentIndex = 0;
    public ArrayIterator(T[] array) {
        array = array;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

    @Override
    public T next() {
        return array[currentIndex++];
    }
}

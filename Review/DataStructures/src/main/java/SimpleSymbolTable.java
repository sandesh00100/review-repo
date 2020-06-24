public class SimpleSymbolTable<Key,Value> implements SymbolTable<Key, Value> {
    @Override
    public void put(Key key, Value val) {

    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    private int rank(Key key){
    }
}

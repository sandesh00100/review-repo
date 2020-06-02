
public interface HashTable <Key,Value>{
    int size();
    boolean isEmpty();
    void add(Key k, Value v);
    Value get(Key k);
    Value remove(Key k);
}

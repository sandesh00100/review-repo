/**
 * The size of the array has to be greater than the number of key-value pairs
 * TODO: Research uniform hashing assumption
 * @param <K>
 * @param <V>
 */
public class HashTableLinearProbingImpl<K, V> implements HashTable<K,V>{
    private int size = 3001;
    private V[] vals = (V []) new Object[size];
    private K[] keys = (K[]) new Object[size];

    private int getIndex(K key)
    {
        // Making the hashcode positive "by anding off the signed bit" then getting a mod of the size of buckets list
        // Just be aware that the cost of hashing sometimes does become more than the actual processing
        // Red black might me more effective in some cases
        return (key.hashCode() & 0x7fffffff) % size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (int i=0; i < size; i++){
            if (keys[i] != null){
                return false;
            }
        }
        return true;
    }

    @Override
    public void add(K k, V v) {
        int i;
        for (i = getIndex(k); keys[i] != null; i=(i+1) % size){
            if (keys[i].equals(k)){
                break;
            }
        }
        keys[i] = k;
        vals[i] = v;

    }

    @Override
    public V get(K k) {
        for (int i = getIndex(k); keys[i] != null; i = (i+1) % size){
            if (k.equals(keys[i])){
                return vals[i];
            }
        }
        return null;
    }

    @Override
    public V remove(K k) {
        for (int i = getIndex(k); keys[i] != null; i = (i+1) % size){
            if (k.equals(keys[i])){
                V removedVal = vals[i];
                vals[i] = null;
                keys[i] = null;
                return removedVal;
            }
        }
        return null;
    }
}

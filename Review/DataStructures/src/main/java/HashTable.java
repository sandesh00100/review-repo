import java.util.ArrayList;
import java.util.List;


/**
 * Typical HashCode Method
 *  public int hashCode(){
 *      int hash = 17;  (non-zero-constant)
 *      hash = 31*hash + memberVar1.hashCode(); (31 is the typical prime we use to hash)
 *      hash = 31*hash + memberVar2.hashCode(); (Similar to horners method where we compute a new hash for each element)
 *      ...
 *      return hash;
 *  }
 * @param <K>
 * @param <V>
 */
public class HashTable<K, V> {
	private static class HashNode<K,V> {
		K key;
		V value;
		
		HashNode<K,V> next;
		
		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private List<HashNode<K,V>> buckets;
	private int numBuckets;
	private int size;
	
	public HashTable() {
		buckets = new ArrayList<HashNode<K,V>>();
		numBuckets = 10;
		size = 0;
		
		for (int i = 0; i < numBuckets; i++) {
			buckets.add(null);
		}
	}
	
	public int size() {return this.size;}
	public boolean isEmpty() {return size() == 0;}

	
	private int getBucketIndex(K key) 
    { 
        int hashCode = key.hashCode(); 
        int index = hashCode % numBuckets; 
        return index; 
    } 
	
	public V get(K key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> currentNode = buckets.get(bucketIndex);
		
		while (currentNode != null) {
			if (currentNode.key.equals(key)) {
				return currentNode.value;
			}
		}
		
		return null;
	}
	
	public V remove(K key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K,V> currentNode = buckets.get(bucketIndex);
		V val = null;
		
		while(currentNode != null) {
			if (currentNode.key.equals(key)) {
				if (currentNode.next != null) {
					currentNode = currentNode.next;
				}
				val = currentNode.value;
				size--;
			}
		}
		
		return val;
	}
	
	public void add(K key, V value) {
		HashNode<K,V> node = new HashNode<K,V>(key,value);
		int bucketIndex = getBucketIndex(key);
		HashNode<K,V> currentNode = buckets.get(bucketIndex);
		boolean keyExists = false;
		if (currentNode == null) {
			buckets.set(bucketIndex, currentNode);
		}
		
		while (currentNode.next != null) {
			if (currentNode.key.equals(key)) {
				currentNode.value = value;
				keyExists = true;
				return;
			}
			currentNode = currentNode.next;
		}
		
		if (!keyExists) {
			currentNode.next = node;
			size++;
		}
		
		//TODO: Implement Increasing size of buckets
		if ((1.0 * size)/numBuckets >= .7) {
			
		}
		
	}
	
	
}

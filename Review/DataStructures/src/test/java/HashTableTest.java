import org.junit.jupiter.api.Test;

public class HashTableTest {
    @Test
    public void seperateChainingTest(){
        HashTable<String, Integer> hashTable = new HashTableSeperateChainingImpl<>();
        hashTable.add("one",1);
        hashTable.add("two", 2);
        hashTable.add("three", 3);
        hashTable.add("four", 4);
        assert(hashTable.get("one") == 1);
        hashTable.add("one",3);
        assert(hashTable.get("one") == 3);
        hashTable.remove("one");
        assert (hashTable.get("one") == null);
    }

    @Test
    public void linearProbingTest(){
        HashTable<String, Integer> hashTable = new HashTableLinearProbingImpl<>();
        hashTable.add("one",1);
        hashTable.add("two", 2);
        assert(hashTable.get("one") == 1);
        hashTable.add("one",3);
        assert(hashTable.get("one") == 3);
        hashTable.remove("one");
        assert(hashTable.get("one") == null);
    }
}

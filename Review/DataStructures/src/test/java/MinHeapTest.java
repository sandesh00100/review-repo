import org.junit.jupiter.api.Test;

public class MinHeapTest {
    @Test
    public void heapSortTest(){
        int[] expectedSortedArray = {6,5,4,3,2,1};
        MinHeap mh = new MinHeap(new int[]{1,2,3,6,4,5});
        int[] sortedArray = mh.sort();
        for(int i=0; i<expectedSortedArray.length; i++){
            if(sortedArray[i] != expectedSortedArray[i]){
                assert(false);
            }
        }
        assert(true);
    }
}

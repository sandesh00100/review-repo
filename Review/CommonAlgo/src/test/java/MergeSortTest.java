import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
    int[] sortedArray = new int[]{1,2,3,4,5,6};
    int[] unsortedArray;
    @Before
    public void initalizeUnsortedArray(){
        unsortedArray = new int[]{3,5,1,4,2,6};
    }

    @Test
    public void inplaceMergeSortTest(){
        MergeSortInplace.sort(unsortedArray);
        for (int i=0; i<unsortedArray.length; i++){
            if(unsortedArray[i] != sortedArray[i]){
                assert(false);
            }
        }
        assert(true);
    }

    @Test
    public void bottomUpSortTest(){
        MergeSortBottomUp.sort(unsortedArray);
        for (int i=0; i<unsortedArray.length; i++){
            if(unsortedArray[i] != sortedArray[i]){
                assert(false);
            }
        }
        assert(true);
    }

}

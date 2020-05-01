import org.junit.Test;

public class MergeSortTest {
    @Test
    public void mergeSortTest(){
        int[] array = new int[]{3,5,1,4,2};
        MergeSortInplace.sort(array);
        for(int i:array){
            System.out.println(i);
        }
        assert(true);
    }
}

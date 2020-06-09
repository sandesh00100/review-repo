/**
 * Insersition sort uses n^2/4 compares and n^2/4 exchanges
 * Depends on the order of the array
 *
 * Best case scenario
 * it's already sorted, makes N-1 compares and 0 exchanges
 *
 * Worst case scenario
 * Makes N^2/2 comapres and exchanges
 *
 *
 */
public class InsertionSort {
    public static void sort(int[] a){
        int size = a.length;
        for (int i=0; i<size; i++){
            for (int j=i; j>0; j--){
                if (a[j] < a[j-1]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}

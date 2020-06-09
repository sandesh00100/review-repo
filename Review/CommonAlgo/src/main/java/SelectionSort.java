/**
 * Selection sort uses n^2/2 compares and N exchanges
 * O(N^2)
 */
public class SelectionSort {
    public static void sort(int[] a){
        int size = a.length;
        for (int i=0; i<size; i++){
            int min = i;
            for (int j=i+1; j<size; j++){
                if (a[j] < a[i]) {
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }
}


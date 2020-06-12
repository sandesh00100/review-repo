/**
 * increment sequence knut
 * 3x + 1 1, 4, 13, 40, 121, 364,...
 * depending on the increment sequence results may vary
 * Worst case seems to be O(N^(3/2))
 * Very fast unless arraysize is huge, fixed footprint for code
 */
public class ShellSort {
    public static void sort(int[] a){
        int size = a.length;
        int h = 1;
        while (h < size/3){
            h = 3*h + 1;
        }

        while (h >= 1){
            for (int i=h; i<size; i++){
                for(int j=i; (j>h) && (a[j] < a[j-h]); j=-h){
                   int temp = a[j];
                   a[j] = a[j-h];
                   a[j-h] = temp;
                }
            }
            h = h/3;
        }
    }
}

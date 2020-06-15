/**
 * Faster than mergesort
 *
 * Average case NlogN
 * worst case (n^2)/2 (very unlikely)
 */
public class QuickSort {
    private static int partition(int[] a, int lo, int hi){
        int i = lo, j=hi+1;
        while(true){
            while(a[++i] < a[lo]){
                if (i == hi) break;
            }
            while(a[lo] < a[--j]){
                if (j == lo) break;
            }
            if(i >= j) break;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int temp = a[j];
        a[j] = a[lo];
        a[lo] = temp;
    return j;
    }

    public static void sort(int a[]){
        // Random shuffle is important for performance
        Shuffle.shuffle(a);
        sort(a, 0, a.length-1);
    }

    public static void sort(int a[], int lo, int hi){
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    /**
     *  Selects the top kth element in the array
     *  Takes linear time on average
     *
     *  There is a selection algo that has the worst case for linear time but the constants are too high to use it in practice
      * @param a
     * @param k
     * @return
     */
    private static int select(int[] a, int k){
        // For performance
        Shuffle.shuffle(a);
        int lo=0, hi=a.length-1;
        while (hi>lo){
            int j = partition(a, lo, hi);
            // if j is less than k we know that we have to search the right sub array a[j+1] - a[hi]
            if (j<k) lo = j+1;
            // if j is greater than k we know that we have to search the right sub array a[lo] - a[j-1]
            else if (j>k) hi = j-1;
            // if j is equal to k then we know that we've found the element since when we partition the index we've partitioned on is always sorted
            else return a[k];
        }
        // We're going to return the kth position be cause we know the subarray is sorted
        return a[k];
    }
}


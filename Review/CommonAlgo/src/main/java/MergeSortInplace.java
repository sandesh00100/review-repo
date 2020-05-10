public class MergeSortInplace {
    /**
     * This has to be two sorted array
     * @param a
     * @param aux
     * @param lo
     * @param mid
     * @param hi
     */
    //TODO: Go over stability and comparators
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
//        assert isSorted(a, lo, mid);
//        assert isSorted(a, mid+1, hi);
        System.out.println("Merging");
        for (int i=lo; i<=hi; i++){
            System.out.print(a[i]);
            aux[i] = a[i];
        }
        System.out.println();
        int i=lo, j=mid+1;
        for (int k=lo; k<=hi; k++){
            if (j>hi){
                a[k] = aux[i++];
            } else if (i>mid) {
                a[k] = aux[j++];
            } else {
                a[k]= aux[i] < aux[j] ? aux[i++] : aux[j++];
        }
        }
//        assert isSorted(a, lo, hi);
    }

    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length-1);
    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi-lo < 1){
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }
}

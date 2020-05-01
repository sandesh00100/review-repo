public class MergeSortBottomUp {
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
    public static void sort(int[] a){
        int arrayFullSize = a.length;
        int[] aux = new int[arrayFullSize];
        for (int sz =1; sz < arrayFullSize; sz = sz*2) {
            for(int lo = 0; lo < arrayFullSize-sz; lo += sz*2){
                merge(a, aux, lo, lo+sz-1, Math.min(lo+(sz*2),arrayFullSize-1));
            }
        }
    }
}

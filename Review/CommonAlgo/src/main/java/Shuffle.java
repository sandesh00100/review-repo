/**
 * Knuth's uniformly random permutation in linear time
 */
public class Shuffle {
   public static void shuffle(int[] a){
       int size = a.length;
       for (int i=0; i<size; i++){
           int currentValue = a[i];
           Math.random(i+1);
       }
   }
}

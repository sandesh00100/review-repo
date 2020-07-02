import java.util.List;

public class KeySearch {
    /**
     * Takes in range of
     * @param lo
     * @param hi
     */
    public int oneDimensionalRangeSearch(Integer lo, Integer hi, BinarySearchTree<Integer, Integer> bst){
       if (bst.contains(hi)) return bst.rank(hi) - bst.rank(lo) + 1;
       else return bst.rank(hi) - bst.rank(lo);
    }

    public int sweepLineAlgorithim(int[][] pointGraph){
        int intersectionCount = 0;
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
        for (int i=0; i<pointGraph[0].length; i++){
            int[] verticalPoints = pointGraph[i];
            int[] verticalLine = new int[2];
            int verticalLineIndex = 0;
            for(int j=0; j<verticalPoints.length; j++){
                if (verticalPoints[j] == 1) {
                    verticalLine[verticalLineIndex] = j;
                    verticalLineIndex++;
                }
            }

            if (verticalLineIndex == 1){
                if(bst.contains(verticalLine[0])){
                    bst.delete(verticalLine[0]);
                } else {
                    bst.put(verticalLine[0], verticalLine[0]);
                }
            } else if (verticalLineIndex>1) {
                intersectionCount += oneDimensionalRangeSearch(verticalLine[0], verticalLine[1], bst);
            }
        }
        return intersectionCount;
    }

}

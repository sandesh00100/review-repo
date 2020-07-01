import java.util.HashSet;
import java.util.Set;

public class twoDimensionalSearch {
    /**
     * The bst is going to contain integers as keys and two points stored as values;
     * @param binarySearchTree
     * @return
     */
    public static int search(BinarySearchTree<Integer,Integer[]> binarySearchTree, int[][] rectangle){

    }

    public static BinarySearchTree<Integer, Integer[]> partitionTrees(){
    }

    public static TwoDimensionalPoint[] generateTwoDimensionalPoints(int numPoints, TwoDimensionalPoint[] rectangle){
        Set<TwoDimensionalPoint> points = new HashSet<>();

        for (int i=0; i<numPoints; i++){
            //TODO: Generate random points
            TwoDimensionalPoint point = new TwoDimensionalPoint(i,i);
        }
    }
}

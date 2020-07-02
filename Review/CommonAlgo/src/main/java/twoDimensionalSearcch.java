import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class twoDimensionalSearch {
    /**
     * The bst is going to contain integers as keys and two points stored as values;
     * @param binarySearchTree
     * @return
     */
    public static int search(BinarySearchTree<TwoDimensionalPoint,Integer> binarySearchTree, int[][] rectangle){
        return 0;
    }

    public static BinarySearchTree<TwoDimensionalPoint,Integer> generateTwoDimensionalPoints(int numPoints,  int xBound, int yBound){
        Set<TwoDimensionalPoint> points = new HashSet<>();
        BinarySearchTree<TwoDimensionalPoint, Integer> bst = new BinarySearchTree<>();
        Random rand = new Random();
        for (int i=0; i<numPoints; i++){
            int x = rand.nextInt(xBound + 1);
            int y = rand.nextInt(yBound + 1);
            PointDirection pointDirection = i % 2 == 0 ? PointDirection.VERTICAL : PointDirection.HORIZONTAL;
            TwoDimensionalPoint point = new TwoDimensionalPoint(x,y,pointDirection);
            if (!points.contains(point)){
                points.add(point);
                bst.put(point,i);
            }
        }
        return bst;
    }
}

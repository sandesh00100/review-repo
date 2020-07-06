import org.w3c.dom.css.Rect;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
//TODO:Finish searcch implementation
public class TwoDimSearchTree extends BinarySearchTree<TwoDimensionalPoint, Integer> {
    @Override
    public void put(TwoDimensionalPoint twoDimensionalPoint, Integer val) {
        AtomicInteger level = new AtomicInteger(0);
        root = put(root, twoDimensionalPoint, val, level);
    }

    private Node put(Node curNode, TwoDimensionalPoint twoDimensionalPoint, Integer val, AtomicInteger level) {
        if (curNode == null) {
            size++;
            PointDirection pointDirection = level.get() % 2 == 0 ? PointDirection.VERTICAL : PointDirection.HORIZONTAL;
            twoDimensionalPoint.setPointDirection(pointDirection);
            return new Node(twoDimensionalPoint, val);
        }
        level.addAndGet(1);
        int cmp = twoDimensionalPoint.compareTo(curNode.key);
        if (cmp < 0) curNode.left = put(curNode.left, twoDimensionalPoint, val);
        else if (cmp > 0) curNode.right = put(curNode.right, twoDimensionalPoint, val);
        else curNode.value = val;
        curNode.count = 1 + size(curNode.left) + size(curNode.right);
        return curNode;
    }

    public Set<TwoDimensionalPoint> search(Node node, Rectangle rectangle){
        Set<TwoDimensionalPoint> points = new HashSet<>();
        search(node, rectangle, points);
        return points;
    }

    public void search(Node node, Rectangle rectangle, Set<TwoDimensionalPoint> points){
        if (node == null) return;
        TwoDimensionalPoint curPoint = node.key;
        if (rectangle.pointInRectangle(curPoint)){
            points.add(curPoint);
        }
        if (curPoint.getPointDirection() == PointDirection.VERTICAL){
            if (curPoint.getX() >= rectangle.getX2()){
                search(node.left, rectangle, points);
            }
            if (curPoint.getX() <= rectangle.getX1()) {
                search(node.right, rectangle, points);
            }
        } else {
            if (curPoint.getY() >= rectangle.getY2()){
                search(node.left, rectangle, points);
            }
            if (curPoint.getY() <= rectangle.getY1()){
                search(node.right, rectangle, points);
            }
        }
    }

    public TwoDimensionalPoint nearestNeighbor(TwoDimensionalPoint queryPoint){
       TwoDimensionalPoint nearestNeighbor = root.key;
       nearestNeighbor(queryPoint, nearestNeighbor, root);
       return nearestNeighbor;
    }

    private void nearestNeighbor(TwoDimensionalPoint queryPoint, TwoDimensionalPoint currentNearestNeighbor, Node node){
        if (node == null){
            return;
        }

        TwoDimensionalPoint currentPoint = node.key;
        PointDirection pointDirection = currentPoint.getPointDirection();
        double currentNearestNeighborDistance = calculateDistance(queryPoint,currentNearestNeighbor);
        double currentPointDistance = calculateDistance(queryPoint, currentPoint);

        if (currentPointDistance < currentNearestNeighborDistance){
            currentNearestNeighbor = currentPoint;
        }

        boolean searchLeftFirst = (pointDirection == PointDirection.VERTICAL && queryPoint.getX() < currentPoint.getX()) || (pointDirection == PointDirection.HORIZONTAL && queryPoint.getY() > currentPoint.getY());
        if (searchLeftFirst){
            nearestNeighbor(queryPoint, currentNearestNeighbor, node.left);
        } else {
            nearestNeighbor(queryPoint, currentNearestNeighbor, node.right);
        }

        TwoDimensionalPoint boundPoint;
        if (pointDirection == PointDirection.VERTICAL){
            boundPoint = new TwoDimensionalPoint(currentPoint.getX(), queryPoint.getY());
        } else {
            boundPoint = new TwoDimensionalPoint(queryPoint.getX(), currentPoint.getY());
        }

        double minBoundDistance = calculateDistance(queryPoint, boundPoint);
        boolean skipBranch = currentNearestNeighborDistance < minBoundDistance;

        if (!skipBranch){
            if(searchLeftFirst){
                nearestNeighbor(queryPoint, currentNearestNeighbor, node.right);
            } else {
                nearestNeighbor(queryPoint, currentNearestNeighbor, node.left);
            }
        }

    }

    private double calculateDistance(TwoDimensionalPoint p1, TwoDimensionalPoint p2){
        return Math.sqrt(Math.pow(p1.getX()-p2.getX(),2) + Math.pow(p1.getY()-p2.getY(),2));
    }
}


public class OneDimensionlIntervalSearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

    public void put(Key lo, Key hi, Value val){
        root = put(lo, hi, val, root);
    }

    public Node put(Key lo, Key hi, Value val, Node node){
        if (node == null){
            return new Node(lo, hi, val);
        }
        int cmp = lo.compareTo(node.lo);
        if (cmp < 1){
            Node leftNode = put(lo, hi, val, node.left);
            int leftNodeCmp = hi.compareTo(leftNode.hi);
            if (leftNodeCmp < 1){
                node.hi = leftNode.hi;
            }
            node.left = leftNode;
        } else {
            Node rightNode = put(lo, hi, val, node.left);
            int rightNodeCmp = hi.compareTo(rightNode.hi);
            if (rightNodeCmp < 1){
                node.hi = rightNode.hi;
            }
            node.right = rightNode;
        }
        return node;
    }

    public Value get(Key lo, Key hi){
        return null;
    }

    public void delete(Key lo, Key hi){

    }

    public Node search (Key lo, Key hi){
       Node curNNode = root;
       while (curNNode != null){
           int rightHiCmp = lo.compareTo(curNNode.right.hi);
           if (curNNode.intersects(lo,hi)) return curNNode;
           else if (curNNode.left == null) curNNode = curNNode.right;
           else if (rightHiCmp < 0) curNNode = curNNode.right;
           else curNNode = curNNode.left;
       }
       return null;
    }

    private class Node {
        private Key lo, hi;
        private Value value;
        private Node left, right;

        public Node(Key lo, Key hi, Value value) {
            this.lo = lo;
            this.hi = hi;
            this.value = value;
        }

        private boolean intersects(Key lo, Key hi){
            int loHiCmp = lo.compareTo(this.hi);
            int loLoCmp = lo.compareTo(this.lo);
            int hiLoCmp = hi.compareTo(this.lo);
            int hiHiCmp = hi.compareTo(this.hi);
            if (hiHiCmp <= 0 && hiLoCmp >= 0){
                return true;
            }
            if (loHiCmp <= 0 && loLoCmp >= 0){
                return  true;
            }
            return false;
        }
    }
}

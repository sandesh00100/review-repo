public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }

    
}

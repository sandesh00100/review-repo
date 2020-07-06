/**
 * Bascally has the quick sort partition
 * If N distinct keys are inserted into a BST in random order, the exppected number of compares for a search/insert is ~2logN
 *
 * Worst case would be time porportional to N when it's basically becaomes a linked list
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    protected Node root;
    protected int size = 0;

    /**
     * Finding the largest key that is less than the key being passed in
     * @param key
     * @return
     */
    public Key floor(Key key){
       Node floorNode = floor(root, key);
       if (floorNode == null) return null;
       return floorNode.key;
    }

    private Node floor(Node curNode, Key key){
        if (curNode == null) return null;
        int cmp = key.compareTo(curNode.key);
        if (cmp == 0) return curNode;
        if (cmp < 0) return floor(curNode.left, key);
        Node possibleFloorNode = floor(curNode.right, key);
        if (possibleFloorNode != null) return possibleFloorNode;
        else return curNode;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    protected Node put(Node curNode, Key key, Value val){
        if (curNode == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(curNode.key);
        if (cmp < 0) curNode.left = put(curNode.left, key, val);
        else if (cmp > 0) curNode.right = put(curNode.right, key, val);
        else curNode.value = val;
        curNode.count = 1 + size(curNode.left) + size(curNode.right);
        return curNode;
    }

    public Value get(Key key) {
        Node curNode = root;
        while (curNode != null){
            int cmp = key.compareTo(curNode.key);
            if (cmp<0) curNode = curNode.left;
            else if (cmp>0) curNode = curNode.right;
            else return curNode.value;
        }
        return null;
    }

    // Hibbard deletion
    public void deleteMin(){
        root = deleteMin(root);
    }

    public Node deleteMin(Node node){
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    //Hibbard deletion
    public Node delete(Node node, Key key){
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) delete(node.left, key);
        else if (cmp > 0) delete(node.right, key);
        else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;

            Node nodeToDelete = node;
            node = min(nodeToDelete);
            node.right = deleteMin(nodeToDelete.right);
            node.left = nodeToDelete.left;
        }
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Node min(Node node){
        if (node == null) {
            return null;
        }
        Node currentNode = node;
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public boolean contains(Key key) {
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    protected int size(Node node){
        if (node == null) return 0;
        return node.count;
    }

    public Iterable<Key> keys(){
        QueueWithList<Key> queue = new QueueWithList<>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node node, Queue<Key> queue){
        if (node == null) return;
        inorder(node.left, queue);
        queue.enqueue(node.key);
        inorder(node.right, queue);
    }
    /**
     * rank = how many keys are smaller than the key given
     * @param key
     * @return
     */
    public int rank(Key key){
        return rank(key, root);
    }

    private int rank(Key key, Node node){
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return rank(key, node.left);
        else if (cmp > 0) return 1 + size(node.left) + rank(key, node.right);
        else return size(node.left);
    }

    protected class Node {
        protected Key key;
        protected Value value;
        protected Node left, right;
        protected int count;
        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }

}

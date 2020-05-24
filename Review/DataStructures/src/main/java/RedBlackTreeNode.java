/**
 * Allows 1 or 2 keys per node
 *  2-node: one keys, two children
 *  3-node: two keys, three children
 *      left child has value lower than two keys, middle child has a node between the two keys  and right node has a value larger than two keys
 *
 *
 *                  M
 *                /  \
 *              EJ     R
 *            / | \   / \
 *          AC  H  L P   SX
 *         /|\ /\ /\/\  / | \ (Null links)
 * Every path from the root to null link has the same length (perfect balance)
 */

enum Color {
    RED,
    BLACK
}
public class RedBlackTreeNode {
    int value;
    private RedBlackTreeNode rightNode;
    private RedBlackTreeNode leftNode;
    Color color;

    public RedBlackTreeNode(int value, Color color){
        this.value = value;
        this.color = color;
    }

    private boolean isRed(RedBlackTreeNode node){
        // All null links are black
        if (node == null) return false;
        return node.color == Color.RED;
    }
    public boolean contains(RedBlackTreeNode node, int val){
        while (node != null){
            if (node.value == val) {
                return true;
            } else if (node.value > val){
                node = node.leftNode;
            } else {
                node = node.rightNode;
            }
        }
        return false;
    }

    /**
     * E is being passed in to the function to be rotated
     *               (E)
     *             /    \
     *     (val < E)   (S) (red link)
     *                 /  \
     *     ( E< val < S)   (val>S)
     *
     *                   (S)
     *                 /    \
     *     (Red Link) (E)     (val>s)
     *              /  \
     *      (val < E)   (E<val<S)
     * @param E
     * @return
     */
    private RedBlackTreeNode rotateLeft(RedBlackTreeNode E){
        RedBlackTreeNode S = E.rightNode;
        E.rightNode = S.leftNode;
        S.leftNode = E;
        S.color = E.color;
        E.color = Color.RED;
        return S;
    }

    private RedBlackTreeNode rotateRight(RedBlackTreeNode S){
        RedBlackTreeNode E = S.leftNode;
        S.leftNode = E.rightNode;
        E.rightNode = S;
        E.color = S.color;
        S.color = Color.RED;
        return E;
    }

    private void flipColors (RedBlackTreeNode node){
        node.color = Color.RED;
        node.leftNode.color = Color.BLACK;
        node.rightNode.color = Color.BLACK;
    }

    private RedBlackTreeNode put(RedBlackTreeNode node, int val ){
        if (node == null) return new RedBlackTreeNode(val, Color.RED);
        else if (node.value > val) node.leftNode = put(node.leftNode, val);
        else if (node.value < val) node.rightNode = put(node.rightNode, val);
        else node.value = val;
        if (isRed(node.rightNode) && !isRed(node.leftNode)) node = rotateLeft(node);
        if (isRed(node.leftNode) && isRed(node.leftNode.leftNode)) node = rotateRight(node);
        if (isRed(node.leftNode) && isRed(node.rightNode)) flipColors(node);
        return node;
    }
}

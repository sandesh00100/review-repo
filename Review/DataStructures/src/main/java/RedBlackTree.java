public class RedBlackTree {
    private static class RedBlackTreeNode{
        int value;
        private RedBlackTreeNode rightNode;
        private RedBlackTreeNode leftNode;
        Color color;

        public RedBlackTreeNode(int value, Color color){
            this.value = value;
            this.color = color;
        }

        public static boolean isRed(RedBlackTreeNode node){
            // All null links are black
            if (node == null) return false;
            return node.color == Color.RED;
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
        private static RedBlackTreeNode rotateLeft(RedBlackTreeNode E){
            RedBlackTreeNode S = E.rightNode;
            E.rightNode = S.leftNode;
            S.leftNode = E;
            S.color = E.color;
            E.color = Color.RED;
            return S;
        }

        private static RedBlackTreeNode rotateRight(RedBlackTreeNode S){
            RedBlackTreeNode E = S.leftNode;
            S.leftNode = E.rightNode;
            E.rightNode = S;
            E.color = S.color;
            S.color = Color.RED;
            return E;
        }

        private static void flipColors (RedBlackTreeNode node){
            node.color = Color.RED;
            node.leftNode.color = Color.BLACK;
            node.rightNode.color = Color.BLACK;
        }

    }

    private RedBlackTreeNode root;

    public boolean contains(int val){
        RedBlackTreeNode node = root;
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

    private RedBlackTreeNode put(RedBlackTreeNode node, int val ){
        if (node == null) {
            Color nodeColor = Color.RED;
            if (root == null){
                nodeColor = Color.BLACK;
            }
            return new RedBlackTreeNode(val, nodeColor);
        }
        else if (node.value > val) node.leftNode = put(node.leftNode, val);
        else if (node.value < val) node.rightNode = put(node.rightNode, val);
        else node.value = val;
        if (RedBlackTreeNode.isRed(node.rightNode) && !RedBlackTreeNode.isRed(node.leftNode)) node = RedBlackTreeNode.rotateLeft(node);
        if (RedBlackTreeNode.isRed(node.leftNode) && RedBlackTreeNode.isRed(node.leftNode.leftNode)) node = RedBlackTreeNode.rotateRight(node);
        if (RedBlackTreeNode.isRed(node.leftNode) && RedBlackTreeNode.isRed(node.rightNode)) RedBlackTreeNode.flipColors(node);
        return node;
    }

    public void put(int val) {
       this.root = put(root, val);
    }
}

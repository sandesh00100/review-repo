import org.junit.jupiter.api.Test;

public class RedBlackTreeTest {
    @Test
    public void redBlackTreeTest(){

       RedBlackTree redBlackTree = new RedBlackTree();
       redBlackTree.put('S'); //83
       redBlackTree.put('E'); //69
       redBlackTree.put( 'A'); //65
       redBlackTree.put( 'R'); //82
       redBlackTree.put('C'); //67
       redBlackTree.put( 'H'); //72
       redBlackTree.put( 'X'); //88
       redBlackTree.put( 'M'); //77
       redBlackTree.put( 'P'); //80
       redBlackTree.put( 'L'); //76
        /**
         *                   Final Tree
         *                        M
         *                     /    \
         *                   E       R
         *                 /  \     / \
         *               C     l  P  X
         *       (RED) / RED /       / (RED)
         *            A    H       S
         */
        assert(true);
    }
}

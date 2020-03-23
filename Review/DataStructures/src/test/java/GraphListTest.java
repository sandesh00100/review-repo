import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GraphListTest {
    static GraphList graph;

    /**
     *          1      4
     *         /     /
     *       0     3 -- 5
     *        \  /  \    \
     *         2     8    \
     *          \  /       \
     *           7 -------- 6
     */
    @BeforeAll
    public static void setUp(){
        graph = new GraphList();
        graph.addEdgeBiDirectional(0,1);
        graph.addEdgeBiDirectional(0,2);
        graph.addEdgeBiDirectional(2,3);
        graph.addEdgeBiDirectional(3,4);
        graph.addEdgeBiDirectional(3,5);
        graph.addEdgeBiDirectional(5,6);
        graph.addEdgeBiDirectional(6,7);
        graph.addEdgeBiDirectional(7,8);
        graph.addEdgeBiDirectional(2,7);
        graph.addEdgeBiDirectional(3,8);
        graph.addEdgeBiDirectional(10,11);
    }

    @Test
    public void testDfsStack(){
        assert(graph.hasPathDfsWithStack(0, 8));
        System.out.println("------------------------------------");
        assert(!graph.hasPathDfsWithStack(3,10));
    }

    @Test
    public void testBfsQueue(){
        assert(graph.hasPathBfsWithQueue(0,3));
    }

}

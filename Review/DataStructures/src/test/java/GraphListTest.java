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
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(7,8);
        graph.addEdge(2,7);
        graph.addEdge(3,8);
        graph.addEdge(10,11);
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

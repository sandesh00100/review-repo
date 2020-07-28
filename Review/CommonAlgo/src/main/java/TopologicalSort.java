import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Cant have cycles to do a topological sort
 */
public class TopologicalSort {
    private Set<GraphNode> visitedNodes;
    private Stack<GraphNode> reversesPost;

    public TopologicalSort(DiGraph graph) {
        reversesPost = new Stack<>();
        visitedNodes = new HashSet<>();
        Map<Integer,GraphNode> nodeLookUp = graph.getNodeLookup();
        for (GraphNode graphNode: nodeLookUp.values()){
            if (!visitedNodes.contains(graphNode)){
                dfs(graph,graphNode);
            }
        }
    }

    private void dfs(DiGraph graph,GraphNode graphNode){
        visitedNodes.add(graphNode);
        for (GraphNode adjGraphNode: graphNode.adjacentNodes){
            if (!visitedNodes.contains(adjGraphNode)){
                dfs(graph,adjGraphNode);
            }
        }
        reversesPost.push(graphNode);
    }

    public Iterable<GraphNode> reversePost(){
        return reversesPost;
    }
}
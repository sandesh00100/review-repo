import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConnectedComponents {
    public static Map<Integer,Integer> getStronglyConnectedComponenets(DiGraph graph){
       TopologicalSort topologicalSort = new TopologicalSort(graph);
       return getConnectedComponentMap(topologicalSort.reversePost());
    }

    public static Map<Integer,Integer> getConnectedComponentMap(Iterable<GraphNode> graphNodes){
        Map<Integer,Integer> connectedComponents = new HashMap<>();
        int componentId = 0;
        for (GraphNode graphNode: graphNodes){
            if (!connectedComponents.containsKey(graphNode.id)){
                dfsSearch(graphNode, connectedComponents, componentId);
            }
        }
        return connectedComponents;
    }

    private static void dfsSearch(GraphNode graphNode, Map<Integer,Integer> connectedComponents, int componentId){
        StackWithList<GraphNode> nodes = new StackWithList<GraphNode>();
        Set<GraphNode> visitedNodes = new HashSet<GraphNode>();
        nodes.push(graphNode);
        visitedNodes.add(graphNode);
        connectedComponents.put(graphNode.id, componentId);
        while (!nodes.isEmpty()) {
            GraphNode currentNode = nodes.peek();
            boolean hasNodesToVisit = false;
            for (GraphNode adjNode : currentNode.adjacentNodes) {
                if (!visitedNodes.contains(adjNode)) {
                    connectedComponents.put(componentId, adjNode.id);
                    hasNodesToVisit = true;
                    visitedNodes.add(adjNode);
                    nodes.push(adjNode);
                    break;
                }
            }
            if (!hasNodesToVisit) {
                nodes.pop();
            }
        }
    }
}


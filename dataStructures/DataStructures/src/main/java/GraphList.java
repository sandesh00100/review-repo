import java.util.*;

public class GraphList implements Graph {
    private HashMap<Integer, GraphNode> nodeLookup = new HashMap<Integer, GraphNode>();

    @Override
    public void addEdge(int source, int destination) {
        GraphNode s = nodeLookup.get(source);
        GraphNode d = nodeLookup.get(destination);
        s.adjacentNodes.add(d);
    }

    public void addEdgeBiDirectional(int source, int destination) {
        GraphNode s = nodeLookup.get(source);
        GraphNode d = nodeLookup.get(destination);

        if (s == null) {
            s = new GraphNode(source);
            nodeLookup.put(s.id, s);
        }

        if (d == null) {
            d = new GraphNode(destination);
            nodeLookup.put(d.id, d);
        }

        s.adjacentNodes.add(d);
        d.adjacentNodes.add(s);
    }

    @Override
    public boolean hasPathDFS(int source, int destination) {
        GraphNode s = nodeLookup.get(source);
        GraphNode d = nodeLookup.get(destination);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(s,d,visited);
    }

    public boolean hasPathDfsWithStack(int source, int destination){
        GraphNode s = nodeLookup.get(source);
        GraphNode d = nodeLookup.get(destination);
        Stack<GraphNode> nodes = new Stack<GraphNode>();
        Set<GraphNode> visitedNodes = new HashSet<GraphNode>();
        nodes.push(s);
        visitedNodes.add(s);
        System.out.println("Visiting:" + s.id);
        while (!nodes.isEmpty()){
            GraphNode currentNode = nodes.peek();
            if (currentNode.equals(d)){
                return true;
            }
            boolean hasNodesToVisit = false;
            for (GraphNode adjNode: currentNode.adjacentNodes){
                if (!visitedNodes.contains(adjNode)){
                    hasNodesToVisit = true;
                    visitedNodes.add(adjNode);
                    nodes.push(adjNode);
                    System.out.println("Visiting:" + adjNode.id);
                    break;
                }
            }
            if (!hasNodesToVisit){
                nodes.pop();
            }
        }
        return false;
    }

    public boolean hasPathBfsWithQueue(int source, int destination){
        GraphNode s = nodeLookup.get(source);
        GraphNode d = nodeLookup.get(destination);
        Queue<GraphNode> nodes = new Queue<GraphNode>();
        Set<GraphNode> visitedNodes = new HashSet<GraphNode>();
        nodes.add(s);
        visitedNodes.add(s);
        System.out.println("Visiting:" + s.id);

        while (!nodes.isEmpty()) {
            GraphNode currentNode = nodes.remove();
            if (currentNode.equals(d)){
                return true;
            }
            visitedNodes.add(currentNode);
            for(GraphNode adjNode: currentNode.adjacentNodes) {
                if (!visitedNodes.contains(adjNode)) {
                    nodes.add(adjNode);
                    visitedNodes.add(adjNode);
                    System.out.println("Visiting:" + adjNode.id);
                }
            }
        }
        return false;
    }

    private boolean hasPathDFS(GraphNode source, GraphNode destination, HashSet<Integer> visited) {
        if (visited.contains(source.id)) return false;
        visited.add(source.id);
        if (source == destination){
            return true;
        }
        for (GraphNode child: source.adjacentNodes){
            if (hasPathDFS(child, destination, visited)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasPathBFS(int source, int destination) {
        GraphNode s = nodeLookup.get(source);
        GraphNode d = nodeLookup.get(destination);
        LinkedList<GraphNode> nextToVisit = new LinkedList<GraphNode>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextToVisit.add(s);
        while (!nextToVisit.isEmpty()){
            GraphNode node = nextToVisit.remove();
            if (node == d){
                return true;
            }

            if (visited.contains(node.id)) {
                continue;
            }

            for (GraphNode child: node.adjacentNodes){
                nextToVisit.add(child);
            }
        }
        return false;
    }
}

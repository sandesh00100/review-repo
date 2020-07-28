import java.util.*;

public class GraphList implements Graph {
    protected HashMap<Integer, GraphNode> nodeLookup = new HashMap<Integer, GraphNode>();
    protected int numEdges = 0;

    @Override
    public void addEdge(int source, int destination) {
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
        numEdges++;
    }

    public LinkedList<GraphNode> adj(int vertex){
        return nodeLookup.get(vertex).adjacentNodes;
    }

    public int getNumVerticies(){
        return nodeLookup.size();
    }

    public int getNumEdges(){
        return numEdges;
    }

    public static int degree(GraphList graph, int vertex){
       return graph.adj(vertex).size();
    }

    public static int maxDegree(GraphList graph){
        int max = 0;
        for (int i = 0; i < graph.getNumVerticies(); i++){
            if (degree(graph, i) > max) {
                max = degree(graph, i);
            }
        }
        return max;
    }

    public static double averageDegree(GraphList graph){
        return 2.0 * graph.numEdges / graph.getNumVerticies();
    }

    public static int numberOfSelfLoops(GraphList graph){
        int count = 0;
        for (int i = 0; i < graph.getNumVerticies(); i++){
            for(GraphNode graphNode: graph.adj(i)){
                if (graphNode.id == i){
                    count++;
                }
            }
        }
        return count/2;
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
        StackWithList<GraphNode> nodes = new StackWithList<GraphNode>();
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
        QueueWithList<GraphNode> nodes = new QueueWithList<GraphNode>();
        Set<GraphNode> visitedNodes = new HashSet<GraphNode>();
        nodes.enqueue(s);
        visitedNodes.add(s);
        System.out.println("Visiting:" + s.id);

        while (!nodes.isEmpty()) {
            GraphNode currentNode = nodes.dequeue();
            if (currentNode.equals(d)){
                return true;
            }
            visitedNodes.add(currentNode);
            for(GraphNode adjNode: currentNode.adjacentNodes) {
                if (!visitedNodes.contains(adjNode)) {
                    nodes.enqueue(adjNode);
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

    public Map<Integer, GraphNode> getNodeLookup(){
        return nodeLookup;
    }
}

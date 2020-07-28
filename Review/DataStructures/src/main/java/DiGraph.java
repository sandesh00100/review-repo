public class DiGraph extends GraphList {
    public DiGraph(){
        super();
    }

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
        numEdges++;
    }
}

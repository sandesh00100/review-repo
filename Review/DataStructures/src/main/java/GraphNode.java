import java.util.LinkedList;

public class GraphNode {
    public int id;
    LinkedList<GraphNode> adjacentNodes = new LinkedList<GraphNode>();
    public GraphNode(int id){
        this.id = id;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        GraphNode other = (GraphNode) obj;
        return this.id ==  other.id;
    }
}

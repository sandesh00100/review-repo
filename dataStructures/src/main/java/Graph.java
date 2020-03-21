public interface Graph {
    void addEdge(int source, int destination);
    boolean hasPathDFS(int source, int destination);
    boolean hasPathBFS(int source, int destination);
}

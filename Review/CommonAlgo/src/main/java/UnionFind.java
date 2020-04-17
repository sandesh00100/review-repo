
public interface UnionFind {
    /**
     * Add connection between p and q
     * @param p
     * @param q
     */
    void union(int p, int q);

    /**
     * Check if p and q are in the same component
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q);
}

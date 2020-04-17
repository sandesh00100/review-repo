/**
 * Data structure
 * *Integer array ids[] of size N
 * *Interpertation: ids[i] is the parent of i
 * *root of i is ids[ids[....ids[i]]]
 *
 * Function     Cost
 * initalize    N
 * union        N
 * find         N(When trees get too tall)
 */

public class UnionFindQuickUnion implements UnionFind {
    private int[] ids;

    public UnionFindQuickUnion(int N){
        ids = new int[N];
        for (int i=0; i<N; i++) {
            ids[i] = i;
        }
    }
    @Override
    /**
     *To create a union you need to connect the id of p's root to the id of q's root
     */
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        ids[pRoot] = qRoot;
    }

    @Override
    /**
     * Check if p and q have the same root
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i){
        // if i==ids[i] that means that's the root
        while(i != ids[i]) {
            i = ids[i];
        }
        return i;
    }
}

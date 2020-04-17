/**
 *Weighted quick-union
 **Modify quick-union to avoid tall trees
 **keep track of size of each tree(#objects)
 **Balance by linking root of smaller tree to root of larger tree
 *
 * Function     Cost
 * initalize    N
 * union        log(N) (Depth of the tree)
 * connected    log(N) (Depth of the tree)
 *
 */
public class UnionFindWeightedQuickUnion implements UnionFind{
    int[] ids;
    int[] size;

    public UnionFindWeightedQuickUnion(int N){
        ids = new int[N];
        size = new int[N];

        for (int i=0; i<N; i++){
            ids[i] = i;
        }
    }
    @Override
    /**
     * Make sure the smaller tree is connected to the root of the larger tree
     */
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        if (size[qRoot] < size[pRoot]) {
            ids[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            ids[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
    }

    private int root(int i){
        // if i==ids[i] that means that's the root
        while(i != ids[i]) {
            // Having every other node point to the grandparent node (halves path length)
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}

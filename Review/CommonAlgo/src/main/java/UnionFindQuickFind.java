import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Equivalence realtion:
 * Reflexive: p is connected to q, then q is connnected to p
 * Symmetric: if p is connected to q, then q is connected to p
 * Transitive: if p is connected to q and q is connect3ed to r, then p is connected to r
 *
 * For the algorithim:
 * We need to
 * * Find query - Check if two objects are in the same components
 * * Union Command - Replace components containing two objects with their union
 */

/**Function     Cost
 * initialize   N
 * union        N
 * find         1
 *
 * Worst case N^2
 */
public class UnionFindQuickFind implements UnionFind{
    /**
     * Initialize union-find data structure with N objects
     * @param n
     */
    private int[] ids;
    public UnionFindQuickFind(int n) {
        ids = new int[n];
        for (int i = 0; i < n; n++){
            ids[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pCompId = ids[p];
        int qCompId = ids[q];
        for (int i = 0; i < ids.length; i++){
            if (ids[i] == pCompId) {
                ids[i] = qCompId;
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return ids[p] == ids[q];
    }

}

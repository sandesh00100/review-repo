import org.junit.Test;

public class UnionFindTest {
    @Test
    public void unionFindTest(){
        int N = 10;
        int[][] pairs = {{4,3},{3,8},{6,5},{9,4},{2,1},{8,9},{5,0},{7,2},{6,1},{1,0},{6,7}};
        UnionFindQuickFind uf = new UnionFindQuickFind(N);
        for (int[] pair: pairs){
            int p = pair[0];
            int q = pair[1];
            if (!uf.connected(p,q)){
                uf.union(p,q);
                System.out.println(p + " -- " + q );
            }
        }
        assert(true);
    }
}

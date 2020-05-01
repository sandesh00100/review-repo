import org.junit.Test;

public class DijkstrasTwoStackTest {
    DijkstrasTwoStack dijkstrasTwoStack = new DijkstrasTwoStack();
    @Test
    public void dijkstrasTwoStackTest(){
        double result = dijkstrasTwoStack.orderOfOperations("(((1+((2+3)*(4*5)))-5)/2)");
        assert(result == 48.0);
    }
}

import org.junit.jupiter.api.Test;

public class LinkedListProblemsTest {
    LinkedListProblems linkedListProblems = new LinkedListProblems();
    @Test
    public void removeDupsTest(){
        LinkedListNode<Integer> head = linkedListProblems.generateLinkedListWithArray(new int[]{1,2,3,2,4,5,6,6,7,8,6});
        linkedListProblems.removeDups(head);
        linkedListProblems.printLinkedList(head);
        assert(true);
    }
}

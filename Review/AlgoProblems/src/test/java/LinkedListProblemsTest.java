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

    @Test
    public void sumLists(){
        LinkedListNode<Integer> list1Node = linkedListProblems.generateLinkedListWithArray(new int[]{7,1,6});
        LinkedListNode<Integer> list2Node = linkedListProblems.generateLinkedListWithArray(new int[]{5,9,2});
        LinkedListNode<Integer> list3Node = linkedListProblems.generateLinkedListWithArray(new int[]{7});
        LinkedListNode<Integer> list4Node = linkedListProblems.generateLinkedListWithArray(new int[]{5,9,2});
        LinkedListNode<Integer> listNodeSum = linkedListProblems.sumLists(list1Node,list2Node);
        LinkedListNode<Integer> listNodeSum2 = linkedListProblems.sumLists(list4Node,list3Node);

        int[] expectedSum = {2,1,9};
        int[] expectedSum2 = {2,0,3};

        boolean isExpected1 = true;
        boolean isExpected2 = true;

        for (int i : expectedSum) {
            if (list2Node == null) {
                isExpected1 = false;
                break;
            }

            isExpected1 = listNodeSum.data == i;
            if(!isExpected1){
                break;
            }
            listNodeSum = listNodeSum.next;
        }

        for (int i : expectedSum2){
            if (list2Node == null) {
                isExpected2 = false;
                break;
            }
            isExpected2 = listNodeSum2.data == i;
            if (!isExpected2) {
                break;
            }
            listNodeSum2 = listNodeSum2.next;
        }

        assert(isExpected1 && isExpected2);
    }
}

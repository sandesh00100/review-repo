import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListProblems {
    public void removeDups(LinkedListNode<Integer> Head){
        LinkedListNode<Integer> compareNode = Head;
        LinkedListNode<Integer> currentNode = Head;

        while (currentNode.next != null) {
            if (currentNode.next.data == compareNode.data) {
                currentNode.next = currentNode.next.next;
            }
            currentNode = currentNode.next;

            if (currentNode == null || currentNode.next == null && compareNode.next != null) {
                compareNode = compareNode.next;
                currentNode = compareNode;
            }
        }
    }

    public int returnKthToLast(LinkedListNode<Integer> node, int k){
        ArrayList<Integer> elementList = new ArrayList<Integer>();

        while (node != null) {
            elementList.add(node.data);
            node = node.next;
        }

        return elementList.get(elementList.size()-k+1);
    }

    public void deleteMiddleNode(LinkedListNode<Integer> nodeToDelete){
        nodeToDelete.data = nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;
    }

    // need to revist
//    public LinkedListNode<Integer> partition(LinkedList<Integer> node, int partition) {
//
//    }

    public LinkedListNode<Integer> generateLinkedListWithArray(int[] values) {
        LinkedListNode<Integer> currentNode = new LinkedListNode<>(values[0]);
        LinkedListNode<Integer> head = currentNode;
        for (int i=1; i<values.length; i++){
            currentNode.next = new LinkedListNode<>(values[i]);
            currentNode = currentNode.next;
        }
        return head;
    }

    public LinkedListNode<Integer> sumLists(LinkedListNode<Integer> list1Node, LinkedListNode<Integer> list2Node) {
        LinkedListNode<Integer> currentSumNode = null;
        int carryOver = 0;
        while (list1Node != null && list2Node != null) {
            if (currentSumNode == null) {
                currentSumNode = new LinkedListNode<>(list1Node.data + list2Node.data);
            } else {
                int sum = list1Node.data + list2Node.data + carryOver;
                carryOver = sum/10;
                LinkedListNode<Integer> nextNode = new LinkedListNode<>(sum % 10);
                currentSumNode.next = nextNode;
                currentSumNode = currentSumNode.next;
            }
            list1Node = list2Node.next;
            list2Node = list2Node.next;
        }

        LinkedListNode<Integer> unfinishedNode = list1Node != null ? list1Node : list2Node;

        while (unfinishedNode != null) {
            currentSumNode.next = new LinkedListNode<>(unfinishedNode.data);
            currentSumNode = currentSumNode.next;
            unfinishedNode = unfinishedNode.next;
        }

        return currentSumNode;
    }

    public void printLinkedList(LinkedListNode<Integer> node){
        System.out.print(node.data);
        node = node.next;
        while (node != null) {
            System.out.print("=>" + node.data);
            node = node.next;
        }
    }
}

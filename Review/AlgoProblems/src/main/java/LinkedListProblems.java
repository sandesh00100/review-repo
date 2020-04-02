
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

    public LinkedListNode<Integer> generateLinkedListWithArray(int[] values) {
        LinkedListNode<Integer> currentNode = new LinkedListNode<>(values[0]);
        LinkedListNode<Integer> head = currentNode;
        for (int i=1; i<values.length; i++){
            currentNode.next = new LinkedListNode<>(values[i]);
            currentNode = currentNode.next;
        }
        return head;
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

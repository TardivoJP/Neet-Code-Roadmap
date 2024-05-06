import java.util.HashMap;

class CopyListWithRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Node oldList = head;
        HashMap<Node, Node> map = new HashMap<>();

        while(oldList != null){
            map.put(oldList, new Node(oldList.val));
            oldList = oldList.next;
        }

        oldList = head;

        while(oldList != null){
            Node copy = map.get(oldList);
            copy.next = map.get(oldList.next);
            copy.random = map.get(oldList.random);
            oldList = oldList.next;
        }

        return map.get(head);
    }
}
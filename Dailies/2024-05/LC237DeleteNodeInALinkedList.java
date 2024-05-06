class DeleteNodeInALinkedList {
    public static void main(String[] args){
        ListNode list1 = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
        ListNode list2 =new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));

        printList(list1);
        deleteNode(list1.next); // expected 4 1 9
        printList(list1);

        System.out.println("@@@@@@@@@@@@@@@@@@@");

        printList(list2);
        deleteNode(list2.next.next); // expected 4 5 9
        printList(list2);
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void deleteNode(ListNode node) {
        ListNode cur = node;
        ListNode dummy = new ListNode(69);
        dummy.next = cur;

        while(cur != null){
            if(cur.next != null){
                cur.val = cur.next.val;
                cur = cur.next;
                dummy = dummy.next;
            }else{
                dummy.next = null;
                break;
            }
        }
    }
}
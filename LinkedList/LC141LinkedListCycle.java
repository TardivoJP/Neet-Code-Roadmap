class LinkedListCycle {
    public static void main(String[] args){
        ListNode list1 = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        list1.next.next.next.next = list1;

        ListNode list2 = new ListNode(5, new ListNode(2));
        list2.next.next = list2;

        ListNode list3 = new ListNode(1);

        printList(list1, 4);
        System.out.println(hasCycle(list1)); // expected true

        System.out.println("@@@@@@@@@@@@@@@@@@@");

        printList(list2, 2);
        System.out.println(hasCycle(list2)); // expected true
        
        System.out.println("@@@@@@@@@@@@@@@@@@@");

        printList(list3, 1);
        System.out.println(hasCycle(list3)); // expected false
    }

    public static void printList(ListNode head, int size){
        for(int i=0; i<size; i++){
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

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                return true;
            }                        
        }

        return false;
    }

}

class ReorderList {
    public static void main(String[] args){
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,  new ListNode(5)))));

        printList(list1);
        reorderList(list1); // expected 1 4 2 3
        printList(list1);

        System.out.println("@@@@@@@@@@@@@@@@@@@");

        printList(list2);
        reorderList(list2); // expected 1 5 2 4 3
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

    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode prev = null;

        while(secondHalf != null){
            ListNode temp = secondHalf.next;

            secondHalf.next = prev;
            prev = secondHalf ;
            secondHalf  = temp;
        }

        secondHalf = prev;
        ListNode firstHalf = head;

        while(secondHalf != null){
            ListNode tempFirst = firstHalf.next;
            ListNode tempSecond = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = tempFirst;

            secondHalf = tempSecond;
            firstHalf = tempFirst;
        }
    }
}

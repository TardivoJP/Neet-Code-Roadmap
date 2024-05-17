class RemoveNthNodeFromEndOfList {
    public static void main(String[] args){
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,  new ListNode(5)))));
        ListNode list2 = new ListNode(1);
        ListNode list3 = new ListNode(1, new ListNode(2));

        printList(list1);
        list1 = removeNthFromEndClever(list1, 2); // expected 1 2 3 5
        printList(list1);

        System.out.println("@@@@@@@@@@@@@@@@@@@");

        printList(list2);
        list2 = removeNthFromEndClever(list2, 1); // expected empty
        printList(list2);

        System.out.println("@@@@@@@@@@@@@@@@@@@");

        printList(list3);
        list3 = removeNthFromEndClever(list3, 2); // expected 2
        printList(list3);
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

    public static ListNode removeNthFromEndClever(ListNode head, int n) {
        ListNode dummy = new ListNode(69);
        dummy.next = head;

        ListNode left = dummy;
        ListNode right = head;
        int diff = 0;

        while(right != null){
            diff++;
            right = right.next;

            if(diff > n){
                left = left.next;
            }
        }

        left.next = left.next.next;

        return dummy.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int size = 0;

        while(cur != null){
            size++;
            cur = cur.next;
        }

        int remove = size - n + 1;
        cur = head;
        int count = 0;
        ListNode prev = null;

        while(cur != null){
            count++;

            if(count == remove - 1){
                prev = cur;
            }

            if(count == remove){
                if(prev == null){
                    return cur.next;
                }else{
                    prev.next = cur.next;
                }
            }

            size++;
            cur = cur.next;
        }

        return head;
    }
}
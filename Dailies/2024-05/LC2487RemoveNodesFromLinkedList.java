class RemoveNodesFromLinkedList {
    public static void main(String[] args){
        ListNode list1 = new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))));
        ListNode list2 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))));

        printList(list1);
        list1 = removeNodes(list1); // expected 13,8
        printList(list1);

        System.out.println("@@@@@@@@@@@@@@@@@@@");

        printList(list2);
        list2 = removeNodes(list2); // expected 1,1,1,1
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

    //Found this really cool recursive implementation
    //It technically accomplishes everything in just two passes through the list
    //First pass is forwards with the recursive call stack, until head.next is null
    //Then it keeps comparing the values previous to it, setting up the respective links or ignoring smaller values
    public ListNode removeNodesRecursive(ListNode head) {
        if (head.next == null) {
            return head;
        }
        
        ListNode temp = removeNodesRecursive(head.next);
        if (temp.val > head.val) {
            return temp;
        } else {
            head.next = temp;
            return head;
        }
    }

    public static ListNode removeNodes(ListNode head) {
        ListNode reversed = reverseList(head);

        ListNode cur = reversed;
        ListNode next = cur.next;

        outerloop:
        while(cur != null && next != null){
            while(cur.val > next.val){
                next = next.next;

                if(next == null){
                    cur.next = null;
                    break outerloop;
                }
            }
            
            cur.next = next;
            next = next.next;
            cur = cur.next;
        }

        return reverseList(reversed);
    }


    public static ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            ListNode temp = cur.next;

            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }
}
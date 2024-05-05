class MergeTwoSortedLists {
    public static void main(String[] args){
        //ListNode list1 = new ListNode(5, new ListNode(6, new ListNode(7)));
        //ListNode list2 = new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(11, new ListNode(12)))));

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));


        ListNode result = mergeTwoLists(list1, list2); // expected 1,1,2,3,4,4
        printList(result); 
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curA = list1;
        ListNode curB = list2;
        ListNode newHead = new ListNode(69);
        ListNode curC = newHead;

        while(curA != null && curB != null){
            if(curA.val < curB.val){
                curC.next = curA;
                curA = curA.next;
            }else{
                curC.next = curB;
                curB = curB.next;
            }
            curC = curC.next;
        }

        if(curB != null){
            curC.next = curB;
        }else if(curA != null){
            curC.next = curA;
        }

        return newHead.next;
    }
}
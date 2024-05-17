class ReverseNodesInKGroup {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));


        l1 = reverseKGroup(l1, 2); // expected 2 1 4 3 5
        printList(l1);

        l2 = reverseKGroup(l2, 3); // expected 3 2 1 4 5
        printList(l2);
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        int size = calcSize(head) + 1;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy.next;
        ListNode prev = dummy;

        int counterToReverse = k;
        int iterations = 0;

        while(cur != null){
            iterations++;
            if(size - iterations < k){
                break;
            }

            if(counterToReverse == k){
                ListNode temp = reverse(cur, k);
                cur = temp;
                prev.next = cur;
                counterToReverse = 0;
            }

            prev = cur;
            cur = cur.next;
            counterToReverse++;
        }

        return dummy.next;
    }

    public static ListNode reverse(ListNode head, int n){
        ListNode cur = head;
        ListNode prev = null;

        int i = 1;

        while(cur != null && i <= n){
            ListNode temp = cur.next;

            cur.next = prev;
            prev = cur;
            cur = temp;

            i++;
        }

        if(cur != null){
            head.next = cur;
        }

        return prev;
    }

    public static int calcSize(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
}
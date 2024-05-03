class AddTwoNumbers {
    public static void main(String[] args){
        ListNode testCase1l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode testCase1l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode testCase2l1 = new ListNode(0);
        ListNode testCase2l2 = new ListNode(0);

        ListNode testCase3l1 = new ListNode(5);
        ListNode testCase3l2 = new ListNode(5);

        ListNode testCase4l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode testCase4l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));


        ListNode l3 = addTwoNumbers(testCase1l1, testCase1l2);

        while(l3 != null){
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }
        System.out.println();

        l3 = addTwoNumbers(testCase2l1, testCase2l2);

        while(l3 != null){
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }
        System.out.println();

        l3 = addTwoNumbers(testCase3l1, testCase3l2);

        while(l3 != null){
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }
        System.out.println();

        l3 = addTwoNumbers(testCase4l1, testCase4l2);

        while(l3 != null){
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int digit = l1.val + l2.val + carry;

        if(digit >= 10){
            digit %= 10;
            carry++;
        }

        ListNode cur = new ListNode(digit);

        if(l1.next != null || l2.next != null){
            return addTwoNumbersAux(l1.next, l2.next, cur, cur, carry);
        }else{
            if(carry>0){
                return addTwoNumbersAux(l1.next, l2.next, cur, cur, carry);
            }else{
                return cur;
            }
        }
    }

    public static ListNode addTwoNumbersAux(ListNode l1, ListNode l2, ListNode head, ListNode cur, int carry){
        int digit = 0;

        if(l1 == null && l2 == null && carry>0){
            digit = carry;
        }else if(l1 == null){
            digit = l2.val + carry;
        }else if(l2 == null){
            digit = l1.val + carry;
        }else{
            digit = l1.val + l2.val + carry;
        }

        carry = 0;

        if(digit >= 10){
            digit %= 10;
            carry++;
        }

        cur.next = new ListNode(digit);

        if(l1 == null && l2 == null){
            if(carry>0){
                return addTwoNumbersAux(l1, l2, head, cur.next, carry);
            }else{
                return head;
            }
        }else{
            if(l1 != null && l2 != null){
                if(l1.next == null && l2.next == null && carry == 0){
                    return head;
                }else{
                    return addTwoNumbersAux(l1.next, l2.next, head, cur.next, carry);
                }
            }else if(l1 != null && l2 == null){
                if(l1.next == null){
                    if(carry>0){
                        return addTwoNumbersAux(l1.next, l2, head, cur.next, carry);
                    }else{
                        return head;
                    }
                }else{
                    return addTwoNumbersAux(l1.next, l2, head, cur.next, carry);
                }
            }else if(l1 == null && l2 != null){
                if(l2.next == null){
                    if(carry>0){
                        return addTwoNumbersAux(l1, l2.next, head, cur.next, carry);
                    }else{
                        return head;
                    }
                }else{
                    return addTwoNumbersAux(l1, l2.next, head, cur.next, carry);
                }
            }
        }

        return head;

    }
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
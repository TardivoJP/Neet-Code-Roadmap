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


        printList(testCase1l1);
        printList(testCase1l2);
        printList(addTwoNumbers(testCase1l1, testCase1l2)); // expected 7,0,8

        System.out.println("@@@@@@@@@@@@@@@@@@@");

        printList(testCase2l1);
        printList(testCase2l2);
        printList(addTwoNumbers(testCase2l1, testCase2l2)); // expected 0

        System.out.println("@@@@@@@@@@@@@@@@@@@");

        printList(testCase3l1);
        printList(testCase3l2);
        printList(addTwoNumbers(testCase3l1, testCase3l2)); // expected 0,1

        System.out.println("@@@@@@@@@@@@@@@@@@@");

        printList(testCase4l1);
        printList(testCase4l2);
        printList(addTwoNumbers(testCase4l1, testCase4l2)); // expected 8,9,9,9,0,0,0,1
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(69);
        ListNode cur = dummy;

        int carry = 0;

        while(l1 != null || l2 != null || carry > 0){
            int total = 0;

            if(l1 != null){
                total += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                total += l2.val;
                l2 = l2.next;
            }

            total += carry;

            if(total > 9){
                total %= 10;
                carry = 1;
            }else{
                carry = 0;
            }

            cur.next = new ListNode(total);
            cur = cur.next;
        }

        return dummy.next;
    }

    // OLD IMPLEMENTATION
    // THE CODE BELOW IS WHAT I WROTE IN MY FIRST ATTEMPT OF THE PROBLEM

    public static ListNode addTwoNumbersOldImplementation(ListNode l1, ListNode l2) {
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
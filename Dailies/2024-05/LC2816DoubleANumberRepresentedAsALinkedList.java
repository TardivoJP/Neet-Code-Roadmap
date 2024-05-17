class DoubleANumberRepresentedAsALinkedList {
  public static void main(String[] args){
    ListNode list1 = new ListNode(1, new ListNode(8, new ListNode(9)));
    ListNode list2 = new ListNode(9, new ListNode(9, new ListNode(9)));
    
    printList(list1);
    list1 = doubleIt(list1); // expected 3,7,8
    printList(list1);
    
    System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
    
    printList(list2);
    list2 = doubleIt(list2); // expected 1,9,9,8
    printList(list2);
  }
  
  public static void printList(ListNode head){
    while(head != null){
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println();
  }
  
  public static ListNode doubleIt(ListNode head) {
    head = reverseList(head);
    ListNode cur = head;
    
    int carry = 0;
    
    while(cur != null){
      cur.val = (cur.val * 2) + carry;
      carry = cur.val/10;
      cur.val %= 10;
      
      if(cur.next == null && carry > 0){
        cur.next = new ListNode(carry);
        cur = cur.next;
        break;
      }
      
      cur = cur.next;
    }
    
    head = reverseList(head);

    return head;
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
  
  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }  
}
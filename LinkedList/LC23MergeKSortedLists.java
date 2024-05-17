import java.util.Comparator;
import java.util.PriorityQueue;

class MergeKSortedLists {
  public static void main(String[] args){
      ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
      ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
      ListNode l3 = new ListNode(2, new ListNode(6));

      ListNode[] lists1 = {l1, l2, l3};
      
      ListNode result = mergeKLists(lists1);
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

  public static ListNode mergeKLists(ListNode[] lists) {
      PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt((ListNode n) -> n.val));

      for(ListNode head : lists){
          if(head != null){
              pq.add(head);
          }
      }

      ListNode dummy = new ListNode();
      ListNode cur = dummy;

      while(!pq.isEmpty()){
          ListNode temp = pq.poll();

          if(temp.next != null){
              pq.add(temp.next);
          }

          cur.next = temp;
          cur = cur.next;
      }

      return dummy.next;
  }
}
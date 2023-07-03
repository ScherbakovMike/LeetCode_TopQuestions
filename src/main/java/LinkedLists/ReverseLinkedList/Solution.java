
class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    var length = 0;
    var tail = head;
    while (tail.next != null) {
      length++;
      tail = tail.next;
    }
    length++;
    var left = head;
    ListNode right;
    for (int i = 0; i < length / 2; i++) {
      right = left;
      for (int j = 0; j < (length - i * 2) - 1; j++) {
        right = right.next;
      }
      left.val = left.val + right.val;
      right.val = left.val - right.val;
      left.val = left.val - right.val;
      left = left.next;
    }
    return head;
  }

  public static void main(String[] args) {
//    var head = new ListNode(3);
//    head.next = new ListNode(1);
//    head.next.next = new ListNode(3);
//    head.next.next.next = new ListNode(4);
//    head.next.next.next.next = new ListNode(1);
//    head.next.next.next.next.next = new ListNode(4);
//    head.next.next.next.next.next.next= new ListNode(-1);
    var head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    printList(head);
    head = new Solution().reverseList(head);
    printList(head);
  }

  private static void printList(ListNode head) {
    var currentNode = head;
    while (currentNode != null) {
      System.out.println(currentNode.val);
      currentNode = currentNode.next;
    }
  }

}
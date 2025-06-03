package LinkedLists;

public class MiddleOfTheLinkedList {

  public ListNode middleNode(ListNode head) {
    var fast = head;
    var slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    var list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    // var list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,
    // new ListNode(6))))));
    System.out.println(new MiddleOfTheLinkedList().middleNode(list).val);
  }
}

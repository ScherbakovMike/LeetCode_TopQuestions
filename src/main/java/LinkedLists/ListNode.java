package LinkedLists;

public class ListNode {

  public int val;
  public ListNode next;

  ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode of(int... arr) {
    ListNode head = null;
    ListNode lastNode = null;
    for (int i = 0; i < arr.length; i++) {
      if (head == null) {
        head = new ListNode(arr[0]);
        lastNode = head;
      } else {
        lastNode.next = new ListNode(arr[i]);
        lastNode = lastNode.next;
      }
    }
    return head;
  }
}

package LinkedLists.DeleteNodeInALinkedList;

public class Solution {
  public void deleteNode(ListNode node) {
    var currentNode = node;
    while (currentNode != null) {
      if (currentNode.next != null) {
        currentNode.val = currentNode.next.val;
        if (currentNode.next.next == null) {
          currentNode.next = null;
        }
      }
      currentNode = currentNode.next;
    }
  }

  public static void main(String[] args) {
    var head = new ListNode(4);
    head.next = new ListNode(5);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(9);
    printList(head);
    new Solution().deleteNode(head);
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

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}
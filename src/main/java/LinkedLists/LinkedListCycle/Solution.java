package LinkedLists.LinkedListCycle;

import java.util.HashSet;

public class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    var left = head;
    var links = new HashSet<ListNode>();
    while (!links.contains(left.next) && left.next != null) {
      links.add(left);
      left = left.next;
    }
    return (links.contains(left.next));
  }

  private static void printList(ListNode head) {
    var currentNode = head;
    while (currentNode != null) {
      System.out.println(currentNode.val);
      currentNode = currentNode.next;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(0);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = head.next;

    // head.next.next.next.next = head.next;
    System.out.println(new Solution().hasCycle(head));
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

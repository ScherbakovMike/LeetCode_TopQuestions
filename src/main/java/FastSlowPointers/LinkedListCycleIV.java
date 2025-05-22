package FastSlowPointers;

import LinkedLists.ListNode;

/*
https://www.educative.io/courses/grokking-coding-interview/linked-list-cycle-iv
Statement
Given the head of a singly linked list, implement a function to detect and remove any cycle present in the list. A cycle occurs when a node's next pointer links back to a previous node, forming a loop within the list.

The function must modify the linked list in place, ensuring it remains acyclic while preserving the original node order. If no cycle is found, return the linked list as is.
 */
public class LinkedListCycleIV {

  public static ListNode removeCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    ListNode preSlow = null;
    do {
      preSlow = slow;
      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      }
    } while (slow != null && fast != null && slow != fast);

    if (slow == null || fast == null) {
      return head;
    }

    fast = head;
    while (fast != slow) {
      fast = fast.next;
      preSlow = slow;
      slow = slow.next;
    }
    System.out.println("Cycle starts at the " + slow.val + "; prior node is " + preSlow.val);
    preSlow.next = null;
    return head;
  }
}

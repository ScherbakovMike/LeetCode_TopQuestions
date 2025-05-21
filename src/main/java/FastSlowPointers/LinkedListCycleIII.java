package FastSlowPointers;

import LinkedLists.ListNode;

/*
https://www.educative.io/courses/grokking-coding-interview/linked-list-cycle-iii
Statement
Given the head of a linked list, determine the length of the cycle present in the linked list. If there is no cycle, return 0.

A cycle exists in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 */
public class LinkedListCycleIII {

  public static int countCycleLength(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    do {
      slow = slow.next;
      fast = fast.next.next;
    } while (slow != null && fast != null && fast.next != null && slow != fast);

    if (slow == null || fast == null || fast.next == null) {
      return 0;
    }

    // reset fast to head;
    fast = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    // slow = the start of the cycle
    int length = 1;
    ListNode entrance = slow;
    while (slow.next != entrance) {
      slow = slow.next;
      length++;
    }
    return length;
  }

  public static void main(String[] args) {
    ListNode test1 = ListNode.of(1, 2, 3, 4, 5);
    test1.next.next.next.next.next = test1.next;
    System.out.println(countCycleLength(test1));
  }
}

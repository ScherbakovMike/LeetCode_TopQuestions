package LinkedLists.ReverseLinkedList;

/*
https://leetcode.com/problems/reverse-linked-list/
206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

import LinkedLists.*;

public class Solution {
  // Iterative algorithm
  // TC: O(n), SC: O(1)
  //    public ListNode reverseList(ListNode head) {
  //        if (head == null || head.next == null) {
  //            return head;
  //        }
  //        ListNode preCurrent = head;
  //        ListNode current = head.next;
  //        head.next = null;
  //
  //        while (current.next != null) {
  //            ListNode buf = current.next;
  //            current.next = preCurrent;
  //            preCurrent = current;
  //            current = buf;
  //        }
  //        current.next = preCurrent;
  //        return current;
  //    }

  // Recursive algorithm
  // TC: O(n), SC: O(n)
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverseRemainingList(head.next, head);
    head.next = null;
    return newHead;
  }

  private ListNode reverseRemainingList(ListNode head, ListNode tail) {
    ListNode buf = head.next;
    head.next = tail;
    if (buf == null) return head;
    else return reverseRemainingList(buf, head);
  }

  //  public ListNode reverseList(ListNode head) {
  //    if (head == null || head.next == null) {
  //      return head;
  //    }
  //    var length = 0;
  //    var tail = head;
  //    while (tail.next != null) {
  //      length++;
  //      tail = tail.next;
  //    }
  //    length++;
  //    var left = head;
  //    ListNode right;
  //    for (int i = 0; i < length / 2; i++) {
  //      right = left;
  //      for (int j = 0; j < (length - i * 2) - 1; j++) {
  //        right = right.next;
  //      }
  //      left.val = left.val + right.val;
  //      right.val = left.val - right.val;
  //      left.val = left.val - right.val;
  //      left = left.next;
  //    }
  //    return head;
  //  }

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

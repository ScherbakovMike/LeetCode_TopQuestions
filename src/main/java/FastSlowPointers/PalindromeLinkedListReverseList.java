package FastSlowPointers;

import LinkedLists.*;

/*
234. Palindrome Linked List (Slow-fast pointers & Reverse List)
https://leetcode.com/problems/palindrome-linked-list/description/

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Constraints:
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedListReverseList {

  public static boolean palindrome(ListNode head) {
    // 0. Validations
    // 1. Find the middle of the list
    // 2. Reverse the second part of the list
    // 3. Iterate through both parts comparing items
    // 4. Reverse the second part again
    if (head == null) return false;
    if (head.next == null) return true;
    Object[] listInfo = findMiddleNode(head);
    ListNode middleNode = (ListNode) listInfo[0];
    ListNode lastNode = (ListNode) listInfo[2];
    int length = (int) listInfo[1];
    ListNode reversedList = reverseList(head, middleNode);

    ListNode left1 = reversedList;
    ListNode right1Exclusively = middleNode;
    ListNode left2 = middleNode;
    if (length % 2 == 1) left2 = left2.next;
    ListNode right2Inclusively = lastNode;

    ListNode cur1 = left1;
    ListNode cur2 = left2;

    Boolean comparingResult = true;
    while (cur1 != right1Exclusively && cur2 != right2Inclusively.next) {
      if (cur1.val != cur2.val) {
        comparingResult = false;
        break;
      }
      cur1 = cur1.next;
      cur2 = cur2.next;
    }
    reverseList(reversedList, middleNode);
    return comparingResult;
  }

  private static Object[] findMiddleNode(ListNode head) {
    // use slow and fast runners
    // when the fast runners comes to the finish, the slow runner is
    // at the middle node (for the odd-legth list)
    // or at the beginning of the second part (for the eve-length list)
    ListNode slow = head;
    ListNode fast = head;
    int length = 1;
    while (fast != null && fast.next != null) {
      fast = fast.next;
      length++;
      if (fast.next != null) {
        fast = fast.next;
        length++;
      }
      slow = slow.next;
    }
    return new Object[] {slow, length, fast};
  }

  // 1 2 3 4 5 6 ... 7
  private static ListNode reverseList(ListNode head, ListNode nodeAfterTail) {
    ListNode current = head.next;
    ListNode prev = head;
    head.next = null;
    while (current != nodeAfterTail) {
      ListNode buf = current.next;
      current.next = prev;
      prev = current;
      current = buf;
    }
    head.next = nodeAfterTail;
    return prev;
  }

  public static void main(String[] args) {
    //        ListNode head = null;
    ListNode head = new ListNode(1);
    //        ListNode head = new ListNode(1, new ListNode(2));
    //        ListNode head = new ListNode(1, new ListNode(1));
    //        ListNode head = new ListNode(1,
    //                new ListNode(2,
    //                        new ListNode(2,
    //                                new ListNode(1))));
    //        ListNode head = new ListNode(1,
    //                new ListNode(2,
    //                        new ListNode(3,
    //                                new ListNode(2, new ListNode(1)))));
    System.out.println(palindrome(head));
  }
}

package FastSlowPointers;

import LinkedLists.*;

/*
234. Palindrome Linked List (Recursive approach)
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
public class PalindromeLinkedListRecursive {

    private static ListNode leftNode = null;

    public static boolean palindrome(ListNode head) {
        // We will recursively traverse a list until it reaches the end
        // Then we will compare values at the exit from the function
        leftNode = head;
        return traverseListRecursively(head);
    }

    private static boolean traverseListRecursively(ListNode head) {
        if (head == null) {
            return true;
        }
        if (!traverseListRecursively(head.next)) return false;
        if (head.val != leftNode.val) return false;
        leftNode = leftNode.next;
        return true;
    }

    public static void main(String[] args) {
//        ListNode head = null;
//        ListNode head = new ListNode(1);
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
        ListNode head = new ListNode(1,
                new ListNode(0,
                        new ListNode(1)));
        System.out.println(palindrome(head));
    }
}

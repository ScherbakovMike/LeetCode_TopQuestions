package LinkedLists.RemoveNthNodeFromTheEnd;

/*
19. Remove Nth Node From End of List
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */
public class RemoveNthNodeFromEndOfLList2 {

    public static ListNode removeNthLastNode(ListNode head, int n) {
        var firstNode = head;
        var secondNode = head;
        ListNode preFirstNode = null;
        for (var i = 0; i < n; i++) {
            secondNode = secondNode.next;
        }
        while (secondNode != null) {
            preFirstNode = firstNode;
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        if (preFirstNode == null) {
            return head.next;
        } else {
            preFirstNode.next = firstNode.next;
            return head;
        }
    }

    private static void printList(ListNode head) {
        var currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        var head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        var head1 = new ListNode(427);
        printList(removeNthLastNode(head1, 5));
    }
}

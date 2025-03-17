package LinkedLists.RemoveNthNodeFromTheEnd;

//19. https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
/*
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
public class RemoveNthNodeFromEndOfLList {

    public static ListNode removeNthLastNode(ListNode head, int n) {

        // Replace this placeholder return statement with your code
        if (head == null) {
            return null;
        }
        var prev = head;
        var right = head.next;
        if (n > 0 && right == null) {
            return null;
        }
        while (right != null) {
            var i = 0;
            while (i < n && right != null) {
                right = right.next;
                i++;
            }
            if (i == n && right == null) {
                prev.next = prev.next.next;
                return head;
            }
            if (i == (n - 1)) {
                return head.next;
            }
            if (i < (n - 1)) {
                return null;
            }

            if (i == n) {
                prev = prev.next;
                right = prev.next;
            }
        }
        return head;
    }

    private static void printList(ListNode head) {
        var currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
//        var head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        printList(removeNthLastNode(head1, 1));

        var head1 = new ListNode(427);
        printList(removeNthLastNode(head1, 1));
    }
}

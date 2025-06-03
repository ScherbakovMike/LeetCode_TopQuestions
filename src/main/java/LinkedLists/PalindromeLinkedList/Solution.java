package LinkedLists.PalindromeLinkedList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
  public boolean isPalindrome(ListNode head) {
    var result = true;
    var length = Integer.MAX_VALUE;
    var left = head;
    ListNode leftRight = null;
    for (int i = 0; (i < length / 2) && result; i++) {
      var right = left;
      if (leftRight != null && leftRight != left) {
        right = leftRight;
        leftRight = null;
      } else {
        int j;
        for (j = 0; (j < (length - 2 * i - 1)) && right.next != null; j++) {
          leftRight = right;
          right = right.next;
        }
        if (length == Integer.MAX_VALUE) {
          length = j + 1;
        }
      }
      if (left.val != right.val) {
        result = false;
      }
      left = left.next;
    }
    return result;
  }

  private static void printList(ListNode head) {
    var currentNode = head;
    while (currentNode != null) {
      System.out.println(currentNode.val);
      currentNode = currentNode.next;
    }
  }

  public static void main(String[] args) {
    var array = new int[] {1, 9, 4, 4, 9, 1};
    ListNode head = null;
    ListNode lastNode = null;
    for (int i = 0; i < array.length; i++) {
      if (head == null) {
        head = new ListNode(array[i]);
        lastNode = head;
      } else {
        lastNode.next = new ListNode(array[i]);
        lastNode = lastNode.next;
      }
    }
    printList(head);
    System.out.println(new Solution().isPalindrome(head));
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

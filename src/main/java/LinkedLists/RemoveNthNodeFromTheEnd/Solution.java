package LinkedLists.RemoveNthNodeFromTheEnd;


import java.util.Arrays;

// Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode preNNode = null;
    ListNode nNode = head;
    int lastNodeCounter = 0;
    var curNode = head;
    while (curNode != null) {
      lastNodeCounter++;
      if (lastNodeCounter > n) {
        preNNode = nNode;
        nNode = nNode.next;
      }
      curNode = curNode.next;
    }
    if (lastNodeCounter == n) {
      head = nNode.next;
    } else if (lastNodeCounter > n) {
      preNNode.next = nNode.next;
    }
    return head;
  }

  public static void main(String[] args) {
    var head = new ListNode(4);
    head.next = new ListNode(5);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(9);
    printList(head);
    new Solution().removeNthFromEnd(head, 3);
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


package LinkedLists.MergeTwoSortedLists;

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

public class Solution {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode savedHead = null;
    ListNode lastNode = null;
    var head1 = list1;
    var head2 = list2;
    while (head1 != null || head2 != null) {
      if (head2 == null) {
        lastNode = addToList(lastNode, head1.val);
        head1 = head1.next;
      } else if (head1 == null) {
        lastNode = addToList(lastNode, head2.val);
        head2 = head2.next;
      } else if (head1.val < head2.val) {
        lastNode = addToList(lastNode, head1.val);
        head1 = head1.next;
      } else if (head1.val > head2.val) {
        lastNode = addToList(lastNode, head2.val);
        head2 = head2.next;
      } else if (head1.val == head2.val) {
        lastNode = addToList(lastNode, head1.val);
        head1 = head1.next;
        if (savedHead == null) {
          savedHead = lastNode;
        }
        lastNode = addToList(lastNode, head2.val);
        head2 = head2.next;
      }
      if (savedHead == null) {
        savedHead = lastNode;
      }
    }
    return savedHead;
  }

  ListNode addToList(ListNode head, int value) {
    ListNode lastNode;
    if (head == null) {
      head = new ListNode(value);
      lastNode = head;
    } else {
      head.next = new ListNode(value);
      lastNode = head.next;
    }
    return lastNode;
  }

  public static void main(String[] args) {
    var list1 = new ListNode(1);
    list1.next = new ListNode(2);
    list1.next.next = new ListNode(4);

    var list2 = new ListNode(1);
    list2.next = new ListNode(3);
    list2.next.next = new ListNode(4);

    //    ListNode list1 = null;
    //    var list2 = new ListNode(0);

    printList(new Solution().mergeTwoLists(list1, list2));
  }

  private static void printList(ListNode head) {
    var currentNode = head;
    while (currentNode != null) {
      System.out.println(currentNode.val);
      currentNode = currentNode.next;
    }
  }
}

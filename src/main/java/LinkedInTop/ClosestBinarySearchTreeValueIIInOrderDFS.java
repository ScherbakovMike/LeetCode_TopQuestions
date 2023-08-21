package LinkedInTop;

import java.util.LinkedList;
import java.util.List;

public class ClosestBinarySearchTreeValueIIInOrderDFS {

  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    var result = new LinkedList<Integer>();
    dfsInOrder(root, target, k, result);
    return result;
  }

  private void dfsInOrder(TreeNode root, double target, int k, LinkedList<Integer> result) {
    if (root == null) {
      return;
    }
    dfsInOrder(root.left, target, k, result);
    if (result.size() < k) {
      result.add(root.val);
    } else {
      var diff = Math.abs(root.val - target);
      var diffLeft = Math.abs(result.peekFirst() - target);
      var diffRight = Math.abs(result.peekLast() - target);
      if (diff < diffLeft) {
        result.removeFirst();
        result.add(root.val);
      } else {
        if (diff < diffRight) {
          result.removeFirst();
          result.add(root.val);
        } else {
          return;
        }
      }
    }
    dfsInOrder(root.right, target, k, result);
  }

  public static void main(String[] args) {
    var tree = TreeNode.of(new Integer[]{18, 0, 40, null, 2, 22, 49, 1, 17, 21, 32, 45, null, null, null, 9, null, 19, null, 29, 37, 44, 47, 8, 13, null, 20, 26, 30, 33, 39, 42, null, 46, 48, 3, null, 10, 16, null, null, 24, 27, null, 31, null, 35, 38, null, 41, 43, null, null, null, null, null, 4, null, 12, 14, null, 23, 25, null, 28, null, null, 34, 36, null, null, null, null, null, null, null, 7, 11, null, null, 15, null, null, null, null, null, null, null, null, null, null, 5, null, null, null, null, null, null, 6});
//    var tree = new TreeNode(4,
//      new TreeNode(2,
//        new TreeNode(1),
//        new TreeNode(3)),
//      new TreeNode(5,
//        new TreeNode(4),
//        new TreeNode(6)));
    System.out.println(new ClosestBinarySearchTreeValueIIInOrderDFS().closestKValues(
      tree,
      5.142857,
      3
    ));
  }
  /*
  [18,0,40,null,2,22,49,1,17,21,32,45,null,null,null,9,null,19,null,29,37,44,47,8,13,null,20,26,30,33,39,42,null,46,48,3,null,10,16,null,null,24,27,null,31,null,35,38,null,41,43,null,null,null,null,null,4,null,12,14,null,23,25,null,28,null,null,34,36,null,null,null,null,null,null,null,7,11,null,null,15,null,null,null,null,null,null,null,null,null,null,5,null,null,null,null,null,null,6]
  5.142857
  3
   */
}

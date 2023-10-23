package LinkedInTop;

import java.util.LinkedList;

public class SecondMinimumNodeInABinaryTree {

  public static void main(String[] args) {
    var root = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
    //var root = new TreeNode(2, new TreeNode(2), new TreeNode(2));
//    var root = new TreeNode(1,
//      new TreeNode(1,
//        new TreeNode(1),
//        new TreeNode(1)),
//      new TreeNode(1,
//        new TreeNode(1),
//        new TreeNode(1)));

    System.out.println(new SecondMinimumNodeInABinaryTree().findSecondMinimumValue(root));
  }

  public int findSecondMinimumValue(TreeNode root) {
    var maxValue = root.val;
    var queue = new LinkedList<TreeNode>();
    addChildrenToQueue(root, queue);
    Integer minValue = null;
    while (!queue.isEmpty()) {
      var curElem = queue.removeLast();
      if (curElem.val > maxValue
        && (minValue == null || curElem.val < minValue)) {
        if (curElem.val == (maxValue - 1)) {
          return curElem.val;
        }
        minValue = curElem.val;
      }
      if (curElem.val == maxValue) {
        addChildrenToQueue(curElem, queue);
      }
    }
    return minValue == null ? -1 : minValue;
  }

  private  void addChildrenToQueue(TreeNode curElem, LinkedList<TreeNode> queue) {
    if (curElem.right != null) {
      queue.add(curElem.right);
    }
    if (curElem.left != null) {
      queue.add(curElem.left);
    }
  }
}

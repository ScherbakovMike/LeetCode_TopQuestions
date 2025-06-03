package Trees.ValidateBinarySearchTree;

import LinkedInTop.TreeNode;

public class Solution {

  public static void main(String[] args) {
    var tree = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    //        var tree = new TreeNode(6,
    //                new TreeNode(4, new TreeNode(3), new TreeNode(5)),
    //                new TreeNode(8, new TreeNode(7), new TreeNode(9)));
    //        var tree = new TreeNode(7,
    //                new TreeNode(4),
    //                new TreeNode(8, new TreeNode(6), new TreeNode(9)));
    //        var tree = new TreeNode(4,
    //                new TreeNode(2, new TreeNode(3), null),
    //                new TreeNode(8, new TreeNode(6), null));
    //        var tree = new TreeNode(2,
    //                new TreeNode(2),
    //                new TreeNode(2));
    //        var tree = new TreeNode(32,
    //                new TreeNode(26,
    //                        new TreeNode(19,
    //                                null,
    //                                new TreeNode(27)),
    //                        null),
    //                new TreeNode(47,
    //                        null,
    //                        new TreeNode(56)));
    System.out.println(new Solution().isValidBST(tree));
  }

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (root.left != null) {
      if (root.left.val >= root.val) {
        return false;
      }
      var maxInLeft = findMax(root.left, root.left.val);
      if (maxInLeft >= root.val) {
        return false;
      }
    }
    if (root.right != null) {
      if (root.right.val <= root.val) {
        return false;
      }
      var minInRight = findMin(root.right, root.right.val);
      if (minInRight <= root.val) {
        return false;
      }
    }
    var isLeftValid = root.left == null || isValidBST(root.left);
    var isRightValid = root.right == null || isValidBST(root.right);
    return isLeftValid && isRightValid;
  }

  private int findMax(TreeNode node, int curMax) {
    if (node != null) {
      if (node.val > curMax) {
        curMax = node.val;
      }
      curMax = Math.max(curMax, Math.max(findMax(node.left, curMax), findMax(node.right, curMax)));
    }
    return curMax;
  }

  private int findMin(TreeNode node, int curMin) {
    if (node != null) {
      if (node.val < curMin) {
        curMin = node.val;
      }
      curMin = Math.min(curMin, Math.min(findMin(node.left, curMin), findMax(node.right, curMin)));
    }
    return curMin;
  }
}

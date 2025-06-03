package Trees.MaximumDepthOfBinaryTree;

import LinkedInTop.TreeNode;

public class Solution {
  public int maxDepth(TreeNode root) {
    return traversalTreeInDepth(root, 0);
  }

  private int traversalTreeInDepth(TreeNode root, int currentDepth) {
    if (root != null) {
      currentDepth++;
      return Math.max(
          traversalTreeInDepth(root.left, currentDepth),
          traversalTreeInDepth(root.right, currentDepth));
    }
    return currentDepth;
  }

  public static void main(String[] args) {
    var tree =
        new TreeNode(
            3,
            new TreeNode(
                9,
                new TreeNode(10, new TreeNode(11, new TreeNode(12, null, null), null), null),
                null),
            new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
    System.out.println(new Solution().maxDepth(tree));
  }
}

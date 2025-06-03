package Trees;

import LinkedInTop.TreeNode;

public class MinimumDepthOfBinaryTree {

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    var minDepth = 1;
    return minDepthR(root, minDepth);
  }

  private int minDepthR(TreeNode root, int minDepth) {
    if (root.left == null && root.right == null) {
      return minDepth;
    }
    return Math.min(
        root.left == null ? Integer.MAX_VALUE : minDepthR(root.left, minDepth + 1),
        root.right == null ? Integer.MAX_VALUE : minDepthR(root.right, minDepth + 1));
  }

  public static void main(String[] args) {
    var root = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4)));
    System.out.println(new MinimumDepthOfBinaryTree().minDepth(root));
  }
}

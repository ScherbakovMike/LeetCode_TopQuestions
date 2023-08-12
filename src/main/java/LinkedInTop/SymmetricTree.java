package LinkedInTop;

//Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
  }

  private boolean isMirror(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }

    return left.val == right.val
      && isMirror(left.left, right.right)
      && isMirror(left.right, right.left);
  }


}
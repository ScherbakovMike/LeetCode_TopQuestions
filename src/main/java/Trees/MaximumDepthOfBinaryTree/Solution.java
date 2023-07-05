package Trees.MaximumDepthOfBinaryTree;

import java.util.concurrent.atomic.AtomicInteger;

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

public class Solution {
  public int maxDepth(TreeNode root) {
    AtomicInteger maxDepth = new AtomicInteger(0);
    AtomicInteger currentDepth = new AtomicInteger(0);
    traversalTreeInDepth(root, maxDepth, currentDepth);
    return maxDepth.get();
  }

  private void traversalTreeInDepth(TreeNode root, AtomicInteger maxDepth, AtomicInteger currentDepth) {
    if (root != null) {
      currentDepth.incrementAndGet();
      var currentDepthBackup = new AtomicInteger(currentDepth.get());
      traversalTreeInDepth(root.left, maxDepth, currentDepth);
      if (currentDepth.get() > maxDepth.get()) {
        maxDepth.set(currentDepth.get());
      }
      currentDepth.set(currentDepthBackup.get());
      traversalTreeInDepth(root.right, maxDepth, currentDepth);
      if (currentDepth.get() > maxDepth.get()) {
        maxDepth.set(currentDepth.get());
      }
    }
  }

  public static void main(String[] args) {
    var tree = new TreeNode(3,
      new TreeNode(9, null, null),
      new TreeNode(20,
        new TreeNode(15, null, null),
        new TreeNode(7, null, null)));
    System.out.println(new Solution().maxDepth(tree));
  }
}

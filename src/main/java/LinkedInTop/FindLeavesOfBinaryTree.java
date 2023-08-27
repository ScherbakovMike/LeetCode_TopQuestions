package LinkedInTop;

import java.util.LinkedList;
import java.util.List;

public class FindLeavesOfBinaryTree {
  private final List<List<Integer>> result = new LinkedList<>();

  public List<List<Integer>> findLeaves(TreeNode root) {
    getHeight(root);
    return this.result;
  }

  private int getHeight(TreeNode root) {
    if (root == null) {
      return -1;
    }
    if (root.left == null && root.right == null) {
      if (this.result.isEmpty()) {
        this.result.add(new LinkedList<>());
      }
      this.result.get(0).add(root.val);
      return 0;
    }
    var curHeight = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    if (curHeight >= this.result.size()) {
      this.result.add(new LinkedList<>());
    }
    this.result.get(curHeight).add(root.val);
    return curHeight;
  }

  public static void main(String[] args) {
    var root = TreeNode.of(new Integer[]{1, 2});
    System.out.println(new FindLeavesOfBinaryTree().findLeaves(root));
  }
}

package LinkedInTop;

import java.util.ArrayDeque;

public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  TreeNode() {
  }

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public TreeNode(int val, TreeNode left) {
    this.val = val;
    this.left = left;
  }

  public static TreeNode of(Integer[] nums) {
    var queue = new ArrayDeque<TreeNode>();

    TreeNode root = new TreeNode(nums[0]);
    queue.add(root);

    int i = 1;
    while (i < nums.length) {
      TreeNode parent = queue.poll();

      Integer leftNum = nums[i++];

      if (leftNum != null) {
        TreeNode left = new TreeNode(leftNum);
        parent.left = left;

        queue.add(left);
      }

      if (i < nums.length) {
        Integer rightNum = nums[i++];

        if (rightNum != null) {
          TreeNode right = new TreeNode(rightNum);
          parent.right = right;

          queue.add(right);
        }
      }
    }

    return root;
  }
}

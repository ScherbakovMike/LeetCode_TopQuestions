package Trees.MaximumDepthOfBinaryTree;

import com.sun.source.tree.Tree;

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
        return traversalTreeInDepth(root, 0);
    }

    private int traversalTreeInDepth(TreeNode root, int currentDepth) {
        if (root != null) {
            currentDepth++;
            return Math.max(traversalTreeInDepth(root.left, currentDepth),
                    traversalTreeInDepth(root.right, currentDepth));
        }
        return currentDepth;
    }

    public static void main(String[] args) {
        var tree = new TreeNode(3,
                new TreeNode(9,
                        new TreeNode(10,
                                new TreeNode(11,
                                        new TreeNode(12, null, null),
                                        null),
                                null),
                        null),
                new TreeNode(20,
                        new TreeNode(15, null, null),
                        new TreeNode(7, null, null)));
        System.out.println(new Solution().maxDepth(tree));
    }
}

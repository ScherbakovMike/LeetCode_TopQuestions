package LinkedInTop;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreeLevelOrderTraversal {

  public static void main(String[] args) {
//    var root = new TreeNode(3,
//      new TreeNode(9),
//      new TreeNode(20,
//        new TreeNode(15),
//        new TreeNode(7)));
    var root = new TreeNode(1,
      new TreeNode(2,
        new TreeNode(4)
      ), new TreeNode(3, null, new TreeNode(5))
    );
    System.out.println(levelOrder(root));
    //Output: [[3],[9,20],[15,7]]
  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    var result = new ArrayList<List<Integer>>();
    if (root == null) {
      return result;
    }
    result.add(List.of(root.val));
    var children = nodeChildren(root);
    while (!children.isEmpty()) {
      result.add(children.stream().map(node -> node.val).toList());
      children = children.stream().flatMap(node->nodeChildren(node).stream()).toList();
    }
    return result;
  }

  private static List<TreeNode> nodeChildren(TreeNode node) {
    var result = new ArrayList<TreeNode>();
    if (node == null) {
      return result;
    }
    if (node.left != null) {
      result.add(node.left);
    }
    if (node.right != null) {
      result.add(node.right);
    }
    return result;
  }
}

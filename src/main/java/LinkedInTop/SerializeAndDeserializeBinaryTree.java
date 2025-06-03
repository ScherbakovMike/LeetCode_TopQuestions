package LinkedInTop;

import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    var result = new StringBuilder();
    result.append("[");
    var queue = new LinkedList<TreeNode>();
    queue.add(root);
    var maxNotNull = 0;
    while (!queue.isEmpty()) {
      var curElem = queue.pop();
      result.append(curElem == null ? "null" : curElem.val);
      if (curElem != null) {
        maxNotNull = result.length();
      }
      result.append(",");
      if (curElem != null) {
        queue.add(curElem.left);
        queue.add(curElem.right);
      }
    }
    result.replace(maxNotNull, result.length(), "");
    result.append("]");
    return result.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.length() < 3) {
      return null;
    }
    var dataPrep = data.substring(1, data.length() - 1);
    var queueCurNode = new LinkedList<TreeNode>();
    var posDelimiter = dataPrep.indexOf(',');
    if (posDelimiter == -1) {
      posDelimiter = dataPrep.length();
    }
    var valStr = dataPrep.substring(0, posDelimiter);
    var val = Integer.parseInt(valStr);
    var prevDelimiter = posDelimiter;
    var root = new TreeNode(val);
    queueCurNode.add(root);

    posDelimiter = dataPrep.indexOf(',', posDelimiter + 1);

    while (posDelimiter < dataPrep.length() && prevDelimiter != dataPrep.length()) {
      Integer left = null;
      if (posDelimiter < 0) {
        posDelimiter = dataPrep.length();
      }
      var leftStr = dataPrep.substring(prevDelimiter + 1, posDelimiter);
      if (!leftStr.equals("null")) {
        left = Integer.parseInt(leftStr);
      }
      Integer right = null;
      prevDelimiter = posDelimiter;
      posDelimiter = dataPrep.indexOf(',', prevDelimiter + 1);
      if (posDelimiter < 0) {
        posDelimiter = dataPrep.length();
      }
      String rightStr = null;
      if (prevDelimiter != posDelimiter) {
        if (posDelimiter > 0) {
          rightStr = dataPrep.substring(prevDelimiter + 1, posDelimiter);
        } else {
          rightStr = dataPrep.substring(prevDelimiter + 1);
          posDelimiter = dataPrep.length();
        }
        if (!rightStr.equals("null")) {
          right = Integer.parseInt(rightStr);
        }
      }
      var curNode = queueCurNode.pop();
      if (left != null) {
        var leftNode = new TreeNode(left);
        curNode.left = leftNode;
        queueCurNode.add(leftNode);
      }
      if (right != null) {
        var rightNode = new TreeNode(right);
        curNode.right = rightNode;
        queueCurNode.add(rightNode);
      }
      prevDelimiter = posDelimiter;
      posDelimiter = dataPrep.indexOf(',', prevDelimiter + 1);
    }
    return root;
  }

  public static void main(String[] args) {
    //    var tree = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new
    // TreeNode(5)));
    // var tree = TreeNode.of(new Integer[]{1, 2, 3, null, null, 4, 5});
    var tree =
        TreeNode.of(
            new Integer[] {
              4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5,
              null, 9, null, null, -1, -4, null, null, null, -2
            });
    // var tree = new TreeNode(1);
    var serializedTree = new SerializeAndDeserializeBinaryTree().serialize(tree);
    System.out.println(serializedTree);
    var deserializedTree = new SerializeAndDeserializeBinaryTree().deserialize(serializedTree);
    System.out.println(new SerializeAndDeserializeBinaryTree().serialize(deserializedTree));
  }
}

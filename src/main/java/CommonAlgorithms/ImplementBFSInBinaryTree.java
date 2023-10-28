package CommonAlgorithms;

import CommonAlgorithms.ImplementBinaryTree.BinaryTree.Node;
import java.util.LinkedList;

public class ImplementBFSInBinaryTree {

  private static void bfsIterative(Node node) {
    var queue = new LinkedList<Node>();
    queue.push(node);
    while (!queue.isEmpty()) {
      var curNode = queue.poll();
      System.out.println(curNode.value);
      if (curNode.left != null) {
        queue.add(curNode.left);
      }
      if (curNode.right != null) {
        queue.add(curNode.right);
      }
    }
  }

  private static void bfsRecursive(LinkedList<Node> queue) {
    if (queue.isEmpty()) {
      return;
    }
    var curNode = queue.poll();
    System.out.println(curNode.value);
    if (curNode.left != null) {
      queue.add(curNode.left);
    }
    if (curNode.right != null) {
      queue.add(curNode.right);
    }
    bfsRecursive(queue);
  }

  public static void main(String[] args) {
    var tree = new CommonAlgorithms.ImplementBinaryTree.BinaryTree<>(50);
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(60);
    tree.insert(55);
    tree.insert(65);

    System.out.println("BFS iterative:");
    bfsIterative(tree.root);

    System.out.println("BFS recursive:");
    var queue = new LinkedList<Node>();
    queue.push(tree.root);
    bfsRecursive(queue);
  }
}

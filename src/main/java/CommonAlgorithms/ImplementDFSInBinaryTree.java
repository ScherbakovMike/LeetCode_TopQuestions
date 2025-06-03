package CommonAlgorithms;

import CommonAlgorithms.ImplementBinaryTree.BinaryTree.Node;

public class ImplementDFSInBinaryTree {

  private static void dfsPreOrder(Node node) {
    System.out.println(node.value);
    if (node.left != null) {
      dfsPreOrder(node.left);
    }
    if (node.right != null) {
      dfsPreOrder(node.right);
    }
  }

  private static void dfsInOrder(Node node) {
    if (node.left != null) {
      dfsInOrder(node.left);
    }
    System.out.println(node.value);
    if (node.right != null) {
      dfsInOrder(node.right);
    }
  }

  private static void dfsPostOrder(Node node) {
    if (node.left != null) {
      dfsPostOrder(node.left);
    }
    if (node.right != null) {
      dfsPostOrder(node.right);
    }
    System.out.println(node.value);
  }

  public static void main(String[] args) {
    var tree = new CommonAlgorithms.ImplementBinaryTree.BinaryTree<>(50);
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(60);
    tree.insert(55);
    tree.insert(65);

    System.out.println("DFS preOrder:");
    dfsPreOrder(tree.root);

    System.out.println("DFS inOrder:");
    dfsInOrder(tree.root);

    System.out.println("DFS postOrder:");
    dfsPostOrder(tree.root);
  }
}

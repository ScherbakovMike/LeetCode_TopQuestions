package CommonAlgorithms;

import java.lang.reflect.Array;

public class ImplementBinaryTree {

  public static class BinaryTree<T extends Comparable<T>> {

    Node<T> root;

    public BinaryTree(T value) {
      this.root = new Node<>(value, null, null);
    }

    public Node<T> insert(T value) {
      var nodeWithParent = traverseDFS(root, value, null);
      var node = new Node<>(value, null, null);
      if (value.compareTo(nodeWithParent[0].value) < 0) {
        nodeWithParent[0].left = node;
      } else {
        nodeWithParent[0].right = node;
      }
      return node;
    }

    public Node<T> lookup(T value) {
      var nodeWithParent = traverseDFS(root, value, null);
      if (nodeWithParent[0].value == value) {
        return nodeWithParent[0];
      }
      return null;
    }

    public Node<T> remove(T value) {
      var nodeWithParent = traverseDFS(root, value, null);
      var node = nodeWithParent[0];
      var parent = nodeWithParent[1];
      if (node.value != value) {
        return null;
      }
      // node without children
      if (node.left == null && node.right == null) {
        if (parent != null && parent.left == node) {
          parent.left = null;
        }
        if (parent != null && parent.right == node) {
          parent.right = null;
        }
        if (parent == null) {
          this.root = null;
        }
      }
      // node with only left children
      if (node.left != null && node.right == null) {
        if (parent != null && parent.left == node) {
          parent.left = node.left;
        }
        if (parent != null && parent.right == node) {
          parent.right = node.left;
        }
        if (parent == null) {
          this.root = node.left;
        }
      }
      // node with only right children
      if (node.left == null && node.right != null) {
        if (parent != null && parent.left == node) {
          parent.left = node.right;
        }
        if (parent != null && parent.right == node) {
          parent.right = node.right;
        }
        if (parent == null) {
          this.root = node.right;
        }
      }
      // node with both children
      if (node.left != null && node.right != null) {
        var successorWithParent = traverseDFS(node.right, node.value, null);
        var successor = successorWithParent[0];
        var valueReplacement = successor.value;
        remove(successor.value);
        node.value = valueReplacement;
      }
      return node;
    }

    private Node<T>[] traverseDFS(Node<T> root, T value, Node<T> parent) {
      if (value.compareTo(root.value) < 0 && root.left != null) {
        return traverseDFS(root.left, value, root);
      } else if (value.compareTo(root.value) > 0 && root.right != null) {
        return traverseDFS(root.right, value, root);
      } else {
        var result = (Node<T>[]) Array.newInstance(root.getClass(), 2);
        result[0] = root;
        result[1] = parent;
        return result;
      }
    }

    private void printTree() {
      System.out.println(this.root.toString(1));
    }

    public static class Node<T extends Comparable<T>> {

      public T value;
      public Node<T> left;
      public Node<T> right;

      @Override
      public String toString() {
        return String.format("value = %s%nleft = %s%nright = %s%n", value,
            left == null ? "" : left.toString(),
            right == null ? "" : right.toString());
      }

      public String toString(int tabs) {
        return String.format("value = %s%n%sleft = %s%n%sright = %s%n",
            value,
            "\t".repeat(tabs), left == null ? "" : left.toString(tabs + 1),
            "\t".repeat(tabs), right == null ? "" : right.toString(tabs + 1));
      }

      public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
      }
    }
  }

  public static void main(String[] args) {
    /*
                50
           10         60
         5    15   55   65
     */
    var tree = new BinaryTree<>(50);
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(60);
    tree.insert(55);
    tree.insert(65);
    tree.printTree();
    System.out.println(tree.lookup(55));
    System.out.println(tree.lookup(70));

    tree.remove(50);
    System.out.println(tree.lookup(50));
  }
}

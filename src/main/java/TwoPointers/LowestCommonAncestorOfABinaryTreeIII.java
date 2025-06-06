package TwoPointers;

// Definition for a Node.
class Node {
  public int val;
  public Node left;
  public Node right;
  public Node parent;
}

public class LowestCommonAncestorOfABinaryTreeIII {
  public Node lowestCommonAncestor(Node p, Node q) {
    Node p1 = p;
    Node p2 = q;
    while (p1 != p2) {
      p1 = p1.parent;
      p2 = p2.parent;
      if (p1 == null) {
        p1 = q;
      } else if (p2 == null) {
        p2 = p;
      }
    }
    return p1;
  }

  public static void main(String[] args) {}
}

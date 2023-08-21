package LinkedInTop;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestBinarySearchTreeValueIIMaxHeap {
  private static class DiffEntry {
    protected double diff;
    protected int value;

    public DiffEntry(double diff, boolean sign, int value) {
      this.diff = diff;
      this.value = value;
    }
  }

  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    var comparator = Comparator.comparing(elem -> Math.abs(((DiffEntry) elem).diff));
    var result = new PriorityQueue<DiffEntry>(comparator.reversed());
    closestKValuesR(root, target, result, k);
    return result.stream()
      .map(item -> item.value)
      .toList();
  }

  private void closestKValuesR(TreeNode root, double target, PriorityQueue<DiffEntry> result, int k) {
    var queue = new LinkedList<TreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      var elem = queue.pop();
      if (elem.left != null) {
        queue.add(elem.left);
      }
      if (elem.right != null) {
        queue.add(elem.right);
      }
      var diff = target-elem.val;
      result.add(new DiffEntry(diff, diff > 0, elem.val));
      if (result.size() > k) {
        result.poll();
      }
    }
  }
}

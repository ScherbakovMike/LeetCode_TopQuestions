package LinkedInTop;

import java.util.Comparator;
import java.util.TreeSet;

public class MaxStackBalancedTrees {

  private TreeSet<int[]> stack;
  private TreeSet<int[]> values;

  private int counter;

  public MaxStackBalancedTrees() {
    stack = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
    values = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    counter = 0;
  }

  public void push(int x) {
    stack.add(new int[] {counter, x});
    values.add(new int[] {x, counter});
    counter++;
  }

  public int pop() {
    var last = stack.pollLast();
    values.remove(new int[] {last[1], last[0]});
    return last[1];
  }

  public int top() {
    return stack.last()[1];
  }

  public int peekMax() {
    return values.last()[0];
  }

  public int popMax() {
    var last = values.pollLast();
    stack.remove(new int[] {last[1], last[0]});
    return last[0];
  }

  public static void main(String[] args) {
    var stack = new MaxStackBalancedTrees();
    stack.push(5);
    stack.push(1);
    stack.push(5);
    System.out.println(stack.top());
    System.out.println(stack.popMax());
    System.out.println(stack.top());
    System.out.println(stack.peekMax());
    System.out.println(stack.pop());
    System.out.println(stack.top());
  }
}

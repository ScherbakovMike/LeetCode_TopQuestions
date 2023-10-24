package LinkedInTop;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class MaxStackHeapLazyUpdate {

  private final LinkedList<int[]> stack;
  private final TreeSet<int[]> values;
  private final Set<Integer> removed;

  private int counter;

  public MaxStackHeapLazyUpdate() {
    stack = new LinkedList<>();
    values = new TreeSet<>((a, b) -> b[0] - a[0] == 0 ? b[1] - a[1] : b[0] - a[0]);
    removed = new HashSet<>();
    counter = 0;
  }

  public void push(int x) {
    stack.add(new int[]{x, counter});
    values.add(new int[]{x, counter});
    counter++;
  }

  public int pop() {
    var last = stack.pollLast();
    while(removed.contains(last[1])) {
      last = stack.pollLast();
    }
    removed.add(last[1]);
    return last[0];
  }

  public int top() {
    var last = stack.peekLast();
    while(removed.contains(last[1])) {
      stack.pollLast();
      last = stack.peekLast();
    }
    return last[0];
  }

  public int peekMax() {
    var last = values.first();
    while(removed.contains(last[1])) {
      values.pollFirst();
      last = values.first();
    }
    return last[0];
  }

  public int popMax() {
    var last = values.pollFirst();
    while(removed.contains(last[1])) {
      last = values.pollFirst();
    }
    removed.add(last[1]);
    return last[0];
  }

  public static void main(String[] args) {
    var stack = new MaxStackHeapLazyUpdate();
//    stack.push(5);
//    stack.push(1);
//    stack.push(5);
//    System.out.println(stack.top());
//    System.out.println(stack.popMax());
//    System.out.println(stack.top());
//    System.out.println(stack.peekMax());
//    System.out.println(stack.pop());
//    System.out.println(stack.top());

    stack.push(5);
    stack.push(1);

    System.out.println(stack.top());

  }
}

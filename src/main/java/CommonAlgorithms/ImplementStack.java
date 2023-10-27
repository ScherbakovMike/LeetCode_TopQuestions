package CommonAlgorithms;

public class ImplementStack {

  private static class Stack<T> {

    private Node<T> tail;

    private static class Node<T> {

      private final T value;
      private Node<T> prev;

      public Node(T value, Node<T> prev) {
        this.value = value;
        this.prev = prev;
      }
    }

    public void push(T value) {
      var node = new Node<>(value, null);
      if (tail != null) {
        node.prev = this.tail;
      }
      this.tail = node;
    }

    public T pop() {
      if (this.tail == null) {
        throw new IllegalArgumentException("The stack is empty");
      }
      var node = this.tail;
      this.tail = this.tail.prev;
      return node.value;
    }
  }

  public static void main(String[] args) {
    var stack = new Stack<Integer>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
